package ro.ubb.tcp;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubb.model.Sensor;
import ro.ubb.service.SensorService;
import ro.ubb.service.ServerService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
@RequiredArgsConstructor
@Component
public class TcpServer implements Server{

    @Autowired
    private final ServerService service;

    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    public void startServer() {
        try (var serverSocket = new ServerSocket(SensorService.PORT)) {
            System.out.println("server started; waiting for clients...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("client connected");
                executorService.submit(new ClientHandler(clientSocket, service));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        private final ServerService service;
        public ClientHandler(Socket socket, ServerService service) {
            this.socket = socket;
            this.service = service;
        }

        @Override
        public void run() {
            try (var is = socket.getInputStream()) {
                var request = Sensor.builder().build();
                request.readFrom(is);
                service.handle(request);
                System.out.println("Received sensor information: " + request);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

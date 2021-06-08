package ro.ubb.tcp;

import ro.ubb.model.Sensor;
import ro.ubb.service.SensorService;

import java.io.IOException;
import java.net.Socket;

public class TcpClient{

    public void sendAndReceive(Sensor request) {
            try (var socket = new Socket(SensorService.HOST, SensorService.PORT);
             var os = socket.getOutputStream()) {
            request.writeTo(os);
        } catch (IOException e) {
           throw new RuntimeException("Something went wrong!!");
        }
    }
}

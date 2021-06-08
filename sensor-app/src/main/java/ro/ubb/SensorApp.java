package ro.ubb;


import ro.ubb.service.SensorService;
import ro.ubb.service.SensorServiceImpl;
import ro.ubb.tcp.TcpClient;
import ro.ubb.ui.Console;

import java.io.IOException;
import java.util.concurrent.Executors;

public class SensorApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        var executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        TcpClient client = new TcpClient();
        SensorService service = new SensorServiceImpl(executorService, client);
        Console clientConsole = new Console(service);
        clientConsole.run();

        System.out.println("Bye!!");

        executorService.shutdown();
    }
}

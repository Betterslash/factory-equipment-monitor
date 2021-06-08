package ro.ubb.service;

import ro.ubb.model.Sensor;
import ro.ubb.tcp.TcpClient;

import java.util.Random;
import java.util.concurrent.ExecutorService;

public class SensorServiceImpl extends SensorService {

    private final ExecutorService executorService;

    private final TcpClient tcpClient;

    public SensorServiceImpl(ExecutorService executorService, TcpClient tcpClient) {
        this.executorService = executorService;
        this.tcpClient = tcpClient;
    }

    @Override
    public void sendData(Sensor sensor) {
        var random = new Random();
        executorService.submit(() -> {
            sensor.setData(random.ints(sensor.getLowerBound(), sensor.getUpperBound()).iterator().nextInt());
            tcpClient.sendAndReceive(sensor);
            return sensor.toString();
        });
    }
}

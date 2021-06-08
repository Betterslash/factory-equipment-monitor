package ro.ubb.ui;

import ro.ubb.model.Sensor;
import ro.ubb.service.SensorService;
import ro.ubb.validator.SensorValidatorImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Console {

    private final SensorService service;

    public Console(SensorService service) {
        this.service = service;
    }

    public void run() throws IOException, InterruptedException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("id = ");
        int id = Integer.parseInt(br.readLine());
        System.out.print("name = ");
        String name = br.readLine();
        System.out.print("upper bound = ");
        int upperBound = Integer.parseInt(br.readLine());
        System.out.print("lower bound = ");
        int lowerBound = Integer.parseInt(br.readLine());
        var random = new Random();
        var sensor = Sensor.builder()
                .id(id)
                .name(name)
                .upperBound(upperBound)
                .lowerBound(lowerBound)
                .data(random.ints(lowerBound, upperBound).iterator().nextInt())
                .build();
        SensorValidatorImpl.validate(sensor);
        while (true){
            this.service.sendData(sensor);
            Thread.sleep(4500);
        }
    }
}

package ro.ubb.service;

import ro.ubb.model.Sensor;

import java.io.IOException;

public abstract class SensorService {

    public static final String HOST = "localhost";
    public static final int PORT = 8080;

    public abstract void sendData(Sensor sensor) throws IOException;
}

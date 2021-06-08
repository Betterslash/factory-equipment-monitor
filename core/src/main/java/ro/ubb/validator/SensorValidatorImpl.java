package ro.ubb.validator;

import ro.ubb.exception.SensorValidatorException;
import ro.ubb.model.Sensor;

public class SensorValidatorImpl{
    public static void validate(Sensor sensor) {
        if(sensor.getId() < 1024){
            throw new SensorValidatorException("Sensor's id must be bigger than 1024 and must not be null!!");
        } else if (sensor.getName() == null){
            throw new SensorValidatorException("Sensor's name must not be null!!");
        }
    }
}

package ro.ubb.mapper;

import ro.ubb.model.Sensor;
import ro.ubb.model.SensorEntity;

public interface SensorMapper {
    SensorEntity toEntity(Sensor sensor);
}

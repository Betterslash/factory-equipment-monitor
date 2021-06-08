package ro.ubb.mapper;

import org.springframework.stereotype.Component;
import ro.ubb.model.Sensor;
import ro.ubb.model.SensorEntity;

import java.sql.Time;
import java.time.LocalTime;

@Component
public class SensorMapperImpl implements SensorMapper{
    public SensorEntity toEntity(Sensor sensor){
        return SensorEntity.builder()
                .data(sensor.getData())
                .name(sensor.getName())
                .time(Time.valueOf(LocalTime.now()))
                .build();
    }
}

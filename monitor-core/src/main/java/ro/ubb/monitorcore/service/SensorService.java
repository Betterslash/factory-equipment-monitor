package ro.ubb.monitorcore.service;

import ro.ubb.monitorcore.dto.MinSensorDto;
import ro.ubb.monitorcore.dto.SensorDto;

import java.util.List;

public interface SensorService {

    List<SensorDto> getAll();

    List<MinSensorDto> getDistinct();

    List<SensorDto> getTop(String name);
}

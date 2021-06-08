package ro.ubb.monitorcore.mapper;

import org.mapstruct.Mapper;
import ro.ubb.monitorcore.dto.SensorDto;
import ro.ubb.monitorcore.model.SensorEntity;

@Mapper(componentModel = "spring")
public interface SensorMapper {

    SensorDto fromEntityToDto(SensorEntity entity);

    SensorEntity fromDtoToEntity(SensorDto sensorDto);

}

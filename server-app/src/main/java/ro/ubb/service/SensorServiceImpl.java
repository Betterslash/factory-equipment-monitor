package ro.ubb.service;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.mapper.SensorMapper;
import ro.ubb.model.Sensor;
import ro.ubb.repository.SensorRepository;

@Data
@RequiredArgsConstructor
@Service
public class SensorServiceImpl implements ServerService{

    @Autowired
    private final SensorRepository sensorRepository;

    @Autowired
    private final SensorMapper mapper;

    public void handle(Sensor sensor) {
        this.sensorRepository.save(mapper.toEntity(sensor));
    }
}

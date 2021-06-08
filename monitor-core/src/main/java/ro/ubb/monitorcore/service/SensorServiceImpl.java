package ro.ubb.monitorcore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.ubb.monitorcore.dto.MinSensorDto;
import ro.ubb.monitorcore.dto.SensorDto;
import ro.ubb.monitorcore.mapper.SensorMapper;
import ro.ubb.monitorcore.repository.SensorRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SensorServiceImpl implements SensorService{

    private final SensorRepository repository;

    private final SensorMapper mapper;

    @Override
    public List<SensorDto> getAll() {
        return this.repository
                .findAll()
                .stream()
                .map(mapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MinSensorDto> getDistinct() {
        return this.repository.findDistinctName()
                .stream()
                .map(e -> MinSensorDto.builder().name(e).build())
                .collect(Collectors.toList());
    }

    @Override
    public List<SensorDto> getTop(String name) {
        return this.repository.findTopFourByName(name)
                .stream()
                .map(mapper::fromEntityToDto)
                .collect(Collectors.toList());
    }


}

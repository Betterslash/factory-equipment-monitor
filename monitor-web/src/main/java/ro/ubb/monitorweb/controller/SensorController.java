package ro.ubb.monitorweb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.monitorcore.dto.MinSensorDto;
import ro.ubb.monitorcore.dto.SensorDto;
import ro.ubb.monitorcore.service.SensorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sensors")
public class SensorController{

    private final SensorService service;

    @GetMapping
    public List<SensorDto> getAll(){
        return this.service.getAll();
    }

    @GetMapping("/distinct")
    public List<MinSensorDto> getDistinct(){
        return this.service.getDistinct();
    }

    @GetMapping("/{name}")
    public List<SensorDto> getTop(@PathVariable String name){
        return this.service.getTop(name);
    }
}

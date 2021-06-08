package ro.ubb.monitorcore.dto;

import lombok.*;

import java.sql.Time;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorDto {
    private Long id;

    private String name;

    private Integer data;

    private Time time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SensorDto sensorDto = (SensorDto) o;

        return Objects.equals(name, sensorDto.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

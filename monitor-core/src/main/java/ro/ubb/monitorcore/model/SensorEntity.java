package ro.ubb.monitorcore.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;

@Entity(name = "sensor")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer data;

    private Time time;
}

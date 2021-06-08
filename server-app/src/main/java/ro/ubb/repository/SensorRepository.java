package ro.ubb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.model.SensorEntity;

public interface SensorRepository extends JpaRepository<SensorEntity, Long> {
}

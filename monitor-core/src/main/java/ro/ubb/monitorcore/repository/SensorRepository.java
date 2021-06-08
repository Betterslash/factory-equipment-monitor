package ro.ubb.monitorcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.monitorcore.model.SensorEntity;

import java.util.List;

public interface SensorRepository extends JpaRepository<SensorEntity, Long> {
    @Query("SELECT DISTINCT d.name FROM sensor d")
    List<String> findDistinctName();

    @Query(value = "SELECT * " +
            "FROM sensor s " +
            "WHERE s.name = :name" +
            " LIMIT 4", nativeQuery = true)
    List<SensorEntity> findTopFourByName(@Param("name") String name);
}

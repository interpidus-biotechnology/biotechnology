package com.biotechnology;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ExperimentRepository extends MongoRepository<Experiment, String> {
    List<Experiment> findByBiotechnologist(String biotechnologist);
    long deleteByPlantCulture(String plantCulture);
}

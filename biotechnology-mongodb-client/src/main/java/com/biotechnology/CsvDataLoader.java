package com.biotechnology;

import org.apache.commons.csv.*;
import org.springframework.core.io.ClassPathResource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

public class CsvDataLoader {
    public static List<Experiment> load() throws IOException {
        List<Experiment> result = new ArrayList<>();
        try (Reader reader = new InputStreamReader(
                new ClassPathResource("biotechnology.csv").getInputStream(), StandardCharsets.UTF_8);
             CSVParser parser = CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build().parse(reader)) {
            for (CSVRecord r : parser) {
                result.add(new Experiment(
                    r.get("biotechnologist"), r.get("geneticist"), r.get("lab_assistant"),
                    LocalDate.parse(r.get("experiment_date")), r.get("plant_culture"),
                    split(r.get("dna_markers")), split(r.get("protocol_stages")),
                    new Experiment.Laboratory(r.get("laboratory_address"), r.get("laboratory_phone")),
                    Integer.parseInt(r.get("geneticist_experience_years"))
                ));
            }
        }
        return result;
    }
    private static List<String> split(String value) {
        return Arrays.stream(value.split(";")).map(String::trim).toList();
    }
}

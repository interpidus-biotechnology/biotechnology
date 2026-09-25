package com.biotechnology;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.List;

@Document(collection = "biotechnology-experiments")
public class Experiment {
    @Id
    private String id;
    private String biotechnologist;
    private String geneticist;
    private String labAssistant;
    private LocalDate experimentDate;
    private String plantCulture;
    private List<String> dnaMarkers;
    private List<String> protocolStages;
    private Laboratory laboratory;
    private int geneticistExperienceYears;

    public Experiment() {}

    public Experiment(String biotechnologist, String geneticist, String labAssistant,
                      LocalDate experimentDate, String plantCulture, List<String> dnaMarkers,
                      List<String> protocolStages, Laboratory laboratory,
                      int geneticistExperienceYears) {
        this.biotechnologist = biotechnologist;
        this.geneticist = geneticist;
        this.labAssistant = labAssistant;
        this.experimentDate = experimentDate;
        this.plantCulture = plantCulture;
        this.dnaMarkers = dnaMarkers;
        this.protocolStages = protocolStages;
        this.laboratory = laboratory;
        this.geneticistExperienceYears = geneticistExperienceYears;
    }

    public String getId(){ return id; }
    public void setId(String id){ this.id=id; }
    public String getBiotechnologist(){ return biotechnologist; }
    public String getGeneticist(){ return geneticist; }
    public String getLabAssistant(){ return labAssistant; }
    public LocalDate getExperimentDate(){ return experimentDate; }
    public String getPlantCulture(){ return plantCulture; }
    public List<String> getDnaMarkers(){ return dnaMarkers; }
    public List<String> getProtocolStages(){ return protocolStages; }
    public Laboratory getLaboratory(){ return laboratory; }
    public int getGeneticistExperienceYears(){ return geneticistExperienceYears; }

    public void setProtocolStages(List<String> v){ this.protocolStages=v; }

    @Override public String toString() {
        return String.format("Experiment{id='%s', biotechnologist='%s', geneticist='%s', labAssistant='%s', date=%s, plantCulture='%s', dnaMarkers=%s, protocolStages=%s, laboratory=%s, geneticistExperienceYears=%d}",
                id, biotechnologist, geneticist, labAssistant, experimentDate, plantCulture,
                dnaMarkers, protocolStages, laboratory, geneticistExperienceYears);
    }

    public record Laboratory(String address, String phone) {}
}

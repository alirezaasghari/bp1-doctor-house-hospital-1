package at.refugeescode.accountancy.persistence.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Patient {

    @Id
    @GeneratedValue
    private String id;

    private String patientNumber;

    private String name;

    private List<String> symptoms;

    private String illness;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", patientNumber='" + patientNumber + '\'' +
                ", name='" + name + '\'' +
                ", symptoms=" + symptoms +
                ", illness='" + illness + '\'' +
                '}';
    }
}

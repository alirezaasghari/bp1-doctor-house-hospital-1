package at.refugeescode.diagnoseroom.controller;

import at.refugeescode.diagnoseroom.model.Patient;
import at.refugeescode.diagnoseroom.parser.IllnessEncyclopedia;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class DrHouse {

    private IllnessEncyclopedia illnessEncyclopedia;

    public DrHouse(IllnessEncyclopedia illnessEncyclopedia) {
        this.illnessEncyclopedia = illnessEncyclopedia;
    }

    public Patient diagnose(Patient patient) {

        Map<String, List<String>> illnesses = illnessEncyclopedia.getIllnesses();
        List<String> patientSymptoms = patient.getSymptoms();

        String illness = figureOutIllness(illnesses, patientSymptoms);
        patient.setIllness(illness);
        return patient;
    }

    private String figureOutIllness(Map<String, List<String>> illnesses, List<String> patientSymptoms) {
        return illnesses.entrySet().stream()
                .filter(e -> e.getValue().containsAll(patientSymptoms)&&e.getValue().size()==patientSymptoms.size())
                .map(e -> e.getKey())
                .findFirst().orElse("Lupus");
    }
}

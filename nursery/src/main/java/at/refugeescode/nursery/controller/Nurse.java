package at.refugeescode.nursery.controller;

import at.refugeescode.nursery.parser.TreatmentEncyclopedia;
import at.refugeescode.nursery.persistance.model.Patient;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class Nurse {

    private TreatmentEncyclopedia treatmentEncyclopedia;

    public Nurse(TreatmentEncyclopedia treatmentEncyclopedia) {
        this.treatmentEncyclopedia = treatmentEncyclopedia;
    }

    public Patient treatment(Patient patient) {

        Map<String, List<String>> treatments = treatmentEncyclopedia.getTreatments();
        String patientIllness = patient.getIllness();

        String treatment = provideTreatment(treatments, patientIllness);
        patient.setTreatment(treatment);

        return patient;
    }

    private String provideTreatment(Map<String, List<String>> treatments, String illness) {
        return treatments.entrySet().stream()
                .filter(e -> e.getValue().contains(illness))
                .map(e -> e.getKey())
                .findFirst().orElse("No Treatment");
    }

}

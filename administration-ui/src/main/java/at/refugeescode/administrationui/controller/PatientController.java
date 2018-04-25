package at.refugeescode.administrationui.controller;

import at.refugeescode.administrationui.model.LocalPatient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PatientController {

    @Value("${admission.url}")
    String admissionUrl;
    private RestTemplate restTemplate;

    public PatientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void addNewPatient(LocalPatient localPatient) {
        restTemplate.postForEntity(admissionUrl, localPatient, Void.class);
    }

}

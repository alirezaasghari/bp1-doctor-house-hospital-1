package at.refugeescode.administrationui.view;

import at.refugeescode.administrationui.controller.PatientController;
import at.refugeescode.administrationui.model.LocalPatient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeViewController {

    private PatientController patientController;

    public HomeViewController(PatientController patientController) {
        this.patientController = patientController;
    }

    @ModelAttribute("newPatient")
    LocalPatient newPatient() {
        return new LocalPatient();
    }

    @PostMapping()
    String addNewPatient(LocalPatient localPatient) {
        patientController.addNewPatient(localPatient);
        return "redirect:/";
    }

    @GetMapping
    String page() {
        return "home";
    }

}

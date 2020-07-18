package controllers;

import models.Data;
import models.MedicalOrganization;
import models.Patient;
import models.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class ArchivariusController {

    @GetMapping("/user")
    public UserInfo getUser(@RequestParam(name = "snils") String snils){
        return null;
    }

    @PostMapping("/data")
    public Data postData(@RequestParam(name = "snils") String snils){
        return null;
    }

    @GetMapping("/mo")
    public MedicalOrganization getMo(@RequestParam(name = "snils") String snils){
        return null;
    }

    @GetMapping("/iemk")
    public Collection<Patient> getIemk(@RequestParam(name = "snils") String snils){
        return null;
    }
}

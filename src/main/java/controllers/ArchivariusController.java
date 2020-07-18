package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArchivariusController {

    @GetMapping("/user")
    public String getUser(@RequestParam(name = "snils") String snils){

    }
}

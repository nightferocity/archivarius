package controllers;

import dto.Patient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hostco.reguser.types.GetUserResponseType;
import service.RegUserClient;

import java.util.Collection;

@Data
@Controller
public class RegUserController {

    /*
     * Принимает: снилс пользователя
     * Возвращает: пользователя
     * */
    @GetMapping("/user")
    public GetUserResponseType getUser(@RequestParam(name = "snils") String snils){
        return new RegUserClient().getUser(snils);
    }

    /*
     * Принимает: снилс пациента, фамилия пациента
     * Возвращает: пациента
     * */
    @GetMapping("/iemk")
    public Collection<Patient> getIemk(@RequestParam(name = "patientSnils") String snils,
                                       @RequestParam(name = "patientLastName") String lastName){
        return null;
    }
}

package com.hostcoIntern.archivarius.controllers;

import com.hostcoIntern.archivarius.dto.Patient;
import com.hostcoIntern.archivarius.service.RegUserClient;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hostco.reguser.types.GetUserResponseType;

import javax.xml.soap.SOAPException;
import java.util.Collection;

@Data
@Slf4j
@Controller
public class RegUserController {

    private RegUserClient regUserClient;

    /*
     * Принимает: снилс пользователя
     * Возвращает: пользователя
     * */
    //don't h=know how to fix this -6h of my time
    @GetMapping("/user")
    public GetUserResponseType getUser(@RequestParam(name = "snils") String snils) throws SOAPException {
        log.error("snils");
        return regUserClient.getUser(snils);
    }

    /*
     * Принимает: снилс пациента, фамилия пациента
     * Возвращает: пациента
     * */
//    @GetMapping("/iemk")
//    public Collection<Patient> getIemk(@RequestParam(name = "patientSnils") String snils,
//                                       @RequestParam(name = "patientLastName") String lastName){
//        return null;
//    }
}

package controllers;

import dto.Data;
import dto.MedicalOrganization;
import dto.Patient;

import models.RefMo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import repositories.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.hostco.reguser.types.*;

import service.RegUserClient;


import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class ArchivariusController {

    /*
    * Принимает: снилс пользователя
    * Возвращает: пользователя
    * */
    @PostMapping("/user")
    public GetUserResponseType getUser(@RequestParam(name = "snils") String snils){
        return new RegUserClient().getUser(snils);
    }

    /*
     * Получение списка МО
     * */
    @GetMapping("/mo")
    public MedicalOrganization getMo(RefMoRepository repository){
        return null;
    }

    /*
    * Сохранение данных в базу
    * */
    @PostMapping("/data")
    public Data postData(){
        return null;
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

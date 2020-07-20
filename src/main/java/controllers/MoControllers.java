package controllers;

import dto.MedicalOrganization;
import lombok.Data;
import models.RefMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import service.MoService;

import java.util.List;

@Data
@Controller
public class MoControllers {

    @Autowired
    private final MoService moService;

    /*
     * Получение списка МО
     * Тольĸо записи с маĸсимальным значением поля version и значением поля is_shown=true
     * */
    @GetMapping("/mo")
    public List<RefMo> getMo(){
        return moService.getRelevantMo();
    }
}

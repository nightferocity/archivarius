package controllers;

import lombok.Data;
import models.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import service.DataService;

@Data
@Controller
public class DataController {

    @Autowired
    private DataService dataService;

    /*
     * Сохранение данных в базу
     * */
    @PostMapping("/data")
    public void postData(@RequestBody UserData userData)  {
        dataService.addData(userData);
    }
}

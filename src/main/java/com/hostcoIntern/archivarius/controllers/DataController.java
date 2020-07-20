package com.hostcoIntern.archivarius.controllers;

import com.hostcoIntern.archivarius.service.DataService;
import com.hostcoIntern.archivarius.models.UserData;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Data
@Controller
public class DataController {

    private DataService dataService;

    /*
     * Сохранение данных в базу
     * */
    @PostMapping("/data")
    public void postData(@RequestBody UserData userData)  {
        dataService.addData(userData);
    }
}

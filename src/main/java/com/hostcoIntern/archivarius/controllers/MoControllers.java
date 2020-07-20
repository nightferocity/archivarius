package com.hostcoIntern.archivarius.controllers;

import com.hostcoIntern.archivarius.dto.MedicalOrganization;
import com.hostcoIntern.archivarius.dto.MedicalOrganizationList;
import com.hostcoIntern.archivarius.service.MoService;
import com.hostcoIntern.archivarius.models.RefMo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RestController
@Slf4j
public class MoControllers {

    private final MoService moService;

    /*
     * Получение списка МО
     * Тольĸо записи с маĸсимальным значением поля version и значением поля is_shown=true
     * */
    @GetMapping("/mo")
    public MedicalOrganizationList getMo(){
        List<RefMo> relevant = moService.getRelevantMo();
        return MedicalOrganizationList.builder().moList(relevant.stream()
                .map(x -> MedicalOrganization.builder()
                .codeMo(x.getOid())
                .isShown(x.getIsShown())
                .shortName(x.getNameshort()).build())
                .collect(Collectors.toList())).build();
    }
}

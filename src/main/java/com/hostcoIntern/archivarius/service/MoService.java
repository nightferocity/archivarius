package com.hostcoIntern.archivarius.service;

import com.hostcoIntern.archivarius.models.RefMo;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.matcher.FilterableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MoService {

    @Autowired
    public com.hostcoIntern.archivarius.repositories.RefMoRepository RefMoRepository;


    /*
    * возвращает все МО
    * */
    public List<RefMo> getAllMo() {
        return (List<RefMo>) RefMoRepository.findAll();
    }

    /*
    * Возвращает Тольĸо записи с маĸсимальным значением поля version и значением поля is_shown=true
    * */
    public List<RefMo> getRelevantMo(){
        List<RefMo> allMo = getAllMo();
        Optional<RefMo> maxMoVersion =  allMo.stream()
                .max((x, y) -> (int) (1000 * (Double.parseDouble(x.getVersion()) - Double.parseDouble(y.getVersion()))));
        if (maxMoVersion.isEmpty())
            throw new IllegalArgumentException();
        String maxVersion = maxMoVersion.get().getVersion();
        return allMo.stream().filter(x-> x.getVersion().equals(maxVersion)).collect(Collectors.toList());
    }
}

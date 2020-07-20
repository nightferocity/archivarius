package service;

import lombok.extern.slf4j.Slf4j;
import models.RefMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.RefMoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class MoService {

    @Autowired
    public RefMoRepository RefMoRepository;


    /*
    * возвращает все МО
    * */
    public List<RefMo> getAllMo() {
        return RefMoRepository.findAll();
    }

    /*
    * Возвращает Тольĸо записи с маĸсимальным значением поля version и значением поля is_shown=true
    * */
    public List<RefMo> getRelevantMo(){
        List<RefMo> allMo = getAllMo();
        List<RefMo> relevantMo = new ArrayList<>();
        allMo.stream()
                .max((x, y) -> (int) (1000 * (Double.parseDouble(x.getVersion()) - Double.parseDouble(y.getVersion()))))
                .ifPresent(relevantMo::add);
        return relevantMo;
    }
}

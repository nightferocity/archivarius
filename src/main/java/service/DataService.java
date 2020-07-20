package service;

import models.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.UserDataRepository;

@Service
public class DataService {

    @Autowired
    private UserDataRepository userDataRepository;

    public void addData(UserData userData){
        userDataRepository.save(userData);
    }
}

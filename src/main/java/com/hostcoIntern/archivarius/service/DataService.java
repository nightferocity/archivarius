package com.hostcoIntern.archivarius.service;

import com.hostcoIntern.archivarius.models.UserData;
import com.hostcoIntern.archivarius.repositories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    private UserDataRepository userDataRepository;

    public void addData(UserData userData){
        userDataRepository.save(userData);
    }
}

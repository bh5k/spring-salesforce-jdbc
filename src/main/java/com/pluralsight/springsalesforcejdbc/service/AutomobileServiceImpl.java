package com.pluralsight.springsalesforcejdbc.service;

import com.pluralsight.springsalesforcejdbc.model.Automobile;
import com.pluralsight.springsalesforcejdbc.repository.AutomobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomobileServiceImpl implements AutomobileService {

    private AutomobileRepository automobileRepository;

    @Autowired
    public AutomobileServiceImpl(AutomobileRepository automobileRepository) {
        this.automobileRepository = automobileRepository;
    }

    @Override
    public List<Automobile> findAll() {
        return automobileRepository.findAllJdbcTemplate();
    }
}

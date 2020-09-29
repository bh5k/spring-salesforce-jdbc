package com.pluralsight.springsalesforcejdbc.service;

import com.pluralsight.springsalesforcejdbc.model.Automobile;

import java.util.List;

public interface AutomobileService {
    List<Automobile> findAll();
}

package com.pluralsight.springsalesforcejdbc.repository;

import com.pluralsight.springsalesforcejdbc.model.Automobile;

import java.util.List;

public interface AutomobileRepository {
    List<Automobile> findAllJdbc();
    List<Automobile> findAllJdbcTemplate();
}

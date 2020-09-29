package com.pluralsight.springsalesforcejdbc.repository;

import com.pluralsight.springsalesforcejdbc.model.Automobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class AutomobileRepositoryJdbcImpl implements AutomobileRepository {

    @Autowired
    private DataSource dataSource;

    public List<Automobile> findAllJdbc() {
        List<Automobile> autos = Collections.EMPTY_LIST;
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from AUTOMOBILE");
            autos = new ArrayList<>();
            while (rs.next()) {
                Automobile auto = new Automobile();
                auto.setId(rs.getInt("ID"));
                auto.setMake(rs.getString("MAKE"));
                auto.setEngineId(rs.getInt("ENGINE_ID"));
                auto.setTransmissionId(rs.getInt("TRANSMISSION_ID"));
                autos.add(auto);
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e) {}
        return autos;
    }

    public List<Automobile> findAllJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Automobile> autos = jdbcTemplate.query("Select * from AUTOMOBILE", new RowMapper<Automobile>() {
            @Override
            public Automobile mapRow(ResultSet rs, int i) throws SQLException {
                Automobile auto = new Automobile();
                auto.setId(rs.getInt("ID"));
                auto.setMake(rs.getString("MAKE"));
                auto.setEngineId(rs.getInt("ENGINE_ID"));
                auto.setTransmissionId(rs.getInt("TRANSMISSION_ID"));
                return auto;
            }
        });
        return autos;
    }

}

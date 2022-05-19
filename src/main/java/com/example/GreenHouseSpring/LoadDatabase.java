package com.javatpoint.springGreenHouse;

import java.sql.*;
import java.time.LocalDate;


import com.javatpoint.springGreenHouse.Log.Log;
import com.javatpoint.springGreenHouse.Log.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration public class LoadDatabase // implements DatabaseMethods
{
  //private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean CommandLineRunner initDatabase(LogRepository logRepo)
  {
    return args -> {
      Log mesurment = new Log(12, 13, 14, LocalDate.now());
      logRepo.save(mesurment);
      //log.info("Preloading " + employeeRepo.save(bob));
    };
  }
}

/*  @Override public void insertLog(Log log)
  {
    Statement stmt = con.createStatement();
    // insert the data
    stmt.executeUpdate(
        "INSERT INTO Log " + log.getId() + log.getCo2() + log.getHumidity()
            + log.getTemperature() + log.getDate());
  }

  @Override public boolean checkActuator(int greenhouseId)
  {

  }*/

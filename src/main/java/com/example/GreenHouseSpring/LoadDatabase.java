package com.example.GreenHouseSpring;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Logger;

import com.example.GreenHouseSpring.log.Log;
import com.example.GreenHouseSpring.log.LogRepository;

import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration public class LoadDatabase// implements DatabaseMethods
{

  //private static final String ac = "SELECT * FROM Greenhouses WHERE actuator = 1";

  private final LogRepository logRepo;


  public LoadDatabase(LogRepository repo)
  {
    this.logRepo = repo;
  }

/*  private static final Logger log = (Logger) LoggerFactory
      .getLogger(LoadDatabase.class);*/
  //Connection connection;

  //  @Bean CommandLineRunner initDatabase(LogRepository logRepo)
  //      throws SQLException
  //  {
  //    connection = DriverManager
  //        .getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "root");
  //    return args -> {
  //      Log measurement = new Log(12, 13, 14, LocalDate.now());
  //      logRepo.save(measurement);
  //      //log.info("Preloading " + employeeRepo.save(bob));
  //    };
  //  }
}


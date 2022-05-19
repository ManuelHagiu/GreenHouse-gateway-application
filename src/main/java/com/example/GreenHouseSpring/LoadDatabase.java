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

@Configuration public class LoadDatabase implements DatabaseMethods
{

  private static final String ac = "SELECT * FROM Greenhouses WHERE actuator = 1";

  private static final Logger log = (Logger) LoggerFactory
      .getLogger(LoadDatabase.class);
  Connection connection;

  @Bean CommandLineRunner initDatabase(LogRepository logRepo)
      throws SQLException
  {
    connection = DriverManager
        .getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "root");
    return args -> {
      Log measurement = new Log(12, 13, 14, LocalDate.now());
      logRepo.save(measurement);
      //log.info("Preloading " + employeeRepo.save(bob));
    };
  }

  @Override public void insertLog(Log log)
  {

    // insert the data
    try
    {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(
          "INSERT INTO Logs (id,Co2,Humidity,Temperature,Date)" + "VALUES ('"
              + log.getId() + "','" + log.getCo2() + "','" + log.getHumidity()
              + "'," + log.getTemperature() + ",'" + log.getDate() + "')");

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public boolean checkActuator(int greenhouseId)
  {
   try

    {
      Statement stmt = connection.createStatement();
      int ac = stmt.executeUpdate(
          "SELECT greenhouseId FROM Greenhouses WHERE actuator  = 1");
      ac = greenhouseId;

    }
    catch (SQLException e)

    {
      e.printStackTrace();
    }
    return false;
  }
}


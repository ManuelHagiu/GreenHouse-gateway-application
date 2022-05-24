package com.example.GreenHouseSpring;

import com.example.GreenHouseSpring.gateway_endpoint.LoRaClient;
import com.example.GreenHouseSpring.log.Log;
import org.springframework.boot.SpringApplication;
import com.example.GreenHouseSpring.service.GreenHouseDbService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class GreenHouseSpringApplication {

  private static DatabaseMethods greenHouseService;

  public GreenHouseSpringApplication(GreenHouseDbService greenHouseService) {
    this.greenHouseService = greenHouseService;
  }

  public static void main(String[] args) {
    SpringApplication.run(GreenHouseSpringApplication.class, args);
   /*Log measurement = new Log(10.00, 10.00, 10.00, LocalDateTime.now(), 1);
    greenHouseService.insertLog(measurement);*/
    greenHouseService.getActiveActuators();
     new LoRaClient((GreenHouseDbService) greenHouseService);
     for (; ; ) ;


    //greenHouseService.getGreenHousesByLocation("nowhere");
  }

}

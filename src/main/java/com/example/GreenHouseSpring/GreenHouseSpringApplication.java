package com.example.GreenHouseSpring;

import com.example.GreenHouseSpring.gateway_endpoint.LoRaClient;
import com.example.GreenHouseSpring.gateway_endpoint.LoRaClientSender;
import com.example.GreenHouseSpring.greenhouse.GreenHouse;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import com.example.GreenHouseSpring.service.GreenHouseDbService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class GreenHouseSpringApplication {

  private static DatabaseMethods greenHouseService;

  public GreenHouseSpringApplication(GreenHouseDbService greenHouseService) {
    this.greenHouseService = greenHouseService;
  }

  public static void main(String[] args) throws JSONException {
    SpringApplication.run(GreenHouseSpringApplication.class, args);
    //Lunch of the LoRaClient client, so we can receive and store the data
    new LoRaClient((GreenHouseDbService) greenHouseService);
  }

  //Scheduled cron task every 20 seconds
  //Check Greenhouse list if the actuator is true then send the data via Websocket to LoRa server and set to false.
  @Scheduled(cron = "0/20 * * * * ?")
  public void publish() throws JSONException {
    List<GreenHouse> listOfGreenHouses = greenHouseService.getActiveActuators();
    if(!listOfGreenHouses.isEmpty()) {
      new LoRaClientSender((GreenHouseDbService) greenHouseService).updateDeviceSettings();
      for (final GreenHouse item: listOfGreenHouses) {
        item.setActuator(false);
        ((GreenHouseDbService) greenHouseService).updateGreenHouse(item);
      }
    }

  }
}

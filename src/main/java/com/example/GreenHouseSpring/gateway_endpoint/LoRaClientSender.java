package com.example.GreenHouseSpring.gateway_endpoint;

import com.example.GreenHouseSpring.greenhouse.GreenHouse;
import com.example.GreenHouseSpring.service.GreenHouseDbService;
import org.json.JSONException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class LoRaClientSender extends LoRaClient {

  /**
   * The constructor for the Lorawan client initializing the fields.
   */
  public LoRaClientSender(GreenHouseDbService greenHouseDbService) {
    super();
    HttpClient client = HttpClient.newHttpClient();
    CompletableFuture<WebSocket> ws = client.newWebSocketBuilder()
        .buildAsync(URI.create(HARDWARE_CONNECTION_STRING), this);
    this.greenHouseDbService = greenHouseDbService;
    server = ws.join();
  }

  public void sendDownLink(String jsonTelegram) {
    this.server.sendText(jsonTelegram, true);
  }

  public void updateDeviceSettings() throws JSONException {
    try {
      String preferredHumidity = convertToHex(30, 4);

      String payload = "".concat(preferredHumidity);

      String uplink = new org.json.JSONObject()
          .put("cmd", "tx")
          .put("EUI", "0004A30B00E7C8E7")
          .put("port", 2)
          .put("data", payload).toString();

      System.out.println("Sending " + uplink);
      this.sendDownLink(uplink);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private String convertToHex(long sourceNum, int targetLength) {
    String source = Long.toHexString(sourceNum);
    while (source.length() < targetLength) {
      source = "0".concat(source);
    }
    return source;
  }

  private String convertToHex(int sourceNum, int targetLength) {
    return convertToHex((long) sourceNum, targetLength);
  }

  /**
   * We only override the onTextZWSP method since we don't want to store the data multiple times
   */
  public CompletionStage<?> onText​(WebSocket webSocket, CharSequence data, boolean last) {
    return new CompletableFuture().completedFuture("onText() completed.")
        .thenAccept(System.out::println);
  }

}
package com.example.GreenHouseSpring.gateway_endpoint;

import com.example.GreenHouseSpring.DatabaseMethods;
import com.example.GreenHouseSpring.LoadDatabase;

import java.io.*;
import java.net.*;

public class WebSocketServer
{
  Socket socket ;
  DatabaseMethods loadDatabase;

  public WebSocketServer()
  {
    loadDatabase=new LoadDatabase();

    new Thread(new Runnable() {
      public void run() {
        while(true){

        }
      }
    }).start();
    final int PORT = 6789;
    System.out.println("Starting Server...");
    ServerSocket welcomeSocket = null;
    try
    {
      welcomeSocket = new ServerSocket(PORT);
      System.out.println("Waiting for a client...");
      socket = welcomeSocket.accept();
      BufferedReader in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      String request = in.readLine();
      System.out.println("Client> " + request);
      String reply = request.toUpperCase();
      System.out.println("Server> " + reply);
      out.println(reply);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  public void TriggerActuator ()
  {
    PrintWriter out = null;
    try
    {
      out = new PrintWriter(socket.getOutputStream(), true);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    out.println("");
  }
}

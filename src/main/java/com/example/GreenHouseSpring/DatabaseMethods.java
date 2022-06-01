package com.example.GreenHouseSpring;


import com.example.GreenHouseSpring.greenhouse.GreenHouse;
import com.example.GreenHouseSpring.log.Log;

import java.util.List;

public interface DatabaseMethods
{
  public void insertLog(Log log);
  public GreenHouse getLastHumidityPreferred();
  public List<GreenHouse> getActiveActuators();
}

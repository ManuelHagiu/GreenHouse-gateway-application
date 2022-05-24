package com.example.GreenHouseSpring;

import com.example.GreenHouseSpring.greenhouse.GreenHouse;
import com.example.GreenHouseSpring.log.Log;

import java.util.List;

public interface DatabaseMethods
{
  public void insertLog(Log log);
  public List<GreenHouse> getActiveActuators();
  public List<GreenHouse> getGreenHousesByLocation(String str);
}

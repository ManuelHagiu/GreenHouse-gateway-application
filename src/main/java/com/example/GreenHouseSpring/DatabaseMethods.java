package com.example.GreenHouseSpring;

import com.example.GreenHouseSpring.log.Log;


public interface DatabaseMethods
{
  public void insertLog(Log log);
  boolean checkActuator(int greenhouseId);
}

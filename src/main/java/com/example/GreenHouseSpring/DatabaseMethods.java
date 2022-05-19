package com.javatpoint.springGreenHouse;

import com.javatpoint.springGreenHouse.Log.Log;

public interface DatabaseMethods
{
  public void insertLog(Log log);
  boolean checkActuator(int greenhouseId);
}

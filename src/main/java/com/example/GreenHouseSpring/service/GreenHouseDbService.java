package com.example.GreenHouseSpring.service;

import com.example.GreenHouseSpring.DatabaseMethods;
import com.example.GreenHouseSpring.greenhouse.GreenHouse;
import com.example.GreenHouseSpring.greenhouse.GreenHouseRepository;
import com.example.GreenHouseSpring.log.Log;
import com.example.GreenHouseSpring.log.LogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service public class GreenHouseDbService implements DatabaseMethods
{
  private final LogRepository logRepo;
  private final GreenHouseRepository greenRepo;

  public GreenHouseDbService(LogRepository logRepo, GreenHouseRepository greenRepo)
  {
    this.logRepo = logRepo;
    this.greenRepo = greenRepo;
  }

  public List<Log> findAll()
  {

    var it = logRepo.findAll();

    var logs = new ArrayList<Log>();
    it.forEach(e -> logs.add(e));

    return logs;
  }

  public Long count()
  {

    return logRepo.count();
  }

  @Override public void insertLog(Log log)
  {
    try
    {
      logRepo.save(log);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<GreenHouse> getActiveActuators()
  {
    List<GreenHouse> listOfGreenHose = null;
    try
    {
      listOfGreenHose = greenRepo.findAllByActuatorEquals(true);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return listOfGreenHose;
  }

  public List<GreenHouse> getGreenHousesByLocation(String locationName)
  {
    List<GreenHouse> listOfGreenHose = null;
    try
    {
      listOfGreenHose = greenRepo.findByLocation(locationName);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return listOfGreenHose;
  }
}
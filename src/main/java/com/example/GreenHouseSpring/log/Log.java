package com.example.GreenHouseSpring.log;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity @Table(name = "Logs", schema = "dbo", catalog = "GreenHouse")
public class Log
{
  @GeneratedValue(strategy = GenerationType.IDENTITY) @Id @Column(name = "Id_Log", nullable = false) private int idLog;
  @Basic @Column(name = "co2", nullable = true, precision = 2) private double co2;
  @Basic @Column(name = "temperature", nullable = true, precision = 2) private double temperature;
  @Basic @Column(name = "humidity", nullable = true, precision = 2) private double humidity;
  @Basic @Column(name = "date", nullable = true) private LocalDateTime date;
  @Basic @Column(name = "Id_Greenhouse", nullable = true) private Integer idGreenhouse;

  public Log(double co2, double temperature, double humidity,
      LocalDateTime date, Integer idGreenhouse)
  {
    this.co2 = co2;
    this.temperature = temperature;
    this.humidity = humidity;
    this.date = date;
    this.idGreenhouse = idGreenhouse;
  }

  public Log() {}

  public int getIdLog()
  {
    return idLog;
  }

  public void setIdLog(int idLog)
  {
    this.idLog = idLog;
  }

  public double getCo2()
  {
    return co2;
  }

  public void setCo2(double co2)
  {
    this.co2 = co2;
  }

  public double getTemperature()
  {
    return temperature;
  }

  public void setTemperature(double temperature)
  {
    this.temperature = temperature;
  }

  public double getHumidity()
  {
    return humidity;
  }

  public void setHumidity(double humidity)
  {
    this.humidity = humidity;
  }

  public LocalDateTime getDate()
  {
    return date;
  }

  public void setDate(LocalDateTime date)
  {
    this.date = date;
  }

  public Integer getIdGreenhouse()
  {
    return idGreenhouse;
  }

  public void setIdGreenhouse(Integer idGreenhouse)
  {
    this.idGreenhouse = idGreenhouse;
  }

}

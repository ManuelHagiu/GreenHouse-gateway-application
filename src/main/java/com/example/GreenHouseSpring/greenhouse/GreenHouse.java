package com.example.GreenHouseSpring.greenhouse;

import javax.persistence.*;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "Greenhouses", schema = "dbo", catalog = "GreenHouse")
public class GreenHouse
{
  @GeneratedValue(strategy = GenerationType.IDENTITY) @Id @Column(name = "Id_Greenhouse", nullable = false) private int idGreenhouse;
  @Basic @Column(name = "name", nullable = true, length = 50) private String name;
  @Basic @Column(name = "description", nullable = true, length = 200) private String description;
  @Basic @Column(name = "location", nullable = true, length = 50) private String location;
  @Basic @Column(name = "area", nullable = true, precision = 2) private BigDecimal area;
  @Basic @Column(name = "co2Preferred", nullable = true, precision = 2) private BigDecimal co2Preferred;
  @Basic @Column(name = "temperaturePreferred", nullable = true, precision = 2) private BigDecimal temperaturePreferred;
  @Basic @Column(name = "humidityPreferred", nullable = true, precision = 2) private BigDecimal humidityPreferred;
  @Basic @Column(name = "actuator", nullable = true) private Boolean actuator;
  @Basic @Column(name = "owner", nullable = true, length = 50) private String owner;

  public int getIdGreenhouse()
  {
    return idGreenhouse;
  }

  public void setIdGreenhouse(int idGreenhouse)
  {
    this.idGreenhouse = idGreenhouse;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getLocation()
  {
    return location;
  }

  public void setLocation(String location)
  {
    this.location = location;
  }

  public BigDecimal getArea()
  {
    return area;
  }

  public void setArea(BigDecimal area)
  {
    this.area = area;
  }

  public BigDecimal getCo2Preferred()
  {
    return co2Preferred;
  }

  public void setCo2Preferred(BigDecimal co2Preferred)
  {
    this.co2Preferred = co2Preferred;
  }

  public BigDecimal getTemperaturePreferred()
  {
    return temperaturePreferred;
  }

  public void setTemperaturePreferred(BigDecimal temperaturePreferred)
  {
    this.temperaturePreferred = temperaturePreferred;
  }

  public BigDecimal getHumidityPreferred()
  {
    return humidityPreferred;
  }

  public void setHumidityPreferred(BigDecimal humidityPreferred)
  {
    this.humidityPreferred = humidityPreferred;
  }

  public Boolean getActuator()
  {
    return actuator;
  }

  public void setActuator(Boolean actuator)
  {
    this.actuator = actuator;
  }

  public String getOwner()
  {
    return owner;
  }

  public void setOwner(String owner)
  {
    this.owner = owner;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    GreenHouse that = (GreenHouse) o;

    if (idGreenhouse != that.idGreenhouse)
      return false;
    if (name != null ? !name.equals(that.name) : that.name != null)
      return false;
    if (description != null ?
        !description.equals(that.description) :
        that.description != null)
      return false;
    if (location != null ?
        !location.equals(that.location) :
        that.location != null)
      return false;
    if (area != null ? !area.equals(that.area) : that.area != null)
      return false;
    if (co2Preferred != null ?
        !co2Preferred.equals(that.co2Preferred) :
        that.co2Preferred != null)
      return false;
    if (temperaturePreferred != null ?
        !temperaturePreferred.equals(that.temperaturePreferred) :
        that.temperaturePreferred != null)
      return false;
    if (humidityPreferred != null ?
        !humidityPreferred.equals(that.humidityPreferred) :
        that.humidityPreferred != null)
      return false;
    if (actuator != null ?
        !actuator.equals(that.actuator) :
        that.actuator != null)
      return false;
    if (owner != null ? !owner.equals(that.owner) : that.owner != null)
      return false;

    return true;
  }

  @Override public int hashCode()
  {
    int result = idGreenhouse;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (location != null ? location.hashCode() : 0);
    result = 31 * result + (area != null ? area.hashCode() : 0);
    result = 31 * result + (co2Preferred != null ? co2Preferred.hashCode() : 0);
    result = 31 * result + (temperaturePreferred != null ?
        temperaturePreferred.hashCode() :
        0);
    result = 31 * result + (humidityPreferred != null ?
        humidityPreferred.hashCode() :
        0);
    result = 31 * result + (actuator != null ? actuator.hashCode() : 0);
    result = 31 * result + (owner != null ? owner.hashCode() : 0);
    return result;
  }
}

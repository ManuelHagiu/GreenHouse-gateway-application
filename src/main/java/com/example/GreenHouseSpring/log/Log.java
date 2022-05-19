package com.javatpoint.springGreenHouse.Log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Log")
@Table(name = "logs")


public class Log
{
  @Id
  @GeneratedValue(generator = "sequence-generator")
  @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
          @org.hibernate.annotations.Parameter(name = "sequence_name", value = "log_sequence"),
          @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
          @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")

      }
  )
  @Column(updatable = false)
  private Integer id;
  @Column(nullable = false)
  private int  co2 ;
  @Column(nullable = false)
  private int temperature ;
  @Column(nullable = false)
  private int humidity  ;
  @Column(nullable = false)
  private LocalDate date  ;
  // @ManyToMany(mappedBy = "enrolledLog")
  @JsonIgnoreProperties("enrolledLog")
  //private Set<Project> projects;

  Log() {
  }

  public Log(int co2, int temperature, int humidity, LocalDate date ) {
    this.co2 = co2;
    this.temperature = temperature;
    this.humidity = humidity;
    this.date = date;
    // this.projects = new HashSet<>();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getCo2() {
    return co2;
  }

  public void setCo2(int co2) {
    this.co2 = co2;
  }

  public int getTemperature() {
    return temperature;
  }

  public void setTemperature(int temperature) {
    this.temperature = temperature;
  }

  public int getHumidity() {
    return humidity;
  }

  public void setHumidity(int humidity) {
    this.humidity = humidity;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

/* public Set<Project> getProjects() {
    return projects;
  }

  public void setProjects(Set<Project> projects) {
    this.projects = projects;
  }
}*/

}

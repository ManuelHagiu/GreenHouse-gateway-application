package com.example.GreenHouseSpring.greenhouse;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GreenHouseRepository extends JpaRepository<GreenHouse,Integer>
{
  public List<GreenHouse> findAllByActuatorEquals(boolean value);
  public List<GreenHouse> findByLocation(String name);

  //public List<GreenHouse> findByName

}



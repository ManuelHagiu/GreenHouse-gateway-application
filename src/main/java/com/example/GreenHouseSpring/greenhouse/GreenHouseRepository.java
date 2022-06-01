package com.example.GreenHouseSpring.greenhouse;

import com.example.GreenHouseSpring.service.GreenHouseDbService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GreenHouseRepository extends JpaRepository<GreenHouse,Integer>
{
  public GreenHouse findTopByOrderByIdGreenhouseDesc();

  public List<GreenHouse> findAllByActuatorEquals(boolean value);

}



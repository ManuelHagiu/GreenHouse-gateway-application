package com.example.GreenHouseSpring.log;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController public class LogController
{
  private final LogRepository repository;

  LogController(LogRepository repository)
  {
    this.repository = repository;
  }

  @GetMapping("/log") List<Log> all()
  {
    return repository.findAll();
  }

  @PostMapping("/logs") Log newLog(@RequestBody Log newLog)
  {
    return repository.save(newLog);
  }

  @GetMapping("/logs/{id}") Log one(@PathVariable int id)
  {
    return repository.findById(id).orElseThrow(

        /*  () -> new LogNotFoundException(id)*/

    );
  }

  @PostMapping(path = "/add") // Map ONLY POST Requests
  public @ResponseBody String addNewLog(@RequestParam int co2,
      @RequestParam int temperature, @RequestParam int humidity,
      @RequestParam LocalDate date)
  {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

//    Log n = new Log();
//    n.setCo2(co2);
//    n.setTemperature(temperature);
//    n.setHumidity(humidity);
//    n.setDate(date);
//    repository.save(n);
    return "Saved";
  }

  @DeleteMapping("logs/{id}") void deleteLog(@PathVariable Integer id)
  {
    repository.deleteById(id);
  }
}


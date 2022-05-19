package com.javatpoint.springGreenHouse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController
{

  @GetMapping("/")
  String health() {
    return " Hello ";
  }
}

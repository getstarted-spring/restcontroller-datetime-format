package io.getstarted.spring;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/default")
public class DefaultFormatRestController {

  @GetMapping(params = "date")
  public String localDate(@RequestParam final LocalDate date) {
    return date.toString();
  }

  @GetMapping(params = "time")
  public String localTime(@RequestParam final LocalTime time) {
    return time.toString();
  }

  @GetMapping(params = "dateTime")
  public String localDateTime(@RequestParam final LocalDateTime dateTime) {
    return dateTime.toString();
  }
}

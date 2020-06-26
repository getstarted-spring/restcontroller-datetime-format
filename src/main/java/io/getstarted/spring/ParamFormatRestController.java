package io.getstarted.spring;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/param")
public class ParamFormatRestController {

  @GetMapping(params = "date")
  public String localDate(
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate date) {
    return date.toString();
  }

  @GetMapping(params = "time")
  public String localTime(
      @RequestParam @DateTimeFormat(pattern = "HH:mm:ss") final LocalTime time) {
    return time.toString();
  }

  @GetMapping(params = "dateTime")
  public String localDateTime(
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
          final LocalDateTime dateTime) {
    return dateTime.toString();
  }
}

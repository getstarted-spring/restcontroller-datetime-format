package io.getstarted.spring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {DefaultFormatRestController.class})
class DefaultFormatRestControllerTests {

  @Autowired private MockMvc mvc;

  @Test
  void localDate() throws Exception {
    final String date =
        DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(LocalDate.parse("2019-12-31"));
    mvc.perform(get("/default").param("date", date).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void localTime() throws Exception {
    final String time =
        DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.parse("12:59:59"));
    mvc.perform(get("/default").param("time", time).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void localDateTime() throws Exception {
    final String dateTime =
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
            .format(LocalDateTime.parse("2019-12-31T12:59:59"));
    mvc.perform(get("/default").param("dateTime", dateTime).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }
}

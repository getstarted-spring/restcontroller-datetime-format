package io.getstarted.spring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {DefaultFormatRestController.class})
@Import({DateFormatConfiguration.class})
public class GlobalFormatRestControllerTests {

  @Autowired private MockMvc mvc;

  @Test
  void localDate() throws Exception {
    mvc.perform(get("/default").param("date", "2019-12-31").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void localTime() throws Exception {
    mvc.perform(get("/default").param("time", "12:59:59").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void localDateTime() throws Exception {
    mvc.perform(
            get("/default")
                .param("dateTime", "2019-12-31T12:59:59")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }
}

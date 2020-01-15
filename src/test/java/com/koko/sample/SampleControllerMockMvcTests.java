package com.koko.sample;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(SampleController.class)
@AutoConfigureMockMvc
class SampleControllerMockMvcTests {

  @MockBean
  SampleService sampleService;


  @Test
  public void hello(@Autowired MockMvc mockMvc) throws Exception {
    when(sampleService.getName()).thenReturn("world");

    mockMvc.perform(get("/hello"))
        .andExpect(status().is(200))
        .andExpect(content().string("hello world"))
        .andDo(print());

  }

}

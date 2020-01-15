package com.koko.sample;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class SampleControllerWebClientTests {

  @MockBean
  SampleService sampleService;


  @Test
  public void helloClientTest(@Autowired WebTestClient webTestClient) throws Exception {
    when(sampleService.getName()).thenReturn("world");
    webTestClient.get().uri("/hello").exchange()
        .expectStatus().is2xxSuccessful()
        .expectBody(String.class).isEqualTo("hello world");


  }
}

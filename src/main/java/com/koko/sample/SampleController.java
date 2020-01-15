package com.koko.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

  private final SampleService sampleService;

  public SampleController(SampleService sampleService) {
    this.sampleService = sampleService;
  }


  @GetMapping("/hello")
  public String hello() {
    return "hello " + sampleService.getName();
  }


}

package com.koko.sample;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

@JsonTest
class SampleJsonTest {

  @Autowired
  private JacksonTester<Sample> json;

  @Test
  public void SampleJsonTest() throws IOException {
    Sample sample = new Sample();
    sample.setName("kimchi");
    sample.setAge(500);

    assertThat(this.json.write(sample)).as("json 문서와 비교").isEqualToJson("/sample.json");
    assertThat(this.json.write(sample)).hasJsonPathStringValue("@.name");
    assertThat(this.json.write(sample)).hasJsonPathNumberValue("@.age");
    assertThat(this.json.write(sample)).extractingJsonPathStringValue("@.name").isEqualTo(sample.getName());

    assertThat(this.json.read("/sample.json")).hasFieldOrProperty("name");
    assertThat(this.json.read("/sample.json")).hasFieldOrPropertyWithValue("name", sample.getName());
  }
}
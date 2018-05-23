package com.github.detouched;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@SpringBootApplication
public class DemoValueApp {

    // This doesn't start up:
    // Error creating bean with name 'demoBean' ...
    // ...
    // Caused by: java.lang.IllegalStateException: Cannot convert value of type 'java.lang.String' to required type 'java.time.Duration': no matching editors or conversion strategy found
    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoValueApp.class)
                .bannerMode(Banner.Mode.OFF)
                .headless(true)
                .logStartupInfo(false)
                .run(args);
    }

    @Bean
    public String demoBean(@Value("property") Duration property) {
        return "I was given a property through @Value: " + property;
    }
}

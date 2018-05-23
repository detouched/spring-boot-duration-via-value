package com.github.detouched;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.time.Duration;

@SpringBootApplication
@Import(DemoConfigurationPropertiesApp.Props.class)
public class DemoConfigurationPropertiesApp {

    // This starts up without any issues
    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoConfigurationPropertiesApp.class)
                .bannerMode(Banner.Mode.OFF)
                .headless(true)
                .logStartupInfo(false)
                .run(args);
    }

    @Bean
    public String demoBean(Props props) {
        return "I was given a property through @ConfigurationProperties: " + props.getProperty();
    }

    @ConfigurationProperties
    public static class Props {
        private Duration property;

        public Duration getProperty() {
            return property;
        }

        public void setProperty(Duration property) {
            this.property = property;
        }
    }

}

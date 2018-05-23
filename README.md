This repository contains two Spring Boot 2 apps as an example of an issue with
properties injection.
 
[Recently introduced](https://github.com/spring-projects/spring-boot/issues/11078)
support for parsing human-readable format of `java.time.Duration` properties
is incomplete. It works for properties injected into a structured object through
`@ConfigurationProperties`, but it does not work for properties injected through
`@Value`.

There are two Spring Boot 2 applications in this repository, each of which defines
just one bean that needs a `Duration` property to be injected from `application.yml`:

* [`DemoConfigurationPropertiesApp`](/src/main/java/com/github/detouched/DemoConfigurationPropertiesApp.java)
  shows the supported use case.
* [`DemoValueApp`](/src/main/java/com/github/detouched/DemoValueApp.java) shows the
  use case which is not supported yet.

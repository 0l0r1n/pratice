# Spring Framework

## Important annotations

- @SpringBootApplication: adds @Configuration, @EnableAutoConfiguration and @ComponentScan
- A daemon is a program that runs on a background process
- @Data is a lombok annotation that creates all gets, settings, hash and toString methods, based on the fields (thank God for this)
- @Entity is part of the JPA, makes the object read for storage in a JPA-based data store. (JPA - java persistence API)
- Srping data repositories do all the boring work (CRUD, paging, sorting, talking to the DB, etc)
- Spring Boot runs all command line runner beans once the application is loaded
- @ResponseBody means the the advise will be rendered straight into response body
- Exception handler means it only works when an employee not found exception is thrown
- @ResponseStatus sets the status response to 404
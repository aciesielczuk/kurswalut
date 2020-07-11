# kurswalut
A simple server application implementing the RESTful web service based on JAX-RS.
The website's task is to calculate the average exchange rate from recent reports based on data published by the NBP website (https://api.nbp.pl/).

## Technologies
Project created with:
* Java 8
* Java EE
* Maven
* GlassFish
* JAX-RS
* JAXB
* JUnit 5
* MockServer JUnit Jupiter

## Setup
To use: Clone the repository, make sure you have properly configured the GlassFish server and run it using your IDE.<br/>
App start at http://localhost:8080/kurswalut/exchangerates/rates/C/{code}/{topCount}
* {code} – a three letter currency code (ISO 4217 standard)
* {topCount} – a number determining the maximum size of the returned data series<br/>

Example: http://localhost:8080/kurswalut/exchangerates/rates/C/USD/10

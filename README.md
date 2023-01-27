
<!-- ============================================  TITLE ======================================================  -->

# Doctor_Patient_Managment_System
 Platform where doctors can register their patients through a mobile or web portal. For this to work I have built backend APIs to achieve task like: Adding a doctor Adding a patient &amp; it’s symptom Suggesting the doctor based on patient’s symptom


<!-- ============================================  TECH STACK ======================================================  -->

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* swagger ui

<!-- ============================================  FEATURES ======================================================  -->

  
## Features
* We can register a doctor
* delete any doctor by DoctorId
* register a patient
* delete a patient by patientID
* Suggest best doctors based on patients location and symtoms
<!-- ============================================  MODULES ======================================================  -->

## Modules

* Doctor Module
* Patient Module
* DoctorSuggestion Module


<!-- ============================================  INSTALLATION AND RUN ======================================================  -->

## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties] file.


```
    #changing the server port
    server.port=8888

    #db specific properties
    spring.datasource.url=jdbc:mysql://127.0.0.1:3306/PatienttManagement
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=****
    spring.datasource.password=****
    
    #ORM s/w specific properties
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

```
* Swagger dependency has been added to the applicaiton, Hence API's can be accessed using PostMan or Swagger UI.
* URL for accessing Swagger UI : http://localhost:8888/swagger-ui/




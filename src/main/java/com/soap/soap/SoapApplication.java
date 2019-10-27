package com.soap.soap;

import countries.wsdl.GetAllUniversitiesAtLocationResponse;
import countries.wsdl.GetUniversityResponse;
import countries.wsdl.University;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapApplication.class, args);
    }

    @Bean
    CommandLineRunner getUniversityName(UniversityClient client){
        return args -> {
            String name = "Strathmore";
            String location = "Kiambu";
            if (args.length > 0){
                name = args[0];
                location = args[0];
            }
            GetUniversityResponse response = client.getUniversityResponse(name);
            University university = response.getUniversity();
            System.out.println(
                    "University Name: " + university.getName() + "\n University Location: " + university.getLocation() + "\n University Year Founded: " + university.getYearFounded()
            );

            GetAllUniversitiesAtLocationResponse response1 = client.getAllUniversitiesAtLocationResponse(location);
            University university1 = response1.getUniversity();
            System.out.println(
                    "University Name: " + university1.getName() + "\n University Location: " + university1.getLocation() + "\n University Year Founded: " + university1.getYearFounded()
            );
        };
    }

}

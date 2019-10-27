package com.soap.soap;

import countries.wsdl.GetAllUniversitiesAtLocationResponse;
import countries.wsdl.GetAllUniversitiesResponse;
import countries.wsdl.GetUniversityResponse;
import countries.wsdl.University;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

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
                    "\n University By Name \n" +
                    "University Name: " + university.getName() + "\n University Location: " + university.getLocation() + "\n University Year Founded: " + university.getYearFounded() + "\n "
            );

            GetAllUniversitiesAtLocationResponse response1 = client.getAllUniversitiesAtLocationResponse(location);
            University university1 = response1.getUniversity();
            System.out.println(
                    "\n University By Location \n" +
                    "University Name: " + university1.getName() + "\n University Location: " + university1.getLocation() + "\n University Year Founded: " + university1.getYearFounded() + "\n "
            );

            GetAllUniversitiesResponse response2 = client.getAllUniversitiesResponse();
            ArrayList<University> alluniversities = (ArrayList<University>) response2.getUniversity();
            System.out.println("\n All Universities \n");
            for (University alluniversity : alluniversities) {
                System.out.println(
                        "University Name: " + alluniversity.getName() +
                                "\n University Location: " + alluniversity.getLocation() +
                                "\n University Year Founded: " + alluniversity.getYearFounded()
                );
            }
        };
    }

}

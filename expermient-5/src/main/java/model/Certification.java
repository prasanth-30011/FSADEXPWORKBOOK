package model;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 501;
    private String name = "Spring Professional";
    private String dateOfCompletion = "2026-05-20";

    @Override
    public String toString() {
        return "Certification ID: " + id +
               "\nCertification Name: " + name +
               "\nCompletion Date: " + dateOfCompletion;
    }
}

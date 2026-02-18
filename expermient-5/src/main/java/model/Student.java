package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id = 101;
    private String name = "Prasanth";
    private String gender = "Male";

    @Autowired   // 🔥 Spring injects automatically
    private Certification certification;

    @Override
    public String toString() {

        return "Student ID: " + id +
               "\nName: " + name +
               "\nGender: " + gender +
               "\n\n--- Certification Details ---\n" +
               certification;
    }
}

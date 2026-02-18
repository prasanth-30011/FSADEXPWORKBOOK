package config;

import model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Constructor Injection
    @Bean(name="studentConstructor")
    public Student studentByConstructor() {
        return new Student(201, "Charlie", "Electronics", 2);
    }

    // Setter Injection
    @Bean(name="studentSetter")
    public Student studentBySetter() {
        Student s = new Student(202, "Diana", "Chemistry", 1);
        s.setCourse("Biotechnology");
        s.setYear(4);
        return s;
    }
}

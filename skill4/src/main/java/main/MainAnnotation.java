package main;

import config.AppConfig;
import model.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAnnotation {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("=== Constructor Injection Annotation ===");

        Student s1 = context.getBean("studentConstructor", Student.class);
        System.out.println(s1);

        System.out.println("=== Setter Injection Annotation ===");

        Student s2 = context.getBean("studentSetter", Student.class);
        System.out.println(s2);

        context.close();
    }
}

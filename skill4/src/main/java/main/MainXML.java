package main;

import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXML {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("=== Constructor Injection XML ===");

        Student s1 = context.getBean("studentConstructor", Student.class);
        System.out.println(s1);

        System.out.println("=== Setter Injection XML ===");

        Student s2 = context.getBean("studentSetter", Student.class);
        System.out.println(s2);

        ((ClassPathXmlApplicationContext)context).close();
    }
}

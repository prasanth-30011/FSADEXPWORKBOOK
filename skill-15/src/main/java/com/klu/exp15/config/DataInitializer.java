package com.klu.exp15.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.klu.exp15.entity.User;
import com.klu.exp15.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Check if admin user exists
        if (userRepository.findByUsername("admin").isEmpty()) {
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword(passwordEncoder.encode("12345")); // BCrypt encoded
            adminUser.setRole("ADMIN");
            
            userRepository.save(adminUser);
            System.out.println("✅ Admin user created with username: admin, password: 12345");
        } else {
            System.out.println("✅ Admin user already exists");
        }
        
        // Check if employee user exists
        if (userRepository.findByUsername("employee").isEmpty()) {
            User employeeUser = new User();
            employeeUser.setUsername("employee");
            employeeUser.setPassword(passwordEncoder.encode("12345")); // BCrypt encoded
            employeeUser.setRole("EMPLOYEE");
            
            userRepository.save(employeeUser);
            System.out.println("✅ Employee user created with username: employee, password: 12345");
        } else {
            System.out.println("✅ Employee user already exists");
        }
    }
}

package com.addressbook;

import com.addressbook.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Initialize Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Address Book Application Context Initialized!");
        System.out.println("Deploy the WAR file to a servlet container (Tomcat, Jetty, etc.)");
        System.out.println("Access the API at: http://localhost:8080/day8/api/addresses");
        System.out.println("\nNote: This is a Spring Framework application (not Spring Boot)");
        System.out.println("It needs to be deployed to a servlet container to run the web application.");
    }
}



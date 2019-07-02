package ru.brazhnikov.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopDeveloperRunner {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("aop-config.xml");
        Developer developer = (Developer) context.getBean("StudentsService");

        System.out.println(developer);
        //developer.throwSomeMysticException();
    }
}

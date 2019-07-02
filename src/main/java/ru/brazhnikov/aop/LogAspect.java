package ru.brazhnikov.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import ru.brazhnikov.entities.Student;
import ru.brazhnikov.services.StudentsService;

@Aspect
@Configuration
@EnableAspectJAutoProxy
public class LogAspect {
    // определяем срез по всем методам бинов из пакета
    @Before("execution(* ru.brazhnikov.services.*.*(..))")
    private void before( JoinPoint joinPoint ) {
        System.out.println( joinPoint );
    }
}

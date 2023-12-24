package org.example.library.core.aop.logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Pointcut("execution(public * org.example.library.api.controller.BookController.getAll())")
    public void getAllControllerMethod() {}

    @Before("getAllControllerMethod()")
    public void addLoggingForGetAllMethod() {
        System.out.println("Invoked getAll method");
    }
}

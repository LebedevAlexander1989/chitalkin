package org.example.library.core.aop.logger;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class BookControllerLoggerAspect {

    @Pointcut("execution(public * org.example.library.api.controller.BookController.getAll())")
    public void getAllControllerMethod() {}

    @Before("getAllControllerMethod() && target(controller)")
    public void addLoggingForGetAllMethod(Object controller) {
        log.info("Invoked getAll method in class {}", controller);
    }

    @Pointcut("execution(public * org.example.library.api.controller.BookController.add(*))")
    public void addControllerMethod() {}

    @Before(value = "addControllerMethod() " +
            "&& args(requestBookDto)" +
            "&& target(controller)",
            argNames = "requestBookDto,controller")
    public void addLoggingForAddMethod(Object requestBookDto, Object controller) {
        log.info("Invoked add method in class {}, with requestBookDto: {}", controller, requestBookDto);
    }

    @Pointcut("execution(public * org.example.library.api.controller.BookController.update(*))")
    public void updateControllerMethod() {}

    @Before(value = "updateControllerMethod() " +
            "&& args(requestBookDto)" +
            "&& target(controller)",
            argNames = "requestBookDto,controller")
    public void addLoggingForUpdateMethod(Object requestBookDto, Object controller) {
        log.info("Invoked update method in class {}, with requestBookDto: {}", controller, requestBookDto);
    }

    @Pointcut("execution(public * org.example.library.api.controller.BookController.getStatus(*))")
    public void getStatusControllerMethod() {}

    @Before(value = "getStatusControllerMethod() " +
            "&& args(id)" +
            "&& target(controller)",
            argNames = "id,controller")
    public void addLoggingForGetStatusMethod(Object id, Object controller) {
        log.info("Invoked getStatus method in class {}, with id {}", controller, id);
    }
}

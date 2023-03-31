package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class HelloServiceAspect {

    @Before("execution(* services.HelloService.hello(..))")
    public void before(){
        System.out.println("before");
    }

    // Does not matter if method had exception or not. It will work after execution of the method.
    @After("execution(* services.HelloService.hello(..))")
    public void after(){
        System.out.println("after");
    }

    // If you don't have any exception
    @AfterReturning("execution(* services.HelloService.hello(..))")
    public void afterReturning(){
        System.out.println("afterReturning");
    }

    // If an error throwed.
    @AfterThrowing("execution(* services.HelloService.hello(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }

    // The running of method is managed here. You can run the method once, twice, three times...
    // You can run method in some conditions.
    // You don't run the method and instead return something else.
    // Do not change the flow and functionality. It will make your business logic much more complex than it should be.
    // Logging can be made.
    @Around("execution(* services.HelloService.hello2(..))")
    public Object aroundHello2(ProceedingJoinPoint joinPoint){
        String val = "hiii around";
        System.out.println("around method : " + val);
        return val;
    }

    @Around("execution(* services.HelloService.hello3(..))")
    public Object aroundHello3(ProceedingJoinPoint joinPoint){
        System.out.println("aroundHello3 is running");
        Object result = null;
        try {
            result = joinPoint.proceed();
        }catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }


    // Parameters also can be manipulated.
    @Around("execution(* services.HelloService.hello4(..))")
    public Object aroundHello4(ProceedingJoinPoint joinPoint){
        System.out.println("aroundHello4 is running");
        System.out.println("params : [" + Arrays.stream(joinPoint.getArgs()).map(Object::toString).collect(Collectors.joining(",")) + "]");
        System.out.println(joinPoint.getSignature());
        Object result = null;
        try {
            result = joinPoint.proceed(new Object[]{"Changed Parameter"});
        }catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }

}

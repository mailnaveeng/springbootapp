package hello;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Aspect
@Configuration
public class UserAccessAspect {

    @Autowired
    Map<String, Integer> exceptionCounter;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
    @AfterThrowing("execution(* hello.ExternalService.*(..))")
    public void before(JoinPoint joinPoint){
        //Advice
        logger.info("New Check for user access ");
        logger.info(" Allowed execution for {}", joinPoint);
        logger.info(" Allowed execution for {}", joinPoint.getSignature());
        logger.info(" Allowed execution for {}", joinPoint.getSignature().getDeclaringTypeName());
        logger.info(" Allowed execution for {}", joinPoint.getSignature().getDeclaringType());
        logger.info(" Allowed execution for {}", joinPoint.getSignature().getModifiers());
        logger.info(" Allowed execution for {}", joinPoint.getSignature().getName());
        exceptionCounter.put(joinPoint.getSignature().getDeclaringTypeName(),exceptionCounter.getOrDefault(joinPoint.getSignature().getDeclaringTypeName(),0)+1);
    }
}

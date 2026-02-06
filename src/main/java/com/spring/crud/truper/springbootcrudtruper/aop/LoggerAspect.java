package com.spring.crud.truper.springbootcrudtruper.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.spring.crud.truper.springbootcrudtruper.dto.OrdenesDto;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Aspect
@Component
public class LoggerAspect {
	
	@Before("@annotation(com.spring.crud.truper.springbootcrudtruper.anotaciones.LogObjectBefore)")
    public void logSportsIconBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof OrdenesDto) {
            	OrdenesDto ordenesDto = (OrdenesDto) arg;
                log.info("******* Orden Input :: {}", ordenesDto);
            }  
        }
    }

    @AfterReturning(value = "@annotation(com.spring.crud.truper.springbootcrudtruper.anotaciones.LogObjectAfter)", returning = "result")
    public void logSportsIconAfter(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        if (Objects.nonNull(result)) {
            if (result instanceof ResponseEntity) {
                ResponseEntity responseEntity = (ResponseEntity) result;
                if (responseEntity.getStatusCode().value() == 200)
                    log.info("******* Respuesta:: {}", responseEntity.getBody());
                else
                    log.error("Error al generar log...!");
            }
        }
    }
    
    @Around("@annotation(com.spring.crud.truper.springbootcrudtruper.anotaciones.LogTiempoEjecucion)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long inicio = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long tiempoEjecucion = System.currentTimeMillis() - inicio;
        log.info("{} ejecutado en {} ms", joinPoint.getSignature(), tiempoEjecucion);
        return proceed;
    }
	
	
}

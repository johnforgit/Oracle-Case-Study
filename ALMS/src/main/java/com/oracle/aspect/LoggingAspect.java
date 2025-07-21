package com.oracle.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
	@Before(" execution(* com.oracle.*.*.*(..))")
		public void beforeAdvice(JoinPoint point) {
			log.info("*****Before Advice Applied on --"+point.getSignature().getName());
		}
	@After(" execution(* com.oracle.*.*.*(..))")
		public void afterAdvice(JoinPoint point) {
			log.info("*****After Advice Applied on --"+point.getSignature().getName());
		}
	@AfterReturning(pointcut=" execution(* com.oracle.*.*.*(..))",returning="result")
	public void afterReturning(JoinPoint point,Object result) {
		log.info("*****After returning Advice Applied on --"+point.getSignature().getName()+" returned "+result);
	}
	@AfterThrowing(pointcut=" execution(* com.oracle.*.*.*(..))",throwing="error")
	public void afterThrowing(JoinPoint point,Throwable error) {
		log.info("*****After throwing Advice Applied on --"+point.getSignature().getName()+" threw "+error);
	}
	@Around("getPointCut()")
	public Object around(ProceedingJoinPoint joinPoint) {
		log.info("*****Around Advice Applied on --"+joinPoint.getSignature().getName());
		String outcome=null;
		try {
			outcome=(String)joinPoint.proceed();
			if(outcome instanceof String) {
				outcome=outcome.toUpperCase();
			}
		}
			catch(Throwable e) {
				e.printStackTrace();
			}
			return outcome;
		}
	}



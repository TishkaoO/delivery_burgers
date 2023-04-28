package com.example.delivery_burgers.proxy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//@Aspect
//@Component
//@Slf4j
//@EnableScheduling
//public class LoggableAspect {
//    private final Map<String, Integer> methodCallCount = new HashMap<>();
//
//    @Around("@annotation(Loggable)")
//    private void logMethodCall(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        if (!methodCallCount.containsKey(methodName)) {
//            methodCallCount.put(methodName, 1);
//        } else {
//            int count = methodCallCount.get(methodName);
//            methodCallCount.put(methodName, count + 1);
//        }
//        log.info("Method {} called", methodName);
//    }
//
//    @Scheduled(fixedDelay = 60000)
//    public void logMethodCallCount() {
//        log.info("Method call count:");
//        for (Map.Entry<String, Integer> entry : methodCallCount.entrySet()) {
//            log.info("{}: {}", entry.getKey(), entry.getValue());
//        }
//    }
//}

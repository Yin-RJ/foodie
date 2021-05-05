package com.yinrj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/5
 */
@Component
@Aspect
public class LogAspect {
    public static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);

    @Around("execution(* com.yinrj.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        LOG.info("============= {}.{} 开始执行 ==============", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName());
        long beginTime = System.currentTimeMillis();
        Object res = joinPoint.proceed();
        // 记录结束时间
        long endTime = System.currentTimeMillis();
        long takeTime = endTime - beginTime;

        if (takeTime > 3000) {
            LOG.error("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        } else if (takeTime > 2000) {
            LOG.warn("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        } else {
            LOG.info("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        }

        return res;
    }
}

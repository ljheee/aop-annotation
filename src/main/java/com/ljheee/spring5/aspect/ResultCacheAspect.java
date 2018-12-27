package com.ljheee.spring5.aspect;

import com.ljheee.spring5.annotation.ResultCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存 后端结果
 * 实现接口幂等性
 */
@Aspect
@Component
public class ResultCacheAspect {

    private final Map<String, Object> localCache = new ConcurrentHashMap<>();

    @Around("@annotation(resultCache)")
    public Object doAround(ProceedingJoinPoint pjp, ResultCache resultCache) throws Throwable {

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        String key = method.toString() + Arrays.toString(pjp.getArgs());// 方法签名 + 参数列表

        if (localCache.containsKey(key) && localCache.get(key) != null) {
            Object result = localCache.get(key);
            System.out.println("get form cache." + result);

            //如果上次执行处理为异常
            if (result instanceof Exception) {
                Exception exception = (Exception) result;
                throw exception;
            } else {
                //如果不是Exception，则返回该结果
                return result;
            }

        } else {
            Object result = pjp.proceed();
            localCache.put(key, result);
            return result;
        }
    }
}

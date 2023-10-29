package com.pyw.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class XmlAdvice {
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知!");
        System.out.println("目标类：" + joinPoint.getTarget());
        System.out.println("增强处理方法:" + joinPoint.getSignature().getName());
    }
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("返回通知（无异常出现）");
        System.out.println("增强处理方法:" + joinPoint.getSignature().getName());
    }
    public Object around(ProceedingJoinPoint point)throws Throwable{
        System.out.println("环绕通知前面");
        Object object=point.proceed();
        System.out.println("环绕通知后面");
        return object;
    }
    public void afterException(){
        System.out.println("异常通知");
    }
    public void after(){
        System.out.println("后置通知");
    }
}

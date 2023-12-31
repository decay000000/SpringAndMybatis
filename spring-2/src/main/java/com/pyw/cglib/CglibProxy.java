package com.pyw.cglib;

import com.pyw.jdk.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    public Object createProxy(Object target){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)throws Throwable{
        MyAspect myAspect = new MyAspect();
        myAspect.check_Permissions();
        Object obj = methodProxy.invokeSuper(proxy,args);
        myAspect.log();
        return obj;
    }
}

package com.dk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//用此类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private Object target;

    public void setTarget(Object target){
        this.target = target;
    }

    //生成代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    //处理代理实例并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        log(method.getName());
        Object result = method.invoke(target, args);
        return result;
    }

    public void log(String method){
        System.out.println("[debug]正在执行"+method+"方法");
    }
}

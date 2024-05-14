package com.dk.ioc;

import org.springframework.stereotype.Component;

@Component
public class CalImpl implements Cal{
    @Override
    public int Add(int a,int b) {
        int result = a + b;
        return result;
    }

    @Override
    public int sub(int a,int b) {
        int result = a - b;
        return result;
    }

    @Override
    public int mul(int a,int b) {
        int result = a * b;
        return result;
    }

    @Override
    public int div(int a,int b) {
        int result = a / b;
        return result;
    }
}

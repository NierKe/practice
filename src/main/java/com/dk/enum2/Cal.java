package com.dk.enum2;

public enum Cal {
    ADD("+","加"){
        @Override
        double calculate(double x, double y) {
            return x + y;
        }
    },
    SUB("-","减"){
        @Override
        double calculate(double x, double y) {
            return x - y;
        }
    },
    MUL("*","乘"){
        @Override
        double calculate(double x, double y) {
            return x * y;
        }
    },
    DIV("/","除"){
        @Override
        double calculate(double x, double y) {
            return x / y;
        }
    };

    private String code;
    private String message;

    Cal(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public static Cal getCal(String code){
        for(Cal cal : Cal.values()){
            if(cal.code.equals(code)){
                return cal;
            }
        }
        return null;
    }

    abstract double calculate(double x, double y);
}

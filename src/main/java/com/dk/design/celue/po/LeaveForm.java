package com.dk.design.celue.po;

public class LeaveForm {
    private Employee employee;
    private String reason;
    private int days;
    private int type;//1-病假 2-婚丧假 3-年假

    @Override
    public String toString() {
        return "LeaveForm{" +
                "employee=" + employee +
                ", reason='" + reason + '\'' +
                ", days=" + days +
                ", type=" + type +
                '}';
    }

    public LeaveForm(Employee employee, int type, String reason, int days) {
        this.employee = employee;
        this.reason = reason;
        this.days = days;
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

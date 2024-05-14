package com.dk.design.celue.po.stratege;

import com.dk.design.celue.po.LeaveForm;

public class AuditStrategeImpl3 implements AuditStratege{
    @Override
    public boolean isSupport(LeaveForm leaveForm) {
        return leaveForm.getEmployee().getLevel() == 9;
    }

    @Override
    public void audit(LeaveForm leaveForm) {
        System.out.println(leaveForm);
        System.out.println("总经理请假无需审批");
    }

    @Override
    public int getPriority() {
        return 999;
    }

    @Override
    public String getName() {
        return "总经理请假规则";
    }

}

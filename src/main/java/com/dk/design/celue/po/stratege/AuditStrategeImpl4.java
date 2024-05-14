package com.dk.design.celue.po.stratege;

import com.dk.design.celue.po.LeaveForm;

public class AuditStrategeImpl4 implements AuditStratege{
    @Override
    public boolean isSupport(LeaveForm leaveForm) {
        return leaveForm.getDays() == 1 && leaveForm.getType() == 0;
    }

    @Override
    public void audit(LeaveForm leaveForm) {
        System.out.println(leaveForm);
        System.out.println("一天病假无需审批自动通过");
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String getName() {
        return "一天病假请假规则";
    }
}

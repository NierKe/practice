package com.dk.design.celue.po.stratege;

import com.dk.design.celue.po.LeaveForm;

public class AuditStrategeImpl1 implements AuditStratege{
    @Override
    public boolean isSupport(LeaveForm leaveForm) {
        return leaveForm.getDays() <= 3 && leaveForm.getType() == 1;
    }

    @Override
    public void audit(LeaveForm leaveForm) {
        System.out.println(leaveForm);
        System.out.println("三天以下婚丧假无需审批自动通过");
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String getName() {
        return "三天以下婚丧假请假规则";
    }
}

package com.dk.design.celue.po;

import com.dk.design.celue.po.stratege.AuditStratege;
import com.dk.design.celue.po.stratege.AuditStrategeFactory;

public class LeaveServiceNew {
    public void audit(LeaveForm leaveForm){
        AuditStrategeFactory factory = AuditStrategeFactory.getInstance();
        AuditStratege auditStratege = factory.getAuditStratege(leaveForm);
        System.out.println("符合规则：" + auditStratege.getName() + "(" + auditStratege.getClass().getSimpleName()+")");
        auditStratege.audit(leaveForm);
    }
}

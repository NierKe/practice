package com.dk.design.celue.po.stratege;

import com.dk.design.celue.po.LeaveForm;

public interface AuditStratege {
    //判断条件是否匹配
    public boolean isSupport(LeaveForm leaveForm);
    //审核业务逻辑
    public void audit(LeaveForm leaveForm);
    //规则冲突时优先级
    public int getPriority();
    //规则名称
    public String getName();
}

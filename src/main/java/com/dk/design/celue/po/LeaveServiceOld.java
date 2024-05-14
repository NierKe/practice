package com.dk.design.celue.po;

import com.dk.design.celue.po.LeaveForm;

public class LeaveServiceOld {
    public void audit(LeaveForm leaveForm){
        //三天以下婚丧假自动通过
        if(leaveForm.getDays() <= 3 && leaveForm.getType() == 1){
            System.out.println("三天以下婚丧假自动通过");
        }
        if(leaveForm.getDays() > 3 && leaveForm.getType() == 1){
            System.out.println("三天以上婚丧假进入上级审批");
        }
        if(leaveForm.getEmployee().getLevel() == 9){
            System.out.println("总经理请假无需审批");
        }
        if(leaveForm.getDays() == 1 && leaveForm.getType() == 0){
            System.out.println("一天病假无需审批自动通过");
        }
        if(leaveForm.getDays() > 3 && leaveForm.getType() == 0){
            System.out.println("一天以上病假进入审批流程");
        }

    }
}

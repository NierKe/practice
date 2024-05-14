package com.dk.design.celue.po.stratege;

import com.dk.design.celue.po.LeaveForm;

import java.util.ArrayList;
import java.util.List;

public class AuditStrategeFactory {
    private final static AuditStrategeFactory factory  = new AuditStrategeFactory();
    private List<AuditStratege> auditStrategeList  = new ArrayList();
    private AuditStrategeFactory(){
        //注册规则
        auditStrategeList.add(new AuditStrategeImpl1());
        auditStrategeList.add(new AuditStrategeImpl2());
        auditStrategeList.add(new AuditStrategeImpl3());
        auditStrategeList.add(new AuditStrategeImpl4());
        auditStrategeList.add(new AuditStrategeImpl5());
    }
    public static AuditStrategeFactory getInstance(){
        return factory;
    }
    public AuditStratege getAuditStratege(LeaveForm leaveForm){
        AuditStratege auditStratege = null;
        for(AuditStratege stratege : auditStrategeList){
            //找到匹配规则
            if(stratege.isSupport(leaveForm)){
                //如果没有匹配规则，找到匹配的直接赋值
                if(auditStratege == null){
                    auditStratege = stratege;
                }else{
                    //如果发现匹配级相同的其他规则，直接报错
                    if(stratege.getPriority() == auditStratege.getPriority()){
                        throw new RuntimeException("["+auditStratege.getName()+"]:["+stratege.getName() + "]规则冲突，请尽快解决" );
                    }
                    //如果发现高规则，替代现有规则
                    //如总经理请假五天，总经理请假规则（999） > 一天以上请假规则（0）
                    else if(stratege.getPriority() > auditStratege.getPriority()){
                        auditStratege = stratege;
                    }else{

                    }
                }
            }
        }

        if(auditStratege == null){
            throw new RuntimeException("没有匹配规则！");
        }else{
            return auditStratege;
        }
    }
}

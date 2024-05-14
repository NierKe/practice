package com.dk.design.celue.po;

import com.dk.design.celue.po.LeaveServiceNew;
import org.junit.Test;
public class LeaveServiceNewTest {
    private LeaveServiceNew leaveServiceNew = new LeaveServiceNew();
    @Test
    public void case1(){
        LeaveForm LeaveForm = new LeaveForm(new Employee("张三", 6), 1, "家里有事", 5);
        leaveServiceNew.audit(LeaveForm);
    }

    @Test
    public void case2(){
        LeaveForm LeaveForm = new LeaveForm(new Employee("里斯", 6), 2, "年假", 5);
        leaveServiceNew.audit(LeaveForm);
    }
}

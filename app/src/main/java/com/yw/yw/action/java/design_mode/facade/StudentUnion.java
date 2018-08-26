package com.yw.yw.action.java.design_mode.facade;

/**
 * Created by jack
 * On 18-3-30:上午9:58
 * Desc: facade...
 */

public class StudentUnion implements Organization {
    public void operate() {
        System.out.println("我是门面, so也是学生会 ... 由我来给你走报名的流程");

        Organization o1 = new StudentOffice();
        o1.operate();

        Organization o2 = new OfficePart();
        o2.operate();
    }
}

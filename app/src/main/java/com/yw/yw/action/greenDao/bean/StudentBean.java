package com.yw.yw.action.greenDao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jack
 * On 18-4-16:下午6:01
 * Desc:
 */
@Entity
public class StudentBean {
    @Id
    private Long id;
    @Property(nameInDb = "NAME")
    private String name;
    @Generated(hash = 636788913)
    public StudentBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 2097171990)
    public StudentBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

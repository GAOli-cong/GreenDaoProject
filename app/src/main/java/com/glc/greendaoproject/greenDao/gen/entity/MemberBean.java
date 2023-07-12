package com.glc.greendaoproject.greenDao.gen.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @description: 会员表
 * @date: 2023/7/12 16:02
 * @author: gaolicong
 * @email: gaolicong6@gmail.com
 */
@Entity
public class MemberBean {
    @Id
    private long id;

    private long leaderId;

    private String name;

    @Generated(hash = 518257690)
    public MemberBean(long id, long leaderId, String name) {
        this.id = id;
        this.leaderId = leaderId;
        this.name = name;
    }

    @Generated(hash = 1592035565)
    public MemberBean() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLeaderId() {
        return this.leaderId;
    }

    public void setLeaderId(long leaderId) {
        this.leaderId = leaderId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MemberBean{" +
                "id=" + id +
                ", leaderId=" + leaderId +
                ", name='" + name + '\'' +
                '}';
    }
}

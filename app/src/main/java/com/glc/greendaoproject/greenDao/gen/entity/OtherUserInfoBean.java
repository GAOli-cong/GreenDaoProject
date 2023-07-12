package com.glc.greendaoproject.greenDao.gen.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @description: 其他信息表
 * @date: 2023/7/12 15:49
 * @author: gaolicong
 * @email: gaolicong6@gmail.com
 */
@Entity
public class OtherUserInfoBean {
    @Id
    private long id;
    private String address;
    @Generated(hash = 335279900)
    public OtherUserInfoBean(long id, String address) {
        this.id = id;
        this.address = address;
    }
    @Generated(hash = 59605238)
    public OtherUserInfoBean() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OtherUserInfoBean{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}

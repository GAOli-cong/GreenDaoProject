package com.glc.greendaoproject.greenDao.gen.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @description: 教师学生中间表
 * @date: 2023/7/12 16:26
 * @author: gaolicong
 * @email: gaolicong6@gmail.com
 */
@Entity
public class TeacherJoinStudentBean {
    @Id
    private long id;

    private long tId;
    private long sId;
    @Generated(hash = 776471502)
    public TeacherJoinStudentBean(long id, long tId, long sId) {
        this.id = id;
        this.tId = tId;
        this.sId = sId;
    }
    @Generated(hash = 1542025906)
    public TeacherJoinStudentBean() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getTId() {
        return this.tId;
    }
    public void setTId(long tId) {
        this.tId = tId;
    }
    public long getSId() {
        return this.sId;
    }
    public void setSId(long sId) {
        this.sId = sId;
    }

    @Override
    public String toString() {
        return "TeacherJoinStudentBean{" +
                "id=" + id +
                ", tId=" + tId +
                ", sId=" + sId +
                '}';
    }
}

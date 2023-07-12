package com.glc.greendaoproject.greenDao.gen.entity;

import android.util.Log;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.glc.greendaoproject.greenDao.gen.DaoSession;
import com.glc.greendaoproject.greenDao.gen.OtherUserInfoBeanDao;
import com.glc.greendaoproject.greenDao.gen.UserBeanDao;

/**
 * @description: 用户表
 * @date: 2023/7/12 15:47
 * @author: gaolicong
 * @email: gaolicong6@gmail.com
 */
@Entity
public class UserBean {

    @Id
    private long id;

    private String name;

    private String age;
    private Long otherUserInfoId;
    @ToOne(joinProperty = "otherUserInfoId")
    private OtherUserInfoBean otherUserInfoBean;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 83707551)
    private transient UserBeanDao myDao;
    @Generated(hash = 1545019398)
    public UserBean(long id, String name, String age, Long otherUserInfoId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.otherUserInfoId = otherUserInfoId;
    }
    @Generated(hash = 1203313951)
    public UserBean() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public Long getOtherUserInfoId() {
        return this.otherUserInfoId;
    }
    public void setOtherUserInfoId(Long otherUserInfoId) {
        this.otherUserInfoId = otherUserInfoId;
    }
    @Generated(hash = 4979683)
    private transient Long otherUserInfoBean__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1275005484)
    public OtherUserInfoBean getOtherUserInfoBean() {
        Long __key = this.otherUserInfoId;
        if (otherUserInfoBean__resolvedKey == null
                || !otherUserInfoBean__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OtherUserInfoBeanDao targetDao = daoSession.getOtherUserInfoBeanDao();
            OtherUserInfoBean otherUserInfoBeanNew = targetDao.load(__key);
            synchronized (this) {
                otherUserInfoBean = otherUserInfoBeanNew;
                otherUserInfoBean__resolvedKey = __key;
            }
        }
        return otherUserInfoBean;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1952804343)
    public void setOtherUserInfoBean(OtherUserInfoBean otherUserInfoBean) {
        synchronized (this) {
            this.otherUserInfoBean = otherUserInfoBean;
            otherUserInfoId = otherUserInfoBean == null ? null
                    : otherUserInfoBean.getId();
            otherUserInfoBean__resolvedKey = otherUserInfoId;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1491512534)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserBeanDao() : null;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", otherUserInfoId=" + otherUserInfoId +
                ", otherUserInfoBean=" + getOtherUserInfoBean() +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                ", otherUserInfoBean__resolvedKey=" + otherUserInfoBean__resolvedKey +
                '}';
    }
}

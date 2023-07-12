package com.glc.greendaoproject.greenDao.gen.entity;

import android.util.Log;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.glc.greendaoproject.greenDao.gen.DaoSession;
import com.glc.greendaoproject.greenDao.gen.TeacherBeanDao;
import com.glc.greendaoproject.greenDao.gen.StudentBeanDao;

/**
 * @description: 学生表
 * @date: 2023/7/12 16:24
 * @author: gaolicong
 * @email: gaolicong6@gmail.com
 */
@Entity
public class StudentBean {
    @Id
    private long id;

    //entity指的是绑定类
    //sourceProperty填写绑定类中标示自身的id，此处为sId，指StudentBean的id
    //targetProperty填写绑定类中标示关联类的id，此处为tId，指TeacherBean的id
    @ToMany
    @JoinEntity(entity = TeacherJoinStudentBean.class,
            sourceProperty = "sId",
            targetProperty = "tId")
    private List<TeacherBean> teacherBeanList;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1251043925)
    private transient StudentBeanDao myDao;

    @Generated(hash = 1661961426)
    public StudentBean(long id) {
        this.id = id;
    }

    @Generated(hash = 2097171990)
    public StudentBean() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 299074847)
    public List<TeacherBean> getTeacherBeanList() {
        if (teacherBeanList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TeacherBeanDao targetDao = daoSession.getTeacherBeanDao();
            List<TeacherBean> teacherBeanListNew = targetDao
                    ._queryStudentBean_TeacherBeanList(id);
            synchronized (this) {
                if (teacherBeanList == null) {
                    teacherBeanList = teacherBeanListNew;
                }
            }
        }
        return teacherBeanList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 832141143)
    public synchronized void resetTeacherBeanList() {
        teacherBeanList = null;
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
    @Generated(hash = 2072577263)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentBeanDao() : null;
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "id=" + id +
                ", teacherBeanList=" + getTeacherBeanList() +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                '}';
    }
}

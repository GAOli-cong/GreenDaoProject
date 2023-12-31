package com.glc.greendaoproject.greenDao.gen.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.glc.greendaoproject.greenDao.gen.DaoSession;
import com.glc.greendaoproject.greenDao.gen.StudentBeanDao;
import com.glc.greendaoproject.greenDao.gen.TeacherBeanDao;

/**
 * @description: 教师表
 * @date: 2023/7/12 16:22
 * @author: gaolicong
 * @email: gaolicong6@gmail.com
 */
@Entity
public class TeacherBean {
    @Id
    private long id;

    //entity指的是绑定类
    //sourceProperty填写绑定类中标示自身的id，此处为tId，指TeacherBean的id
    //targetProperty填写绑定类中标示关联类的id，此处为sId，指StudentBean的id
    @ToMany
    @JoinEntity(entity = TeacherJoinStudentBean.class,
    sourceProperty = "tId",
    targetProperty = "sId")
    private List<StudentBean> studentBeanList;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 121856788)
    private transient TeacherBeanDao myDao;

    @Generated(hash = 628192610)
    public TeacherBean(long id) {
        this.id = id;
    }

    @Generated(hash = 1376380279)
    public TeacherBean() {
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
    @Generated(hash = 767851859)
    public List<StudentBean> getStudentBeanList() {
        if (studentBeanList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StudentBeanDao targetDao = daoSession.getStudentBeanDao();
            List<StudentBean> studentBeanListNew = targetDao
                    ._queryTeacherBean_StudentBeanList(id);
            synchronized (this) {
                if (studentBeanList == null) {
                    studentBeanList = studentBeanListNew;
                }
            }
        }
        return studentBeanList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 747728825)
    public synchronized void resetStudentBeanList() {
        studentBeanList = null;
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
    @Generated(hash = 1588249045)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTeacherBeanDao() : null;
    }

    @Override
    public String toString() {
        return "TeacherBean{" +
                "id=" + id +
                ", studentBeanList=" + studentBeanList +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                '}';
    }
}

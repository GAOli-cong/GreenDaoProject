package com.glc.greendaoproject.greenDao.gen.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.glc.greendaoproject.greenDao.gen.DaoSession;
import com.glc.greendaoproject.greenDao.gen.MemberBeanDao;
import com.glc.greendaoproject.greenDao.gen.LeaderBeanDao;

/**
 * @description: 领导表
 * @date: 2023/7/12 16:02
 * @author: gaolicong
 * @email: gaolicong6@gmail.com
 */
@Entity
public class LeaderBean {
    @Id
    private long id;

    private String name;


    @ToMany(referencedJoinProperty = "leaderId")
    private List<MemberBean> memberBeans;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 703242250)
    private transient LeaderBeanDao myDao;


    @Generated(hash = 810293016)
    public LeaderBean(long id, String name) {
        this.id = id;
        this.name = name;
    }


    @Generated(hash = 1761610276)
    public LeaderBean() {
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


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 999341871)
    public List<MemberBean> getMemberBeans() {
        if (memberBeans == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MemberBeanDao targetDao = daoSession.getMemberBeanDao();
            List<MemberBean> memberBeansNew = targetDao
                    ._queryLeaderBean_MemberBeans(id);
            synchronized (this) {
                if (memberBeans == null) {
                    memberBeans = memberBeansNew;
                }
            }
        }
        return memberBeans;
    }


    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 942150005)
    public synchronized void resetMemberBeans() {
        memberBeans = null;
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
    @Generated(hash = 1648395956)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLeaderBeanDao() : null;
    }

    @Override
    public String toString() {
        return "LeaderBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", memberBeans=" + getMemberBeans() +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                '}';
    }
}

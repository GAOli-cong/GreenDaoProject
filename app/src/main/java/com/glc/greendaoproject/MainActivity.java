package com.glc.greendaoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.glc.greendaoproject.greenDao.gen.entity.LeaderBean;
import com.glc.greendaoproject.greenDao.gen.entity.MemberBean;
import com.glc.greendaoproject.greenDao.gen.entity.OtherUserInfoBean;
import com.glc.greendaoproject.greenDao.gen.entity.StudentBean;
import com.glc.greendaoproject.greenDao.gen.entity.TeacherBean;
import com.glc.greendaoproject.greenDao.gen.entity.TeacherJoinStudentBean;
import com.glc.greendaoproject.greenDao.gen.entity.UserBean;
import com.glc.greendaoproject.utils.GreenDaoManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    jonEntity();
    }

    /**
     * 一对一
     * 这里举一个简单的例子，用户对象UserBean和用户其他信息对象OtherUserInfoBean，每个用户都对应一个用户其他信息
     */
    private void toOne() {
        UserBean userBean = new UserBean();
        userBean.setId(1);
        userBean.setAge("23");
        userBean.setName("张三");
        Long otherUserInfoId = Long.valueOf(1);
        userBean.setOtherUserInfoId(otherUserInfoId);
        GreenDaoManager.getInstance().mDaoSession.getUserBeanDao().insertOrReplaceInTx(userBean);

        OtherUserInfoBean otherUserInfoBean = new OtherUserInfoBean();
        otherUserInfoBean.setId(1);
        otherUserInfoBean.setAddress("山东济南");
        GreenDaoManager.getInstance().mDaoSession.getOtherUserInfoBeanDao().insertOrReplaceInTx(otherUserInfoBean);


        List<UserBean> list = GreenDaoManager.getInstance().mDaoSession.getUserBeanDao().queryBuilder().build().list();
        Log.d(TAG, "获取的其他信息:"+list);
    }

    /**
     * 一对多
     * 举例，LeaderBean和MemberBean，每个leader可能对应多个member
     */
    private void ToMany() {
        LeaderBean leaderBean = new LeaderBean();
        leaderBean.setId(1);
        leaderBean.setName("领导1");
        GreenDaoManager.getInstance().mDaoSession.getLeaderBeanDao().insertOrReplaceInTx(leaderBean);

        MemberBean memberBean = new MemberBean();
        memberBean.setId(1);
        memberBean.setLeaderId(leaderBean.getId());
        memberBean.setName("小兵1");

        MemberBean memberBean2 = new MemberBean();
        memberBean2.setId(2);
        memberBean2.setLeaderId(leaderBean.getId());
        memberBean2.setName("小兵2");

        GreenDaoManager.getInstance().mDaoSession.getMemberBeanDao().insertOrReplaceInTx(memberBean, memberBean2);

        List<LeaderBean> list = GreenDaoManager.getInstance().mDaoSession.getLeaderBeanDao().queryBuilder().build().list();
        Log.d(TAG, "领导手下的小兵们：" + list);
    }


    /**
     * 多对多
     * 举例，TeacherBean和StudentBean，每个teacher可能对应多个student，每个student也可能对应多个teacher，就如同大学的选修课
     * 多对多的实现关键是一个关系绑定类（TeacherJoinStudentBean.java），这个类中只有变量teacherId和studentId，用来记录绑定的关系
     */
    private void jonEntity() {
        //2个教师和3个学生的关系
        //教师1，带学生1、2
        //教师2，带学生1、3
        //学生1，选修教师1和教师2的课
        List<TeacherBean> teacherList = new ArrayList<TeacherBean>();
        for (long i = 1; i < 3; i++) {
            TeacherBean teacherBean = new TeacherBean();
            teacherBean.setId(i);
            teacherList.add(teacherBean);
        }
        GreenDaoManager.getInstance().mDaoSession.getTeacherBeanDao().insertOrReplaceInTx(teacherList);

        List<StudentBean> studentList = new ArrayList<StudentBean>();
        for (long j = 1; j < 4; j++) {
            StudentBean studentBean = new StudentBean();
            studentBean.setId(j);
            studentList.add(studentBean);
        }
        GreenDaoManager.getInstance().mDaoSession.getStudentBeanDao().insertOrReplaceInTx(studentList);

        //教师1带学生1、2
        List<TeacherJoinStudentBean> teacherJoinStudentList = new ArrayList<TeacherJoinStudentBean>();
        TeacherJoinStudentBean teacherJoinStudentBean = new TeacherJoinStudentBean(1, 1, 1);
        teacherJoinStudentList.add(teacherJoinStudentBean);
        TeacherJoinStudentBean teacherJoinStudentBean1 = new TeacherJoinStudentBean(2, 1, 2);
        teacherJoinStudentList.add(teacherJoinStudentBean1);


        //教师2带学生1、3
        TeacherJoinStudentBean teacherJoinStudentBean2 = new TeacherJoinStudentBean(3, 2, 1);
        teacherJoinStudentList.add(teacherJoinStudentBean2);

        TeacherJoinStudentBean teacherJoinStudentBean3 = new TeacherJoinStudentBean(4, 2, 3);
        teacherJoinStudentList.add(teacherJoinStudentBean3);


        GreenDaoManager.getInstance().mDaoSession.getTeacherJoinStudentBeanDao().insertOrReplaceInTx(teacherJoinStudentList);


        List<StudentBean> studentBeanList = GreenDaoManager.getInstance().mDaoSession.getStudentBeanDao().queryBuilder().build().list();
        Log.d(TAG, "jonEntity: " + studentBeanList);
        List<TeacherBean> teacherBeanList = GreenDaoManager.getInstance().mDaoSession.getTeacherBeanDao().queryBuilder().build().list();
        Log.d(TAG, "jonEntity: " + teacherBeanList);

        List<TeacherBean> teacherBeanListResult = studentBeanList.get(0).getTeacherBeanList();
        Log.d(TAG, "获取到第一个学生的老师们: "+teacherBeanListResult);


    }
}
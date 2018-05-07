package com.huangasys.recycleviewmultiitemdemo;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by huangasys on 2018/4/17.16:17
 *
 * @Describe: 封装多状态的实体类.需要继承MultiItemEntity.将需要显示的实体类型写在一起;
 */

public class ItemEntity implements MultiItemEntity {

    public static final int TYPE_NAME = 1;
    public static final int TYPE_CLASS = 2;
    private String groupName;
    public int getType() {
        return type;
    }

    //第一种布局需要显示的数据类型;

    private int type;

    public void setType(int type) {
        this.type = type;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {

        this.groupName = groupName;
    }

    //第二种布局需要显示的数据类型;
    private int courseId;
    private String courseName;
    private String airdate;
    private String teacherName;
    private double studySchedule;
    private String thumbUrl;
    private int status;

    public int getCourseId()
    {
        return courseId;
    }

    public void setCourseId(int courseId)
    {
        this.courseId = courseId;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public String getAirdate()
    {
        return airdate;
    }

    public void setAirdate(String airdate)
    {
        this.airdate = airdate;
    }

    public String getTeacherName()
    {
        return teacherName;
    }

    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    public double getStudySchedule()
    {
        return studySchedule;
    }

    public void setStudySchedule(double studySchedule)
    {
        this.studySchedule = studySchedule;
    }

    public String getThumbUrl()
    {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl)
    {
        this.thumbUrl = thumbUrl;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    @Override
    public int getItemType() {
        return this.type;
    }

}

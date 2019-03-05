package com.knsg.entity;
import java.beans.Transient;
import java.util.Date;

public class KnUser {

    private String userId;//用户id
    private String userName;//用户名
    private String userPost;//用户职位id
    private String userPassword;//用户密码加盐
    private String salt;//盐
    private Date creatDate;//用户创建时间
    private String postName;


    //非数据库字段
    //增加两个个属性第一：查询出来的用户是否被登录的用户有升级权限
    private String upup;
    //二：是否有被降级
    private String downdown;

    //分数
    private Integer mark;
    //
    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    //    @Transient
    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    //    @Transient
    public String getUpup() {
        return upup;
    }

    public void setUpup(String upup) {
        this.upup = upup;
    }

//    @Transient
    public String getDowndown() {
        return downdown;
    }

    public void setDowndown(String downdown) {
        this.downdown = downdown;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPost() {
        return userPost;
    }

    public void setUserPost(String userPost) {
        this.userPost = userPost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

package com.knsg.dao;

import com.knsg.entity.KnUser;
import com.knsg.entity.UserMark;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserMarkDao {

    //插入新打的分数
    Integer insertUserMark(UserMark userMark);
    //查询本月已经被打分的用户
    List<UserMark> selectOldMarkUser(@Param("postId") String postId, @Param("firstDate") Date firstDate, @Param("lastDate") Date lastDate);
}

package com.knsg.services;

import com.knsg.entity.KnUser;
import com.knsg.entity.UserMark;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserMarkService {

    //插入新打的分数
    Integer insertUserMark(UserMark userMark);
    //查询本月已经被打分的用户
    List<UserMark> selectOldMarkUser(String postId,Date firstDate,Date lastDate);
}

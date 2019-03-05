package com.knsg.dao;

import com.knsg.entity.KnPost;
import com.knsg.entity.KnUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KnUserDao {

    //获取用户信息，职位信息
    KnUser selectHaveUser(String userNmae);

    //根据当前用户查询他管理的所有员工信息，包括自己
    List<KnUser> selectEveryUserRelation(String postId);

    //更新被降职或者升职后用户信息
    Integer updataUserPost(@Param("userId") String userId,@Param("knPost") KnPost knPost);

    //查询允许被打分的员工
    List<KnUser> selectMarkUser(String postId);
}

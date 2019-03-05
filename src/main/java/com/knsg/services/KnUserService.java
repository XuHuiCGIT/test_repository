package com.knsg.services;

import com.knsg.entity.KnPost;
import com.knsg.entity.KnUser;

import java.util.List;

public interface KnUserService {
    //判断是否存在此用户
    KnUser selectHaveUser(String userNmae);
    //根据当前用户查询他管理的所有员工信息，包括自己
    List<KnUser> selectEveryUserRelation(String postId);
    //更新被降职或者升职后用户信息
    Integer updataUserPost(String userId, KnPost knPost);
    //查询允许被打分的员工
    List<KnUser> selectMarkUser(String postId);
}

package com.knsg.services;

import com.knsg.entity.KnMage;

import java.util.List;

public interface KnMageService {
    //获取用户功能模块
    List<KnMage> selectUserManage(String userId);
}

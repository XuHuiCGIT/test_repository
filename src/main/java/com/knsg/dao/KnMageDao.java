package com.knsg.dao;

import com.knsg.entity.KnMage;
import java.util.List;

public interface KnMageDao {
    //查询登录用户的功能模块
    List<KnMage> selectUserManage(String postId);
}

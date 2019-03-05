package com.knsg.services.imp;

import com.knsg.dao.KnUserDao;
import com.knsg.entity.KnPost;
import com.knsg.entity.KnUser;
import com.knsg.services.KnUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnUserServiceImp implements KnUserService {

    @Autowired
    private KnUserDao knUserDao;


    @Override
    public KnUser selectHaveUser(String userNmae) {
        return knUserDao.selectHaveUser(userNmae);
    }

    @Override
    public List<KnUser> selectMarkUser(String postId) {
        return knUserDao.selectMarkUser(postId);
    }

    @Override
    public List<KnUser> selectEveryUserRelation(String postId) {
        return knUserDao.selectEveryUserRelation(postId);
    }

    @Override
    public Integer updataUserPost(String userId, KnPost knPost) {
        return knUserDao.updataUserPost(userId,knPost);
    }
}

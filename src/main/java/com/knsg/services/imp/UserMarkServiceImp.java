package com.knsg.services.imp;

import com.knsg.dao.UserMarkDao;
import com.knsg.entity.UserMark;
import com.knsg.services.UserMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserMarkServiceImp implements UserMarkService {

    @Autowired
    private UserMarkDao userMarkDao;

    @Override
    public Integer insertUserMark(UserMark userMark) {
        return userMarkDao.insertUserMark(userMark);
    }

    @Override
    public List<UserMark> selectOldMarkUser(String postId, Date firstDate, Date lastDate) {
        return userMarkDao.selectOldMarkUser(postId,firstDate,lastDate);
    }
}

package com.knsg.services.imp;


import com.knsg.dao.KnMageDao;
import com.knsg.entity.KnMage;
import com.knsg.services.KnMageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KnMageServiceImp implements KnMageService {

    @Autowired
    private KnMageDao knMageDao;

    @Override
    public List<KnMage> selectUserManage(String postId) {
        return knMageDao.selectUserManage(postId);
    }
}

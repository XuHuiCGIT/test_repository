package com.knsg.services.imp;

import com.knsg.dao.LiftPostRelationshipDao;
import com.knsg.services.LiftPostRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LiftPostRelationshipServiceImp implements LiftPostRelationshipService {

    @Autowired
    private LiftPostRelationshipDao liftPostRelationshipDao;
    @Override
    public List<String> selectLiftUser(String hightPostId) {
        return liftPostRelationshipDao.selectLiftUser(hightPostId);
    }
}

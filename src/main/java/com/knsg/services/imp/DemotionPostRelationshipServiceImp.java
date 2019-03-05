package com.knsg.services.imp;

import com.knsg.dao.DemotionPostRelationshipDao;
import com.knsg.services.DemotionPostRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemotionPostRelationshipServiceImp implements DemotionPostRelationshipService {
    @Autowired
    private DemotionPostRelationshipDao demotionPostRelationshipDao;
    @Override
    public List<String> selectDemotionUser(String hightPostId) {
        return demotionPostRelationshipDao.selectDemotionUser(hightPostId);
    }
}

package com.knsg.services;


import org.springframework.stereotype.Service;

import java.util.List;

public interface DemotionPostRelationshipService {
    //根据上级id查询可以有权降级对应的员工
    List<String> selectDemotionUser(String hightPostId);
}

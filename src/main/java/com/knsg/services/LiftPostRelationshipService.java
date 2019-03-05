package com.knsg.services;

import java.util.List;

public interface LiftPostRelationshipService {
    //根据上级id查询可以有权升级对应的员工
    List<String> selectLiftUser(String hightPostId);
}

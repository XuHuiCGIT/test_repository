package com.knsg.dao;

import java.util.List;

public interface LiftPostRelationshipDao {
    //根据上级id查询可以有权升级对应的员工
    List<String> selectLiftUser(String hightPostId);
}

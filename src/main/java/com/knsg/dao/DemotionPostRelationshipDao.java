package com.knsg.dao;


import java.util.List;

public interface DemotionPostRelationshipDao {

    //根据上级id查询可以有权降级对应的员工
    List<String> selectDemotionUser(String hightPostId);

}

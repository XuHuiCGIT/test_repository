package com.knsg.services;

import com.knsg.entity.KnPost;

public interface PostRelationParentService {
    //降级查询对应id
    KnPost selectDownPost(String postId);
    //升级查询对应id
    KnPost selectUpPost(String postId);
}

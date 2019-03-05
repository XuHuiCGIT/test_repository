package com.knsg.services.imp;

import com.knsg.dao.PostRelationParentDao;
import com.knsg.entity.KnPost;
import com.knsg.services.PostRelationParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostRelationParentServiceImp implements PostRelationParentService {
    @Autowired
    private PostRelationParentDao postRelationParentDao;
    @Override
    public KnPost selectDownPost(String postId) {
        return postRelationParentDao.selectDownPost(postId);
    }

    @Override
    public KnPost selectUpPost(String postId) {
        return postRelationParentDao.selectUpPost(postId);
    }
}

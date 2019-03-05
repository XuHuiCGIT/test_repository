package com.knsg.controller;

import com.knsg.entity.*;
import com.knsg.services.*;
import com.knsg.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manage")
@EnableAutoConfiguration
public class ManageController {

    @Autowired
    private KnUserService knUserService;
    @Autowired
    private DemotionPostRelationshipService demotionPostRelationshipService;
    @Autowired
    private LiftPostRelationshipService liftPostRelationshipService;
    @Autowired
    private PostRelationParentService postRelationParentService;
    @Autowired
    private UserMarkService userMarkService;
    //点击的员工信息功能
    @RequestMapping("/magStaff")
    @ResponseBody
    public List<KnUser> magStaff(HttpServletRequest request) {

        List<KnUser> KnUserList = null;
        //获取当前登录的用户
        KnUser user = (KnUser) request.getSession().getAttribute("user");
        KnUserList = knUserService.selectEveryUserRelation(user.getUserPost());
        //获取用户可以降职的user
        List<String> demotionPostIdList = demotionPostRelationshipService.selectDemotionUser(user.getUserPost());
        for (KnUser knUser : KnUserList
        ) {
            if (demotionPostIdList.contains(knUser.getUserPost())) {//进入说明满足条件
                knUser.setDowndown("Y");
            }
        }
        //获取可以升职的user
        List<String> liftPostIdList = liftPostRelationshipService.selectLiftUser(user.getUserPost());
        for (KnUser knUser : KnUserList
        ) {
            if (liftPostIdList.contains(knUser.getUserPost())) {//进入说明满足条件
                knUser.setUpup("Y");
            }
        }
        //System.out.println(KnUserList.toString());
//        for (KnUser knUser:KnUserList
//             ) {
//            System.out.println(knUser.getUpup()+"=="+knUser.getDowndown());
//        }
        return KnUserList;
    }

    //当点击升职或者降职
    @RequestMapping("/upordown")
    @ResponseBody
    public String upordown(@RequestParam String userId, @RequestParam String ud, @RequestParam String postId) {
//        System.out.println(userId+"=="+ud+"=="+postId);
        KnPost endPost = null;
        if ("up".equals(ud)) {//升值
            endPost = postRelationParentService.selectUpPost(postId);
        } else if ("down".equals(ud)) {//降职
            endPost = postRelationParentService.selectDownPost(postId);
        }
//        System.out.println(endPost.getPostId()+"=="+endPost.getPostName());
        //把最终的postid修改数据库
        knUserService.updataUserPost(userId, endPost);
        return "YES";
    }

    @RequestMapping("/mark")//打分系统
    @ResponseBody
    public List<KnUser> mark(HttpServletRequest request) throws Exception{

        List<UserMark> userMarkList = null;
        //去查询可以打分的人群，
        KnUser user = (KnUser) request.getSession().getAttribute("user");
//        System.out.println(user.getUserPost());
        Date thisMonthFirstDay = DateUtil.getThisMonthFirstDay();
        Date thisMonthLastday = DateUtil.getThisMonthLastday();

        String formatf = new SimpleDateFormat("yyyy-MM-dd").format(thisMonthFirstDay);
        String formatl = new SimpleDateFormat("yyyy-MM-dd").format(thisMonthLastday);
//        System.out.println("formatf=="+formatf+"||||"+"formatl="+formatl);
        Date datef = new SimpleDateFormat("yyyy-MM-dd dd:mm:ss").parse(formatf + " 00:00:00");
        Date datel = new SimpleDateFormat("yyyy-MM-dd dd:mm:ss").parse(formatl + " 23:59:59");
        userMarkList = userMarkService.selectOldMarkUser(user.getUserPost(),datef,datel);

        //查询一共那些用户
        List<KnUser> knUsers = knUserService.selectMarkUser(user.getUserPost());
        for (KnUser knUser:knUsers
             ) {
            knUser.setParentId(user.getUserPost());
            for (UserMark userMark:userMarkList
                 ) {
                if(knUser.getUserId().equals(userMark.getUserId())){
                    knUser.setMark(userMark.getMark());
                }
            }
        }

        return knUsers;
    }

    @RequestMapping("/playMark")
    @ResponseBody
    public String playMark(@RequestParam String userId, @RequestParam String mark, @RequestParam String postParentId){

        UserMark userMark = new UserMark();
        Date date = new Date();
        userMark.setMark(Integer.valueOf(mark));
        userMark.setParentId(postParentId);
        userMark.setUserId(userId);
        userMark.setCreatDate(date);
//        System.out.println(userId+"=="+mark+"=="+postParentId);
        userMarkService.insertUserMark(userMark);
        return "YES";
    }
}

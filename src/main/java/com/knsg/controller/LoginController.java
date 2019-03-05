package com.knsg.controller;


import com.knsg.entity.KnMage;
import com.knsg.entity.KnUser;
import com.knsg.services.KnMageService;
import com.knsg.services.KnUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * xhc
 * */
@Controller
@EnableAutoConfiguration
public class LoginController {

    @Autowired
    private KnMageService knMageService;
    @Autowired
    private KnUserService knUserService;

    @RequestMapping("/index")
    public String hollerTwo() {
        return "index";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> hollerThree(String userName, String passWord, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        KnUser knUser = new KnUser();
//        System.out.println("userName=" + userName);
//        System.out.println("passWord=" + passWord);
        //通过传入的参数判断是否存在此用户
        KnUser knUserHave = knUserService.selectHaveUser(userName);
//        System.out.println("knUserHave="+knUserHave);
        if(knUserHave==null){//用户名不存在时直接返回
            map.put("state","NO");
            return map;
        }
        //当用户名存在，在比对密码是否正确
        if(!knUserHave.getUserPassword().equals(passWord)){//不一致时返回错误
            map.put("state","NO");
            return map;
        }
        //用户密码一致事,查询该用户的功能模块
        List<KnMage> knMages = knMageService.selectUserManage(knUserHave.getUserPost());
        //用户登陆成功吧信息放到session
        request.getSession().setAttribute("user", knUserHave);
        //吧功能模块和基本信息传到前端，页面动态展示
        map.put("state","YES");
        map.put("user",knUserHave);
        map.put("manage",knMages);
        return map;
    }
    @RequestMapping("/manage")
    public String hollerFour(HttpServletRequest request) {
        return "manage";
    }
}

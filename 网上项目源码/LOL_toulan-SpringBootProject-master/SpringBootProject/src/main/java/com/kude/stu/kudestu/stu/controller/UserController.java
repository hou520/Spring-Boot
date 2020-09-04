package com.kude.stu.kudestu.stu.controller;

import com.kude.stu.kudestu.stu.entity.LoginMsg;
import com.kude.stu.kudestu.stu.entity.User;
import com.kude.stu.kudestu.stu.service.UserService;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 处理用户信息的控制层
 *
 * @author liyage
 */


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    private User user;

    /**
     * 查询用户的方法
     */

    @ResponseBody
    @RequestMapping("/findAll")
    public List<User> findAll() {

        return userService.findAll();

    }

    @ResponseBody
    @RequestMapping("/findById")
    public User findUserById(int id) {
        return userService.findUserById(id);
    }

    /**
     * 注册用户
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public User reg(User user) {
        return userService.save(user);
    }


    /**
     * 判断是否登录
     *
     * @param session
     * @return
     */
    @PostMapping("/isLogin")
    public String isLogin(HttpSession session) {
        User user = (User) session.getAttribute("user");

        System.out.println(session.getAttribute("user"));
        if (user != null) {
            return "1";
        } else {
            return "0";
        }
    }

    /**
     * 退出系统
     *
     * @param session
     * @return
     */
    @PostMapping("exit")
    public String exit(HttpSession session, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        session.removeAttribute("user");
        session.invalidate();
        return "0";
    }

    /**
     * 登录用户
     */
    @PostMapping("/login")
    public LoginMsg login(String username, String password, String isLogin, HttpServletResponse response, HttpSession session) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        User user = userService.login(username, password);
        LoginMsg loginMsg = new LoginMsg();
        if (user != null) {
            loginMsg.setCode(1);
            loginMsg.setResult(user);
            session.setAttribute("user", user);
        } else {
            loginMsg.setCode(0);
            loginMsg.setResult(null);
        }
        //userService.login(username,password);
        System.out.println(userService.login(username, password));
        System.out.println(loginMsg.getCode());
        // return userService.login(username,password);
        return loginMsg;
        //return null;
    }


    /**
     * 删除用户
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public void delete(int id) {
        userService.deleteById(id);
        System.out.println("删除成功");
    }

//    public String showname(){
//
//    }
}

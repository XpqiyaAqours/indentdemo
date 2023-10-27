package com.indent.indentdemo.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.indent.indentdemo.system.entity.User;
import com.indent.indentdemo.system.service.IUserService;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dlx
 * @since 2023-10-23
 */
@RestController
@RequestMapping("/system/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/all")
    public List<User> getalluser(){
        List<User> list = userService.list();
        return list;
    }
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody User user, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> data=userService.login(user, session, request, response);
        if(data != null) {
            return data;
        }
        throw new RuntimeException("用户名或密码错误");
    }

    @GetMapping("/info")
    public Map<String,Object> getUserInfo(HttpServletRequest req, HttpServletResponse resp){
        //根据token获取用户信息
        Map<String,Object> data=userService.getUserInfo(req, resp);
        if(data != null) {
            return data;
        }
        throw new RuntimeException("用户无效");
    }

    @PostMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        userService.logout(session,request,response);
        String data = "登出成功";
        return data;
    }

    @GetMapping("/list")
    //用户查询功能
    public  Map<String,Object> getUserList(@RequestParam(value = "username",required = false)String username,
                                           @RequestParam(value = "phone",required = false)String phone,
                                           @RequestParam(value = "pageNo")long pageNo,
                                           @RequestParam(value = "pageSize")long pageSize){
        System.out.println(username);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(username),User::getUsername,username);
        wrapper.eq(StringUtils.hasLength(phone),User::getPhone,phone);
        wrapper.orderByDesc(User::getId);

        Page<User> Page = new Page<>(pageNo,pageSize);
        userService.page(Page,wrapper);
        Map<String,Object> data =new HashMap<>();
        data.put("total",Page.getTotal());
        data.put("rows",Page.getRecords());
        System.out.println(data);
        return data;

    }
    //新增用户
    @PostMapping
    public String addUser(@RequestBody User user){
        user.setId(null);
        userService.save(user);
        String result = "新增用户成功";
        return result;

    }
    //修改用户
    @PutMapping
    public String updateUser(@RequestBody User user){
        userService.updateById(user);
        String result = "修改用户成功";
        return result;
    }
    //按ID查找用户
    //用于在修改用户的界面展示原用户信息
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id")Integer id){
        User user  = userService.getById(id);
        return user;
    }
    //删除用户
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id")Integer id){
        userService.removeById(id);
        return "用户删除成功";

    }

}
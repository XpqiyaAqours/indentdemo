package com.indent.indentdemo.system.service;

import com.indent.indentdemo.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dlx
 * @since 2023-10-23
 */
public interface IUserService extends IService<User> {
    Map<String, Object> login(User user, HttpSession session, HttpServletRequest request, HttpServletResponse response);

    Map<String, Object> getUserInfo(HttpServletRequest req, HttpServletResponse resp);

    void logout(HttpSession session, HttpServletRequest request, HttpServletResponse response);

}

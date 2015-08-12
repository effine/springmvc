package com.effine.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.effine.entity.User;
import com.effine.service.UserService;

@Controller
@RequestMapping("user")
public class UserAction {
	@Autowired
	private UserService userService;

	// TODO 所有方法都没有判断登录状态
	@RequestMapping("add")
	@ResponseBody
	public String addUser(HttpServletRequest request, HttpServletResponse response, User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", 0);
		if (null != user) {
			user.setId(new Random().nextInt(9999999));
			boolean isSuccess = userService.addUser(user);
			if (isSuccess) {
				result.put("status", 1);
				result.put("msg", "添加用户成功");
			} else result.put("msg", "添加用户失败");
		} else result.put("msg", "参数为空");
		return JSON.toJSONString(result, SerializerFeature.WriteNullStringAsEmpty);
	}

	@RequestMapping("del")
	@ResponseBody
	public String delUser(HttpServletRequest request, HttpServletResponse response, int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", 0);
		if (0 != id) {
			boolean isSuccess = userService.delUser(id);
			if (isSuccess) {
				result.put("status", 1);
				result.put("msg", "删除用户成功");
			} else result.put("msg", "删除用户失败");
		} else result.put("msg", "参数为空");
		return JSON.toJSONString(result, SerializerFeature.WriteNullStringAsEmpty);
	}

	@RequestMapping("update")
	@ResponseBody
	public String updateUser(HttpServletRequest request, HttpServletResponse response, User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", 0);
		if (null != user) {
			boolean isSuccess = userService.updateUser(user);
			if (isSuccess) {
				result.put("status", 1);
				result.put("msg", "添加用户成功");
			} else result.put("msg", "添加用户失败");
		} else result.put("msg", "参数为空");
		return JSON.toJSONString(result, SerializerFeature.WriteNullStringAsEmpty);
	}

	@RequestMapping("get")
	@ResponseBody
	public String getUser(HttpServletRequest request, HttpServletResponse response, int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", 0);
		if (0 != id) {
			User user = userService.getUser(id);
			if (null != user) {
				result.put("status", 1);
				result.put("user", user);
			} else 	result.put("msg", "没有该用户");
		} else result.put("msg", "参数为空");
		return JSON.toJSONString(result, SerializerFeature.WriteNullStringAsEmpty);
	}

	@RequestMapping("list")
	@ResponseBody
	public String getUserList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", 0);
		List<User> list = userService.getUserList();
		if (null != list) {
			result.put("status", 1);
			result.put("userList", list);
		} else result.put("msg", "不存在用户");
		return JSON.toJSONString(result, SerializerFeature.WriteNullStringAsEmpty);
	}
	
	/**
	 * 用户登录
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return JSON
	 */
	@RequestMapping(value = "login", produces="application/json; charset=utf-8")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response, String username, String password) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", 0);
		if (null != username && "" != username) {
			if (null != password && "" != password) {
				User user = userService.login(username,password);
				if (null != user) {
					result.put("status", 1);
					result.put("msg", "登录成功");
					request.getSession().setAttribute("user", user);
				} else 	result.put("msg", "登录失败");
			}else result.put("msg", "密码为空");
		} else result.put("msg", "用户名为空");
		return JSON.toJSONString(result, SerializerFeature.WriteNullStringAsEmpty);
	}
}

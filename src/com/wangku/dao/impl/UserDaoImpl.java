package com.wangku.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wangku.dao.UserDao;
import com.wangku.entity.User;
import com.wangku.mapper.UserMapper;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserMapper userMapper;

	public boolean addUser(User user) {
		try {
			userMapper.addUser(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean delUser(int id) {
		try {
			userMapper.removeUser(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean updateUser(User user) {
		try {
			userMapper.editUser(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public User getUser(int id) {
		return userMapper.getUserById(id);
	}

	public List<User> getUserList() {
		return userMapper.getAllUser();
	}

	public User login(String username, String password) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("username", username);
		param.put("password", password);
		return userMapper.login(param);
	}
}

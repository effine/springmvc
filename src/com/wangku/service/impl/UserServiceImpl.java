package com.wangku.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangku.dao.UserDao;
import com.wangku.entity.User;
import com.wangku.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	public boolean delUser(int id) {
		return userDao.delUser(id);
	}

	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	public User getUser(int id) {
		return userDao.getUser(id);
	}

	public List<User> getUserList() {
		return userDao.getUserList();
	}

	public User login(String username, String password) {
		return userDao.login(username, password);
	}
}

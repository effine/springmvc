package com.wangku.dao;

import java.util.List;

import com.wangku.entity.User;

public interface UserDao {

	boolean addUser(User user);

	boolean delUser(int id);

	boolean updateUser(User user);

	User getUser(int id);

	List<User> getUserList();

	User login(String username, String password);
}

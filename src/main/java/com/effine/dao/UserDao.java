package com.effine.dao;

import java.util.List;

import com.effine.entity.User;

public interface UserDao {

	boolean addUser(User user);

	boolean delUser(int id);

	boolean updateUser(User user);

	User getUser(int id);

	List<User> getUserList();

	User login(String username, String password);
}

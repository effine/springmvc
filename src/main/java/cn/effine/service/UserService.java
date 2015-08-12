package cn.effine.service;

import java.util.List;

import cn.effine.entity.User;

public interface UserService {

	boolean addUser(User user);

	boolean delUser(int id);

	boolean updateUser(User user);

	User getUser(int id);

	List<User> getUserList();

	User login(String username, String password);
}

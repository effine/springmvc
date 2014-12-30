package com.wangku.mapper;

import java.util.List;
import java.util.Map;

import com.wangku.entity.User;

public interface UserMapper {

	void addUser(User user);

	void removeUser(int id);

	void editUser(User user);

	List<User> getAllUser();

	User getUserById(int id);

	User login(Map<String,String> map);
}

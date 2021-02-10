package cn.me.service;

import cn.me.model.dto.User;

public interface UserService
{
	void saveUser(User user);

	User findByName(String name);
}

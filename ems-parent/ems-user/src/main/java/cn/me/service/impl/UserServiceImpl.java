package cn.me.service.impl;

import cn.me.mapper.UserMapper;
import cn.me.model.dto.User;
import cn.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserMapper userMapper;

	@Override
	public void saveUser(User user)
	{
		User queryUser = userMapper.findByName(user.getUsername());
		if (queryUser != null)
		{
			throw new RuntimeException("当前用户已存在");
		}
		user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		user.setStatus("已激活");
		user.setRegisterTime(new Date());
		userMapper.saveUser(user);
	}

	@Override
	public User findByName(String name)
	{
		return null;
	}
}

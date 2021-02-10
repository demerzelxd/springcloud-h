package cn.me.mapper;

import cn.me.model.dto.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper
{
	void saveUser(User user);

	User findByName(@Param("username") String username);
}

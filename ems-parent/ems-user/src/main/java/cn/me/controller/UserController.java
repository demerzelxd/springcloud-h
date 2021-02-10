package cn.me.controller;

import cn.me.model.dto.User;
import cn.me.service.UserService;
import cn.me.utils.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class UserController
{
	@Autowired
	private StringRedisTemplate redisTemplate;

	@Autowired
	private UserService userService;

	/**
	 * 生成验证码
	 */
	@GetMapping(value = "user/getImage", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Map<String, Object> getImage() throws IOException
	{
		Map<String, Object> map = new HashMap<>();
		// 生成验证码
		String code = VerifyCodeUtils.generateVerifyCode(4);
		// 存储验证码redis，超时时间60s
		String codeKey = UUID.randomUUID().toString();
		redisTemplate.opsForValue().set(codeKey, code, 60, TimeUnit.SECONDS);
		// 根据字符串生成验证码图片，放入内存输出流
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		VerifyCodeUtils.outputImage(120, 60, byteArrayOutputStream, code);
		// base64转换验证码，加上固定的头
		String data = "data:image/png;base64," + Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());
		// 响应验证码
		map.put("src", data);
		map.put("codeKey", codeKey);
		return map;
	}

	/**
	 * 用户注册
	 */
	@PostMapping(value = "user/register", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Map<String, Object> register(@RequestBody User user, @RequestParam("code") String code, @RequestParam("codeKey") String codeKey)
	{
		Map<String, Object> map = new HashMap<>();
		try
		{
			// 判断验证码是否过期
			if (!Boolean.TRUE.equals(redisTemplate.hasKey(codeKey)))
			{
				throw new RuntimeException("验证码过期");
			}
			// 根据codeKey取得验证码
			String oldCode = redisTemplate.opsForValue().get(codeKey);
			// 比较验证码
			if (StringUtils.equalsIgnoreCase(code, oldCode))
			{
				// 注册用户
				userService.saveUser(user);
				map.put("msg", "用户注册成功");
				map.put("status", true);
			}
			else
			{
				throw new RuntimeException("输入的验证码不正确");
			}
		}
		catch (RuntimeException e)
		{
			map.put("msg", e.getMessage());
			map.put("status", false);
		}
		return map;
	}
}

package cn.me.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class ProductController
{
	@Value("${server.port}")
	private Integer port;

	@GetMapping("/product/showMsg")
	public String showMsg()
	{
		log.info("进入商品服务，展示商品信息！");
		return "进入商品服务，展示商品信息！当前端口信息为" + port;
	}

	@GetMapping("/product/findAll")
	public Map<String, Object> findAll()
	{
		log.info("进入商品服务，查询所有商品信息！");
		Map<String, Object> map = new HashMap<>();
		map.put("status", true);
		map.put("msg", "查询所有商品信息成功！当前端口信息为" + port);
		return map;
	}
}

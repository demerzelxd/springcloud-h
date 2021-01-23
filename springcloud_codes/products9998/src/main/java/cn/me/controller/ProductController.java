package cn.me.controller;

import cn.me.model.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/product/findByParam")
	public Map<String, Object> findByParam(@RequestParam("productId") String productId)
	{
		Map<String, Object> map = new HashMap<>();
		log.info("商品服务接收到的id为：【{}】", productId);
		map.put("status", true);
		map.put("msg", "根据商品id查询商品信息成功！当前端口" + port);
		map.put("productId", productId);
		return map;
	}

	@PostMapping("/product/save")
	public Map<String, Object> save(@RequestParam("name") String name)
	{
		Map<String, Object> map = new HashMap<>();
		log.info("商品服务接收到的名称为：【{}】", name);
		map.put("status", true);
		map.put("msg", "保存商品成功！当前端口" + port);
		map.put("name", name);
		return map;
	}

	// 默认openfeign在进行服务调用时，要求服务提供方在1s内返回结果，如果超时openfeign会直接报错
	// 但往往业务逻辑复杂的时候会超过1s，所以要修改openfeign的超时时间
	@PostMapping("/product/create")
	public Map<String, Object> create(@RequestBody ProductDTO productDTO)
	{
		// 模拟超时，在服务提供方加入线程等待阻塞
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<>();
		log.info("商品服务接收到的数据为：【{}】", productDTO);
		map.put("status", true);
		map.put("msg", "创建商品成功！当前端口" + port);
		map.put("productDTO", productDTO);
		return map;
	}
}

package cn.me.fallback;

import cn.me.client.ProductClient;
import cn.me.model.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductClientFallback implements ProductClient
{
	private Map<String, Object> map = new HashMap<>();

	@Override
	public Map<String, Object> findAll()
	{
		map.clear();
		map.put("status", false);
		map.put("msg", "当前查询所有不可用，服务已被降级!!!");
		return map;
	}

	@Override
	public Map<String, Object> findByParam(String productId)
	{
		map.clear();
		map.put("status", false);
		map.put("msg", "当前查询所有不可用，服务已被降级!!!");
		return map;
	}

	@Override
	public Map<String, Object> save(String name)
	{
		map.clear();
		map.put("status", false);
		map.put("msg", "当前查询所有不可用，服务已被降级!!!");
		return map;
	}

	@Override
	public Map<String, Object> create(ProductDTO productDTO)
	{
		map.clear();
		map.put("status", false);
		map.put("msg", "当前查询所有不可用，服务已被降级!!!");
		return map;
	}
}

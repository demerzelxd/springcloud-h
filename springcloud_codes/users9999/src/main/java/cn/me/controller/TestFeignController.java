package cn.me.controller;

import cn.me.client.ProductClient;
import cn.me.model.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@Slf4j
public class TestFeignController
{
	@Autowired
	private ProductClient productClient;

	@GetMapping(value = "/test/feign", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Map<String, Object> testFeign()
	{
		log.info("进入测试feign");
		Map<String, Object> msg = productClient.findAll();
		log.info("返回信息【{}】", msg);
		return msg;
	}

	@GetMapping(value = "/test/param", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Map<String, Object> testParam(@RequestParam("productId") String productId)
	{
		return productClient.findByParam(productId);
	}

	@GetMapping(value = "/test/postParam", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Map<String, Object> testPostParam(@RequestParam("name") String name)
	{
		return productClient.save(name);
	}

	@GetMapping(value = "/test/postDTO", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Map<String, Object> testPostDTO(@RequestParam("name") String name)
	{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId("1").setName(name).setPrice("1.1").setCreateTime(new Date());
		return productClient.create(productDTO);
	}
}

package cn.me.client;

import cn.me.model.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

// 声明当前接口是调用商品服务的openfeign组件
@FeignClient("products")
public interface ProductClient
{
	// 查询所有商品信息
	@GetMapping("/product/findAll")
	Map<String, Object> findAll();

	// 根据商品id查询商品信息
	@GetMapping("/product/findByParam")
	//使 用openfeign的get方式传递参数，参数变量必须通过RequestParam注解
	Map<String, Object> findByParam(@RequestParam("productId") String productId);

	@PostMapping("/product/save")
	Map<String, Object> save(@RequestParam("name") String name);

	@PostMapping("/product/create")
	Map<String, Object> create(@RequestBody ProductDTO productDTO);
}

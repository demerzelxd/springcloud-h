package cn.me.controller;

import com.netflix.loadbalancer.IRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 负载均衡策略都是在客户端也就是调用方进行的
 */
@RestController
@Slf4j
public class UserController
{
	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/user/showProductMsg", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public String showProductMsg()
	{
		// 第一种调用方式，RestTemplate方式不能负载均衡
		RestTemplate restTemplate = new RestTemplate();
		// 参数为url和返回类型
		String msg = restTemplate.getForObject("http://localhost:9998/product/showMsg", String.class);
		log.info("调用成功返回的信息:【{}】", msg);
		return msg;
	}

	@GetMapping(value = "/user/findAllProducts", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Map findAllProducts()
	{
		// 第一种调用方式
		// RestTemplate restTemplate = new RestTemplate();
		// 参数为url和返回类型，randomHost自定义随机负载均衡
		// 存在问题，如果9997挂掉了，还是会访问
		// 使用restTemplate没有通过eureka,不知道服务有没有挂掉
		// Map msg = restTemplate.getForObject("http://"+randomHost()+"/product/findAll", Map.class);
		// log.info("调用成功返回的信息:【{}】", msg);

		// 第二种调用方式discoveryClient（没有负载均衡）
		// eureka已经集成了ribbon，ribbon能根据服务名称获取该名称下的所有主机地址（实例）
		// discoveryClient（没有负载均衡）、loadBalanceClient、@LoadBalance
		// List<ServiceInstance> serviceInstances = discoveryClient.getInstances("products");
		// for (ServiceInstance serviceInstance : serviceInstances)
		// {
		// 	System.out.println(serviceInstance.getHost());
		// 	System.out.println(serviceInstance.getPort());
		// }

		// 第三种调用方式loadBalanceClient（负载均衡），只返回一个serviceInstance，默认为轮询策略
		// ServiceInstance serviceInstance = loadBalancerClient.choose("products");
		// System.out.println(serviceInstance.getHost());
		// System.out.println(serviceInstance.getPort());
		// RestTemplate restTemplate = new RestTemplate();
		// String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/product/findAll";
		// Map msg = restTemplate.getForObject(url, Map.class);

		// 第四种调用方式@LoadBalance（负载均衡，默认轮询），使用注入的方法获取RestTemplate，
		// 并且url的host和port，统一用products，即服务名替代
		Map msg = restTemplate.getForObject("http://products/product/findAll", Map.class);
		return msg;
	}

	public static String randomHost()
	{
		List<String> list = new ArrayList<>();
		list.add("localhost:9997");
		list.add("localhost:9998");
		Random random = new Random();
		// 在01随机
		int i = random.nextInt(2);
		return list.get(i);
	}
}

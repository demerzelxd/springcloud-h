package cn.me.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig
{
	// 以后需要RestTemplate直接注入
	@Bean
	@LoadBalanced  //代表注入得到的RestTemplate是带有Ribbon负载均衡的对象
	public RestTemplate getTemplate()
	{
		return new RestTemplate();
	}
}

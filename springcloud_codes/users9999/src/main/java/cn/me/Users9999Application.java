package cn.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients  // 开启openfeign支持，feign里面包括了ribbon
public class Users9999Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Users9999Application.class, args);
	}
}

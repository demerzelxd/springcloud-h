package cn.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
// 开启断路器
@EnableCircuitBreaker
public class Products9998Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Products9998Application.class, args);
	}
}

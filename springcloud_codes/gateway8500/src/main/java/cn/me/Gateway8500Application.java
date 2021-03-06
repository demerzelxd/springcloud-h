package cn.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Gateway8500Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Gateway8500Application.class, args);
	}
}

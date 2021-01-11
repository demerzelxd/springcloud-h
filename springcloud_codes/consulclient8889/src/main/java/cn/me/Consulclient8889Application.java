package cn.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// @EnableDiscoveryClient  对consul来说写不写都行
public class Consulclient8889Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Consulclient8889Application.class, args);
	}
}

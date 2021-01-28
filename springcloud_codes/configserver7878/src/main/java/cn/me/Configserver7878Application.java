package cn.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
// 开启配置服务器支持，启动时会拉取远端git上的配置文件
@EnableConfigServer
// 扫描过滤器
@ServletComponentScan(basePackages = "cn.me.filters")
public class Configserver7878Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Configserver7878Application.class, args);
	}
}

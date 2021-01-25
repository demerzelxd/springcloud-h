package cn.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
// 开启仪表盘localhost:9990/hystrix输入http://localhost:9998/hystrix.stream可以监控商品服务
@EnableHystrixDashboard
public class Hystrixdashboard9990Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Hystrixdashboard9990Application.class, args);
	}
}

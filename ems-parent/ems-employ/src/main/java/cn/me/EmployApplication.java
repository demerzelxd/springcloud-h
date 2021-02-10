package cn.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(EmployApplication.class, args);
    }
}

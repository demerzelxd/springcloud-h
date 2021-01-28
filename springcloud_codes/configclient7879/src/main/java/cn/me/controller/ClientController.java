package cn.me.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 可以刷新当前代码区域
@RefreshScope
public class ClientController
{
	@Value("${server.port}")
	private Integer port;

	@Value("${name}")
	private String name;

	@GetMapping("/client/test")
	public String testClient()
	{
		return "当前姓名为" + name;
	}
}

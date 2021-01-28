package cn.me.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局filter
 */
@Configuration
@Slf4j
public class CustomGlobalFilter implements GlobalFilter, Ordered
{
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
	{
		log.info("进入自定义的filter");
		// 有username这个请求参数，则放行
		if (exchange.getRequest().getQueryParams().get("username") != null)
		{
			log.info("用户身份信息合法,放行请求继续执行!!!");
			return chain.filter(exchange);
		}
		log.info("非法用户,拒绝访问!!!");
		// 返回空页面
		return exchange.getResponse().setComplete();
	}

	@Override
	public int getOrder()
	{
		// 数字越小的filter越先执行
		return -1;
	}
}

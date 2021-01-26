package cn.me;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

@SpringBootTest
class Gateway8500ApplicationTests
{
	@Test
	public void getZoneDateTime()
	{
		// 获取时区时间
		ZonedDateTime now = ZonedDateTime.now();
		System.out.println(now);
	}
}

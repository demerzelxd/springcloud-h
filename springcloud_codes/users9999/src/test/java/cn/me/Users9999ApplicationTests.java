package cn.me;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Users9999ApplicationTests
{

	@Test
	void contextLoads()
	{
	}

	@Test
	public void testSub()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("12345;");
		String msg = sb.toString();
		if (msg.endsWith(";"))
		{
			msg = msg.substring(0, sb.length() - 1);
			System.out.println(msg);
		}
	}
}

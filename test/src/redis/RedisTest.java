package redis;

import java.util.List;
import java.util.Set;
import redis.clients.jedis.Jedis;

/**
 * Redis Java测试
 * @author YMGC
 *
 */
public class RedisTest {

	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("192.168.40.129");
		System.out.println("链接成功");
		System.out.println("正在运行：" + jedis.ping());
		
		System.out.println("+++++++++++++++++++String+++++++++++++++++++");
		jedis.set("name", "张昊");
		System.out.println("get:" + jedis.get("name"));
		System.out.println("+++++++++++++++++++String+++++++++++++++++++");
		
		System.out.println("+++++++++++++++++++List+++++++++++++++++++");
		jedis.lpush("top10", "10");
		jedis.lpush("top10", "9");
		jedis.lpush("top10", "8");
		jedis.lpush("top10", "7");
		
		Long len = jedis.llen("top10");
		List<String> lrange = jedis.lrange("top10", 0, len);
		for (String string : lrange) {
			System.out.println("top10：" + string);
		}
		System.out.println("+++++++++++++++++++List+++++++++++++++++++");
		
		System.out.println("+++++++++++++++++++Set+++++++++++++++++++");
		jedis.sadd("helloredis", "settest1");
		jedis.sadd("helloredis", "settest2");
		jedis.sadd("helloredis", "settest3");
		jedis.sadd("helloredis", "settest4");
		Set<String> smembers = jedis.smembers("helloredis");
		for (String string : smembers) {
			System.out.println("Set：" + string);
		}
		System.out.println("+++++++++++++++++++Set+++++++++++++++++++");
	}

}

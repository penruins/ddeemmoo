package redis;

import redis.clients.jedis.Jedis;

/**
 * [Java 使用 Redis](https://www.runoob.com/redis/redis-java.html)
 */
public class RedisTest {
  public static void main(String[] args) {
    test001();
    test002();
    test003();
  }
  public static void test001() {
    Jedis jedis = new Jedis("localhost");
    System.out.println(jedis.ping());
  }
  public static void test002() {
    Jedis jedis = new Jedis("localhost");
    jedis.set("penruins","lx_tdcq_king@icloud.com");
  }
  public static void test003() {
    Jedis jedis = new Jedis("localhost");
    System.out.println(jedis.get("penruins"));
  }
}

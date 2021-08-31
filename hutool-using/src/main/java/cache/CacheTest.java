package cache;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.date.DateUnit;

public class CacheTest {
  public static void main(String[] args) {
    test001();
  }
  public static void test001() {
    Cache<String,String> fifoCache = CacheUtil.newFIFOCache(3);
    fifoCache.put("key1","value1", DateUnit.SECOND.getMillis()*3);
    fifoCache.put("key2","value2", DateUnit.SECOND.getMillis()*3);
    fifoCache.put("key3","value3", DateUnit.SECOND.getMillis()*3);

    fifoCache.put("key4","value4", DateUnit.SECOND.getMillis()*3);


    System.out.println(fifoCache.get("key1"));
    System.out.println(fifoCache.get("key2"));
    System.out.println(fifoCache.get("key3"));
    System.out.println(fifoCache.get("key4"));
  }
}

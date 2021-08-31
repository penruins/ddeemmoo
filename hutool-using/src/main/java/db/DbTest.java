package db;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * https://www.hutool.cn/docs/#/db/%E6%95%B0%E6%8D%AE%E5%BA%93%E7%AE%80%E5%8D%95%E6%93%8D%E4%BD%9C-Db
 */
public class DbTest {
  public static void main(String[] args) throws SQLException {
    test001();
  }
  public static void test001() throws SQLException {
    List<Entity> book = Db.use().findAll("book");
    book.forEach(b -> {
      System.out.println(b);
    });

  }
}

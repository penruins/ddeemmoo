package database.postgresql;

import random.NameRandom;
import random.NumberRandom;
import random.entity.People;
import redis.clients.jedis.Jedis;

import java.sql.*;
import java.util.List;

public class MainTest {
  private static final String url = "jdbc:postgresql://localhost:54322/mydb001";
  private static final String username = "postgres";
  private static final String password = "123456";

  public static void main(String[] args) throws Exception{
    test007();
  }

  /**
   * 查询数据库中的 `t_users` 表中的所有数据，并且打印
   * [JDBC连接postgresql例子](https://blog.csdn.net/s465689853/article/details/81217448)
   *
   * 这里我没有 `try-catch` 不然代码太乱了
   */
  public static void test001() throws Exception {
    // 建立数据库的时候 `first` 都拼错了

    String sql = "select * from t_people";

    Class.forName("org.postgresql.Driver").newInstance();
    Connection connection = DriverManager.getConnection(url,username,password);

    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ResultSet resultSet = null;
      resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      int id = resultSet.getInt("id");
      String name = resultSet.getString("name");
      int age = resultSet.getInt("age");
      System.out.println("id=" + id + ", name=" + name + ", age=" + age);
    }
  }
  // 增加1600000条信息
  public static void test002() throws Exception{
    String sql = "insert into t_people values(?,?,?);";

    Class.forName("org.postgresql.Driver").newInstance();
    Connection connection = DriverManager.getConnection(url,username,password);
    PreparedStatement preparedStatement = connection.prepareStatement(sql);


    // 400个名字
    List<String> names = NameRandom.randomNames();
    for(long i=1;i<names.size()*4000;i++) {
      long id = (long) i;
      String name = names.get((int)(i%400));
      int age = NumberRandom.randomNumber(80);
      preparedStatement.setLong(1,i);
      preparedStatement.setString(2,name);
      preparedStatement.setInt(3,age);
      preparedStatement.executeUpdate();
      System.out.println(i);
    }
  }
  // 直接查询数据库所用时间
  public static void test003() throws Exception {
    // 建立数据库的时候 `first` 都拼错了
    long startTime = System.currentTimeMillis();

    String sql = "select * from t_people";

    Class.forName("org.postgresql.Driver").newInstance();
    Connection connection = DriverManager.getConnection(url,username,password);

    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ResultSet resultSet = null;
    resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      long id = resultSet.getLong("id");
      String name = resultSet.getString("name");
      int age = resultSet.getInt("age");
      System.out.println("id=" + id + ", name=" + name + " ,age=" + age);
    }
    long endTime = System.currentTimeMillis();
    long duration = (endTime - startTime);
    System.out.println("duration=" + duration);
  }
  // 直接查询数据库所用事件，根据 id
  public static void test004() throws Exception {
    long startTime = System.currentTimeMillis();

    String sql = "select * from t_people where id=?";

    Class.forName("org.postgresql.Driver").newInstance();
    Connection connection = DriverManager.getConnection(url,username,password);
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    for(long i=0;i<1599999;i++) {
      preparedStatement.setLong(1,i);
      ResultSet resultSet = null;
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        System.out.println("id=" + id + ", name=" + name + " ,age=" + age);
      }
    }
    long endTime = System.currentTimeMillis();
    long duration = (endTime - startTime);
    System.out.println("duration=" + duration);
  }
  /**
   * 加入缓存查询
   *
   * 如果缓存中存在，则直接获取
   * 如果没有，则从数据库中读取，然后存入缓存
   * @throws Exception
   */
  public static void test005() throws Exception {
    Jedis jedis = new Jedis("localhost");

    long startTime = System.currentTimeMillis();

    String sql = "select * from t_people where id=?";

    Class.forName("org.postgresql.Driver").newInstance();
    Connection connection = DriverManager.getConnection(url,username,password);
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    for(long i=0;i<1599999;i++) {
      String key = i+"_id";
      if(jedis.exists(key)) {
        System.out.println(jedis.get(key));
      } else {
        preparedStatement.setLong(1,i);
        ResultSet resultSet = null;
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
          long id = resultSet.getLong("id");
          String name = resultSet.getString("name");
          int age = resultSet.getInt("age");
          String value = "id=" + id + ", name=" + name + " ,age=" + age;
          jedis.set(key,value);
          System.out.println(value);
        }
      }
    }
    long endTime = System.currentTimeMillis();
    long duration = (endTime - startTime);
    System.out.println("duration=" + duration);
  }
  // 分页查询测试
  public static void test006() throws Exception {
    long startTime = System.currentTimeMillis();

    String sql = "select * from t_people limit 3 offset 4";

    Class.forName("org.postgresql.Driver").newInstance();
    Connection connection = DriverManager.getConnection(url,username,password);

    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ResultSet resultSet = null;
    resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      long id = resultSet.getLong("id");
      String name = resultSet.getString("name");
      int age = resultSet.getInt("age");
      System.out.println("id=" + id + ", name=" + name + " ,age=" + age);
    }
    long endTime = System.currentTimeMillis();
    long duration = (endTime - startTime);
    System.out.println("duration=" + duration);
    resultSet.close();
    preparedStatement.close();
    connection.close();
  }
  // 通过分页查询，查询所有的信息
  public static void test007() throws Exception{
    int page_num = 0;
    long page_size = 0;
    do {
      page_size = PostgresqlUtils.pageSelect("t_people",2,page_num);
      page_num++;
    } while (page_size == 2);
  }
}













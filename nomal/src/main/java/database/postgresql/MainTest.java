package database.postgresql;

import random.NameRandom;
import random.NumberRandom;
import random.entity.People;

import java.sql.*;
import java.util.List;

public class MainTest {
  public static void main(String[] args) throws Exception{
    test002();
  }

  /**
   * [JDBC连接postgresql例子](https://blog.csdn.net/s465689853/article/details/81217448)
   * 查询数据库中的 `t_users` 表中的所有数据，并且打印
   *
   * 这里我没有 `try-catch` 不然代码太乱了
   */
  public static void test001() throws Exception {
    // 建立数据库的时候 `first` 都拼错了
    String url = "jdbc:postgresql://localhost:5432/myfrist";
    String username = "postgres";
    String password = "mzrfviwhninayh";

    String sql = "select * from t_users";

    Class.forName("org.postgresql.Driver").newInstance();
    Connection connection = DriverManager.getConnection(url,username,password);

    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ResultSet resultSet = null;
      resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      int id = resultSet.getInt("id");
      String name = resultSet.getString("name");
      String address = resultSet.getString("address");
      int age = resultSet.getInt("age");
      System.out.println("id=" + id + ", name=" + name + ", address=" + address + ", age=" + age);
    }
  }
  public static void test002() throws Exception{
    String url = "jdbc:postgresql://localhost:5432/myfrist";
    String username = "postgres";
    String password = "mzrfviwhninayh";

    String sql = "insert into t_people values(?,?,?);";

    Class.forName("org.postgresql.Driver").newInstance();
    Connection connection = DriverManager.getConnection(url,username,password);
    PreparedStatement preparedStatement = connection.prepareStatement(sql);


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
}

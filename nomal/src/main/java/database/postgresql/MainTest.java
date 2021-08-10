package database.postgresql;

import java.sql.*;

public class MainTest {
  public static void main(String[] args) throws Exception{
    System.out.println("========== test001() ==========");
    test001();
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
}

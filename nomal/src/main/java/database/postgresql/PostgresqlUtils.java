package database.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostgresqlUtils {

  private static final String url = "jdbc:postgresql://localhost:54322/mydb001";
  private static final String username = "postgres";
  private static final String password = "123456";

  public static long getCount(String table_name) throws Exception{
    long count = 0;
    String sql = "select count(*) from " + table_name;

    Class.forName("org.postgresql.Driver").newInstance();
    Connection connection = DriverManager.getConnection(url,username,password);

    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ResultSet resultSet = null;
    resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      count = resultSet.getLong("count");
    }
    resultSet.close();
    preparedStatement.close();
    connection.close();
    return count;
  }
  public static long pageSelect(String table_name, long limit, long offset) throws Exception{
    int count = 0;
    String sql = "select * from " + table_name + " limit "+ limit + " offset " + offset;

    Class.forName("org.postgresql.Driver").newInstance();
    Connection connection = DriverManager.getConnection(url,username,password);

    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ResultSet resultSet = null;
    resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      count++;
      long id = resultSet.getLong("id");
      String name = resultSet.getString("name");
      int age = resultSet.getInt("age");
      System.out.println("id=" + id + ", name=" + name + " ,age=" + age);
    }
    resultSet.close();
    preparedStatement.close();
    connection.close();
    return count;
  }

  public static void main(String[] args) throws Exception{
    //System.out.println(getCount("t_people"));
    System.out.println(pageSelect("t_people", 3, 0));
  }
}

package database.mysql;

import random.NameRandom;
import random.NumberRandom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySqlTest {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    String url = "jdbc:mysql://localhost:3306/db_user";
    String username = "root";
    String password = "mzrfviwhninayh";

    String sql = "insert into t_people values(?,?,?);";

    Class.forName("com.mysql.cj.jdbc.Driver");
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
}

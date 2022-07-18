package JDBC;

import java.sql.*;

public class JDBCExampleOne {
   public static void main(String[] args) throws SQLException {
      Connection connection =
              DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental","postgres","123420");
      PreparedStatement preparedStatement = connection.prepareStatement("select address_id,city_id,district"+", address from address" );
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
         System.out.println(resultSet.getInt("address_id")
         + " , " + resultSet.getInt(2)
         + " , " + resultSet.getString(3)
         + " , " + resultSet.getString(4));
      }
      connection.close();
   }

}

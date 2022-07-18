package JDBC;

import java.sql.*;

public class SelectExample {
    public static void main(String[] args) throws SQLException {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental","postgres","123420");
        PreparedStatement preparedStatement = connection.prepareStatement
                ("select f.film_id,f.title,l.name from film f inner join language l on l.language_id=f.language_id");
      ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getInt("film_id")
            + " - " + resultSet.getString("title")
                    + " - " + resultSet.getString("name"));
        }
        connection.close();
    }
}

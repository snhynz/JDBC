package JDBC;

import java.sql.*;

// id 800 ile 825 arasında olan filmlerin title ı NS ile biten filmler
public class MyScannerExample {
    public static void main(String[] args) throws SQLException {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental","postgres","123420");
        String sql = "select f.film_id,f.title from film f " +
                "where (f.film_id between 800 and 825) and f.title like '%ns'";
        PreparedStatement preparedStatement =
                connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getInt("film_id")
            + " - " + resultSet.getString("title"));
        }
        connection.close();
    }
}

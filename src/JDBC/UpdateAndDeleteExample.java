package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateAndDeleteExample {
    private static final String TABLE_NAME = "ibrahim_senih_yanaz";
    public static void main(String[] args) throws SQLException {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental","postgres","123420");
update(connection);
delete(connection);
    }
    public static void update(Connection connection) throws SQLException {
        String updateSql = "update " + TABLE_NAME + " set name ='AAA' where id=1 ";
        PreparedStatement updatePS = connection.prepareStatement(updateSql);
        updatePS.executeUpdate();
        System.out.println("Güncelleme yapıldı");

    }
    public static void delete(Connection connection) throws SQLException {
        String deleteSql = "delete from " + TABLE_NAME + " where id=2 ";
        PreparedStatement deletePS = connection.prepareStatement(deleteSql);
        deletePS.executeUpdate();
        System.out.println("Silme tamamlandı");
    }

}

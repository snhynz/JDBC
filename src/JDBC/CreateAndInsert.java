package JDBC;

import java.sql.*;

//Kendi adında bir tablo oluştur
//id int - name varchar - surname varchar
//3 datada insert edilecek
public class CreateAndInsert {
    private static final String TABLE_NAME = "ibrahim_senih_yanaz";
    public static void main(String[] args) throws SQLException {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental","postgres","123420");
if(checkTable(connection)){
    System.out.println("Tablo var");
}
else{
       PreparedStatement createPS =
               connection.prepareStatement("create table "+ TABLE_NAME+" (id integer,name varchar(50), surname varchar(50))");
        createPS.executeUpdate();
        System.out.println("Tablo oluşturuldu.");}

        PreparedStatement insertPS =
                connection.prepareStatement("insert into " +TABLE_NAME+" (id,name,surname)" +
                        "values(1,'Senih','Yanaz'),"
                + " (2,'Zehra','Yanaz'),"
                + " (3,'Siraç','Yanaz');");
        insertPS.executeUpdate();
        System.out.println("İnsert işlemi tamamlandı.");
        connection.close();

    }
    public static boolean checkTable(Connection connection) throws SQLException {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet =
                databaseMetaData.getTables(null, null, TABLE_NAME, new String[]{"TABLE"});
        while (resultSet.next()) {
            String name = resultSet.getString("TABLE_NAME");
            if(name.equals(TABLE_NAME)){
                return true;
            }
        }return false;

    }
}

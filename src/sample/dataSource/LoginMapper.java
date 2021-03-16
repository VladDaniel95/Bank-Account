package sample.dataSource;

import sample.domain.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMapper {
    public static boolean getLoginAdmin(String username, String password) {

        try {
            dbConnection db = dbConnection.getConnection();
            Connection con = db.connection;

            String sql = "SELECT username, password, role FROM login WHERE (username = ? and password = ?)";
            PreparedStatement prepSt = con.prepareStatement(sql);

            prepSt.setString(1, username);
            prepSt.setString(2, password);

            ResultSet rs = prepSt.executeQuery();

            int count = 0;
            if (rs.next()) {
                count+=1;
            }
            rs.close();
            if (count == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Eroare in DataSource, LoginMapper, getLoginAdmin" + e);
            return false;
        }
    }


}



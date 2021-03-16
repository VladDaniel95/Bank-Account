package sample.dataSource;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.domain.Account;
import sample.domain.dbConnection;

import java.sql.*;

public class AccountMapper {
    public static void INSERT(int account_id, int client_id, String type, double amount){
        dbConnection db = dbConnection.getConnection();
        Connection con = db.connection;
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement("INSERT INTO account(acc_id, client_id,type,amount) VALUES(?,?,?,? )");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {

            pstmt.setInt(1, account_id );
            pstmt.setInt(2, client_id);
            pstmt.setString(3, type);
            pstmt.setDouble(4, amount);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void DELETE(int account_id){
        dbConnection db = dbConnection.getConnection();
        Connection con = db.connection;
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement("DELETE FROM account where acc_id=?");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {

            pstmt.setInt(1, account_id );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void UPDATE(int account_id, int client_id, String type, double amount){
        dbConnection db = dbConnection.getConnection();
        Connection con = db.connection;
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement("UPDATE account SET  type=?, amount=? where acc_id=?");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {

            pstmt.setString(1, type );
            pstmt.setDouble(2, amount);
            pstmt.setInt(3,account_id );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static ObservableList<Account>getAllRows() throws ClassNotFoundException, SQLException{
        dbConnection db = dbConnection.getConnection();
        Connection con = db.connection;
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement("Select * FROM account");
            ResultSet rs= pstmt.executeQuery();
            ObservableList<Account> acc_list= getAccountObjects(rs);
            return acc_list;
        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }

    }
    private static ObservableList<Account> getAccountObjects(ResultSet rs) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Account>a_list= FXCollections.observableArrayList();
            while (rs.next()){
                Account acc = new Account();
                acc.setAcc_id(rs.getInt("acc_id"));
                acc.setClient_id(rs.getInt("client_id"));
                acc.setType(rs.getString("type"));
                acc.setAmount(rs.getDouble("amount"));
                a_list.add(acc);

            }
            return a_list;

        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }


    }
}

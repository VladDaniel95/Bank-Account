package sample.dataSource;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.domain.Account;
import sample.domain.Client;
import sample.domain.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper {
    public static void INSERT(String name , int id_card, String address, int login_id, String cnp,int client_id){
        dbConnection db = dbConnection.getConnection();
        Connection con = db.connection;
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement("INSERT INTO client(name, id_card ,address,login_id,cnp,client_id) VALUES(?,?,?,?,?,? )");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {

            pstmt.setString(1, name );
            pstmt.setInt(2, id_card);
            pstmt.setString(3, address);
            pstmt.setInt(4, login_id);
            pstmt.setString(5, cnp);
            pstmt.setInt(6, client_id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void DELETE(int client_id){
        dbConnection db = dbConnection.getConnection();
        Connection con = db.connection;
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement("DELETE FROM client where client_id=?");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {

            pstmt.setInt(1, client_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void UPDATE(String name, int id_card,String address, int login_id, String cnp, int client_id){
        dbConnection db = dbConnection.getConnection();
        Connection con = db.connection;
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement("UPDATE client SET name=?, id_card=?, address=?, login_id=?, cnp=? where client_id=?");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {

            pstmt.setString(1, name );
            pstmt.setInt(2,id_card);
            pstmt.setString(3,address );
            pstmt.setInt(4, login_id );
            pstmt.setString(5,cnp);
            pstmt.setInt(6,client_id );

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static ObservableList<Client> getAllRows() throws ClassNotFoundException, SQLException{
        dbConnection db = dbConnection.getConnection();
        Connection con = db.connection;
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement("Select * FROM client");
            ResultSet rs= pstmt.executeQuery();
            ObservableList<Client> client_list= getClientObjects(rs);
            return client_list;
        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }

    }
    private static ObservableList<Client> getClientObjects(ResultSet rs) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Client>c_list= FXCollections.observableArrayList();
            while (rs.next()){
                Client c = new Client();
                c.setName(rs.getString("name"));
                c.setId_card(rs.getInt("id_card"));
                c.setAddress(rs.getString("address"));
                c.setLogin_id(rs.getInt("login_id"));
                c.setCnp(rs.getString("cnp"));
                c.setClient_id(rs.getInt("client_id"));
                c_list.add(c);

            }
            return c_list;

        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }


    }
}

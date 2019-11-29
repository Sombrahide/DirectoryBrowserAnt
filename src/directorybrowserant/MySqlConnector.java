/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorybrowserant;

import java.sql.*;

/**
 *
 * @author Juanjo
 */
public class MySqlConnector {

    private Connection _con;
    private Statement _stmt;
    private ResultSet _rs;

    public MySqlConnector() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public MySqlConnector(String url, String user, String password) {
        try {
            _con = DriverManager.getConnection(url, user, password);
            _stmt = _con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void connect(String url, String user, String password) {
        try {
            _con = DriverManager.getConnection(url, user, password);
            _stmt = _con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public ResultSet command (String command) {
        try {
            _rs = _stmt.executeQuery(command);
        } catch (Exception e) {
            System.out.println(e);
        }
        return _rs;
    }
    public void close (){
        try {
            _con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

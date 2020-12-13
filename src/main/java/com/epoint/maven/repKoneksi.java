/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epoint.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class repKoneksi {
    public static Connection getKoneksi() {
        Connection koneksi = null;
        try {
            String driver = "org.sqlite.JDBC";
            String url = "jdbc:sqlite:db/epoint_db.db";
            
            Class.forName(driver);
            koneksi = DriverManager.getConnection(url);

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        
        return koneksi;
    }
}

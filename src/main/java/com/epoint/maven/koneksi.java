/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epoint.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class koneksi {
    private Connection koneksi;

    public Connection connect(){
       //untuk koneksi ke driver
       try{
           Class.forName("org.sqlite.JDBC");
//           JOptionPane.showMessageDialog(null, "berhasil load driver");
       }catch(ClassNotFoundException ex){
           JOptionPane.showMessageDialog(null, "Tidak ada Driver!\n" + ex);
       }

       //untuk koneksi ke database
       try{
           String url="jdbc:sqlite:db/epoint_db.db";
           koneksi=DriverManager.getConnection(url);
           System.out.println("Berhasil koneksi");
       }catch(SQLException se){
           System.out.println("Gagal koneksi "+se);
           JOptionPane.showMessageDialog(null,"Gagal Koneksi Database","Peringatan",JOptionPane.WARNING_MESSAGE);
       }
       return koneksi;
    }
}

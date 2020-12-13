/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epoint.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Amrie.Dev
 */
public class fungsi {
    String data[]=new String[1];
    
    public String kol_tabel(String kol,String tb,String kolcr,String val){
         try {
              java.sql.Connection koneksi = new koneksi().connect();
              java.sql.Statement stmt=koneksi.createStatement();
              java.sql.ResultSet rs=stmt.executeQuery("select "+kol+" from "+tb+" where "+kolcr+"='"+val+"'");
               // Class.forName("org.sqlite.JDBC");
//            Connection cn = (Connection) DriverManager.getConnection("jdbc:sqlite:db/epoint_db.db");
//            ResultSet rs = cn.createStatement().executeQuery("select "+kol+" from "+tb+" where "+kolcr+"='"+val+"'");
            if(rs.next()){
                 data[0]=rs.getString(1);
            }
            rs.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        return data[0];
    }
    
    public String cek_point(String nim){
         try {
             java.sql.Connection koneksi = new koneksi().connect();
             java.sql.Statement stmt=koneksi.createStatement();
             java.sql.ResultSet rs=stmt.executeQuery("select sum(point) from point where nim='"+nim+"'");
               // Class.forName("org.sqlite.JDBC");
//            Connection cn = (Connection) DriverManager.getConnection("jdbc:sqlite:db/epoint_db.db");
//            ResultSet rs = cn.createStatement().executeQuery("select sum(point) from point where nim='"+nim+"'");
            if(rs.next()){
                 data[0]=rs.getString(1);
            }
            rs.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        return data[0];
    }
    
        public String cari_point(String jenis, String keg){
         try {
              java.sql.Connection koneksi = new koneksi().connect();
              java.sql.Statement stmt=koneksi.createStatement();
              java.sql.ResultSet rs=stmt.executeQuery("select point from kegiatan where jenis='"+jenis+"' and nama='"+keg+"'");
               // Class.forName("org.sqlite.JDBC");
//            Connection cn = (Connection) DriverManager.getConnection("jdbc:sqlite:db/epoint_db.db");
//            ResultSet rs = cn.createStatement().executeQuery("select point from kegiatan where jenis_k='"+jenis+"' and nama_k='"+keg+"'");
            if(rs.next()){
                 data[0]=rs.getString(1);
            }
            rs.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        return data[0];
    }
    
    public String ConvertDate(String tgl){
        String tgl2 = null;
        tgl2 = tgl.substring(0,10);
        return tgl2;
    }
    
    public String showDateNow() {
        Date tgls = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String hasil = sdf.format(tgls);
        return hasil;
    }
}

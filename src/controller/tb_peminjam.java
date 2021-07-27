/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.peminjam;


public class tb_peminjam {
    Connection con;
    public tb_peminjam(Connection con)
    {
        this.con = con;
    }
    
    
     public List<peminjam> getAllPeminjam(String cari){
      List<peminjam> listPeminjam = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tb_peminjam "
                    + "WHERE NIK LIKE '%" + cari + "%'");
             ResultSet rs = ps.executeQuery();
             while  (rs.next())
             {
                peminjam plgn = new peminjam();
                plgn.setnNIK(rs.getString(1));
                plgn.setpPlat_motor(rs.getString(2));
                plgn.setBayar(rs.getInt(3));
                
                listPeminjam.add(plgn);
             }
        } catch (SQLException ex) {
            Logger.getLogger(tb_pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPeminjam;
        
    }
    public List<peminjam> getAllPeminjam(){
      List<peminjam> listPeminjam = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT tb_pelanggan.Nama, tb_pelanggan.NIK, tb_motor.Type_motor, tb_motor.Plat_motor, tb_peminjam.Tagihan, tb_peminjam.Waktu "
                    +"FROM tb_peminjam INNER JOIN tb_pelanggan"
                    +" ON tb_peminjam.NIK = tb_pelanggan.NIK INNER JOIN tb_motor ON tb_peminjam.Plat_motor = tb_motor.Plat_motor ");
            //SELECT * FROM tb_peminjam
             ResultSet rs = ps.executeQuery();
             while  (rs.next())
             {
                 
                peminjam plgn = new peminjam();
                plgn.setNamaa (rs.getString(1));
                plgn.setnNIK(rs.getString(2));
                plgn.setTypee(rs.getString(3));
                plgn.setpPlat_motor(rs.getString(4));
                plgn.setBayar(rs.getInt(5));
                
                
                listPeminjam.add(plgn);
             }
        } catch (SQLException ex) {
            Logger.getLogger(tb_pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPeminjam;
        
    }
    public boolean insertpelanggan(peminjam plgn) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tb_peminjam (NIK, Plat_motor, Tagihan) "
                    + "VALUES (?, ?, ?)");
            ps.setString(1, plgn.getnNIK());
            ps.setString(2, plgn.getpPlat_motor());
            ps.setInt(3, plgn.getBayar());
          
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deletePelanggan(String nik) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM tb_peminjam "
                    + "WHERE NIK='" + nik + "'");
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public int totalPeminjam() {
        int total = 0;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM tb_peminjam");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(tb_peminjam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    public boolean updatePeminjam(peminjam plgn, String namaUpdate) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tb_peminjam "
                    + "SET NIK=?, Plat_motor=?, Tagihan=? "
                    + "WHERE NIK=?");
            ps.setString(1, plgn.getnNIK());
            ps.setString(2, plgn.getpPlat_motor());
            ps.setInt(3, plgn.getBayar());
            ps.setString(4, plgn.getnNIK());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    
     
}

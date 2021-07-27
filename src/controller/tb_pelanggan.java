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
import model.pelanggan;

/**
 *
 * @author User
 */
public class tb_pelanggan {
   
    Connection con;
    public tb_pelanggan(Connection con)
    {
        this.con = con;
    }
    
    
     public List<pelanggan> getAllPelanggan(String cari){
      List<pelanggan> listPelanggan = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tb_pelanggan "
                    + "WHERE Nama LIKE '%" + cari + "%'");
             ResultSet rs = ps.executeQuery();
             while  (rs.next())
             {
                pelanggan plgn = new pelanggan();
                plgn.setNIK(rs.getString(1));
                plgn.setNama(rs.getString(2));
                plgn.setAlamat(rs.getString(3));
                plgn.setNo_hp(rs.getString(4));
            
                
                
                listPelanggan.add(plgn);
             }
        } catch (SQLException ex) {
            Logger.getLogger(tb_pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPelanggan;
        
    }
    public List<pelanggan> getAllPeminjam(){
      List<pelanggan> listPelanggan = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tb_pelanggan ");
             ResultSet rs = ps.executeQuery();
             while  (rs.next())
             {
                pelanggan plgn = new pelanggan();
                plgn.setNIK(rs.getString(1));
                plgn.setNama(rs.getString(2));
                plgn.setAlamat(rs.getString(3));
                plgn.setNo_hp(rs.getString(4));
               
                
                listPelanggan.add(plgn);
             }
        } catch (SQLException ex) {
            Logger.getLogger(tb_pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPelanggan;
        
    }
    public boolean insertpelanggan(pelanggan plgn) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tb_pelanggan (NIK, Nama, Alamat, No_Hp) "
                    + "VALUES (?, ?, ?, ?)");
            ps.setString(1, plgn.getNIK());
            ps.setString(2, plgn.getNama());
            ps.setString(3, plgn.getAlamat());
            ps.setString(4, plgn.getNo_hp());
       
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
            PreparedStatement ps = con.prepareStatement("DELETE FROM tb_pelanggan "
                    + "WHERE Nama='" + nik + "'");
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public int totalPelanggan() {
        int total = 0;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM tb_pelanggan");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(tb_pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    public boolean updatePelanggan(pelanggan plgn, String namaUpdate) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tb_pelanggan "
                    + "SET NIK=?, Nama=?, Alamat=?, No_Hp=?"
                    + "WHERE NIK=?");
            ps.setString(1, plgn.getNIK());
            ps.setString(2, plgn.getNama());
            ps.setString(3, plgn.getAlamat());
            ps.setString(4, plgn.getNo_hp());
            ps.setString(5, plgn.getNIK());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}

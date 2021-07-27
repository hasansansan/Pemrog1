
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.motor;


public class tb_motor {
    Connection con;
    public tb_motor(Connection con)
    {
        this.con = con;
    }
    
    
     public List<motor> getAllMotor(String cari){
      List<motor> listMotor = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tb_motor "
                    + "WHERE Type_motor LIKE '%" + cari + "%'");
             ResultSet rs = ps.executeQuery();
             while  (rs.next())
             {
                motor mtr = new motor();
                mtr.setType_motor(rs.getString(1));
                mtr.setTahun(rs.getString(2));
                mtr.setPlat_motor1(rs.getString(3));
                mtr.setHarperjam(rs.getInt(4));
                
                listMotor.add(mtr);
             }
        } catch (SQLException ex) {
            Logger.getLogger(tb_motor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMotor;
        
    }
    public List<motor> getAllMotor(){
      List<motor> listMotor = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tb_yamaha ");
             ResultSet rs = ps.executeQuery();
             while  (rs.next())
             {
                motor mtr = new motor();
                mtr.setType_motor(rs.getString(1));
                mtr.setTahun(rs.getString(2));
                mtr.setPlat_motor1(rs.getString(3));
                mtr.setHarperjam(rs.getInt(4));
                
                listMotor.add(mtr);
             }
        } catch (SQLException ex) {
            Logger.getLogger(tb_pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMotor;
        
    }
//    public boolean insertYamaha(motor mtr) {
//        try {
//            PreparedStatement ps = con.prepareStatement("INSERT INTO tb_motor (NIK, Nama, Alamat, No_Hp) "
//                    + "VALUES (?, ?, ?, ?)");
//            ps.setString(1, mtr.getType_motor());
//            ps.setString(2, mtr.getTahun());
//            ps.setString(3, mtr.getJumunit();
//            ps.setString(4, mtr.getHarperjam();
//            
//            if (ps.executeUpdate() > 0) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
    
//    public boolean deletePelanggan(String nik) {
//        try {
//            PreparedStatement ps = con.prepareStatement("DELETE FROM tb_pelanggan "
//                    + "WHERE Nama='" + nik + "'");
//            if (ps.executeUpdate() > 0) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
    
    public int totalMotor() {
        int total = 0;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM tb_motor");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(tb_motor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    public boolean updateMotor(motor mtr, String namaUpdate) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tb_motor "
                    + "SET Type_motor=?, Tahun=?, Plat_motor=?, Harga_perjam=? "
                    + "WHERE Plat_motor=?");
            ps.setString(1, mtr.getType_motor());
            ps.setString(2, mtr.getTahun());
            ps.setString(3, mtr.getPlat_motor());
            ps.setInt(4, mtr.getHarperjam());
            ps.setString(5, mtr.getType_motor());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

   
}

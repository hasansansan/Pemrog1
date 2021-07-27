
package Tampilan;

import controller.db_rentalmotor;
import controller.tb_pelanggan;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.pelanggan;



class Proses extends Thread {

    Pelanggan m;

    public Proses(Pelanggan m) {
        this.m = m;
    }

    @Override
    public void run() {
        while (true) {
            int totalTemp = new tb_pelanggan(m.con).totalPelanggan();
            if (m.total != totalTemp) {
                m.total = totalTemp;
                m.bindingTbPelanggan(null);  
            }
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Proses.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}



public class Pelanggan extends javax.swing.JFrame {
   
    Connection con;
    List<pelanggan> listPelanggan = new ArrayList<>();
    int indeksPilih;
    String namaPelanggan;
    int total;
    String filename;
    byte[] person_image=null;
    
    
    public void bindingTbPelanggan(String cari)
    {
        if (cari == null) {
            cari = "";
        }
        total = new tb_pelanggan(con).totalPelanggan();
        listPelanggan = new tb_pelanggan(con).getAllPelanggan(cari);
        Object [][] o = new Object[listPelanggan.size()][5];
        for (int i=0; i<listPelanggan.size();i++){
            o[i][0] = listPelanggan.get(i).getNIK();
            o[i][1] = listPelanggan.get(i).getNama();
            o[i][2] = listPelanggan.get(i).getAlamat();
            o[i][3] = listPelanggan.get(i).getNo_hp();
         
        }
        
  Tbl_tabel.setModel(new javax.swing.table.DefaultTableModel(
    o,
    new String [] {
        "NIK", "Nama", "Alamat", "No_Hp", "Gambar"
    }
)
  {
      boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
  
                
        
    }
     public void resetForm() {
        
        tf_nik.setText("");
        tf_nama.setText("");
        tf_alamat.setText("");
        tf_noHP.setText("");
        
        btn_Insert.setEnabled(true);
        btn_update.setEnabled(true);
        btn_delete.setEnabled(true);
    }
     
     public void ThreadCal(){
         Thread t = new Thread(){
            @Override
            public void run(){
                while(true){
                    Calendar kal = new GregorianCalendar();
                    int tahun = kal.get(Calendar.YEAR);
                    int bulan = kal.get(Calendar.MONTH);
                    int hari = kal.get(Calendar.DAY_OF_MONTH);
                    int jam = kal.get(Calendar.HOUR_OF_DAY);
                    int menit = kal.get(Calendar.MINUTE);
                    int detik = kal.get(Calendar.SECOND);
                   
                    String tanggal = hari+"-"+bulan+"-"+tahun;
                    String waktu = jam+":"+menit+":"+detik;
                    
                    labeltanggal.setText(tanggal);
                    labeljam.setText(waktu);
            }
           }  
         };
         t.start();
     }
   
         
    public Pelanggan() {
        initComponents();
        con = new db_rentalmotor().getConnection();
        bindingTbPelanggan(null);
        Thread t = new Thread(new Proses(this));
        t.start();
        ThreadCal();
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_nama = new javax.swing.JTextField();
        tf_alamat = new javax.swing.JTextField();
        tf_noHP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_nik = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_tabel = new javax.swing.JTable();
        btn_next = new javax.swing.JButton();
        btn_Insert = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_cari = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        butongambar = new javax.swing.JButton();
        TF_gambar = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        tampil = new javax.swing.JLabel();
        labeltanggal = new javax.swing.JLabel();
        labeljam = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Javanese Text", 1, 24)); // NOI18N
        jLabel1.setText("RENTAL MOTOR");

        jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 1, 18))); // NOI18N

        jLabel2.setText("Nama           :");

        jLabel3.setText("NIK              :");

        jLabel4.setText("Alamat         :");

        jLabel5.setText("No. Telpon   :");

        jLabel6.setText("Foto KTP      :");

        Tbl_tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIK", "Nama", "Alamat", "No_Hp", "Gambar"
            }
        ));
        Tbl_tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tbl_tabel);

        btn_next.setText("Next");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_Insert.setText("Insert");
        btn_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InsertActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_cari.setText("cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        butongambar.setText("Browse");
        butongambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butongambarActionPerformed(evt);
            }
        });

        TF_gambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_gambarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TF_gambar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(butongambar)
                                .addGap(143, 143, 143))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_refresh)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_Insert)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_update))
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tf_nama, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(tf_alamat)
                                            .addComponent(tf_noHP)
                                            .addComponent(tf_nik))
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_cari)
                                        .addGap(18, 18, 18)
                                        .addComponent(tampil, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_delete)
                        .addGap(21, 21, 21))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_next)
                .addGap(44, 44, 44))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tf_nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tf_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tf_noHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(tampil, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)))
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TF_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butongambar))
                .addGap(12, 12, 12)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Insert)
                    .addComponent(btn_update)
                    .addComponent(btn_delete)
                    .addComponent(btn_refresh)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_next)
                .addGap(6, 6, 6))
        );

        labeltanggal.setText("jLabel7");

        labeljam.setText("jLabel8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labeltanggal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labeljam)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labeltanggal)
                    .addComponent(labeljam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
       
        String txt = tf_nik.getText();  
        if(txt.isEmpty()){
         JOptionPane.showMessageDialog(btn_next, "Harus Di Isi");
         }else{
            motor n = new motor();
            cetak ct = new cetak();
               n.nnik = tf_nik.getText();
               n.setNIK(tf_nik.getText());
               ct.nnikk = tf_nik.getText();
               ct.setNIK(tf_nik.getText());
             n.setVisible(true);
             this.dispose();
         }
        
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
           if (JOptionPane.showConfirmDialog(this, "Apakah Anda akan update Pelanggna ini ?", "Update Pelanggan", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            pelanggan plgn = new pelanggan();
            plgn.setNIK(tf_nik.getText());
            plgn.setNama(tf_nama.getText());
            plgn.setAlamat(tf_alamat.getText());
            plgn.setNo_hp(tf_noHP.getText());
            if (!plgn.equals("")) {
                new tb_pelanggan(con).updatePelanggan(plgn, namaPelanggan);
                JOptionPane.showMessageDialog(this, "Data Pelanggan berhasil diupdate");
                resetForm();
                bindingTbPelanggan(null);
            } else {
                JOptionPane.showMessageDialog(this, "Data Pelanggan gagal disimpan !");
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InsertActionPerformed
        pelanggan plgn = new pelanggan();
        
        plgn.setNIK(tf_nik.getText());
        plgn.setNama(tf_nama.getText());
        plgn.setAlamat(tf_alamat.getText());
        plgn.setNo_hp(tf_noHP.getText());
       
        
        listPelanggan.add(plgn);
        if (new tb_pelanggan(con).insertpelanggan(plgn)) {
            JOptionPane.showMessageDialog(this, "Data Pelanggna berhasil disimpan");
            resetForm();
            bindingTbPelanggan(null);
        } else {
            JOptionPane.showMessageDialog(this, "Data Pelanggana gagal disimpan !");
        }
        bindingTbPelanggan(null);
       
    }//GEN-LAST:event_btn_InsertActionPerformed

    private void Tbl_tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_tabelMouseClicked
         int row = Tbl_tabel.getSelectedRow();
        namaPelanggan = listPelanggan.get(row).getNama();
        if (row >= 0) {
            tf_nik.setText(listPelanggan.get(row).getNIK());
            tf_nama.setText(listPelanggan.get(row).getNama());
            tf_alamat.setText(listPelanggan.get(row).getAlamat());
            tf_noHP.setText(listPelanggan.get(row).getNo_hp());
          
            
            btn_Insert.setEnabled(false);
            btn_update.setEnabled(true);
            btn_delete.setEnabled(true);
        }
    }//GEN-LAST:event_Tbl_tabelMouseClicked

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        bindingTbPelanggan(tf_nama.getText());
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        bindingTbPelanggan(null);
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
          if (JOptionPane.showConfirmDialog(this, "Apakah Anda akan delete Pelanggan ini ?", "Delete ", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (new tb_pelanggan(con).deletePelanggan(namaPelanggan)) {
                JOptionPane.showMessageDialog(this, "Data Pelanggan berhasil didelete");
                resetForm();
                bindingTbPelanggan(null);
            } else {
                JOptionPane.showMessageDialog(this, "Data Pelanggan gagal didelete");
            }
        }   
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void butongambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butongambarActionPerformed
    JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        ImageIcon imageicon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(tampil.getWidth(),tampil.getHeight(),Image.SCALE_SMOOTH));
        tampil.setIcon(imageicon);        

    }//GEN-LAST:event_butongambarActionPerformed

    private void TF_gambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_gambarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_gambarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tf_nik.setText("");
        tf_nama.setText("");
        tf_alamat.setText("");
        tf_noHP.setText("");

        btn_Insert.setEnabled(true);
        btn_update.setEnabled(false);
        btn_delete.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
          
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pelanggan().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TF_gambar;
    private javax.swing.JTable Tbl_tabel;
    private javax.swing.JButton btn_Insert;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton butongambar;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labeljam;
    private javax.swing.JLabel labeltanggal;
    private javax.swing.JLabel tampil;
    private javax.swing.JTextField tf_alamat;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_nik;
    private javax.swing.JTextField tf_noHP;
    // End of variables declaration//GEN-END:variables
}

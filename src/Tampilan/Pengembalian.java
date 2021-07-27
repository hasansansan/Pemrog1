/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tampilan;

import controller.db_rentalmotor;
import controller.tb_pelanggan;
import controller.tb_peminjam;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

class Prosesss extends Thread {

    Pengembalian m;

    public Prosesss(Pengembalian m) {
        this.m = m;
    }

    @Override
    public void run() {
        while (true) {
            int totalTemp = new tb_peminjam(m.con).totalPeminjam();
            if (m.total != totalTemp) {
                m.total = totalTemp;
                m.bindingTbMotor(null);
                
            }
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Proses.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class Pengembalian extends javax.swing.JFrame {

    Connection con;
    List<model.peminjam> listPinjam = new ArrayList<>();
    
    int indeksPilih;
    String namaMotor;
    int total;

    public void bindingTbMotor(String cari) {
        if (cari == null) {
            cari = "";
        }
        total = new tb_peminjam(con).totalPeminjam();
        listPinjam = new tb_peminjam(con).getAllPeminjam();
        
        Object[][] o = new Object[listPinjam.size()][5];
        for (int i = 0; i < listPinjam.size(); i++) {
            o[i][0] = listPinjam.get(i).getNamaa();
            o[i][1] = listPinjam.get(i).getnNIK();
            o[i][2] = listPinjam.get(i).getTypee();
            o[i][3] = listPinjam.get(i).getpPlat_motor();
            o[i][4] = listPinjam.get(i).getBayar();
            
        }
        tabelpinjam.setModel(new javax.swing.table.DefaultTableModel(
                o,
                new String[]{
                    "Nama", "NIK", "Type_motor", "Plat_motor", "Tagihan"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

    }
    
    public Pengembalian() {
        initComponents();
        con = new db_rentalmotor().getConnection();
        bindingTbMotor(null);
        Thread t = new Thread(new Prosesss(this));
        t.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tf_cari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpinjam = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        labelnikk = new javax.swing.JLabel();
        labelpelat = new javax.swing.JLabel();
        labelbayar = new javax.swing.JLabel();
        labelnama = new javax.swing.JLabel();
        labeltype = new javax.swing.JLabel();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        jLabel1.setText("RENTAL MOTOR");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 1, 18))); // NOI18N

        jButton1.setText("Cari");

        jLabel2.setText("CARI  NIK   : ");

        tabelpinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama", "NIK", "Type motor", "Plat_Motor", "Bayar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelpinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpinjamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpinjam);

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        labelnikk.setText("jLabel3");

        labelpelat.setText("jLabel4");

        labelbayar.setText("jLabel5");

        labelnama.setText("jLabel3");

        labeltype.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelpelat, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(labelnikk)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelbayar)
                            .addComponent(jButton2)
                            .addComponent(labelnama)
                            .addComponent(labeltype))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(labelnama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelnikk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labeltype)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelpelat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelbayar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelpinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpinjamMouseClicked
      int row = tabelpinjam.getSelectedRow();
        if (row >= 0) {
            
            labelnama.setText(listPinjam.get(row).getNamaa());
            labelnikk.setText(listPinjam.get(row).getnNIK());
            labeltype.setText(listPinjam.get(row).getTypee());
            labelpelat.setText(listPinjam.get(row).getpPlat_motor());
            labelbayar.setText(String.valueOf(listPinjam.get(row).getBayar()));
        }
    }//GEN-LAST:event_tabelpinjamMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if (JOptionPane.showConfirmDialog(this, "Apakah Anda akan delete Pelanggan ini ?", "Delete ", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (new tb_peminjam(con).deletePelanggan(namaMotor)) {
                JOptionPane.showMessageDialog(this, "Data Pelanggan berhasil didelete");
               
                bindingTbMotor(null);
            } else {
                JOptionPane.showMessageDialog(this, "Data Pelanggan gagal didelete");
            }
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelbayar;
    private javax.swing.JLabel labelnama;
    private javax.swing.JLabel labelnikk;
    private javax.swing.JLabel labelpelat;
    private javax.swing.JLabel labeltype;
    private javax.swing.JTable tabelpinjam;
    private javax.swing.JTextField tf_cari;
    // End of variables declaration//GEN-END:variables
}

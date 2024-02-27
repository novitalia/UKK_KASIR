
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class FormUser extends javax.swing.JFrame {
Connection con;
DefaultTableModel tm;
PreparedStatement stm;

private void Connect(){
        con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/kasir_restoran", "root", "");
        } catch(Exception e) {
            System.out.print("ERROR KONEKSI KE DATABASE:\n" + e);
        }
}
private void refreshTable(){
     Object []baris = {"ID PEGAWAI", "NAMA PEGAWAI", "USERNAME",  "PASSWORD", "NO HANDPHONE", "LEVEL"};
        tm = new DefaultTableModel(null, baris);
        tb_user.setModel(tm);
        Connection con = new KasirKecantikan().getConnection();
        try {
            String sql = "SELECT*FROM  pegawai order by id_peg asc";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String id_peg = hasil.getString("id_peg");
                String nama = hasil.getString("nama_peg");
                String user = hasil.getString("username");
                String pass = hasil.getString("password");
                String no = hasil.getString("handphone");
                String level = hasil.getString("level");
                String[] data = {id_peg, nama, user, pass, no, level};
                tm.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL","Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
}

public void reset(){
        id_pegawai.setText("");
        nama_pegawai.setText("");
        usn.setText("");
        password.setText("");
        no_hp.setText("");
        level.setSelectedIndex(0);
    }
    /**
     * Creates new form user
     */
    public FormUser() {
        initComponents();
        Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width,screen.height);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        refreshTable();
        Connect();
        reset();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_user = new javax.swing.JTable();
        id_pegawai = new javax.swing.JTextField();
        nama_pegawai = new javax.swing.JTextField();
        usn = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        no_hp = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        txt_cari = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        Update = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        level = new javax.swing.JComboBox<>();
        Insert = new javax.swing.JButton();
        Reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Users-icon.png"))); // NOI18N
        jLabel1.setText("USER");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/iconclose.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(628, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(523, 523, 523)
                .addComponent(jLabel9)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 102));
        jLabel2.setText("Id Pegawai");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 102));
        jLabel3.setText("Username");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 102));
        jLabel4.setText("Nama Pegawai");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        tb_user.setBackground(new java.awt.Color(255, 153, 102));
        tb_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_userMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_user);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 1120, 190));

        id_pegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_pegawaiActionPerformed(evt);
            }
        });
        jPanel1.add(id_pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 300, 40));

        nama_pegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_pegawaiActionPerformed(evt);
            }
        });
        jPanel1.add(nama_pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 300, 40));
        jPanel1.add(usn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 300, 40));

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 370, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 102));
        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 102));
        jLabel6.setText("No.Handphone");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 102));
        jLabel7.setText("Jabatan");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, -1, -1));
        jPanel1.add(no_hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 370, 40));

        cari.setBackground(new java.awt.Color(255, 204, 204));
        cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/finded.png"))); // NOI18N
        cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cariMouseClicked(evt);
            }
        });
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        jPanel1.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, 50));

        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 470, 40));

        jPanel3.setBackground(new java.awt.Color(255, 153, 102));

        Update.setBackground(new java.awt.Color(255, 204, 204));
        Update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Edit.png"))); // NOI18N
        Update.setText("UPDATE");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Hapus.setBackground(new java.awt.Color(255, 204, 204));
        Hapus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Delete.png"))); // NOI18N
        Hapus.setText("DELETE");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(486, 486, 486)
                .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(541, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update)
                    .addComponent(Hapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 1380, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 102));
        jLabel8.setText("DATA USER");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, -1, -1));

        level.setBackground(new java.awt.Color(255, 153, 102));
        level.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT--", "ADMIN", "KASIR" }));
        jPanel1.add(level, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 270, 40));

        Insert.setBackground(new java.awt.Color(255, 204, 204));
        Insert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Add.png"))); // NOI18N
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });
        jPanel1.add(Insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 140, -1, -1));

        Reset.setBackground(new java.awt.Color(255, 204, 204));
        Reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Uparrow2.png"))); // NOI18N
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });
        jPanel1.add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 140, 60, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        // TODO add your handling code here:
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO pegawai VALUES (?,?,?,?,?,?)");
            ps.setString(1, id_pegawai.getText());
            ps.setString(2, nama_pegawai.getText());
            ps.setString(3, usn.getText());
            ps.setString(4, password.getText());
            ps.setString(5, no_hp.getText());
            ps.setString(6, level.getSelectedItem().toString());
            ps.executeUpdate();
            
            refreshTable();
            id_pegawai.setText("");
            nama_pegawai.setText("");
            usn.setText("");
            password.setText("");
            no_hp.setText("");
            level.setSelectedItem("");
           
        JOptionPane.showMessageDialog(this,"data telah tersimpan");
        }catch(Exception e){
             JOptionPane.showMessageDialog(this,"data gagal disimpan");
            System.out.println("masukan data dengan benar" + e + "\n\n");

        }
    }//GEN-LAST:event_InsertActionPerformed

    private void tb_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_userMouseClicked
        // TODO add your handling code here:
        id_pegawai.setText(tm.getValueAt(tb_user.getSelectedRow(),0).toString());
        nama_pegawai.setText(tm.getValueAt(tb_user.getSelectedRow(),1).toString());
        usn.setText(tm.getValueAt(tb_user.getSelectedRow(),2).toString());
        password.setText(tm.getValueAt(tb_user.getSelectedRow(),3).toString());
        no_hp.setText(tm.getValueAt(tb_user.getSelectedRow(),4).toString());
        String comboBox = (tm.getValueAt(tb_user.getSelectedRow(),5).toString());
        for (int i =0; i< level.getItemCount(); i++){
            if (level.getItemAt(i).toString().equalsIgnoreCase(comboBox)){
                level.setSelectedIndex(i);
            }
        }
         //buttonGroup1.setSelected(tm.getValueAt(tb_user.getSelectedRow(),5).toString());
    }//GEN-LAST:event_tb_userMouseClicked

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        // TODO add your handling code here:
         int ok = JOptionPane.showConfirmDialog(null,"Anda Yakin Ingin Menghapus Rasa Ini='"+nama_pegawai.getText()+"'",".:: Konfirmasi ::.", JOptionPane.YES_NO_OPTION);
            if (ok==0){
                try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM pegawai WHERE id_peg=?");
            ps.setString(1, id_pegawai.getText());
            ps.executeUpdate();
            refreshTable();
           
        } catch(Exception e) {
            System.out.print("ERROR KUERI KE DATABASE:\n" + e + "\n\n");
        }
            }
    }//GEN-LAST:event_HapusActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:       
       try {
            PreparedStatement ps = con.prepareStatement("UPDATE pegawai SET `nama_peg`=?,`username`=?,`password`=?,`handphone`=?,`level`=? WHERE id_peg=?");

            ps.setString(1, nama_pegawai.getText());
            ps.setString(2, usn.getText());
            ps.setString(3, password.getText());
            ps.setString(4, no_hp.getText());
            ps.setString(5, level.getSelectedItem().toString());
            ps.setString(6, id_pegawai.getText());
            JOptionPane.showMessageDialog(this,"data telah diupdate");
            ps.executeUpdate();
            
            refreshTable();
            id_pegawai.setText("");
            nama_pegawai.setText("");
            usn.setText("");
            password.setText("");
            no_hp.setText("");
            level.setSelectedItem("");
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"data gagal diupdate");
            System.out.println("hahahah eroro/n" + e);

        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_ResetActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        pencarian_user();
    }//GEN-LAST:event_cariActionPerformed

    private void cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariMouseClicked
        // TODO add your handling code here:
        pencarian_user();
    }//GEN-LAST:event_cariMouseClicked

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
        pencarian_user();
    }//GEN-LAST:event_txt_cariActionPerformed

    private void id_pegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_pegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_pegawaiActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void nama_pegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_pegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_pegawaiActionPerformed
  
    //PENCARIAN DATA USER
    public void pencarian_user(){
    String cari = txt_cari.getText();
        Object[] Baris={"ID PEGAWAI", "NAMA PEGAWAI", "USERNAME",  "PASSWORD", "NO HANDPHONE", "LEVEL"};
        tm = new DefaultTableModel(null, Baris);
        tb_user.setModel(tm);
        Connection con = new KasirKecantikan().getConnection();
     try {
        String sql="SELECT * FROM pegawai WHERE nama_peg like '%"+txt_cari.getText()+"%'";
            java.sql.Statement stmt=con.createStatement();
            java.sql.ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){                
                String id_peg =rs.getString("id_peg");
                String nama =rs.getString("nama_peg");
                String user =rs.getString("username");
                String pass =rs.getString("password");
                String no =rs.getString("handphone");
                String level =rs.getString("level");
                String[] dataField={id_peg, nama, user, pass, no, level};
                tm.addRow(dataField);
             }
        }
        catch(Exception ex){
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Hapus;
    private javax.swing.JButton Insert;
    private javax.swing.JButton Reset;
    private javax.swing.JButton Update;
    private javax.swing.JButton cari;
    private javax.swing.JTextField id_pegawai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> level;
    private javax.swing.JTextField nama_pegawai;
    private javax.swing.JTextField no_hp;
    private javax.swing.JTextField password;
    private javax.swing.JTable tb_user;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField usn;
    // End of variables declaration//GEN-END:variables

    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class FormUtama extends javax.swing.JFrame {
private String email;
private String level;
    /**
     * Creates new form FormUtama
     */
    public FormUtama() {
        initComponents();
         this.setLocationRelativeTo(null);
           Tanggal_sekarang();
        jamDigital();
    }
public void setUsername(String u){
        email=u;
    }
    public void setLevel(String l){
        level=l;
        FormLogin utama=new FormLogin();
    switch (level) {
        case "ADMIN":
            Admin.setEnabled(true);
            Kasir.setEnabled(false);
           
            break;
        case "KASIR":
            Admin.setEnabled(false);
            Kasir.setEnabled(true);
            break;
        default:
            break;
    }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbl_tanggal = new javax.swing.JLabel();
        lbl_jam = new javax.swing.JLabel();
        Admin = new javax.swing.JButton();
        Kasir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 153, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/iconclose.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, -1, -1));

        lbl_tanggal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_tanggal.setText("TANGGAL");
        lbl_tanggal.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, -1));

        lbl_jam.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_jam.setText("JAM");
        lbl_jam.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(lbl_jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 230, -1));

        Admin.setBackground(new java.awt.Color(255, 153, 102));
        Admin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Admin-icon.png"))); // NOI18N
        Admin.setText("ADMIN");
        Admin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminActionPerformed(evt);
            }
        });
        getContentPane().add(Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, 330, 70));

        Kasir.setBackground(new java.awt.Color(255, 153, 102));
        Kasir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/iconlogkasir.png"))); // NOI18N
        Kasir.setText("KASIR");
        Kasir.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Kasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KasirActionPerformed(evt);
            }
        });
        getContentPane().add(Kasir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 560, 320, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/menuutama.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminActionPerformed
        // TODO add your handling code here:
        FormAdmin a=new FormAdmin();
        a.show();
    }//GEN-LAST:event_AdminActionPerformed

    private void KasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KasirActionPerformed
        // TODO add your handling code here:
        FormKasir a=new FormKasir();
        a.show();
    }//GEN-LAST:event_KasirActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        int jawab;
        if ((jawab= JOptionPane.showConfirmDialog(null, "Anda yakin ingin logout", "konfirmasi", JOptionPane.YES_NO_CANCEL_OPTION)) == 0) {
            FormLogin lg = new FormLogin();
            lg.show();
            this.dispose();
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    //perintah menampilkan tanggal
    public void Tanggal_sekarang(){
        java.util.Date sekarang = new java.util.Date();
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat ("dd-MM-yyyy") ;
        lbl_tanggal.setText("TANGGAL "+kal.format(sekarang));
    }
    
    // jam digital Konstruktor
  public void jamDigital() {
    // ActionListener untuk Keperluan Timer
    ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        String nol_jam = "";
        String nol_menit = "";
        String nol_detik = "";
        // Membuat Date
        Date dt = new Date();
        // Mengambil nilaj JAM, MENIT, dan DETIK Sekarang
        int nilai_jam = dt.getHours();
        int nilai_menit = dt.getMinutes();
        int nilai_detik = dt.getSeconds();
        // Jika nilai JAM lebih kecil dari 10 (hanya 1 digit)
        if (nilai_jam <= 9) {
          // Tambahkan "0" didepannya
          nol_jam = "0";
        }
        // Jika nilai MENIT lebih kecil dari 10 (hanya 1 digit)
        if (nilai_menit <= 9) {
          // Tambahkan "0" didepannya
          nol_menit = "0";
        }
        // Jika nilai DETIK lebih kecil dari 10 (hanya 1 digit)
        if (nilai_detik <= 9) {
          // Tambahkan "0" didepannya
          nol_detik = "0";
        }
        // Membuat String JAM, MENIT, DETIK
        String jam = nol_jam + Integer.toString(nilai_jam);
        String menit = nol_menit + Integer.toString(nilai_menit);
        String detik = nol_detik + Integer.toString(nilai_detik);
        // Menampilkan pada Layar
        lbl_jam.setText("JAM "+jam + ":" + menit + ":" + detik);
      }
    };
    // Timer
    new Timer(1000, taskPerformer).start();
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
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Admin;
    private javax.swing.JButton Kasir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_jam;
    private javax.swing.JLabel lbl_tanggal;
    // End of variables declaration//GEN-END:variables
}

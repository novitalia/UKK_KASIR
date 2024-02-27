/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static kasir.FormUser.main;

/**
 *
 * @author User
 */
public class KasirKecantikan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FormLogin main=new FormLogin();
             main.setVisible(true);
    }

    static void closekoneksi(Connection cn, PreparedStatement pr, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Connection con;
    public Connection getConnection(){
        try {
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kasir_restoran","root","");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi GAGAL \n"+e);
        }
        return con;
    }
       
   
    }
   
   


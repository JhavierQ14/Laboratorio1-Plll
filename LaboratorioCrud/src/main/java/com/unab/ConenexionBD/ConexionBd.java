/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.ConenexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhavi
 */
public class ConexionBd {
    private static Connection ConnectionDB = null;

    public Connection getConnection() {

        try {
            String url = "jdbc:mysql://localhost:3306/lab";
            String user = "Jenny";
            String password = "root";
            
            ConnectionDB = DriverManager.getConnection(url,user,password);
         

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error " + ex.toString());
        
}

        return ConnectionDB; 
    }
}

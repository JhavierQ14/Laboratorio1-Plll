/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.DAO;

import com.unab.ConenexionBD.ConexionBd;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import com.unab.Entidades.Contactos;
/**
 *
 * @author Jhavi
 */
public class ClsContacto {
    
    ConexionBd conexioncls = new ConexionBd();
    Connection con = conexioncls.getConnection();
    
    public ArrayList<Contactos> mostrarC(){
    
        ArrayList<Contactos> arr= null;
        
        try {
            arr = new ArrayList<Contactos>();
            CallableStatement cd = con.prepareCall("Select * from Contactos");
            ResultSet resultado = cd.executeQuery();

            while (resultado.next()) {
                Contactos ctt = new Contactos();
                ctt.setId(resultado.getInt("Id"));
                ctt.setNombre(resultado.getString("Nombre"));
                ctt.setEdad(resultado.getInt("Edad"));
                ctt.setEmail(resultado.getString("Email"));
                 ctt.setNumeroDeTelefono(resultado.getString("NumeroDeTelefono"));
                arr.add(ctt);
            }
            
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
    return arr;
    }
    
    public void Insert(Contactos ctt){
        try {
            
              CallableStatement cs = con.prepareCall("insert into "+"contactos "
                      + "(Nombre,Edad,Email,NumeroDeTelefono)"
                      + " values('"+ctt.getNombre()+"','"+ctt.getEdad()+"','"+ctt.getEmail()+"','"+ctt.getNumeroDeTelefono()+"')");
              
              cs.execute();
              
              JOptionPane.showMessageDialog(null, "Contacto Agregado","Mensaje sistema",1);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
    
    
    
    }
}

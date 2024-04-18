/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Wstov
 */
public class Conexion {
    private static Connection conn = null;
    private static String login = "ESTUDIANTE";
    private static String pass = "74123";
    private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    
    public static Connection getConnection(){
    
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, login, pass);
            conn.setAutoCommit(false);
            if (conn != null) {
                System.out.println("Conexion Exitosa");
            }else{
                System.out.println("Conexion Erronea");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexion Erronea"+ e.getMessage());
        }
        return conn;
    }
    
    public void desconexion(){
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar");
                  
        }
    }
    
    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.getConnection();
        
    }
    
}

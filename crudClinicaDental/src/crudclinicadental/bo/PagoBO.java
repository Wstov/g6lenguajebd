/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.bo;

import crudclinicadental.dao.PagoDAO;
import crudclinicadental.db.Conexion;
import crudclinicadental.entity.PagoEntity;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Wstov
 */
public class PagoBO {
    
    private String mensaje = "";
    private PagoDAO pagoDAO = new PagoDAO();

    public String agregarPago(PagoEntity pag) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = pagoDAO.agregarPago(conn, pag);
            
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
            
        }finally{
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }

    public String modificarPago(PagoEntity pag) {
                Connection conn = Conexion.getConnection();
        try {
            mensaje = pagoDAO.modificarPago(conn, pag);
           
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
            
        }finally{
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }

    public String eliminarPago(int id) {
           Connection conn = Conexion.getConnection();
        try {
            mensaje = pagoDAO.eliminarPago(conn, id);
            
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
            
        }finally{
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }

    public void listarPago(JTable tabla) {
        Connection conn = Conexion.getConnection();
        pagoDAO.listarPago(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

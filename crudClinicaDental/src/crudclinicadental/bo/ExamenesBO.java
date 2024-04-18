/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.bo;

import crudclinicadental.dao.ExamenesDAO;
import crudclinicadental.db.Conexion;
import crudclinicadental.entity.ExamenesEntity;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Wstov
 */
public class ExamenesBO {
    
    private String mensaje = "";
    private ExamenesDAO examenesDAO = new ExamenesDAO();

    public String agregarExamen(ExamenesEntity exam) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = examenesDAO.agregarExamen(conn, exam);
            
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

    public String modificarExamen(ExamenesEntity exam) {
                Connection conn = Conexion.getConnection();
        try {
            mensaje = examenesDAO.modificarExamen(conn, exam);
           
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

    public String eliminarExamen(int id) {
           Connection conn = Conexion.getConnection();
        try {
            mensaje = examenesDAO.eliminarExamen(conn, id);
            
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

    public void listarExamen(JTable tabla) {
        Connection conn = Conexion.getConnection();
        examenesDAO.listarExamen(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

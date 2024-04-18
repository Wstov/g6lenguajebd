package crudclinicadental.bo;

import crudclinicadental.dao.ExamenesDAO;
import crudclinicadental.db.Conexion;
import crudclinicadental.entity.ExamenesEntity;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Wstov
 */
public class ExamenesBO {
    
    private String mensaje = "";
    private ExamenesDAO examDAO = new ExamenesDAO();

    public String agregarExamenes(ExamenesEntity exam) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = examDAO.agregarExamen(conn, exam);
            
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

    public String modificarExamenes(ExamenesEntity exam) {
                Connection conn = Conexion.getConnection();
        try {
            mensaje = examDAO.modificarExamen(conn, exam);
           
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

    public String eliminarExamenes(int id) {
           Connection conn = Conexion.getConnection();
        try {
            mensaje = examDAO.eliminarExamen(conn, id);
            
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
            
        }finally{
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    public void listarExamenes(JTable tabla) {
        Connection conn = Conexion.getConnection();
        examDAO.listarExamen(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getMaxID() {
        Connection conn = Conexion.getConnection();
        int id = examDAO.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
}

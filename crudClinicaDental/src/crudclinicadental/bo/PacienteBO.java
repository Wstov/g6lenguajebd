/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.bo;

import crudclinicadental.dao.PacientesDAO;
import crudclinicadental.db.Conexion;
import crudclinicadental.entity.PacienteEntiy;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Wstov
 */
public class PacienteBO {
    
    private String mensaje = "";
    private PacientesDAO pacientesDAO = new PacientesDAO();

    public String agregarPaciente(PacienteEntiy pacienteEntiy) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = pacientesDAO.agregarPaciente(conn, pacienteEntiy);
            
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

    public String modificarPaciente(PacienteEntiy pacienteEntiy) {
                Connection conn = Conexion.getConnection();
        try {
            mensaje = pacientesDAO.modificarPaciente(conn, pacienteEntiy);
           
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

    public String eliminarPaciente(int id) {
           Connection conn = Conexion.getConnection();
        try {
            mensaje = pacientesDAO.eliminarPaciente(conn, id);
            
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

    public void listarPaciente(JTable tabla) {
        Connection conn = Conexion.getConnection();
        pacientesDAO.listarPaciente(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getMaxID() {
        Connection conn = Conexion.getConnection();
        int id = pacientesDAO.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
}

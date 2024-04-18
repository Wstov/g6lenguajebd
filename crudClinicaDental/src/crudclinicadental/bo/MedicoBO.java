/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.bo;


import crudclinicadental.dao.MedicoDAO;
import crudclinicadental.db.Conexion;
import crudclinicadental.entity.MedicoEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Wstov
 */
public class MedicoBO {

    private String mensaje = "";
    private MedicoDAO medicoDAO = new MedicoDAO();

    public String agregarMedico(MedicoEntity med) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = medicoDAO.agregarMedico(conn, med);
            
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

    public String modificarMedico(MedicoEntity med) {
                Connection conn = Conexion.getConnection();
        try {
            mensaje = medicoDAO.modificarMedico(conn, med);
           
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

    public String eliminarMedico(int id) {
           Connection conn = Conexion.getConnection();
        try {
            mensaje = medicoDAO.eliminarMedico(conn, id);
            
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

    public void listarMedico(JTable tabla) {
        Connection conn = Conexion.getConnection();
        medicoDAO.listarMedico(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        public int getMaxID() {
        Connection conn = Conexion.getConnection();
        int id = medicoDAO.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
}

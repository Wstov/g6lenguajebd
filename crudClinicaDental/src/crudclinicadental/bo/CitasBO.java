/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.bo;

import crudclinicadental.dao.CitasDAO;
import crudclinicadental.db.Conexion;
import crudclinicadental.entity.CitasEntity;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Wstov
 */
public class CitasBO {
    private String mensaje = "";
    private CitasDAO citasDAO = new CitasDAO();

    public String agregarCitas(CitasEntity med) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = citasDAO.agregarCitas(conn, med);
            
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

    public String modificarCita(CitasEntity med) {
                Connection conn = Conexion.getConnection();
        try {
            mensaje = citasDAO.modificarCitas(conn, med);
           
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

    public String eliminarCita(int id) {
           Connection conn = Conexion.getConnection();
        try {
            mensaje = citasDAO.eliminarCitas(conn, id);
            
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

    public void listarCitas(JTable tabla) {
        Connection conn = Conexion.getConnection();
        citasDAO.listarCitas(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

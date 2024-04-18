/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.bo;

import crudclinicadental.dao.TratamientosDAO;
import crudclinicadental.db.Conexion;
import crudclinicadental.entity.TratamientoEntity;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Wstov
 */
public class TratamientoBO {
    
    private String mensaje = "";
    private TratamientosDAO trataDAO = new TratamientosDAO();

    public String agregarTratamiento(TratamientoEntity trat) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = trataDAO.agregarTratamiento(conn, trat);
            
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

    public String modificarTratamiento(TratamientoEntity trat) {
                Connection conn = Conexion.getConnection();
        try {
            mensaje = trataDAO.modificarTratamiento(conn, trat);
           
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

    public String eliminarTratamiento(int id) {
           Connection conn = Conexion.getConnection();
        try {
            mensaje = trataDAO.eliminarTratamiento(conn, id);
            
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

    public void listarTratamiento(JTable tabla) {
        Connection conn = Conexion.getConnection();
        trataDAO.listarTratamiento(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getMaxID() {
        Connection conn = Conexion.getConnection();
        int id = trataDAO.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
}

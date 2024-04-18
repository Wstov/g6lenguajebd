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
public class TratamientosBO {
    
    private String mensaje = "";
    private TratamientosDAO trataDAO = new TratamientosDAO();

    public String agregarTratamientos(TratamientoEntity trata) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = trataDAO.agregarTratamiento(conn, trata);
            
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

    public String modificarTratamientos(TratamientoEntity trata) {
                Connection conn = Conexion.getConnection();
        try {
            mensaje = trataDAO.modificarTratamiento(conn, trata);
           
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

    public String eliminarTratamientos(int id) {
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
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }

    public void listarTratamientos(JTable tabla) {
        Connection conn = Conexion.getConnection();
        trataDAO.listarTratamiento(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

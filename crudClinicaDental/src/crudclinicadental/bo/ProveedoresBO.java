/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.bo;

import crudclinicadental.dao.ProveedoresDAO;
import crudclinicadental.db.Conexion;
import crudclinicadental.entity.ProveedoresEntity;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Wstov
 */
public class ProveedoresBO {
    
    private String mensaje = "";
    private ProveedoresDAO ProveedorDAO = new ProveedoresDAO();

    public String agregarProveedores(ProveedoresEntity provee) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = ProveedorDAO.agregarProveedores(conn, provee);
            
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

    public String modificarProveedores(ProveedoresEntity provee) {
                Connection conn = Conexion.getConnection();
        try {
            mensaje = ProveedorDAO.modificarProveedores(conn, provee);
           
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

    public String eliminarProveedores(int id) {
           Connection conn = Conexion.getConnection();
        try {
            mensaje = ProveedorDAO.eliminarProveedores(conn, id);
            
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

    public void listarProveedores(JTable tabla) {
        Connection conn = Conexion.getConnection();
        ProveedorDAO.listarProveedores(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

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
public class ProveedorBO {
    
    private String mensaje = "";
    private ProveedoresDAO preveedorDAO = new ProveedoresDAO();

    public String agregarProveedor(ProveedoresEntity preve) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = preveedorDAO.agregarProveedores(conn, preve);
            
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

    public String modificarProveedor(ProveedoresEntity preve) {
                Connection conn = Conexion.getConnection();
        try {
            mensaje = preveedorDAO.modificarProveedores(conn, preve);
           
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

    public String eliminarProveedor(int id) {
           Connection conn = Conexion.getConnection();
        try {
            mensaje = preveedorDAO.eliminarProveedores(conn, id);
            
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

    public void listarProveedor(JTable tabla) {
        Connection conn = Conexion.getConnection();
        preveedorDAO.listarProveedores(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getMaxID() {
        Connection conn = Conexion.getConnection();
        int id = preveedorDAO.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
}

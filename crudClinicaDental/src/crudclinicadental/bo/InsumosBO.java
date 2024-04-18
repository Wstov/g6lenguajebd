/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.bo;

import crudclinicadental.dao.InsumosDAO;
import crudclinicadental.db.Conexion;
import crudclinicadental.entity.InsumoEntity;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Wstov
 */
public class InsumosBO {
    
    private String mensaje = "";
    private InsumosDAO insumoDAO = new InsumosDAO();

    public String agregarInsumo(InsumoEntity insu) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = insumoDAO.agregarInsumo(conn, insu);
            
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

    public String modificarInsumo(InsumoEntity insu) {
                Connection conn = Conexion.getConnection();
        try {
            mensaje = insumoDAO.modificarInsumo(conn, insu);
           
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

    public String eliminarInsumo(int id) {
           Connection conn = Conexion.getConnection();
        try {
            mensaje = insumoDAO.eliminarInsumo(conn, id);
            
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

    public void listarInsumo(JTable tabla) {
        Connection conn = Conexion.getConnection();
        insumoDAO.listarInsumo(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getMaxID() {
        Connection conn = Conexion.getConnection();
        int id = insumoDAO.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
}

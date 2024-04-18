/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.bo;

import crudclinicadental.dao.ComentariosDAO;
import crudclinicadental.db.Conexion;
import crudclinicadental.entity.ComentariosEntity;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Wstov
 */
public class ComentariosBO {
    
    private String mensaje = "";
    private ComentariosDAO comentariosDAO = new ComentariosDAO();

    public String agregarComentario(ComentariosEntity comen) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = comentariosDAO.agregarComentario(conn, comen);
            
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

    public String modificarComentario(ComentariosEntity comen) {
                Connection conn = Conexion.getConnection();
        try {
            mensaje = comentariosDAO.modificarComentario(conn, comen);
           
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

    public String eliminarComentario(int id) {
           Connection conn = Conexion.getConnection();
        try {
            mensaje = comentariosDAO.eliminarComentario(conn, id);
            
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

    public void listarComentario(JTable tabla) {
        Connection conn = Conexion.getConnection();
        comentariosDAO.listarComentario(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

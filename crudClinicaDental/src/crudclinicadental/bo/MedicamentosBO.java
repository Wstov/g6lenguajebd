/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.bo;

import crudclinicadental.dao.MedicamentosDAO;
import crudclinicadental.db.Conexion;
import crudclinicadental.entity.MedicamentosEntity;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Wstov
 */
public class MedicamentosBO {
    
    private String mensaje = "";
    private MedicamentosDAO medicamenicamentoDAO = new MedicamentosDAO();

    public String agregarMedicamento(MedicamentosEntity medicamen) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = medicamenicamentoDAO.agregarMedicamentos(conn, medicamen);
            
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

    public String modificarMedicamento(MedicamentosEntity medicamen) {
                Connection conn = Conexion.getConnection();
        try {
            mensaje = medicamenicamentoDAO.modificarMedicamentos(conn, medicamen);
           
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

    public String eliminarMedicamento(int id) {
           Connection conn = Conexion.getConnection();
        try {
            mensaje = medicamenicamentoDAO.eliminarMedicamentos(conn, id);
            
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

    public void listarMedicamento(JTable tabla) {
        Connection conn = Conexion.getConnection();
        medicamenicamentoDAO.listarMedicamentos(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

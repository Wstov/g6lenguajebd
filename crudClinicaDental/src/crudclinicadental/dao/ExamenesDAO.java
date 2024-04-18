/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;

import crudclinicadental.entity.ExamenesEntity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wstov
 */
public class ExamenesDAO {
        
    private String mensaje="";
    
    public String agregarExamen(Connection con, ExamenesEntity exa){
        PreparedStatement pst = null;
        String sql = "INSERT INTO REGISTRO_EXAMENES (ID_EXAMEN, TIPO_EXAMEN, RESULTADOS, FECHA, ID_PACIENTE) "
                + "VALUES(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, exa.getIdExamenes());
            pst.setString(2, exa.getTipoExamen());
            pst.setString(3, exa.getResultado());
            pst.setDate(4, Date.valueOf(exa.getFecha()));
            pst.setInt(5, exa.getIdPaciente());

            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarExamen(Connection con, ExamenesEntity exa) {
        PreparedStatement pst = null;
        String sql = "UPDATE REGISTRO_EXAMENES SET TIPO_EXAMEN = ?, RESULTADOS = ?, FECHA = ?, ID_PACIENTE = ?"
                + "WHERE ID_EXAMEN = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, exa.getTipoExamen());
            pst.setString(2, exa.getResultado());
            pst.setDate(3, Date.valueOf(exa.getFecha()));
            pst.setInt(4, exa.getIdPaciente());
            pst.setInt(5, exa.getIdExamenes());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE ACTUALIZAR CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarExamen(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM REGISTRO_EXAMENES WHERE ID_EXAMEN = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            mensaje = "ELIMINADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (SQLException  e) {
            mensaje = "NO SE ELIMINO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public void listarExamen(Connection con, JTable tabla) {
        DefaultTableModel model;
        String [] columnas = {"ID","TIPO DE EXAMEN","RESULTADOS","FECHA","ID PACIENTE"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM REGISTRO_EXAMENES ORDER BY ID_EXAMEN";
        
        String [] filas = new String[5];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 5; i++) {
                    filas[i] = rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE LISTAR LA TABLA");
        }
    }
    
    public int getMaxID(Connection con) {
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(ID_EXAMEN)+1 as id FROM REGISTRO_EXAMENES";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar id " + e.getMessage());
        }
        return id;
    }
}

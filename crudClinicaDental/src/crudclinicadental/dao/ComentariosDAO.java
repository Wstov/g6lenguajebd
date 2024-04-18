/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;

import crudclinicadental.entity.ComentariosEntity;
import crudclinicadental.entity.MedicoEntity;
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
public class ComentariosDAO {
     
    private String mensaje="";
    
    public String agregarComentario(Connection con, ComentariosEntity comen){
        PreparedStatement pst = null;
        String sql = "INSERT INTO COMENTARIOS_CITA (ID_COMENTARIO, ID_CITA, ID_PACIENTE, FECHA, COMENTARIO) "
                + "VALUES(COMENTARIOS_SEQ.NEXTVAL,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, comen.getIdCita());
            pst.setInt(2, comen.getIdPaciente());
            pst.setDate(3, Date.valueOf(comen.getFecha()));
            pst.setString(4, comen.getComentario());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarComentario(Connection con, ComentariosEntity comen) {
        PreparedStatement pst = null;
        String sql = "UPDATE COMENTARIOS_CITA SET ID_CITA = ?, ID_PACIENTE = ?, FECHA = ?, COMENTARIO = ?"
                + "WHERE ID_COMENTARIO = ?";
        try {
            pst = con.prepareStatement(sql);
             pst.setInt(1, comen.getIdCita());
            pst.setInt(2, comen.getIdPaciente());
            pst.setDate(3, Date.valueOf(comen.getFecha()));
            pst.setString(4, comen.getComentario());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE ACTUALIZAR CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarComentario(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM COMENTARIOS_CITA WHERE ID_COMENTARIO = ?";
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

    public void listarComentario(Connection con, JTable tabla) {
        DefaultTableModel model;
        String [] columnas = {"ID","ID CITA","ID PACIENTE","FECHA","COMENTARIO"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM COMENTARIOS_CITA ORDER BY ID_COMENTARIO";
        
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
        String sql = "SELECT MAX(ID_COMENTARIO)+1 as id FROM COMENTARIOS_CITA";
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

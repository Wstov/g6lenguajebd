/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;


import crudclinicadental.entity.PagoEntity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
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
public class PagoDAO {
    private String mensaje="";
    
    public String agregarPago(Connection con, PagoEntity pagoEntity){
        PreparedStatement pst = null;
        String sql = "INSERT INTO PAGO (ID_RECIBO, FECHA, HORA, ID_PACIENTE, ID_MEDICO, ID_CITA, ID_INSUMOS, PAGO) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pagoEntity.getIdPago());
            pst.setInt(2, pagoEntity.getIdMedico());
            pst.setDate(3, Date.valueOf(pagoEntity.getFecha()));
            pst.setTime(4, Time.valueOf(pagoEntity.getHora()));
            pst.setInt(5, pagoEntity.getIdPaciente());
            pst.setInt(6, pagoEntity.getIdMedico());
            pst.setInt(7, pagoEntity.getIdCita());
            pst.setInt(8, pagoEntity.getIdInsumo());
            pst.setDouble(9, pagoEntity.getPago());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarPago(Connection con, PagoEntity pagoEntity) {
        PreparedStatement pst = null;
        String sql = "UPDATE PAGO SET FECHA = ?, HORA = ?, ID_PACIENTE = ?, ID_MEDICO = ?, ID_CITA = ?, ID_INSUMOS = ?, PAGO = ?"
                + "WHERE ID_RECIBO = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setDate(1, Date.valueOf(pagoEntity.getFecha()));
            pst.setTime(2, Time.valueOf(pagoEntity.getHora()));
            pst.setInt(3, pagoEntity.getIdPaciente());
            pst.setInt(4, pagoEntity.getIdMedico());
            pst.setInt(5, pagoEntity.getIdCita());
            pst.setInt(6, pagoEntity.getIdInsumo());
            pst.setDouble(7, pagoEntity.getPago());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE ACTUALIZAR CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarPago(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM PAGO WHERE ID_RECIBO = ?";
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

    public void listarPago(Connection con, JTable tabla) {
        DefaultTableModel model;
        String [] columnas = {"ID","FECHA","HORA","ID PACIENTE","ID MEDICO","ID CITA","ID INSUMOS","PAGO"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM PAGO ORDER BY ID_RECIBO";
        
        String [] filas = new String[8];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 8; i++) {
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
        String sql = "SELECT MAX(ID_RECIBO)+1 as id FROM PAGO";
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

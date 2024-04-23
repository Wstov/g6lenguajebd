/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;

import crudclinicadental.entity.InsumoEntity;
import java.sql.Connection;
import java.sql.*;
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
public class InsumosDAO {
        
    private String mensaje="";
    
    public String agregarInsumo(Connection con, InsumoEntity insumoEntity){
        PreparedStatement pst = null;
        String sql = "{ call Insertar_Insumos(?,?,?,?,?) }";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, insumoEntity.getIdInsumo());
            pst.setString(2, insumoEntity.getNombreInsumo());
            pst.setInt(3, insumoEntity.getCosto());
            pst.setString(4, insumoEntity.getUbicacion());
//            pst.setDate(5, insumoEntity.getFechaVencimiento());

            java.util.Date fechaUtil = insumoEntity.getFechaVencimiento();
            long milliseconds = fechaUtil.getTime(); // Obtener la cantidad de milisegundos desde el epoch
            Date fechaSql = new java.sql.Date(milliseconds); // Crear un java.sql.Date con los milisegundos
            pst.setDate(5, fechaSql); // Establecer el java.sql.Date en el PreparedStatement
            
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarInsumo(Connection con,  InsumoEntity insumoEntity) {
        PreparedStatement pst = null;
        String sql = "UPDATE INSUMOS SET NOMBRE_INSU = ?, COSTO = ?, UBICACION = ?, FECHA_VENCIMIENTO = ?"
                + "WHERE ID_INSUMOS = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, insumoEntity.getNombreInsumo());
            pst.setInt(2, insumoEntity.getCosto());
            pst.setString(3, insumoEntity.getUbicacion());
//            pst.setDate(4, Date.valueOf(insumoEntity.getFechaVencimiento()));
            java.util.Date fechaUtil = insumoEntity.getFechaVencimiento();
            long milliseconds = fechaUtil.getTime(); // Obtener la cantidad de milisegundos desde el epoch
            java.sql.Date fechaSql = new java.sql.Date(milliseconds); // Crear un java.sql.Date con los milisegundos
            pst.setDate(4, fechaSql); // Establecer el java.sql.Date en el PreparedStatement
            pst.setInt(5, insumoEntity.getIdInsumo());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE ACTUALIZAR CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarInsumo(Connection con, int idInsumo) {
    CallableStatement cst = null;
    String mensaje = "";

    try {
        // Preparar la llamada al procedimiento almacenado
        String call = "{ call Eliminar_Insumo(?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, idInsumo); // Establecer el ID del insumo como parámetro

        // Ejecutar el procedimiento almacenado
        cst.execute();

        // Verificar si el procedimiento ha afectado alguna fila
        if (cst.getUpdateCount() > 0) {
            mensaje = "ELIMINADO CORRECTAMENTE";
        } else {
            mensaje = "SE ELIMINO EL INSUMO CON EL ID " + idInsumo;
        }
    } catch (SQLException e) {
        mensaje = "NO SE ELIMINÓ CORRECTAMENTE \n" + e.getMessage();
    } finally {
        try {
            if (cst != null) {
                cst.close(); // Asegurarse de cerrar el CallableStatement
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return mensaje;
}

    public void listarInsumo(Connection con, JTable tabla) {
        DefaultTableModel model;
        String [] columnas = {"ID","INSUMO","COSTO","UBICACION","FECHA"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM INSUMOS ORDER BY ID_INSUMOS";
        
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
        String sql = "SELECT MAX(ID_INSUMOS)+1 as id FROM INSUMOS";
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

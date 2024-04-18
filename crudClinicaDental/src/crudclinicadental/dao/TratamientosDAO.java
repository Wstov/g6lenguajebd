/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;

import crudclinicadental.entity.TratamientoEntity;
import java.sql.Connection;
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
public class TratamientosDAO {
        
    private String mensaje="";
    
    public String agregarTratamiento(Connection con, TratamientoEntity trata){
        PreparedStatement pst = null;
        String sql = "INSERT INTO TRATAMIENTOS (ID_TRATAMIENTO, NOMBRE, DESCRIPCION, COSTO, ID_INSUMO) "
                + "VALUES(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, trata.getIdTratamiento());
            pst.setString(2, trata.getNombre());
            pst.setString(3, trata.getDescripcion());
            pst.setDouble(4, trata.getCosto());
            pst.setInt(5, trata.getIdInsumo());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarTratamiento(Connection con,  TratamientoEntity trata) {
        PreparedStatement pst = null;
        String sql = "UPDATE TRATAMIENTOS SET NOMBRE = ?, DESCRIPCION = ?, COSTO = ?, ID_INSUMO = ?"
                + "WHERE ID_TRATAMIENTO = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, trata.getNombre());
            pst.setString(2, trata.getDescripcion());
            pst.setDouble(3, trata.getCosto());
            pst.setInt(4, trata.getIdInsumo());
            pst.setInt(5, trata.getIdTratamiento());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE ACTUALIZO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarTratamiento(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM TRATAMIENTOS WHERE ID_TRATAMIENTO = ?";
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

    public void listarTratamiento(Connection con, JTable tabla) {
        DefaultTableModel model;
        String [] columnas = {"ID","NOMBRE","DESCRIPCION","COSTO","ID_INSUMO"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM TRATAMIENTOS ORDER BY ID_TRATAMIENTO";
        
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
        String sql = "SELECT MAX(ID_TRATAMIENTO)+1 as id FROM TRATAMIENTOS";
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

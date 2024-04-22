/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;

import crudclinicadental.entity.MedicamentosEntity;
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
public class MedicamentosDAO {
       
    private String mensaje="";
    
    public String agregarMedicamentos(Connection con, MedicamentosEntity medicamentosEntity){
        PreparedStatement pst = null;
        String sql = "INSERT INTO MEDICAMENTOS (MEDICAMENTOID, NOMBRE, TIPO, DOSIS, DESCRIPCIÓN,PROVEEDORID) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, medicamentosEntity.getIdMedicamentos());
            pst.setString(2, medicamentosEntity.getNombre());
            pst.setString(3, medicamentosEntity.getTipo());
            pst.setString(4, medicamentosEntity.getDosis());
            pst.setString(5, medicamentosEntity.getDescripcion());
            pst.setInt(6, medicamentosEntity.getIdproveedor());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarMedicamentos(Connection con, MedicamentosEntity medicamentosEntity) {
        PreparedStatement pst = null;
        String sql = "UPDATE MEDICAMENTOS SET NOMBRE = ?, TIPO = ?, DOSIS = ?, DESCRIPCIÓN = ?,PROVEEDORID = ?"
                + "WHERE MEDICAMENTOID = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, medicamentosEntity.getNombre());
            pst.setString(2, medicamentosEntity.getTipo());
            pst.setString(3, medicamentosEntity.getDosis());
            pst.setString(4, medicamentosEntity.getDescripcion());
            pst.setInt(5, medicamentosEntity.getIdproveedor());
            pst.setInt(6, medicamentosEntity.getIdMedicamentos());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE ACTUALIZAR CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

 public String eliminarMedicamentos(Connection con, int idMedicamento) {
    CallableStatement cst = null;
    String mensaje = "";

    try {
        // Preparar la llamada al procedimiento almacenado
        String call = "{ call Eliminar_Medicamento(?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, idMedicamento); // Pasar el ID del medicamento como parámetro

        // Ejecutar el procedimiento almacenado
        cst.execute();
        mensaje = "ELIMINADO CORRECTAMENTE";
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


    public void listarMedicamentos(Connection con, JTable tabla) {
                DefaultTableModel model;
        String [] columnas = {"ID","NOMBRE","TIPO","DOSIS","DESCRIPCION","ID PROVEEDOR"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM MEDICAMENTOS ORDER BY MEDICAMENTOID";
        
        String [] filas = new String[6];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
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
        String sql = "SELECT MAX(MEDICAMENTOID)+1 as id FROM MEDICAMENTOS";
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

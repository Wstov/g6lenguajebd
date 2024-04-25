/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;

import crudclinicadental.entity.MedicamentosEntity;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Wstov
 */
public class MedicamentosDAO {
       
    private String mensaje="";
    
    public String agregarMedicamentos(Connection con, MedicamentosEntity medicamentosEntity) {
    CallableStatement cst = null;
    String mensaje = "";
    try {
        String call = "{ call Insertar_Medicamento(?, ?, ?, ?, ?, ?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, medicamentosEntity.getIdMedicamentos());
        cst.setString(2, medicamentosEntity.getNombre());
        cst.setString(3, medicamentosEntity.getTipo());
        cst.setString(4, medicamentosEntity.getDosis());
        cst.setString(5, medicamentosEntity.getDescripcion());
        cst.setInt(6, medicamentosEntity.getIdproveedor());

        cst.execute();
        mensaje = "Guardado correctamente";
    } catch (SQLException e) {
        mensaje = "No se guardó correctamente \n" + e.getMessage();
    } finally {
        try {
            if (cst != null) cst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return mensaje;
}


   public String modificarMedicamentos(Connection con, MedicamentosEntity medicamentosEntity) {
    CallableStatement cst = null;
    String mensaje = "";
    try {
        String call = "{ call Actualizar_Medicamento(?, ?, ?, ?, ?, ?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, medicamentosEntity.getIdMedicamentos());
        cst.setString(2, medicamentosEntity.getNombre());
        cst.setString(3, medicamentosEntity.getTipo());
        cst.setString(4, medicamentosEntity.getDosis());
        cst.setString(5, medicamentosEntity.getDescripcion());
        cst.setInt(6, medicamentosEntity.getIdproveedor());

        cst.executeUpdate(); // Note el uso de executeUpdate para operaciones DML como UPDATE
        mensaje = "Medicamento actualizado correctamente.";
    } catch (SQLException e) {
        mensaje = "Error al actualizar el medicamento: " + e.getMessage();
        e.printStackTrace();
    } finally {
        try {
            if (cst != null) cst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    String[] columnas = {"ID", "NOMBRE", "TIPO", "DOSIS", "DESCRIPCIÓN", "PROVEEDOR ID"};
    model = new DefaultTableModel(null, columnas);

    CallableStatement cst = null;
    ResultSet rs = null;
    try {
        cst = con.prepareCall("{ call Listar_Medicamentos(?) }");
        cst.registerOutParameter(1, OracleTypes.CURSOR); // Asegúrate de tener el driver JDBC adecuado que soporte OracleTypes.
        cst.execute();
        rs = (ResultSet) cst.getObject(1); // Obtener el cursor como un ResultSet

        String[] filas = new String[6];
        while (rs.next()) {
            for (int i = 0; i < 6; i++) {
                filas[i] = rs.getString(i + 1);
            }
            model.addRow(filas);
        }
        tabla.setModel(model);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se puede listar la tabla: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (cst != null) cst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

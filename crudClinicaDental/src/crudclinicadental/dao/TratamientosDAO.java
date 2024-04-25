/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;

import crudclinicadental.entity.TratamientoEntity;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
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
public class TratamientosDAO {
        
    private String mensaje="";
    
    public String agregarTratamiento(Connection con, TratamientoEntity trata) {
    CallableStatement cst = null;
    String mensaje = "";
    try {
        String call = "{ call Insertar_Tratamiento(?, ?, ?, ?, ?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, trata.getIdTratamiento());
        cst.setString(2, trata.getNombre());
        cst.setString(3, trata.getDescripcion());
        cst.setBigDecimal(4, BigDecimal.valueOf(trata.getCosto()));  // Usa BigDecimal para DECIMAL
        cst.setInt(5, trata.getIdInsumo());

        cst.executeUpdate();  // 'executeUpdate' se usa para operaciones de inserción, actualización y eliminación.
        mensaje = "Tratamiento guardado correctamente.";
    } catch (SQLException e) {
        mensaje = "No se guardó correctamente el tratamiento: " + e.getMessage();
    } finally {
        try {
            if (cst != null) cst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return mensaje;
}


    public String modificarTratamiento(Connection con, TratamientoEntity trata) {
    CallableStatement cst = null;
    String mensaje = "";
    try {
       
        String call = "{ call Actualizar_Tratamiento(?, ?, ?, ?, ?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, trata.getIdTratamiento());
        cst.setString(2, trata.getNombre());
        cst.setString(3, trata.getDescripcion());
        cst.setBigDecimal(4, BigDecimal.valueOf(trata.getCosto()));
        cst.setInt(5, trata.getIdInsumo());

        
        cst.executeUpdate();  
        mensaje = "Tratamiento actualizado correctamente.";
    } catch (SQLException e) {
        mensaje = "No se actualizó correctamente el tratamiento: \n" + e.getMessage();
    } finally {
     
        try {
            if (cst != null) cst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return mensaje;
}


    public String eliminarTratamiento(Connection con, int idTratamiento) {
    CallableStatement cst = null;
    String mensaje = "";

    try {
        // Prepare the call to the stored procedure
        String call = "{ call Eliminar_Tratamiento(?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, idTratamiento); // Set the ID of the treatment to delete

        // Execute the stored procedure
        cst.execute();
        mensaje = "ELIMINADO CORRECTAMENTE";
        
    } catch (SQLException e) {
        mensaje = "NO SE ELIMINÓ CORRECTAMENTE \n" + e.getMessage();
    } finally {
        try {
            if (cst != null) {
                cst.close(); // Ensure the CallableStatement is closed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return mensaje;
}


    public void listarTratamiento(Connection con, JTable tabla) {
    DefaultTableModel model;
    String[] columnas = {"ID", "NOMBRE", "DESCRIPCION", "COSTO", "ID_INSUMO"};
    model = new DefaultTableModel(null, columnas);

    CallableStatement cst = null;
    ResultSet rs = null;
    try {
        // Preparar la llamada al procedimiento almacenado
        cst = con.prepareCall("{ call Listar_Tratamientos(?) }");
        cst.registerOutParameter(1, OracleTypes.CURSOR); // Registrar el parámetro de salida del cursor
        cst.execute();
        rs = (ResultSet) cst.getObject(1); // Obtener el conjunto de resultados del cursor

        String[] filas = new String[columnas.length];
        while (rs.next()) {
            for (int i = 0; i < columnas.length; i++) {
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

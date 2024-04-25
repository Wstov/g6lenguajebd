/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;

import crudclinicadental.entity.InsumoEntity;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

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

  public String modificarInsumo(Connection con, InsumoEntity insumoEntity) {
    CallableStatement cst = null;
    String mensaje = "";
    try {
        String call = "{ call Actualizar_Informacion_Insumos(?, ?, ?, ?, ?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, insumoEntity.getIdInsumo());
        cst.setString(2, insumoEntity.getNombreInsumo());
        cst.setBigDecimal(3, new BigDecimal(insumoEntity.getCosto())); // Ajuste para manejar DECIMAL correctamente
        cst.setString(4, insumoEntity.getUbicacion());

        java.util.Date fechaUtil = insumoEntity.getFechaVencimiento();
        long milliseconds = fechaUtil.getTime();
        java.sql.Date fechaSql = new java.sql.Date(milliseconds);
        cst.setDate(5, fechaSql);

        cst.execute();
        mensaje = "ACTUALIZADO CORRECTAMENTE";
    } catch (SQLException e) {
        mensaje = "No se actualizó correctamente \n" + e.getMessage();
    } finally {
        try {
            if (cst != null) {
                cst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return mensaje;
}

public String eliminarInsumo(Connection con, int id) {
    CallableStatement cst = null;
    String mensaje = "";

    try {
        // Llamar al procedimiento almacenado para verificar el insumo
        String call = "{ call  Verificar_Insumo(?, ?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, id); // Establecer el ID del insumo a verificar
        cst.registerOutParameter(2, Types.INTEGER); // Parámetro de salida para el resultado

        // Ejecutar el procedimiento almacenado
        cst.execute();

        // Obtener el resultado del procedimiento almacenado
        int resultado = cst.getInt(2);
        System.out.println(resultado);
        // Verificar el resultado
        if (resultado == 1) {
            mensaje = "No se puede eliminar el insumo dado que está vinculado a otros datos.\n"
                    + "Por favor, revise los datos en Tratamientos y Pagos.";
        } else {
            // Llamar al procedimiento almacenado para eliminar al insumo
            String eliminarCall = "{ call Eliminar_Insumo(?) }";
            CallableStatement eliminarCst = con.prepareCall(eliminarCall);
            eliminarCst.setInt(1, id); // Establecer el ID del insumo a eliminar
            eliminarCst.execute();
            eliminarCst.close();
            mensaje = "ELIMINADO CORRECTAMENTE";
        }
    } catch (SQLException e) {
        mensaje = "NO SE ELIMINÓ CORRECTAMENTE \n" + e.getMessage();
    } finally {
        try {
            if (cst != null) {
                cst.close(); // Asegúrate de cerrar el CallableStatement
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return mensaje;
}


    public void listarInsumo(Connection con, JTable tabla) {
    DefaultTableModel model;
    String[] columnas = {"ID", "INSUMO", "COSTO", "UBICACION", "FECHA"};
    model = new DefaultTableModel(null, columnas);
    
    CallableStatement cst = null;
    ResultSet rs = null;
    try {
        cst = con.prepareCall("{ call Listar_Insumos(?) }");
        cst.registerOutParameter(1, OracleTypes.CURSOR); // Asegúrate de tener el driver ojdbc que soporte OracleTypes
        cst.execute();
        rs = (ResultSet) cst.getObject(1);
        
        String[] filas = new String[5];
        while (rs.next()) {
            for (int i = 0; i < 5; i++) {
                filas[i] = rs.getString(i + 1);
            }
            model.addRow(filas);
        }
        tabla.setModel(model);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "NO SE PUEDE LISTAR LA TABLA INSUMOS: " + e.getMessage());
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

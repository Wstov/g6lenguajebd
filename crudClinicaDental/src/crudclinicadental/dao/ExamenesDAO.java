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
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Wstov
 */
public class ExamenesDAO {
        
    private String mensaje="";
    
    public String agregarExamen(Connection con, ExamenesEntity exa) {
    CallableStatement cst = null;
    String mensaje = "";
    try {
        // Preparar la llamada al procedimiento almacenado
        String call = "{ call Registrar_Examen(?, ?, ?, ?, ?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, exa.getIdExamenes());
        cst.setString(2, exa.getTipoExamen());
        cst.setString(3, exa.getResultado());

        // Convertir la fecha de java.util.Date a java.sql.Date
        java.util.Date fechaUtil = exa.getFecha();
        long milliseconds = fechaUtil.getTime(); // Obtener la cantidad de milisegundos desde el epoch
        Date fechaSql = new java.sql.Date(milliseconds); // Crear un java.sql.Date con los milisegundos
        cst.setDate(4, fechaSql); // Establecer el java.sql.Date en el CallableStatement

        cst.setInt(5, exa.getIdPaciente());

        // Ejecutar el procedimiento almacenado
        cst.execute();
        mensaje = "Examen registrado correctamente";

    } catch (SQLException e) {
        mensaje = "Error al registrar el examen: \n" + e.getMessage();
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


    public String modificarExamen(Connection con, ExamenesEntity exa) {
    CallableStatement cst = null;
    String mensaje = "";
    try {
       
        String call = "{ call Actualizar_Examen(?, ?, ?, ?, ?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, exa.getIdExamenes());
        cst.setString(2, exa.getTipoExamen());
        cst.setString(3, exa.getResultado());

        
        java.util.Date fechaUtil = exa.getFecha();
        long milliseconds = fechaUtil.getTime(); 
        java.sql.Date fechaSql = new java.sql.Date(milliseconds); 
        cst.setDate(4, fechaSql);

        cst.setInt(5, exa.getIdPaciente());

        // Ejecutar el procedimiento almacenado
        cst.execute();
        mensaje = "Examen actualizado correctamente";

    } catch (SQLException e) {
        mensaje = "Error al actualizar el examen: \n" + e.getMessage();
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


    public String eliminarExamen(Connection con, int id) {
    CallableStatement cst = null;
    String mensaje = "";
    try {
        // Preparar la llamada al procedimiento almacenado
        String call = "{ call Eliminar_Examen(?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, id);  // Establecer el ID del examen a eliminar

        // Ejecutar el procedimiento almacenado
        cst.execute();
        mensaje = "Eliminado correctamente";

    } catch (SQLException e) {
        mensaje = "No se eliminó correctamente: \n" + e.getMessage();
    } finally {
        try {
            if (cst != null) {
                cst.close();  // Asegurarse de cerrar el CallableStatement
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return mensaje;
}


    public void listarExamen(Connection con, JTable tabla) {
    DefaultTableModel model;
    String[] columnas = {"ID", "TIPO DE EXAMEN", "RESULTADOS", "FECHA", "ID PACIENTE"};
    model = new DefaultTableModel(null, columnas);

    CallableStatement cst = null;
    ResultSet rs = null;
    try {
        cst = con.prepareCall("{ call Listar_Examenes(?) }");
        cst.registerOutParameter(1, OracleTypes.CURSOR); // Registro del cursor según el tipo Oracle
        cst.execute();
        rs = (ResultSet) cst.getObject(1); // Recuperar el cursor como un ResultSet
        
        String[] filas = new String[5];
        while (rs.next()) {
            for (int i = 0; i < 5; i++) {
                filas[i] = rs.getString(i + 1);
            }
            model.addRow(filas);
        }
        tabla.setModel(model);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "NO SE PUEDE LISTAR LA TABLA: " + e.getMessage());
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

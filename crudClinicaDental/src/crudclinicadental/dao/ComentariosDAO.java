/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;

import crudclinicadental.entity.ComentariosEntity;
import java.sql.Connection;
import java.sql.Date;
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
public class ComentariosDAO {
     
    private String mensaje="";
    
    public String agregarComentario(Connection con, ComentariosEntity comentario) {
    CallableStatement cst = null;
    String mensaje = "";
    try {
        // Preparar la llamada al procedimiento almacenado
        String call = "{ call Insertar_Comentario(?, ?, ?, ?, ?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, comentario.getIdComentario());
        cst.setInt(2, comentario.getIdCita());
        cst.setInt(3, comentario.getIdPaciente());
        java.sql.Date sqlDate = new java.sql.Date(comentario.getFecha().getTime()); // Convertir java.util.Date a java.sql.Date
        cst.setDate(4, sqlDate);
        cst.setString(5, comentario.getComentario());

        // Ejecutar el procedimiento almacenado
        cst.execute();
        mensaje = "COMENTARIO GUARDADO CORRECTAMENTE";
    } catch (SQLException e) {
        mensaje = "NO SE GUARDO CORRECTAMENTE \n" + e.getMessage();
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


   public String modificarComentario(Connection con, ComentariosEntity comen) {
    CallableStatement cst = null;
    String mensaje = "";
    try {
        String call = "{ call Actualizar_Comentario(?, ?, ?, ?, ?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, comen.getIdComentario());
        cst.setInt(2, comen.getIdCita());
        cst.setInt(3, comen.getIdPaciente());
        
        java.util.Date fechaUtil = comen.getFecha();
        long milliseconds = fechaUtil.getTime(); // Convertir java.util.Date a java.sql.Date
        java.sql.Date fechaSql = new java.sql.Date(milliseconds);
        cst.setDate(4, fechaSql);
        
        cst.setString(5, comen.getComentario());

        cst.execute();
        mensaje = "ACTUALIZADO CORRECTAMENTE";
    } catch (SQLException e) {
        mensaje = "NO SE ACTUALIZO CORRECTAMENTE \n" + e.getMessage();
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


    public String eliminarComentario(Connection con, int id) {
    CallableStatement cst = null;
    String mensaje = "";
    try {
        // Preparar la llamada al procedimiento almacenado
        String call = "{ call Eliminar_Comentario_Cita(?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, id);  // Establecer el ID del comentario a eliminar

        // Ejecutar el procedimiento almacenado
        cst.execute();
        mensaje = "ELIMINADO CORRECTAMENTE";

    } catch (SQLException e) {
        mensaje = "NO SE ELIMINO CORRECTAMENTE: \n" + e.getMessage();
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



    public void listarComentario(Connection con, JTable tabla) {
    DefaultTableModel model;
    String[] columnas = {"ID", "ID CITA", "ID PACIENTE", "FECHA", "COMENTARIO"};
    model = new DefaultTableModel(null, columnas);

    CallableStatement cst = null;
    ResultSet rs = null;
    try {
        cst = con.prepareCall("{ call Listar_Comentarios(?) }");
        cst.registerOutParameter(1, OracleTypes.CURSOR);  // Registro del cursor
        cst.execute();
        rs = (ResultSet) cst.getObject(1);  // Obtener el cursor como un ResultSet

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
            System.out.println("ERROR AL MOSTRAR ID ERROR " + e.getMessage());
        }
        return id;
    }
}

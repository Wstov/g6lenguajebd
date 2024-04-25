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
import java.sql.*;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Wstov
 */
public class PagoDAO {
    private String mensaje="";
    
    public String agregarPago(Connection con, PagoEntity pagoEntity){
        PreparedStatement pst = null;
        String sql = "{ call Registrar_Pago(?,?,?,?,?,?,?,?) }";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pagoEntity.getIdPago());
//            pst.setDate(2, Date.valueOf(pagoEntity.getFecha()));
//            pst.setTime(3, Time.valueOf(pagoEntity.getHora()));
            
            java.util.Date fechaUtil = pagoEntity.getFecha();
            long milliseconds = fechaUtil.getTime(); // Obtener la cantidad de milisegundos desde el epoch
            java.sql.Date fechaSql = new java.sql.Date(milliseconds); // Crear un java.sql.Date con los milisegundos
            pst.setDate(2, fechaSql); // Establecer el java.sql.Date en el PreparedStatement

            java.util.Date horaUtil = pagoEntity.getHora();
            long millisecondsHora = horaUtil.getTime(); // Obtener la cantidad de milisegundos desde el epoch
            java.sql.Date horaSql = new java.sql.Date(millisecondsHora); // Crear un java.sql.Date con los milisegundos
            pst.setDate(3, horaSql); // Establecer el java.sql.Date en el PreparedStatement

            pst.setInt(4, pagoEntity.getIdPaciente());
            pst.setInt(5, pagoEntity.getIdMedico());
            pst.setInt(6, pagoEntity.getIdCita());
            pst.setInt(7, pagoEntity.getIdInsumo());
            pst.setDouble(8, pagoEntity.getPago());
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
        String sql = "{ call Actualizar_Pago(?,?,?,?,?,?,?,?) }";
        try {
            pst = con.prepareStatement(sql);
//            pst.setDate(1, Date.valueOf(pagoEntity.getFecha()));
//            pst.setTime(2, Time.valueOf(pagoEntity.getHora()));

            pst.setInt(1, pagoEntity.getIdPago());
            java.util.Date fechaUtil = pagoEntity.getFecha();
            long milliseconds = fechaUtil.getTime(); // Obtener la cantidad de milisegundos desde el epoch
            java.sql.Date fechaSql = new java.sql.Date(milliseconds); // Crear un java.sql.Date con los milisegundos
            pst.setDate(2, fechaSql); // Establecer el java.sql.Date en el PreparedStatement

            java.util.Date horaUtil = pagoEntity.getHora();
            long millisecondsHora = horaUtil.getTime(); // Obtener la cantidad de milisegundos desde el epoch
            java.sql.Date horaSql = new java.sql.Date(millisecondsHora); // Crear un java.sql.Date con los milisegundos
            pst.setDate(3, horaSql); // Establecer el java.sql.Date en el PreparedStatement

            pst.setInt(4, pagoEntity.getIdPaciente());
            pst.setInt(5, pagoEntity.getIdMedico());
            pst.setInt(6, pagoEntity.getIdCita());
            pst.setInt(7, pagoEntity.getIdInsumo());
            pst.setDouble(8, pagoEntity.getPago());
            
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE ACTUALIZAR CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarPago(Connection con, int idRecibo) {
    CallableStatement cst = null;
    String mensaje = "";

    try {
        // Prepare the call to the stored procedure
        String call = "{ call Eliminar_Pago(?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, idRecibo); // Set the ID of the receipt to delete

        // Execute the stored procedure
        cst.execute();
        mensaje = "ELIMINADO CORRECTAMENTE";

    } catch (SQLException e) {
        mensaje = "NO SE ELIMINÓ CORRECTAMENTE. \n" + e.getMessage();
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
    public void listarPago(Connection con, JTable tabla) {
        DefaultTableModel model;
        String [] columnas = {"ID","FECHA","HORA","ID PACIENTE","ID MEDICO","ID CITA","ID INSUMOS","PAGO"};
        model = new DefaultTableModel(null, columnas);
        
                CallableStatement cst = null;
        ResultSet rs = null;
        try {
            cst = con.prepareCall("{ call Listar_Pagos(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR); 
            cst.execute();
            rs = (ResultSet) cst.getObject(1);

            String[] filas = new String[8];
            while (rs.next()) {
                for (int i = 0; i < 8; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE LISTAR LA TABLA PAGOS: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cst != null) {
                    cst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
            System.out.println("ERROR AL MOSTRAR ID " + e.getMessage());
        }
        return id;
    }
}

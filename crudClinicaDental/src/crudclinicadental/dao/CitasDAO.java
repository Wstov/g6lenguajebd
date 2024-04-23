/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;
import crudclinicadental.entity.CitasEntity;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Wstov
 */
public class CitasDAO {
        
    private String mensaje = "";

    public String agregarCita(Connection con, CitasEntity citasEntity) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO REGISTRO_CITAS (ID_CITA, HORA, FECHA, CONSULTORIO, ID_PACIENTE, ID_MEDICO) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, citasEntity.getIdCita());

            java.util.Date horaUtil = citasEntity.getHora();
            long millisecondsHora = horaUtil.getTime(); // Obtener la cantidad de milisegundos desde el epoch
            java.sql.Date horaSql = new java.sql.Date(millisecondsHora); // Crear un java.sql.Date con los milisegundos
            pst.setDate(2, horaSql); // Establecer el java.sql.Date en el PreparedStatement

            java.util.Date fechaUtil = citasEntity.getFecha();
            long milliseconds = fechaUtil.getTime(); // Obtener la cantidad de milisegundos desde el epoch
            java.sql.Date fechaSql = new java.sql.Date(milliseconds); // Crear un java.sql.Date con los milisegundos
            pst.setDate(3, fechaSql); // Establecer el java.sql.Date en el PreparedStatement

            pst.setString(4, citasEntity.getConsultorio());
            pst.setInt(5, citasEntity.getIdpaciente());
            pst.setInt(6, citasEntity.getIdMedico());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarCita(Connection con, CitasEntity citasEntity) {
        PreparedStatement pst = null;
        String sql = "UPDATE REGISTRO_CITAS SET HORA = ?, FECHA = ?, CONSULTORIO = ?, ID_PACIENTE = ?,ID_MEDICO = ?"
                + "WHERE ID_CITA = ?";
        try {
            pst = con.prepareStatement(sql);

            java.util.Date horaUtil = citasEntity.getHora();
            long millisecondsHora = horaUtil.getTime(); // Obtener la cantidad de milisegundos desde el epoch
            java.sql.Date horaSql = new java.sql.Date(millisecondsHora); // Crear un java.sql.Date con los milisegundos
            pst.setDate(1, horaSql); // Establecer el java.sql.Date en el PreparedStatement

            java.util.Date fechaUtil = citasEntity.getFecha();
            long milliseconds = fechaUtil.getTime(); // Obtener la cantidad de milisegundos desde el epoch
            java.sql.Date fechaSql = new java.sql.Date(milliseconds); // Crear un java.sql.Date con los milisegundos
            pst.setDate(2, fechaSql); // Establecer el java.sql.Date en el PreparedStatement

            pst.setString(3, citasEntity.getConsultorio());
            pst.setInt(4, citasEntity.getIdpaciente());
            pst.setInt(5, citasEntity.getIdMedico());
            pst.setInt(6, citasEntity.getIdCita());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE PUDO ACTUALIZAR CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

   public String eliminarCita(Connection con, int idCita) {
    CallableStatement cst = null;
    String mensaje = "";

    try {
        // Preparar la llamada al procedimiento almacenado
        String call = "{ call Eliminar_Cita(?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, idCita); // Establecer el ID de la cita como parámetro

        // Ejecutar el procedimiento almacenado
        cst.execute();

        // Verificar si el procedimiento ha afectado alguna fila
        if (cst.getUpdateCount() > 0) {
            mensaje = "ELIMINADA CORRECTAMENTE";
        } else {
            mensaje = "NO SE ENCONTRÓ NINGUNA CITA CON ID " + idCita;
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

    public void listarCita(Connection con, JTable tabla) {
        DefaultTableModel model;
        String [] columnas = {"ID","HORA","FECHA","CONSULTORIO","ID PACIENTE","ID MEDICO"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM REGISTRO_CITAS ORDER BY ID_CITA";
        
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
        String sql = "SELECT MAX(ID_CITA)+1 as id FROM REGISTRO_CITAS";
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

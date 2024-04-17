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
        
    private String mensaje="";
    
    public String agregarCita(Connection con, CitasEntity citasEntity){
        PreparedStatement pst = null;
        String sql = "INSERT INTO REGISTRO_CITAS (ID_CITA, HORA, FECHA, CONSULTORIO, ID_PACIENTE, ID_MEDICO) "
                + "VALUES(CITAS_SEQ.NEXTVAL,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setTimestamp(1, Timestamp.valueOf(citasEntity.getHora()));
            pst.setDate(2, Date.valueOf(citasEntity.getFecha()));
            pst.setString(3, citasEntity.getConsultorio());
            pst.setInt(4, citasEntity.getIdpaciente());
            pst.setInt(5, citasEntity.getIdMedico());
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
            pst.setTimestamp(1, Timestamp.valueOf(citasEntity.getHora()));
            pst.setDate(2, Date.valueOf(citasEntity.getFecha()));
            pst.setString(3, citasEntity.getConsultorio());
            pst.setInt(4, citasEntity.getIdpaciente());
            pst.setInt(5, citasEntity.getIdMedico());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE PUDO ACTUALIZAR CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarCita(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM REGISTRO_CITAS WHERE ID_CITA = ?";
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

    public void listarMedico(Connection con, JTable tabla) {
        DefaultTableModel model;
        String [] columnas = {"ID","NOMBRE","APELLIDO","CEDULA","TELEFONO","TURNO","ESPECIALIDAD"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM REGISTRO_CITAS ORDER BY ID_CITA";
        
        String [] filas = new String[7];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    filas[i] = rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE LISTAR LA TABLA");
        }
    }
}

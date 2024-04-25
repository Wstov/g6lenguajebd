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
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Wstov
 */
public class CitasDAO {
        
    private String mensaje = "";

    public String agregarCita(Connection con, CitasEntity citasEntity) {
        PreparedStatement pst = null;
        String sql = "{call Insertar_Registro_Citas(?,?,?,?,?,?)}";
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
        CallableStatement cst = null;
        String sql = "{call Actualizar_Registro_Citas(?, ?, ?, ?, ?, ?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, citasEntity.getIdCita());
            java.util.Date horaUtil = citasEntity.getHora();
            long millisecondsHora = horaUtil.getTime(); // Obtener la cantidad de milisegundos desde el epoch
            java.sql.Date horaSql = new java.sql.Date(millisecondsHora); // Crear un java.sql.Date con los milisegundos
            cst.setDate(2, horaSql); // Establecer el java.sql.Date en el PreparedStatement

            java.util.Date fechaUtil = citasEntity.getFecha();
            long milliseconds = fechaUtil.getTime(); // Obtener la cantidad de milisegundos desde el epoch
            java.sql.Date fechaSql = new java.sql.Date(milliseconds); // Crear un java.sql.Date con los milisegundos
            cst.setDate(3, fechaSql); // Establecer el java.sql.Date en el PreparedStatement

            cst.setString(4, citasEntity.getConsultorio());
            cst.setInt(5, citasEntity.getIdpaciente());
            cst.setInt(6, citasEntity.getIdMedico());

            mensaje = "CITA ACTUALIZADA CORRECTAMENTE";
            cst.execute();
            cst.close();
        } catch (Exception e) {
            mensaje = "NO SE PUDO ACTUALIZAR CORRECTAMENTE \n " + e.getMessage();
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

   public String eliminarCita(Connection con, int idCita) {
    CallableStatement cst = null;
    String mensaje = "";

    try {
        String call = "{ call Verificar_Cita(?, ?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, idCita);
        cst.registerOutParameter(2, Types.INTEGER);
        cst.execute();

        int resultado = cst.getInt(2);
        System.out.println("" + resultado);
            if (resultado == 1) {
                mensaje = "No se puede eliminar el cita dado que está vinculado a otros datos.\n"
                        + "Por favor, revise los datos en Comentarios Citas.";
            } else {
                // Llamar al procedimiento almacenado para eliminar al médico
                String eliminarCall = "{ call  Eliminar_Cita(?) }";
                CallableStatement eliminarCst = con.prepareCall(eliminarCall);
                eliminarCst.setInt(1, idCita); // Establecer el ID del médico a eliminar
                eliminarCst.execute();
                eliminarCst.close();
                // ... Código para eliminar al médico ...
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


    public void listarCita(Connection con, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID", "HORA", "FECHA", "CONSULTORIO", "ID PACIENTE", "ID MEDICO"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;
        try {
            cst = con.prepareCall("{ call Listar_Registro_Citas(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            rs = (ResultSet) cst.getObject(1);

            String[] filas = new String[6];
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE LISTAR LA TABLA CITAS: " + e.getMessage());
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

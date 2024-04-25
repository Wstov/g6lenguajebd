/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;


import crudclinicadental.entity.PacienteEntiy;
import java.sql.Connection;
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
public class PacientesDAO {
        private String mensaje="";
    
    public String agregarPaciente(Connection con, PacienteEntiy pacienteEntity){
        PreparedStatement pst = null;
        String sql = "{ call Insertar_Paciente(?,?,?,?,?,?,?,?) }";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pacienteEntity.getIdPaciente());
            pst.setInt(2, pacienteEntity.getCedula());
            pst.setString(3, pacienteEntity.getNombre());
            pst.setString(4, pacienteEntity.getApellidos());
            pst.setString(5, pacienteEntity.getDireccion());
            pst.setInt(6, pacienteEntity.getTelefono());
            pst.setString(7, pacienteEntity.getAlegias());
            pst.setString(8, pacienteEntity.getEnfermedad());
            mensaje = "PACIENTE GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "EL PACIENTE NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarPaciente(Connection con, PacienteEntiy pacienteEntity) {
        CallableStatement cst = null;
        String sql = "{ call Actualizar_Paciente(?,?,?,?,?,?,?,?) }";
        
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, pacienteEntity.getIdPaciente());
            cst.setInt(2, pacienteEntity.getCedula());
            cst.setString(3, pacienteEntity.getNombre());
            cst.setString(4, pacienteEntity.getApellidos());
            cst.setString(5, pacienteEntity.getDireccion());
            cst.setInt(6, pacienteEntity.getTelefono());
            cst.setString(7, pacienteEntity.getAlegias());
            cst.setString(8, pacienteEntity.getEnfermedad());
            mensaje = "PACIENTE GUARDADO CORRECTAMENTE";
            cst.execute();
        } catch (Exception e) {
            mensaje = "EL PACIENTE NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
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

    public String eliminarPaciente(Connection con, int id) {
    CallableStatement cst = null;
    String mensaje = "";

    try {
        // Llamar al procedimiento almacenado para verificar el paciente
        String call = "{ call Verificar_Paciente(?, ?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, id); // Establecer el ID del paciente a verificar
        cst.registerOutParameter(2, Types.INTEGER); // Parámetro de salida para el resultado

        cst.execute();

        int resultado = cst.getInt(2);

       
        if (resultado == 1) {
            mensaje = "No se puede eliminar el paciente dado que está vinculado a citas registradas.";
        } else {
           
            String eliminarCall = "{ call Eliminar_Paciente(?) }";
            CallableStatement eliminarCst = con.prepareCall(eliminarCall);
            eliminarCst.setInt(1, id); 
            eliminarCst.execute();
            eliminarCst.close();
            mensaje = "PACIENTE ELIMINADO CORRECTAMENTE.";
        }
    } catch (SQLException e) {
        mensaje = "No se pudo eliminar el paciente: \n" + e.getMessage();
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


    public void listarPaciente(Connection con, JTable tabla) {
        DefaultTableModel model;
        String [] columnas = {"ID","CEDULA","NOMBRE","APELLIDO","DIRECCION","TELEFONO","ALERGIAS", "EFERMEDAD"};
        model = new DefaultTableModel(null, columnas);
        
        CallableStatement cst = null;
        ResultSet rs = null;
        try {
            cst = con.prepareCall("{ call Listar_Pacientes(?) }");
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
            JOptionPane.showMessageDialog(null, "NO SE PUEDE LISTAR LA TABLA PACIENTES: " + e.getMessage());
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
        String sql = "SELECT MAX(ID_PACIENTE)+1 as id FROM PACIENTE";
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

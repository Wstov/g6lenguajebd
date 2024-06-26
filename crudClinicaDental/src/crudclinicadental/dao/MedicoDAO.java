/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;

import crudclinicadental.db.Conexion;
import crudclinicadental.entity.MedicoEntity;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Wstov
 */
public class MedicoDAO {
    
    private String mensaje="";
    
    public String agregarMedico(Connection con, MedicoEntity med){
        PreparedStatement pst = null;
        String sql = "{ call Insertar_Medico(?,?,?,?,?,?,?) }";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, med.getIdMedico());
            pst.setString(2, med.getNombre());
            pst.setString(3, med.getApellido());
            pst.setInt(4, med.getCedula());
            pst.setInt(5, med.getTelefono());
            pst.setString(6, med.getTurno());
            pst.setString(7, med.getEspecialidad());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarMedico(Connection con, MedicoEntity med) {
        CallableStatement cst = null;
        String sql = "{ call Actualizar_Medico(?,?,?,?,?,?,?) }";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, med.getIdMedico());
            cst.setString(2, med.getNombre());
            cst.setString(3, med.getApellido());
            cst.setInt(4, med.getCedula());
            cst.setInt(5, med.getTelefono());
            cst.setString(6, med.getTurno());
            cst.setString(7, med.getEspecialidad());
            
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            cst.execute();
        } catch (Exception e) {
            mensaje = "NO SE ACTUALIZÓ CORRECTAMENTE \n " + e.getMessage();
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

    public void listarMedico(Connection con, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "APELLIDO", "CEDULA", "TELEFONO", "TURNO", "ESPECIALIDAD"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;
        try {
            cst = con.prepareCall("{ call Listar_Medicos(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR); 
            cst.execute();
            rs = (ResultSet) cst.getObject(1);

            String[] filas = new String[7];
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE LISTAR LA TABLA MEDICOS: " + e.getMessage());
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
        String sql = "SELECT MAX(ID_MEDICO)+1 as id FROM MEDICOS";
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
    
    
    public String eliminarMedico(Connection con, int id) {
        CallableStatement cst = null;
        String mensaje = "";

        try {
            String call = "{ call Verificar_Medico(?, ?) }";
            cst = con.prepareCall(call);
            cst.setInt(1, id); // Establecer el ID del médico a verificar
            cst.registerOutParameter(2, Types.INTEGER); // Parámetro de salida para el resultado

            // Ejecutar el procedimiento almacenado
            cst.execute();

            // Obtener el resultado del procedimiento almacenado
            int resultado = cst.getInt(2);

            // Verificar el resultado
            System.out.println("" + resultado);
            if (resultado == 1) {
                mensaje = "NO SE PUEDE ELIMINAR EL MEDICO DADO QUE ESTA VINCULADO A OTRO DATOS.\n"
                        + "POR FAVOR, REVISE LOS DATOS EN REGISTRO CITAS Y PAGOS.";
            } else {
                // Llamar al procedimiento almacenado para eliminar al médico
                String eliminarCall = "{ call Eliminar_Medico(?) }";
                CallableStatement eliminarCst = con.prepareCall(eliminarCall);
                eliminarCst.setInt(1, id); // Establecer el ID del médico a eliminar
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
}

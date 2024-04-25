/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;


import crudclinicadental.entity.ProveedoresEntity;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Wstov
 */
public class ProveedoresDAO {

    private String mensaje = "";

    
    public String agregarProveedores(Connection con, ProveedoresEntity proveeEntity) {
    CallableStatement cst = null;
    String mensaje = "";
    try {
        // Preparar la llamada al procedimiento almacenado
        String call = "{ call Insertar_Proveedor(?, ?, ?, ?, ?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, proveeEntity.getIdProveedor());
        cst.setString(2, proveeEntity.getNombre());
        cst.setString(3, proveeEntity.getTelefono());
        cst.setString(4, proveeEntity.getDireccion());
        cst.setString(5, proveeEntity.getEmail());

        // Ejecutar el procedimiento almacenado
        cst.execute();
        mensaje = "El proveedor fue guardado correctamente.";
    } catch (SQLException e) {
        mensaje = "El proveedor no se guardó correctamente: " + e.getMessage();
        e.printStackTrace();
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



    public String modificarProveedores(Connection con, ProveedoresEntity proveeEntity) {
    CallableStatement cst = null;
    String mensaje = "";
    try {
        // Preparar la llamada al procedimiento almacenado
        String call = "{ call Actualizar_Proveedor(?, ?, ?, ?, ?) }";
        cst = con.prepareCall(call);
        // Establecer los parámetros del procedimiento almacenado
        cst.setInt(1, proveeEntity.getIdProveedor());
        cst.setString(2, proveeEntity.getNombre());
        cst.setString(3, proveeEntity.getTelefono());
        cst.setString(4, proveeEntity.getDireccion());
        cst.setString(5, proveeEntity.getEmail());

        // Ejecutar el procedimiento almacenado
        cst.execute();
        mensaje = "El proveedor fue actualizado correctamente.";
    } catch (SQLException e) {
        mensaje = "El proveedor no se actualizó correctamente: \n" + e.getMessage();
        e.printStackTrace();
    } finally {
        // Cerrar el CallableStatement
        try {
            if (cst != null) cst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return mensaje;
}

    

   public String eliminarProveedores(Connection con, int idProveedor) {
    CallableStatement cst = null;
    String mensaje = "";

    try {
        // Llamar al procedimiento almacenado para verificar el proveedor
        String call = "{ call Verificar_Proveedor(?, ?) }";
        cst = con.prepareCall(call);
        cst.setInt(1, idProveedor); // Establecer el ID del proveedor a verificar
        cst.registerOutParameter(2, Types.INTEGER); // Parámetro de salida para el resultado

        // Ejecutar el procedimiento almacenado
        cst.execute();

        // Obtener el resultado del procedimiento almacenado
        int resultado = cst.getInt(2);

        // Imprimir el resultado para depuración
        System.out.println("" + resultado);
        if (resultado == 1) {
            mensaje = "No se puede eliminar el proveedor dado que está vinculado a otros datos.\n"
                    + "Por favor, revise los datos en medicamentos u otras tablas relacionadas.";
        } else {
            // Llamar al procedimiento almacenado para eliminar el proveedor
            String eliminarCall = "{ call Eliminar_Proveedor(?) }";
            CallableStatement eliminarCst = con.prepareCall(eliminarCall);
            eliminarCst.setInt(1, idProveedor); // Establecer el ID del proveedor a eliminar
            eliminarCst.execute();
            eliminarCst.close();
            mensaje = "ELIMINADO CORRECTAMENTE";
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

   public void listarProveedores(Connection con, JTable tabla) {
    DefaultTableModel model;
    String[] columnas = {"ID", "NOMBRE", "TELÉFONO", "DIRECCIÓN", "EMAIL"};
    model = new DefaultTableModel(null, columnas);

    CallableStatement cst = null;
    ResultSet rs = null;
    try {
        cst = con.prepareCall("{ call Listar_Proveedores(?) }");
        cst.registerOutParameter(1, OracleTypes.CURSOR); // Registrar el parámetro de salida del cursor
        cst.execute();
        rs = (ResultSet) cst.getObject(1); // Obtener el conjunto de resultados del cursor

        String[] filas = new String[5];
        while (rs.next()) {
            for (int i = 0; i < 5; i++) {
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
        String sql = "SELECT MAX(PROVEEDORID)+1 as id FROM PROVEEDORES";
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

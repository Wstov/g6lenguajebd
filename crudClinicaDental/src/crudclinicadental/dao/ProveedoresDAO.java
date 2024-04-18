/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;


import crudclinicadental.entity.ProveedoresEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wstov
 */
public class ProveedoresDAO {

    private String mensaje = "";

    public String agregarProveedores(Connection con, ProveedoresEntity proveeEntity) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO PROVEEDORES (PROVEEDORESID, NOMBRE, TELÉFONO, DIRECCIÓN, EMAIL) "
                + "VALUES(PROVEE_SEQ.NEXTVAL,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, proveeEntity.getNombre());
            pst.setString(2, proveeEntity.getTelefono());
            pst.setString(3, proveeEntity.getDireccion());
            pst.setString(4, proveeEntity.getEmail());

            mensaje = "EL PROVEEDOR GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "EL PROVEEDOR NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarProveedores(Connection con, ProveedoresEntity proveeEntity) {
        PreparedStatement pst = null;
        String sql = "UPDATE PROVEEDORES SET NOMBRE = ?, TELÉFONO = ?, DIRECCIÓN = ?, EMAIL = ?"
                + "WHERE PROVEEDORESID = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, proveeEntity.getNombre());
            pst.setString(2, proveeEntity.getTelefono());
            pst.setString(3, proveeEntity.getDireccion());
            pst.setString(4, proveeEntity.getEmail());

            mensaje = "El PROVEEDOR SE GUARDO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "EL PROVEEDORES NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarProveedores(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM PROVEEDORES WHERE PROVEEDORESID = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            mensaje = "EL PROVEEDORES SE HA ELIMINADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "EL PROVEEDORES NO SE ELIMINO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public void listarProveedores(Connection con, JTable tabla) {
                DefaultTableModel model;
        String [] columnas = {"ID","NOMBRE","TELEFONO","DIRECCION","EMAIL"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM PROVEEDORES ORDER BY PROVEEDORESID";
        
        String [] filas = new String[5];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 5; i++) {
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

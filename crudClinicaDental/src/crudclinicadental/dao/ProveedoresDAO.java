/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;


import crudclinicadental.entity.ProveedoresEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JTable;

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

    public void listarProveedores(Connection Con, JTable tabla) {
    }
}

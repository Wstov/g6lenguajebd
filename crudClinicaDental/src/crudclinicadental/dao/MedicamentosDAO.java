/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;

import crudclinicadental.entity.MedicamentosEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JTable;

/**
 *
 * @author Wstov
 */
public class MedicamentosDAO {
       
    private String mensaje="";
    
    public String agregarMedicamentos(Connection con, MedicamentosEntity medicamentosEntity){
        PreparedStatement pst = null;
        String sql = "INSERT INTO MEDICAMENTOS (MEDICAMENTOID, NOMBRE, TIPO, DOSIS, DESCRIPCIÓN,PROVEEDORID) "
                + "VALUES(MEDICAMENTOS_SEQ.NEXTVAL,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, medicamentosEntity.getNombre());
            pst.setString(2, medicamentosEntity.getTipo());
            pst.setString(3, medicamentosEntity.getDosis());
            pst.setString(4, medicamentosEntity.getDescripcion());
            pst.setInt(5, medicamentosEntity.getIdproveedor());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE GUARDO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarMedicamentos(Connection con, MedicamentosEntity medicamentosEntity) {
        PreparedStatement pst = null;
        String sql = "UPDATE MEDICAMENTOS SET NOMBRE = ?, TIPO = ?, DOSIS = ?, DESCRIPCIÓN = ?,PROVEEDORID = ?"
                + "WHERE MEDICAMENTOID = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, medicamentosEntity.getNombre());
            pst.setString(2, medicamentosEntity.getTipo());
            pst.setString(3, medicamentosEntity.getDosis());
            pst.setString(4, medicamentosEntity.getDescripcion());
            pst.setInt(5, medicamentosEntity.getIdproveedor());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE ACTUALIZAR CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarMedicamentos(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM MEDICAMENTOS WHERE MEDICAMENTOID = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            mensaje = "ELIMINADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "NO SE ELIMINO CORRECTAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public void listarMedicamentos(Connection Con, JTable tabla) {
    }
}

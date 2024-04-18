/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.dao;

import crudclinicadental.entity.MedicamentosEntity;
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

    public void listarMedicamentos(Connection con, JTable tabla) {
                DefaultTableModel model;
        String [] columnas = {"ID","NOMBRE","TIPO","DOSIS","DESCRIPCION","ID PROVEEDOR"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM MEDICAMENTOS ORDER BY MEDICAMENTOID";
        
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
}

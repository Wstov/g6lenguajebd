/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.bo;


import crudclinicadental.dao.MedicoDAO;
import crudclinicadental.entity.MedicoEntity;
import java.sql.Connection;

/**
 *
 * @author Wstov
 */
public class MedicoBO {

    private String mensaje = "";
    private MedicoDAO mdao = new MedicoDAO();

    public String agregarMedico(MedicoEntity med) {
        Connection conn = Conexion.getConnection()
        try {
            
        } catch (Exception e) {
        }
        return mensaje;
    }

    public String modificarMedico(MedicoEntity med) {
        return mensaje;
    }

    public String eliminarMedico(int id) {
        return mensaje;
    }

    public void listarMedico() {
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.test;

import crudclinicadental.bo.PacienteBO;
import crudclinicadental.entity.PacienteEntiy;

/**
 *
 * @author Wstov
 */
public class PacienteTest {
    PacienteBO pacienteBO = new PacienteBO();
    PacienteEntiy pacienteEntity = new PacienteEntiy();
    String mensaje = "";
    
    public void insertar(){
        pacienteEntity.setCedula(694817243);
        pacienteEntity.setNombre("Marcos");
        pacienteEntity.setApellidos("Rojas");
        pacienteEntity.setDireccion("200 sur del mall");
        pacienteEntity.setTelefono(23456789);
        pacienteEntity.setAlegias("Palen");
        pacienteEntity.setEnfermedad("Asma");
        mensaje = pacienteBO.agregarPaciente(pacienteEntity);
        System.out.println(mensaje);
    }
    
    
    public static void main(String[] args) {
        PacienteTest pacienteTest = new PacienteTest();
        pacienteTest.insertar();
        
    }
}

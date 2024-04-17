/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudclinicadental.test;

import crudclinicadental.bo.MedicoBO;
import crudclinicadental.entity.MedicoEntity;

/**
 *
 * @author Wstov
 */
public class MedicoTest {
    MedicoBO medicoBO = new MedicoBO();
    MedicoEntity medicoEntity = new MedicoEntity();
    String mensaje = "";

    public void insertar() {
        medicoEntity.setNombre("Marcos");
        medicoEntity.setApellido("Rojas");
        medicoEntity.setCedula(123456734);
        medicoEntity.setTelefono(78787878);
        medicoEntity.setTurno("Noche");
        medicoEntity.setEspecialidad("Ortodoncista");
        mensaje = medicoBO.agregarMedico(medicoEntity);
        System.out.println(mensaje);
    }

    public void modificar() {
        medicoEntity.setIdMedico(26);
        medicoEntity.setNombre("Maria");
        medicoEntity.setApellido("Rojas");
        medicoEntity.setCedula(123456734);
        medicoEntity.setTelefono(78787878);
        medicoEntity.setTurno("Noche");
        medicoEntity.setEspecialidad("Ortodoncista");
        mensaje = medicoBO.modificarMedico(medicoEntity);
        System.out.println(mensaje);
    }

    public void eliminar(){
        mensaje = medicoBO.eliminarMedico(26);
        System.out.println(mensaje);
    }
    
    
    public static void main(String[] args) {
        MedicoTest medicoTest = new MedicoTest();
        medicoTest.insertar();
//        medicoTest.modificar();
//        medicoTest.eliminar();

    }
}

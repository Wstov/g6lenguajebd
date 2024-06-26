/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package crudclinicadental.view;

import crudclinicadental.bo.CitasBO;
import crudclinicadental.bo.ComentariosBO;
import crudclinicadental.bo.ExamenesBO;
import crudclinicadental.bo.InsumosBO;
import crudclinicadental.bo.MedicamentosBO;
import crudclinicadental.bo.MedicoBO;
import crudclinicadental.bo.PacienteBO;
import crudclinicadental.bo.PagoBO;
import crudclinicadental.bo.ProveedorBO;
import crudclinicadental.bo.TratamientoBO;
import crudclinicadental.entity.CitasEntity;
import crudclinicadental.entity.ComentariosEntity;
import crudclinicadental.entity.ExamenesEntity;
import crudclinicadental.entity.InsumoEntity;
import crudclinicadental.entity.MedicamentosEntity;
import crudclinicadental.entity.MedicoEntity;
import crudclinicadental.entity.PacienteEntiy;
import crudclinicadental.entity.PagoEntity;
import crudclinicadental.entity.ProveedoresEntity;
import crudclinicadental.entity.TratamientoEntity;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Wstov
 */
public class Administracion extends javax.swing.JFrame {

    private MedicoBO medicoBO = new MedicoBO();
    private PacienteBO pacienteBO = new PacienteBO();
    private CitasBO citasBO = new CitasBO();
    private ComentariosBO comentariosBO = new ComentariosBO();
    private ExamenesBO examenesBO = new ExamenesBO();
    private InsumosBO insumosBO = new InsumosBO();
    private MedicamentosBO medicamentosBO = new MedicamentosBO();
    private PagoBO pagoBO = new PagoBO();
    private ProveedorBO proveedorBO = new ProveedorBO();
    private TratamientoBO tratamientoBO = new TratamientoBO();
    SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Creates new form Administracion
     */
    public Administracion() {
        initComponents();
        listarMedico();
        listarPacientes();
        listarCitas();
        listarComentarios();
        listarExamenes();
        listarInsumos();
        listarMedicamentos();
        listarProveedores();
        listarTratamientos();
        listarPagos();

        idMaxMedico();
        idMaxCitas();
        idMaxComentarios();
        idMaxExamenes();
        idMaxInsumos();
        idMaxPagos();
        idMaxMedicamentos();
        idMaxProveedores();
        idMaxPacientes();
        idMaxTratamientos();

        setTitle("CLINICA DENTAL");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void listarMedico() {
        medicoBO.listarMedico(jTblMedicos);
    }

    public void listarPacientes() {
        pacienteBO.listarPaciente(jTblPaciente);
    }

    public void listarCitas() {
        citasBO.listarCitas(jTblCitas);
    }

    public void listarComentarios() {
        comentariosBO.listarComentario(jTblComen);
    }

    public void listarExamenes() {
        examenesBO.listarExamenes(jTblExamenes);
    }

    public void listarInsumos() {
        insumosBO.listarInsumo(jTblInsumos);
    }

    public void listarMedicamentos() {
        medicamentosBO.listarMedicamento(jTblMedicamentos);
    }

    public void listarPagos() {
        pagoBO.listarPago(jTblPago);
    }

    public void listarProveedores() {
        proveedorBO.listarProveedor(jTblProvee);
    }

    public void listarTratamientos() {
        tratamientoBO.listarTratamiento(jTblTratamientos);
    }

//-------------id Max---------------------------
    public void idMaxMedico() {
        jTextFieldIDMedico.setText(medicoBO.getMaxID() + "");
    }

    public void idMaxPacientes() {
        jTextFieldIDPaciente.setText(pacienteBO.getMaxID() + "");
    }

    public void idMaxCitas() {
        jTextFieldIDCitas.setText(citasBO.getMaxID() + "");
    }

    public void idMaxComentarios() {
        jTextFieldIDComentarios.setText(comentariosBO.getMaxID() + "");
    }

    public void idMaxExamenes() {
        jTextFieldIDExamenes.setText(examenesBO.getMaxID() + "");
    }

    public void idMaxMedicamentos() {
        jTextFieldIDMedicamentos.setText(medicamentosBO.getMaxID() + "");
    }

    public void idMaxPagos() {
        jTextFieldIDPago.setText(pagoBO.getMaxID() + "");
    }

    public void idMaxInsumos() {
        jTextFieldIDInsumos.setText(insumosBO.getMaxID() + "");
    }

    public void idMaxTratamientos() {
        jTextFieldIDTratamiento.setText(tratamientoBO.getMaxID() + "");
    }

    public void idMaxProveedores() {
        jTextFieldIDProveedor.setText(proveedorBO.getMaxID() + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Medicos = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblMedicos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldCedula = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldTurno = new javax.swing.JTextField();
        jTextFieldEspecialidad = new javax.swing.JTextField();
        jBtnGuardarMedico = new javax.swing.JButton();
        jBtnModificarMedico = new javax.swing.JButton();
        jBtnEliminarMedico = new javax.swing.JButton();
        jBtnLimpiarMedico = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldIDMedico = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTblPaciente = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCedulaPaciente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldNombrePaciente = new javax.swing.JTextField();
        jTextFieldApellidoPaciente = new javax.swing.JTextField();
        jTextFieldDireccionPaciente = new javax.swing.JTextField();
        jTextFieldTelefonoPaciente = new javax.swing.JTextField();
        jTextFieldAlergiasPaciente = new javax.swing.JTextField();
        jBtnGuardarMedico1 = new javax.swing.JButton();
        jBtnModificarMedico1 = new javax.swing.JButton();
        jBtnEliminarMedico1 = new javax.swing.JButton();
        jBtnLimpiarMedico1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldIDPaciente = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jTextFieldEfermedadPaciente = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTblMedicamentos = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldMedicamentos = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldMedicamentosTipo = new javax.swing.JTextField();
        jTextFieldDosisMedicamentos = new javax.swing.JTextField();
        jTextFieldDescriMedicamentos = new javax.swing.JTextField();
        jTextFieldProveedorIDMed = new javax.swing.JTextField();
        jBtnGuardarMedicamentos = new javax.swing.JButton();
        jBtnModificarMedicamentos = new javax.swing.JButton();
        jBtnEliminarMedicamentos = new javax.swing.JButton();
        jBtnLimpiarMedicamentos = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jTextFieldIDMedicamentos = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTblPago = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextFieldIDPacientePago = new javax.swing.JTextField();
        jTextFieldIDMedicoPago = new javax.swing.JTextField();
        jTextFieldIDCitaPago = new javax.swing.JTextField();
        jTextFieldIDInsumoPago = new javax.swing.JTextField();
        jBtnGuardarPago = new javax.swing.JButton();
        jBtnModificarPago = new javax.swing.JButton();
        jBtnEliminarPago = new javax.swing.JButton();
        jBtnLimpiarPago = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jTextFieldIDPago = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jTextFieldPago = new javax.swing.JTextField();
        jDateChooserFechaPagos = new com.toedter.calendar.JDateChooser();
        jDateChooserHoraPagos = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTblCitas = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jTextFieldConsultorioCita = new javax.swing.JTextField();
        jTextFieldIDPacienteCita = new javax.swing.JTextField();
        jTextFieldIDMedicoCita = new javax.swing.JTextField();
        jBtnGuardarCitas = new javax.swing.JButton();
        jBtnModificarCitas = new javax.swing.JButton();
        jBtnEliminarCitas = new javax.swing.JButton();
        jBtnLimpiarCitas = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jTextFieldIDCitas = new javax.swing.JTextField();
        jDateChooserFechaCitas = new com.toedter.calendar.JDateChooser();
        jDateChooserHoraCitas = new com.toedter.calendar.JDateChooser();
        jLabel40 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTblExamenes = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jTextFieldExamen = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextFieldResultadoExamen = new javax.swing.JTextField();
        jTextFieldPacienteExamen = new javax.swing.JTextField();
        jBtnGuardarExamenes = new javax.swing.JButton();
        jBtnModificarExamenes = new javax.swing.JButton();
        jBtnEliminarExamenes = new javax.swing.JButton();
        jBtnLimpiarExamenes = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jTextFieldIDExamenes = new javax.swing.JTextField();
        jDateChooserExam = new com.toedter.calendar.JDateChooser();
        jLabel48 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTblTratamientos = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jTextFieldNombreTrata = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jTextFieldDescripcionTrata = new javax.swing.JTextField();
        jTextFieldCostoTrata = new javax.swing.JTextField();
        jTextFieldIDInsumoTrata = new javax.swing.JTextField();
        jBtnGuardarTrata = new javax.swing.JButton();
        jBtnModificarTrata = new javax.swing.JButton();
        jBtnEliminarTrata = new javax.swing.JButton();
        jBtnLimpiarTrata = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jTextFieldIDTratamiento = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTblInsumos = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jTextFieldNombreInsumos = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jTextFieldCostoInsumos = new javax.swing.JTextField();
        jTextFieldUbiInsumos = new javax.swing.JTextField();
        jBtnGuardarInsumos = new javax.swing.JButton();
        jBtnModificarInsumos = new javax.swing.JButton();
        jBtnEliminarInsumos = new javax.swing.JButton();
        jBtnLimpiarInsumos = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        jTextFieldIDInsumos = new javax.swing.JTextField();
        jDateChooserInsumo = new com.toedter.calendar.JDateChooser();
        jLabel64 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTblComen = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jTextFieldCitaComen = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jTextFieldPaciComen = new javax.swing.JTextField();
        jTextFieldComen = new javax.swing.JTextField();
        jBtnGuardarComen = new javax.swing.JButton();
        jBtnModificarComen = new javax.swing.JButton();
        jBtnEliminarComen = new javax.swing.JButton();
        jBtnLimpiarComen = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jTextFieldIDComentarios = new javax.swing.JTextField();
        jDateChooserComenta = new com.toedter.calendar.JDateChooser();
        jLabel72 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTblProvee = new javax.swing.JTable();
        jPanel29 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jTextFieldNombreProvee = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jTextFieldTelefonoProvee = new javax.swing.JTextField();
        jTextFieldDireccionProvee = new javax.swing.JTextField();
        jTextFieldEmailProvee = new javax.swing.JTextField();
        jBtnGuardarPrevee = new javax.swing.JButton();
        jBtnModificarProvee = new javax.swing.JButton();
        jBtnEliminarProvee = new javax.swing.JButton();
        jBtnLimpiarProvee = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        jTextFieldIDProveedor = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTblMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTblMedicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblMedicosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTblMedicos);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jTextFieldNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Cédula:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Teléfono:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Turno:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Especialidad:");

        jTextFieldApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldCedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldTurno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldEspecialidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jBtnGuardarMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnGuardarMedico.setText("Agregar");
        jBtnGuardarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarMedicoActionPerformed(evt);
            }
        });

        jBtnModificarMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnModificarMedico.setText("Modificar");
        jBtnModificarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarMedicoActionPerformed(evt);
            }
        });

        jBtnEliminarMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnEliminarMedico.setText("Eliminar");
        jBtnEliminarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarMedicoActionPerformed(evt);
            }
        });

        jBtnLimpiarMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnLimpiarMedico.setText("Limpiar");
        jBtnLimpiarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarMedicoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("ID:");

        jTextFieldIDMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldIDMedico.setEnabled(false);
        jTextFieldIDMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDMedicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtnGuardarMedico)
                        .addGap(39, 39, 39)
                        .addComponent(jBtnModificarMedico)
                        .addGap(37, 37, 37)
                        .addComponent(jBtnEliminarMedico)
                        .addGap(41, 41, 41)
                        .addComponent(jBtnLimpiarMedico))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIDMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldApellido)
                                .addComponent(jTextFieldTelefono)
                                .addComponent(jTextFieldTurno, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                .addComponent(jTextFieldCedula)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldIDMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardarMedico)
                    .addComponent(jBtnModificarMedico)
                    .addComponent(jBtnEliminarMedico)
                    .addComponent(jBtnLimpiarMedico))
                .addGap(10, 10, 10))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Medicos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        Medicos.addTab("Medicos", jPanel2);

        jTblPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTblPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblPacienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTblPaciente);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Cédula:");

        jTextFieldCedulaPaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldCedulaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCedulaPacienteActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Nombre:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Apellido:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Dirección:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Teléfono:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Alergias:");

        jTextFieldNombrePaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldApellidoPaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldDireccionPaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldTelefonoPaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldAlergiasPaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jBtnGuardarMedico1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnGuardarMedico1.setText("Agregar");
        jBtnGuardarMedico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarMedico1ActionPerformed(evt);
            }
        });

        jBtnModificarMedico1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnModificarMedico1.setText("Modificar");
        jBtnModificarMedico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarMedico1ActionPerformed(evt);
            }
        });

        jBtnEliminarMedico1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnEliminarMedico1.setText("Eliminar");
        jBtnEliminarMedico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarMedico1ActionPerformed(evt);
            }
        });

        jBtnLimpiarMedico1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnLimpiarMedico1.setText("Limpiar");
        jBtnLimpiarMedico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarMedico1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("ID:");

        jTextFieldIDPaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldIDPaciente.setEnabled(false);
        jTextFieldIDPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDPacienteActionPerformed(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel77.setText("Efermedad:");

        jTextFieldEfermedadPaciente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jBtnGuardarMedico1)
                        .addGap(39, 39, 39)
                        .addComponent(jBtnModificarMedico1)
                        .addGap(37, 37, 37)
                        .addComponent(jBtnEliminarMedico1)
                        .addGap(41, 41, 41)
                        .addComponent(jBtnLimpiarMedico1))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel77)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldEfermedadPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldAlergiasPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)
                                .addComponent(jLabel10)
                                .addComponent(jLabel9)
                                .addComponent(jLabel15))
                            .addGap(31, 31, 31)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldIDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNombrePaciente)
                                    .addComponent(jTextFieldDireccionPaciente)
                                    .addComponent(jTextFieldTelefonoPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                    .addComponent(jTextFieldApellidoPaciente))))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldIDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldApellidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldDireccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldAlergiasPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEfermedadPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardarMedico1)
                    .addComponent(jBtnModificarMedico1)
                    .addComponent(jBtnEliminarMedico1)
                    .addComponent(jBtnLimpiarMedico1))
                .addGap(10, 10, 10))
        );

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setText("Pacientes");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1383, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Medicos.addTab("Pacientes", jPanel3);

        jTblMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTblMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblMedicamentosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTblMedicamentos);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Medicamento:");

        jTextFieldMedicamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMedicamentosActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Tipo:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Dosis:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Descripción:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Proveedor ID:");

        jTextFieldMedicamentosTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldDosisMedicamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldDescriMedicamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldProveedorIDMed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jBtnGuardarMedicamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnGuardarMedicamentos.setText("Agregar");
        jBtnGuardarMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarMedicamentosActionPerformed(evt);
            }
        });

        jBtnModificarMedicamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnModificarMedicamentos.setText("Modificar");
        jBtnModificarMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarMedicamentosActionPerformed(evt);
            }
        });

        jBtnEliminarMedicamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnEliminarMedicamentos.setText("Eliminar");
        jBtnEliminarMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarMedicamentosActionPerformed(evt);
            }
        });

        jBtnLimpiarMedicamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnLimpiarMedicamentos.setText("Limpiar");
        jBtnLimpiarMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarMedicamentosActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("ID:");

        jTextFieldIDMedicamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldIDMedicamentos.setEnabled(false);
        jTextFieldIDMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDMedicamentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jBtnGuardarMedicamentos)
                        .addGap(39, 39, 39)
                        .addComponent(jBtnModificarMedicamentos)
                        .addGap(37, 37, 37)
                        .addComponent(jBtnEliminarMedicamentos)
                        .addGap(41, 41, 41)
                        .addComponent(jBtnLimpiarMedicamentos))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIDMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldMedicamentosTipo)
                                .addComponent(jTextFieldDescriMedicamentos)
                                .addComponent(jTextFieldProveedorIDMed, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                .addComponent(jTextFieldDosisMedicamentos)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextFieldIDMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextFieldMedicamentosTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldDosisMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextFieldDescriMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextFieldProveedorIDMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardarMedicamentos)
                    .addComponent(jBtnModificarMedicamentos)
                    .addComponent(jBtnEliminarMedicamentos)
                    .addComponent(jBtnLimpiarMedicamentos))
                .addGap(10, 10, 10))
        );

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel24.setText("Medicamentos");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1383, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Medicos.addTab("Medicamentos", jPanel4);

        jTblPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTblPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblPagoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTblPago);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Fecha:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Hora:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("ID Paciente:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("ID Medico:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("ID Cita:");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("ID Insumos:");

        jTextFieldIDPacientePago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldIDMedicoPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldIDCitaPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldIDInsumoPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jBtnGuardarPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnGuardarPago.setText("Agregar");
        jBtnGuardarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarPagoActionPerformed(evt);
            }
        });

        jBtnModificarPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnModificarPago.setText("Modificar");
        jBtnModificarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarPagoActionPerformed(evt);
            }
        });

        jBtnEliminarPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnEliminarPago.setText("Eliminar");
        jBtnEliminarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarPagoActionPerformed(evt);
            }
        });

        jBtnLimpiarPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnLimpiarPago.setText("Limpiar");
        jBtnLimpiarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarPagoActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("ID:");

        jTextFieldIDPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldIDPago.setEnabled(false);
        jTextFieldIDPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDPagoActionPerformed(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel78.setText("Pago:");

        jTextFieldPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jDateChooserFechaPagos.setDateFormatString("dd/MM/yyyy");

        jDateChooserHoraPagos.setDateFormatString("dd/MM/yyyy HH:mm:ss");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jBtnGuardarPago)
                        .addGap(39, 39, 39)
                        .addComponent(jBtnModificarPago)
                        .addGap(37, 37, 37)
                        .addComponent(jBtnEliminarPago)
                        .addGap(41, 41, 41)
                        .addComponent(jBtnLimpiarPago))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel29)
                            .addComponent(jLabel28)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30)
                            .addComponent(jLabel78))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserFechaPagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooserHoraPagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldIDCitaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldIDPago, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldIDMedicoPago, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                        .addComponent(jTextFieldIDPacientePago))
                                    .addComponent(jTextFieldPago, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldIDInsumoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTextFieldIDPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31)))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooserFechaPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(19, 19, 19)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooserHoraPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIDPacientePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jTextFieldIDMedicoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldIDCitaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29)))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jTextFieldIDInsumoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardarPago)
                    .addComponent(jBtnModificarPago)
                    .addComponent(jBtnEliminarPago)
                    .addComponent(jBtnLimpiarPago))
                .addGap(10, 10, 10))
        );

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel32.setText("Pagos");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel32))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1383, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 26, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Medicos.addTab("Pagos", jPanel5);

        jTblCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTblCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblCitasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTblCitas);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Hora:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Fecha:");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Consultorio:");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("ID Paciente:  ");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setText("ID Medico:");

        jTextFieldConsultorioCita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldIDPacienteCita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldIDMedicoCita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jBtnGuardarCitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnGuardarCitas.setText("Agregar");
        jBtnGuardarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarCitasActionPerformed(evt);
            }
        });

        jBtnModificarCitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnModificarCitas.setText("Modificar");
        jBtnModificarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarCitasActionPerformed(evt);
            }
        });

        jBtnEliminarCitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnEliminarCitas.setText("Eliminar");
        jBtnEliminarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarCitasActionPerformed(evt);
            }
        });

        jBtnLimpiarCitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnLimpiarCitas.setText("Limpiar");
        jBtnLimpiarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarCitasActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("ID:");

        jTextFieldIDCitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldIDCitas.setEnabled(false);
        jTextFieldIDCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDCitasActionPerformed(evt);
            }
        });

        jDateChooserFechaCitas.setDateFormatString("dd/MM/yyyy");

        jDateChooserHoraCitas.setDateFormatString("dd/MM/yyyy HH:mm:ss");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jBtnGuardarCitas)
                        .addGap(39, 39, 39)
                        .addComponent(jBtnModificarCitas)
                        .addGap(37, 37, 37)
                        .addComponent(jBtnEliminarCitas)
                        .addGap(41, 41, 41)
                        .addComponent(jBtnLimpiarCitas))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel39)
                            .addComponent(jLabel34)
                            .addComponent(jLabel33))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldIDCitas, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(jDateChooserFechaCitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldIDPacienteCita)
                            .addComponent(jTextFieldIDMedicoCita, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(jTextFieldConsultorioCita)
                            .addComponent(jDateChooserHoraCitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jTextFieldIDCitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserHoraCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooserFechaCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jTextFieldConsultorioCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jTextFieldIDPacienteCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jTextFieldIDMedicoCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardarCitas)
                    .addComponent(jBtnModificarCitas)
                    .addComponent(jBtnEliminarCitas)
                    .addComponent(jBtnLimpiarCitas))
                .addGap(10, 10, 10))
        );

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel40.setText("Citas");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel40))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1383, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 26, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Medicos.addTab("Registro Citas", jPanel6);

        jTblExamenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTblExamenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblExamenesMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTblExamenes);

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Examen:");

        jTextFieldExamen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldExamenActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setText("Resultado:");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setText("Fecha:");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setText("ID Paciente");

        jTextFieldResultadoExamen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldPacienteExamen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jBtnGuardarExamenes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnGuardarExamenes.setText("Agregar");
        jBtnGuardarExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarExamenesActionPerformed(evt);
            }
        });

        jBtnModificarExamenes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnModificarExamenes.setText("Modificar");
        jBtnModificarExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarExamenesActionPerformed(evt);
            }
        });

        jBtnEliminarExamenes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnEliminarExamenes.setText("Eliminar");
        jBtnEliminarExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarExamenesActionPerformed(evt);
            }
        });

        jBtnLimpiarExamenes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnLimpiarExamenes.setText("Limpiar");
        jBtnLimpiarExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarExamenesActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setText("ID:");

        jTextFieldIDExamenes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldIDExamenes.setEnabled(false);
        jTextFieldIDExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDExamenesActionPerformed(evt);
            }
        });

        jDateChooserExam.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jBtnGuardarExamenes)
                        .addGap(39, 39, 39)
                        .addComponent(jBtnModificarExamenes)
                        .addGap(37, 37, 37)
                        .addComponent(jBtnEliminarExamenes)
                        .addGap(41, 41, 41)
                        .addComponent(jBtnLimpiarExamenes))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel42)
                            .addComponent(jLabel41)
                            .addComponent(jLabel47))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIDExamenes, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldResultadoExamen, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                .addComponent(jTextFieldPacienteExamen)
                                .addComponent(jDateChooserExam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jTextFieldIDExamenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jTextFieldExamen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jTextFieldResultadoExamen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(jDateChooserExam, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextFieldPacienteExamen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardarExamenes)
                    .addComponent(jBtnModificarExamenes)
                    .addComponent(jBtnEliminarExamenes)
                    .addComponent(jBtnLimpiarExamenes))
                .addGap(10, 10, 10))
        );

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel48.setText("Exámenes");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel48))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1383, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Medicos.addTab("Exámenes", jPanel7);

        jTblTratamientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTblTratamientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblTratamientosMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTblTratamientos);

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setText("Nombre:");

        jTextFieldNombreTrata.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldNombreTrata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreTrataActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setText("Descripción:");

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setText("Costo:");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel52.setText("ID Insumo:");

        jTextFieldDescripcionTrata.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldCostoTrata.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldIDInsumoTrata.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jBtnGuardarTrata.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnGuardarTrata.setText("Agregar");
        jBtnGuardarTrata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarTrataActionPerformed(evt);
            }
        });

        jBtnModificarTrata.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnModificarTrata.setText("Modificar");
        jBtnModificarTrata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarTrataActionPerformed(evt);
            }
        });

        jBtnEliminarTrata.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnEliminarTrata.setText("Eliminar");
        jBtnEliminarTrata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarTrataActionPerformed(evt);
            }
        });

        jBtnLimpiarTrata.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnLimpiarTrata.setText("Limpiar");
        jBtnLimpiarTrata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarTrataActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setText("ID:");

        jTextFieldIDTratamiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldIDTratamiento.setEnabled(false);
        jTextFieldIDTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDTratamientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jBtnGuardarTrata)
                        .addGap(35, 35, 35)
                        .addComponent(jBtnModificarTrata)
                        .addGap(36, 36, 36)
                        .addComponent(jBtnEliminarTrata)
                        .addGap(40, 40, 40)
                        .addComponent(jBtnLimpiarTrata))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52)
                            .addComponent(jLabel50)
                            .addComponent(jLabel49)
                            .addComponent(jLabel55))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIDTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNombreTrata, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldDescripcionTrata, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                .addComponent(jTextFieldIDInsumoTrata)
                                .addComponent(jTextFieldCostoTrata)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jTextFieldIDTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jTextFieldNombreTrata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jTextFieldDescripcionTrata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jTextFieldCostoTrata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jTextFieldIDInsumoTrata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardarTrata)
                    .addComponent(jBtnModificarTrata)
                    .addComponent(jBtnEliminarTrata)
                    .addComponent(jBtnLimpiarTrata))
                .addGap(10, 10, 10))
        );

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel56.setText("Tratamientos");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel56))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1383, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Medicos.addTab("Tratamientos", jPanel8);

        jTblInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTblInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblInsumosMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTblInsumos);

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setText("Nombre:");

        jTextFieldNombreInsumos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldNombreInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreInsumosActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setText("Costo:");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel59.setText("Ubicación:");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel60.setText("Vencimiento:");

        jTextFieldCostoInsumos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldUbiInsumos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jBtnGuardarInsumos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnGuardarInsumos.setText("Agregar");
        jBtnGuardarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarInsumosActionPerformed(evt);
            }
        });

        jBtnModificarInsumos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnModificarInsumos.setText("Modificar");
        jBtnModificarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarInsumosActionPerformed(evt);
            }
        });

        jBtnEliminarInsumos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnEliminarInsumos.setText("Eliminar");
        jBtnEliminarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarInsumosActionPerformed(evt);
            }
        });

        jBtnLimpiarInsumos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnLimpiarInsumos.setText("Limpiar");
        jBtnLimpiarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarInsumosActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setText("ID:");

        jTextFieldIDInsumos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldIDInsumos.setEnabled(false);
        jTextFieldIDInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDInsumosActionPerformed(evt);
            }
        });

        jDateChooserInsumo.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jBtnGuardarInsumos)
                        .addGap(39, 39, 39)
                        .addComponent(jBtnModificarInsumos)
                        .addGap(37, 37, 37)
                        .addComponent(jBtnEliminarInsumos)
                        .addGap(41, 41, 41)
                        .addComponent(jBtnLimpiarInsumos))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addComponent(jLabel57)
                            .addComponent(jLabel63)
                            .addComponent(jLabel59)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldIDInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(jTextFieldNombreInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(jTextFieldCostoInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(jTextFieldUbiInsumos)
                            .addComponent(jDateChooserInsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jTextFieldIDInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jTextFieldNombreInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jTextFieldCostoInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jTextFieldUbiInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60)
                    .addComponent(jDateChooserInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardarInsumos)
                    .addComponent(jBtnModificarInsumos)
                    .addComponent(jBtnEliminarInsumos)
                    .addComponent(jBtnLimpiarInsumos))
                .addGap(10, 10, 10))
        );

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel64.setText("Insumos");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel64))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1383, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 26, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Medicos.addTab("Insumos", jPanel9);

        jTblComen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTblComen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblComenMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTblComen);

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel65.setText("ID Cita:");

        jTextFieldCitaComen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldCitaComen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCitaComenActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel66.setText("ID Paciente:");

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel67.setText("Fecha:");

        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel68.setText("Comentario:");

        jTextFieldPaciComen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldComen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jBtnGuardarComen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnGuardarComen.setText("Agregar");
        jBtnGuardarComen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarComenActionPerformed(evt);
            }
        });

        jBtnModificarComen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnModificarComen.setText("Modificar");
        jBtnModificarComen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarComenActionPerformed(evt);
            }
        });

        jBtnEliminarComen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnEliminarComen.setText("Eliminar");
        jBtnEliminarComen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarComenActionPerformed(evt);
            }
        });

        jBtnLimpiarComen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnLimpiarComen.setText("Limpiar");
        jBtnLimpiarComen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarComenActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel71.setText("ID:");

        jTextFieldIDComentarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldIDComentarios.setEnabled(false);
        jTextFieldIDComentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDComentariosActionPerformed(evt);
            }
        });

        jDateChooserComenta.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jBtnGuardarComen)
                        .addGap(39, 39, 39)
                        .addComponent(jBtnModificarComen)
                        .addGap(37, 37, 37)
                        .addComponent(jBtnEliminarComen)
                        .addGap(41, 41, 41)
                        .addComponent(jBtnLimpiarComen))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67)
                            .addComponent(jLabel68)
                            .addComponent(jLabel66)
                            .addComponent(jLabel65)
                            .addComponent(jLabel71))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIDComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCitaComen, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldPaciComen, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                .addComponent(jTextFieldComen)
                                .addComponent(jDateChooserComenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(jTextFieldIDComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jTextFieldCitaComen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(jTextFieldPaciComen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel67)
                    .addComponent(jDateChooserComenta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jTextFieldComen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardarComen)
                    .addComponent(jBtnModificarComen)
                    .addComponent(jBtnEliminarComen)
                    .addComponent(jBtnLimpiarComen))
                .addGap(10, 10, 10))
        );

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel72.setText("Comentarios");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel72))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1383, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Medicos.addTab("Comentarios", jPanel10);

        jTblProvee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTblProvee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblProveeMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTblProvee);

        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel73.setText("Nombre:");

        jTextFieldNombreProvee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldNombreProvee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreProveeActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel74.setText("Teléfono:");

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel75.setText("Dirección:");

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel76.setText("Email:");

        jTextFieldTelefonoProvee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldDireccionProvee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldEmailProvee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jBtnGuardarPrevee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnGuardarPrevee.setText("Agregar");
        jBtnGuardarPrevee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarPreveeActionPerformed(evt);
            }
        });

        jBtnModificarProvee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnModificarProvee.setText("Modificar");
        jBtnModificarProvee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarProveeActionPerformed(evt);
            }
        });

        jBtnEliminarProvee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnEliminarProvee.setText("Eliminar");
        jBtnEliminarProvee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarProveeActionPerformed(evt);
            }
        });

        jBtnLimpiarProvee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnLimpiarProvee.setText("Limpiar");
        jBtnLimpiarProvee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarProveeActionPerformed(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel79.setText("ID:");

        jTextFieldIDProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldIDProveedor.setEnabled(false);
        jTextFieldIDProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jBtnGuardarPrevee)
                        .addGap(39, 39, 39)
                        .addComponent(jBtnModificarProvee)
                        .addGap(37, 37, 37)
                        .addComponent(jBtnEliminarProvee)
                        .addGap(41, 41, 41)
                        .addComponent(jBtnLimpiarProvee))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel75)
                            .addComponent(jLabel76)
                            .addComponent(jLabel74)
                            .addComponent(jLabel73)
                            .addComponent(jLabel79))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIDProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNombreProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldTelefonoProvee, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                                .addComponent(jTextFieldEmailProvee)
                                .addComponent(jTextFieldDireccionProvee)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jTextFieldIDProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(jTextFieldNombreProvee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(jTextFieldTelefonoProvee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jTextFieldDireccionProvee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jTextFieldEmailProvee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardarPrevee)
                    .addComponent(jBtnModificarProvee)
                    .addComponent(jBtnEliminarProvee)
                    .addComponent(jBtnLimpiarProvee))
                .addGap(10, 10, 10))
        );

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel80.setText("Proveedores");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel80))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1383, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Medicos.addTab("Proveedores", jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Medicos)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Medicos)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jBtnModificarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarMedicoActionPerformed
        // TODO add your handling code here:
        if (jTextFieldNombre.getText().isEmpty() || jTextFieldApellido.getText().isEmpty()
                || jTextFieldCedula.getText().isEmpty() || jTextFieldTelefono.getText().isEmpty() || jTextFieldTurno.getText().isEmpty()
                || jTextFieldEspecialidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            MedicoEntity medicoEntity = new MedicoEntity();
            medicoEntity.setIdMedico(Integer.parseInt(jTextFieldIDMedico.getText()));
            medicoEntity.setNombre(jTextFieldNombre.getText());
            medicoEntity.setApellido(jTextFieldApellido.getText());
            medicoEntity.setCedula(Integer.parseInt(jTextFieldCedula.getText()));
            medicoEntity.setTelefono(Integer.parseInt(jTextFieldTelefono.getText()));
            medicoEntity.setTurno(jTextFieldTurno.getText());
            medicoEntity.setEspecialidad(jTextFieldEspecialidad.getText());

            String mensaje = medicoBO.modificarMedico(medicoEntity);
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarMedico();
            listarMedico();
        }

    }//GEN-LAST:event_jBtnModificarMedicoActionPerformed

    private void jBtnGuardarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarMedicoActionPerformed
        // TODO add your handling code here:

        if (jTextFieldNombre.getText().isEmpty() || jTextFieldApellido.getText().isEmpty()
                || jTextFieldCedula.getText().isEmpty() || jTextFieldTelefono.getText().isEmpty() || jTextFieldTurno.getText().isEmpty()
                || jTextFieldEspecialidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            MedicoEntity medicoEntity = new MedicoEntity();
            medicoEntity.setIdMedico(Integer.parseInt(jTextFieldIDMedico.getText()));
            medicoEntity.setNombre(jTextFieldNombre.getText());
            medicoEntity.setApellido(jTextFieldApellido.getText());
            medicoEntity.setCedula(Integer.parseInt(jTextFieldCedula.getText()));
            medicoEntity.setTelefono(Integer.parseInt(jTextFieldTelefono.getText()));
            medicoEntity.setTurno(jTextFieldTurno.getText());
            medicoEntity.setEspecialidad(jTextFieldEspecialidad.getText());

            String mensaje = medicoBO.agregarMedico(medicoEntity);
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarMedico();
            listarMedico();
        }
    }//GEN-LAST:event_jBtnGuardarMedicoActionPerformed

    private void jBtnLimpiarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarMedicoActionPerformed
        // TODO add your handling code here:
        limpiarMedico();
    }//GEN-LAST:event_jBtnLimpiarMedicoActionPerformed

    private void jTextFieldIDMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDMedicoActionPerformed

    private void jTextFieldCedulaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCedulaPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCedulaPacienteActionPerformed

    private void jBtnGuardarMedico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarMedico1ActionPerformed
        // AGREGAR PACIENTE   
        if (jTextFieldCedulaPaciente.getText().isEmpty()
                || jTextFieldNombrePaciente.getText().isEmpty() || jTextFieldApellidoPaciente.getText().isEmpty() || jTextFieldDireccionPaciente.getText().isEmpty()
                || jTextFieldTelefonoPaciente.getText().isEmpty()
                || jTextFieldAlergiasPaciente.getText().isEmpty()
                || jTextFieldEfermedadPaciente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            PacienteEntiy pacienteEntity = new PacienteEntiy();
            pacienteEntity.setIdPaciente(Integer.parseInt(jTextFieldIDPaciente.getText()));
            pacienteEntity.setCedula(Integer.parseInt(jTextFieldCedulaPaciente.getText()));
            pacienteEntity.setNombre(jTextFieldNombrePaciente.getText());
            pacienteEntity.setApellidos(jTextFieldApellidoPaciente.getText());
            pacienteEntity.setDireccion(jTextFieldDireccionPaciente.getText());
            pacienteEntity.setTelefono(Integer.parseInt(jTextFieldTelefonoPaciente.getText()));
            pacienteEntity.setAlegias(jTextFieldAlergiasPaciente.getText());
            pacienteEntity.setEnfermedad(jTextFieldEfermedadPaciente.getText());

            String mensaje = pacienteBO.agregarPaciente(pacienteEntity);
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarPaciente();
            listarPacientes();
        }
    }//GEN-LAST:event_jBtnGuardarMedico1ActionPerformed

    private void jBtnModificarMedico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarMedico1ActionPerformed
        // MODIFICAR PACIENTE
        if (jTextFieldCedulaPaciente.getText().isEmpty()
                || jTextFieldNombrePaciente.getText().isEmpty() || jTextFieldApellidoPaciente.getText().isEmpty() || jTextFieldDireccionPaciente.getText().isEmpty()
                || jTextFieldTelefonoPaciente.getText().isEmpty()
                || jTextFieldAlergiasPaciente.getText().isEmpty()
                || jTextFieldEfermedadPaciente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            PacienteEntiy pacienteEntity = new PacienteEntiy();
            pacienteEntity.setIdPaciente(Integer.parseInt(jTextFieldIDPaciente.getText()));
            pacienteEntity.setCedula(Integer.parseInt(jTextFieldCedulaPaciente.getText()));
            pacienteEntity.setNombre(jTextFieldNombrePaciente.getText());
            pacienteEntity.setApellidos(jTextFieldApellidoPaciente.getText());
            pacienteEntity.setDireccion(jTextFieldDireccionPaciente.getText());
            pacienteEntity.setTelefono(Integer.parseInt(jTextFieldTelefonoPaciente.getText()));
            pacienteEntity.setAlegias(jTextFieldAlergiasPaciente.getText());
            pacienteEntity.setEnfermedad(jTextFieldEfermedadPaciente.getText());

            String mensaje = pacienteBO.modificarPaciente(pacienteEntity);
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarPaciente();
            listarPacientes();
        }

    }//GEN-LAST:event_jBtnModificarMedico1ActionPerformed

    private void jBtnLimpiarMedico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarMedico1ActionPerformed
        // ELIMINAR PACIENTE
        limpiarPaciente();
    }//GEN-LAST:event_jBtnLimpiarMedico1ActionPerformed

    private void jTextFieldIDPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDPacienteActionPerformed

    private void jTextFieldMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMedicamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMedicamentosActionPerformed

    private void jBtnGuardarMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarMedicamentosActionPerformed
        // MEDICAMENTOS AGREGAR
        if (jTextFieldMedicamentos.getText().isEmpty() || jTextFieldMedicamentosTipo.getText().isEmpty()
                || jTextFieldDosisMedicamentos.getText().isEmpty() || jTextFieldDescriMedicamentos.getText().isEmpty() || jTextFieldProveedorIDMed.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            MedicamentosEntity medicamentosEntity = new MedicamentosEntity();
            medicamentosEntity.setIdMedicamentos(Integer.parseInt(jTextFieldIDMedicamentos.getText()));
            medicamentosEntity.setNombre(jTextFieldMedicamentos.getText());
            medicamentosEntity.setTipo(jTextFieldMedicamentosTipo.getText());
            medicamentosEntity.setDosis(jTextFieldDosisMedicamentos.getText());
            medicamentosEntity.setDescripcion(jTextFieldDescriMedicamentos.getText());
            medicamentosEntity.setIdproveedor(Integer.parseInt(jTextFieldProveedorIDMed.getText()));

            String mensaje = medicamentosBO.agregarMedicamento(medicamentosEntity);
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarMedicamentos();
            listarMedicamentos();
        }


    }//GEN-LAST:event_jBtnGuardarMedicamentosActionPerformed

    private void jBtnModificarMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarMedicamentosActionPerformed
        // MODIFICAR MEDICAMENTOS
        if (jTextFieldMedicamentos.getText().isEmpty() || jTextFieldMedicamentosTipo.getText().isEmpty()
                || jTextFieldDosisMedicamentos.getText().isEmpty() || jTextFieldDescriMedicamentos.getText().isEmpty() || jTextFieldProveedorIDMed.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            MedicamentosEntity medicamentosEntity = new MedicamentosEntity();
            medicamentosEntity.setIdMedicamentos(Integer.parseInt(jTextFieldIDMedicamentos.getText()));
            medicamentosEntity.setNombre(jTextFieldMedicamentos.getText());
            medicamentosEntity.setTipo(jTextFieldMedicamentosTipo.getText());
            medicamentosEntity.setDosis(jTextFieldDosisMedicamentos.getText());
            medicamentosEntity.setDescripcion(jTextFieldDescriMedicamentos.getText());
            medicamentosEntity.setIdproveedor(Integer.parseInt(jTextFieldProveedorIDMed.getText()));

            String mensaje = medicamentosBO.modificarMedicamento(medicamentosEntity);
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarMedicamentos();
            listarMedicamentos();
        }


    }//GEN-LAST:event_jBtnModificarMedicamentosActionPerformed

    private void jBtnLimpiarMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarMedicamentosActionPerformed
        // LIMPIAR MEDICAMENTOS
        limpiarMedicamentos();
    }//GEN-LAST:event_jBtnLimpiarMedicamentosActionPerformed

    private void jTextFieldIDMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDMedicamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDMedicamentosActionPerformed

    private void jBtnGuardarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarPagoActionPerformed
        // agregar pagos

        if (jDateChooserFechaPagos.getDateFormatString().isEmpty() || jDateChooserHoraPagos.getDateFormatString().isEmpty()
                || jTextFieldIDPacientePago.getText().isEmpty() || jTextFieldIDMedicoPago.getText().isEmpty() || jTextFieldIDCitaPago.getText().isEmpty()
                || jTextFieldIDInsumoPago.getText().isEmpty() || jTextFieldPago.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            try {

                PagoEntity pagoEntity = new PagoEntity();
                pagoEntity.setIdPago(Integer.parseInt(jTextFieldIDPago.getText()));
                pagoEntity.setFecha(jDateChooserFechaPagos.getDate());
                pagoEntity.setHora(jDateChooserHoraPagos.getDate());

                pagoEntity.setIdPaciente(Integer.parseInt(jTextFieldIDPacientePago.getText()));
                pagoEntity.setIdMedico(Integer.parseInt(jTextFieldIDMedicoPago.getText()));
                pagoEntity.setIdCita(Integer.parseInt(jTextFieldIDCitaPago.getText()));
                pagoEntity.setIdInsumo(Integer.parseInt(jTextFieldIDInsumoPago.getText()));
                pagoEntity.setPago(Double.parseDouble(jTextFieldPago.getText()));

                String mensaje = pagoBO.agregarPago(pagoEntity);
                JOptionPane.showMessageDialog(null, mensaje);
                limpiarPagos();
                listarPagos();
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha u hora incorrecto. Utilice el formato adecuado. ERROR:" + e);
            }
        }
    }//GEN-LAST:event_jBtnGuardarPagoActionPerformed

    private void jBtnModificarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarPagoActionPerformed
        // MODIFICAR PAGOS
         if (jDateChooserFechaPagos.getDateFormatString().isEmpty() || jDateChooserHoraPagos.getDateFormatString().isEmpty()
                || jTextFieldIDPacientePago.getText().isEmpty() || jTextFieldIDMedicoPago.getText().isEmpty() || jTextFieldIDCitaPago.getText().isEmpty()
                || jTextFieldIDInsumoPago.getText().isEmpty() || jTextFieldPago.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            try {

                PagoEntity pagoEntity = new PagoEntity();
                pagoEntity.setIdPago(Integer.parseInt(jTextFieldIDPago.getText()));
                pagoEntity.setFecha(jDateChooserFechaPagos.getDate());
                pagoEntity.setHora(jDateChooserHoraPagos.getDate());

                pagoEntity.setIdPaciente(Integer.parseInt(jTextFieldIDPacientePago.getText()));
                pagoEntity.setIdMedico(Integer.parseInt(jTextFieldIDMedicoPago.getText()));
                pagoEntity.setIdCita(Integer.parseInt(jTextFieldIDCitaPago.getText()));
                pagoEntity.setIdInsumo(Integer.parseInt(jTextFieldIDInsumoPago.getText()));
                pagoEntity.setPago(Double.parseDouble(jTextFieldPago.getText()));

                String mensaje = pagoBO.modificarPago(pagoEntity);
                JOptionPane.showMessageDialog(null, mensaje);
                limpiarPagos();
                listarPagos();
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha u hora incorrecto. Utilice el formato adecuado. ERROR:" + e);
            }
        }
    }//GEN-LAST:event_jBtnModificarPagoActionPerformed

    private void jBtnLimpiarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarPagoActionPerformed
        // LIMPIAR PAGOS
        limpiarPagos();
    }//GEN-LAST:event_jBtnLimpiarPagoActionPerformed

    private void jTextFieldIDPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDPagoActionPerformed

    private void jBtnGuardarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarCitasActionPerformed
        // CITAS AGREGAR
        if (jDateChooserHoraCitas.getDateFormatString().isEmpty() || jDateChooserFechaCitas.getDateFormatString().isEmpty()
                || jTextFieldConsultorioCita.getText().isEmpty() || jTextFieldIDPacienteCita.getText().isEmpty() || jTextFieldIDMedicoCita.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            try {
                CitasEntity ce = new CitasEntity();
                ce.setIdCita(Integer.parseInt(jTextFieldIDCitas.getText()));
                ce.setHora(jDateChooserHoraCitas.getDate());
                ce.setFecha(jDateChooserFechaCitas.getDate());
                ce.setConsultorio(jTextFieldConsultorioCita.getText());
                ce.setIdpaciente(Integer.parseInt(jTextFieldIDPacienteCita.getText()));
                ce.setIdMedico(Integer.parseInt(jTextFieldIDMedicoCita.getText()));

                String mensaje = citasBO.agregarCitas(ce);
                JOptionPane.showMessageDialog(null, mensaje);
                limpiarCitas();
                listarCitas();
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha u hora incorrecto. Utilice el formato adecuado. ERROR:" + e);
            }
        }
    }//GEN-LAST:event_jBtnGuardarCitasActionPerformed

    private void jBtnModificarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarCitasActionPerformed
        // MODIFICAR CITAS
        if (jDateChooserHoraCitas.getDateFormatString().isEmpty() || jDateChooserFechaCitas.getDateFormatString().isEmpty()
                || jTextFieldConsultorioCita.getText().isEmpty() || jTextFieldIDPacienteCita.getText().isEmpty() || jTextFieldIDMedicoCita.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            try {

                CitasEntity ce = new CitasEntity();
                ce.setIdCita(Integer.parseInt(jTextFieldIDCitas.getText()));
                ce.setHora(jDateChooserHoraCitas.getDate());
                ce.setFecha(jDateChooserFechaCitas.getDate());
                ce.setConsultorio(jTextFieldConsultorioCita.getText());
                ce.setIdpaciente(Integer.parseInt(jTextFieldIDPacienteCita.getText()));
                ce.setIdMedico(Integer.parseInt(jTextFieldIDMedicoCita.getText()));

                String mensaje = citasBO.modificarCita(ce);
                JOptionPane.showMessageDialog(null, mensaje);
                limpiarCitas();
                listarCitas();
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha u hora incorrecto. Utilice el formato adecuado. ERROR:" + e);
            }
        }
    }//GEN-LAST:event_jBtnModificarCitasActionPerformed

    private void jBtnLimpiarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarCitasActionPerformed
        // Limpiar Citas
        limpiarCitas();
    }//GEN-LAST:event_jBtnLimpiarCitasActionPerformed

    private void jTextFieldIDCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDCitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDCitasActionPerformed

    private void jTextFieldExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldExamenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldExamenActionPerformed

    private void jBtnGuardarExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarExamenesActionPerformed
        // Guardar Examenes:
        if (jTextFieldIDExamenes.getText().isEmpty() || jTextFieldExamen.getText().isEmpty()
                || jTextFieldResultadoExamen.getText().isEmpty() || jDateChooserExam.getDateFormatString().isEmpty() || jTextFieldPacienteExamen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            try {
                ExamenesEntity examEntity = new ExamenesEntity();
                examEntity.setIdExamenes(Integer.parseInt(jTextFieldIDExamenes.getText()));
                examEntity.setTipoExamen(jTextFieldExamen.getText());
                examEntity.setResultado(jTextFieldResultadoExamen.getText());
                examEntity.setFecha(jDateChooserExam.getDate());
                examEntity.setIdPaciente(Integer.parseInt(jTextFieldPacienteExamen.getText()));

                String mensaje = examenesBO.agregarExamenes(examEntity);
                JOptionPane.showMessageDialog(null, mensaje);
                limpiarExamenes();
                listarExamenes();
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha u hora incorrecto. Utilice el formato adecuado. ERROR:" + e);
            }
        }


    }//GEN-LAST:event_jBtnGuardarExamenesActionPerformed

    private void jBtnModificarExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarExamenesActionPerformed
        // modificar examenes:

        if (jTextFieldIDExamenes.getText().isEmpty() || jTextFieldExamen.getText().isEmpty()
                || jTextFieldResultadoExamen.getText().isEmpty() || jDateChooserExam.getDateFormatString().isEmpty() || jTextFieldPacienteExamen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            try {
                ExamenesEntity examEntity = new ExamenesEntity();
                examEntity.setIdExamenes(Integer.parseInt(jTextFieldIDExamenes.getText()));
                examEntity.setTipoExamen(jTextFieldExamen.getText());
                examEntity.setResultado(jTextFieldResultadoExamen.getText());
                examEntity.setFecha(jDateChooserExam.getDate());
                examEntity.setIdPaciente(Integer.parseInt(jTextFieldPacienteExamen.getText()));

                String mensaje = examenesBO.modificarExamenes(examEntity);
                JOptionPane.showMessageDialog(null, mensaje);
                limpiarExamenes();
                listarExamenes();
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha u hora incorrecto. Utilice el formato adecuado. ERROR:" + e);
            }
        }

    }//GEN-LAST:event_jBtnModificarExamenesActionPerformed

    private void jBtnLimpiarExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarExamenesActionPerformed
        // TODO add your handling code here:
        limpiarExamenes();
    }//GEN-LAST:event_jBtnLimpiarExamenesActionPerformed

    private void jTextFieldIDExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDExamenesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDExamenesActionPerformed

    private void jTextFieldNombreTrataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreTrataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreTrataActionPerformed

    private void jBtnGuardarTrataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarTrataActionPerformed
        // AGREGAR TRATAMIENTO
        if (jTextFieldNombreTrata.getText().isEmpty() || jTextFieldDescripcionTrata.getText().isEmpty()
                || jTextFieldCostoTrata.getText().isEmpty() || jTextFieldIDInsumoTrata.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            TratamientoEntity tratamientoEntity = new TratamientoEntity();
            tratamientoEntity.setIdTratamiento(Integer.parseInt(jTextFieldIDTratamiento.getText()));
            tratamientoEntity.setNombre(jTextFieldNombreTrata.getText());
            tratamientoEntity.setDescripcion(jTextFieldDescripcionTrata.getText());
            tratamientoEntity.setCosto(Integer.parseInt(jTextFieldCostoTrata.getText()));
            tratamientoEntity.setIdInsumo(Integer.parseInt(jTextFieldIDInsumoTrata.getText()));

            String mensaje = tratamientoBO.agregarTratamiento(tratamientoEntity);
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarTratamientos();
            listarTratamientos();
        }
    }//GEN-LAST:event_jBtnGuardarTrataActionPerformed

    private void jBtnModificarTrataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarTrataActionPerformed
        // MODIFICAR TRATAMIENTO
        if (jTextFieldNombreTrata.getText().isEmpty() || jTextFieldDescripcionTrata.getText().isEmpty()
                || jTextFieldCostoTrata.getText().isEmpty() || jTextFieldIDInsumoTrata.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            TratamientoEntity tratamientoEntity = new TratamientoEntity();
            tratamientoEntity.setIdTratamiento(Integer.parseInt(jTextFieldIDTratamiento.getText()));
            tratamientoEntity.setNombre(jTextFieldNombreTrata.getText());
            tratamientoEntity.setDescripcion(jTextFieldDescripcionTrata.getText());
            tratamientoEntity.setCosto(Double.parseDouble(jTextFieldCostoTrata.getText()));
            tratamientoEntity.setIdInsumo(Integer.parseInt(jTextFieldIDInsumoTrata.getText()));

            String mensaje = tratamientoBO.modificarTratamiento(tratamientoEntity);
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarTratamientos();
            listarTratamientos();
        }
    }//GEN-LAST:event_jBtnModificarTrataActionPerformed

    private void jBtnLimpiarTrataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarTrataActionPerformed

        // limpiar tratamiento
        limpiarTratamientos();
    }//GEN-LAST:event_jBtnLimpiarTrataActionPerformed

    private void jTextFieldIDTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDTratamientoActionPerformed

    }//GEN-LAST:event_jTextFieldIDTratamientoActionPerformed

    private void jTextFieldNombreInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreInsumosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreInsumosActionPerformed

    private void jBtnGuardarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarInsumosActionPerformed
        // TODO add your handling code here:

        if (jTextFieldNombreInsumos.getText().isEmpty() || jTextFieldCostoInsumos.getText().isEmpty()
                || jTextFieldUbiInsumos.getText().isEmpty() || jDateChooserInsumo.getDateFormatString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            InsumoEntity insumoEntity = new InsumoEntity();
            insumoEntity.setIdInsumo(Integer.parseInt(jTextFieldIDInsumos.getText()));
            insumoEntity.setNombreInsumo(jTextFieldNombreInsumos.getText());
            insumoEntity.setCosto(Integer.parseInt(jTextFieldCostoInsumos.getText()));
            insumoEntity.setUbicacion(jTextFieldUbiInsumos.getText());
            insumoEntity.setFechaVencimiento(jDateChooserInsumo.getDate());

            String mensaje = insumosBO.agregarInsumo(insumoEntity);
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarInsumos();
            listarInsumos();
        }
    }//GEN-LAST:event_jBtnGuardarInsumosActionPerformed

    private void jBtnModificarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarInsumosActionPerformed
        // TODO add your handling code here:

        if (jTextFieldIDInsumos.getText().isEmpty() || jTextFieldNombreInsumos.getText().isEmpty()
                || jTextFieldCostoInsumos.getText().isEmpty() || jTextFieldUbiInsumos.getText().isEmpty()
                || jDateChooserInsumo.getDateFormatString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            InsumoEntity insumoEntity = new InsumoEntity();
            insumoEntity.setIdInsumo(Integer.parseInt(jTextFieldIDInsumos.getText()));
            insumoEntity.setNombreInsumo(jTextFieldNombreInsumos.getText());
            insumoEntity.setCosto(Integer.parseInt(jTextFieldCostoInsumos.getText()));
            insumoEntity.setUbicacion(jTextFieldUbiInsumos.getText());
            insumoEntity.setFechaVencimiento(jDateChooserInsumo.getDate());

            String mensaje = insumosBO.modificarInsumo(insumoEntity);
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarInsumos();
            listarInsumos();
        }
    }//GEN-LAST:event_jBtnModificarInsumosActionPerformed

    private void jBtnLimpiarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarInsumosActionPerformed
        // limpiar tratamiento
        limpiarInsumos();
    }//GEN-LAST:event_jBtnLimpiarInsumosActionPerformed

    private void jTextFieldIDInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDInsumosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDInsumosActionPerformed

    private void jTextFieldCitaComenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCitaComenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCitaComenActionPerformed

    private void jBtnGuardarComenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarComenActionPerformed
        // AGREGAR COMENTARIOS
        if (jTextFieldCitaComen.getText().isEmpty() || jTextFieldPaciComen.getText().isEmpty()
                || jDateChooserComenta.getDateFormatString().isEmpty() || jTextFieldComen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            try {
                ComentariosEntity cone = new ComentariosEntity();
                cone.setIdComentario(Integer.parseInt(jTextFieldIDComentarios.getText()));
                cone.setIdCita(Integer.parseInt(jTextFieldCitaComen.getText()));
                cone.setIdPaciente(Integer.parseInt(jTextFieldPaciComen.getText()));
                cone.setFecha(jDateChooserComenta.getDate());
                cone.setComentario(jTextFieldComen.getText());

                String mensaje = comentariosBO.agregarComentario(cone);
                JOptionPane.showMessageDialog(null, mensaje);
                limpiarComentarios();
                listarComentarios();
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha u hora incorrecto. Utilice el formato adecuado. ERROR:" + e);
            }
        }
    }//GEN-LAST:event_jBtnGuardarComenActionPerformed

    private void jBtnModificarComenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarComenActionPerformed
        // MODIFICAR COMENTARIOS
        if (jTextFieldCitaComen.getText().isEmpty() || jTextFieldPaciComen.getText().isEmpty()
                || jDateChooserComenta.getDateFormatString().isEmpty() || jTextFieldComen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            try {
                ComentariosEntity cone = new ComentariosEntity();
                cone.setIdComentario(Integer.parseInt(jTextFieldIDComentarios.getText()));
                cone.setIdCita(Integer.parseInt(jTextFieldCitaComen.getText()));
                cone.setIdPaciente(Integer.parseInt(jTextFieldPaciComen.getText()));
                cone.setFecha(jDateChooserComenta.getDate());
                cone.setComentario(jTextFieldComen.getText());

                String mensaje = comentariosBO.modificarComentario(cone);
                JOptionPane.showMessageDialog(null, mensaje);
                limpiarComentarios();
                listarComentarios();
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha u hora incorrecto. Utilice el formato adecuado. ERROR:" + e);
            }
        }
    }//GEN-LAST:event_jBtnModificarComenActionPerformed

    private void jBtnLimpiarComenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarComenActionPerformed
        // limpiar comentarios
        limpiarComentarios();
    }//GEN-LAST:event_jBtnLimpiarComenActionPerformed

    private void jTextFieldIDComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDComentariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDComentariosActionPerformed

    private void jTextFieldNombreProveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreProveeActionPerformed


    }//GEN-LAST:event_jTextFieldNombreProveeActionPerformed

    private void jBtnGuardarPreveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarPreveeActionPerformed
        // AGREGAR PROEEEDEOR:
        if (jTextFieldIDProveedor.getText().isEmpty() || jTextFieldNombreProvee.getText().isEmpty()
                || jTextFieldTelefonoProvee.getText().isEmpty() || jTextFieldDireccionProvee.getText().isEmpty() || jTextFieldEmailProvee.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            ProveedoresEntity proveedoresEntity = new ProveedoresEntity();
            proveedoresEntity.setIdProveedor(Integer.parseInt(jTextFieldIDProveedor.getText()));
            proveedoresEntity.setNombre(jTextFieldNombreProvee.getText());
            proveedoresEntity.setTelefono(jTextFieldTelefonoProvee.getText());
            proveedoresEntity.setDireccion(jTextFieldDireccionProvee.getText());
            proveedoresEntity.setEmail(jTextFieldEmailProvee.getText());

            String mensaje = proveedorBO.agregarProveedor(proveedoresEntity);
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarProveedores();
            listarProveedores();
        } // TODO add your handling code here:
    }//GEN-LAST:event_jBtnGuardarPreveeActionPerformed

    private void jBtnModificarProveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarProveeActionPerformed
        // MODIFICAR PROVEEDORES

        if (jTextFieldIDProveedor.getText().isEmpty() || jTextFieldNombreProvee.getText().isEmpty()
                || jTextFieldTelefonoProvee.getText().isEmpty() || jTextFieldDireccionProvee.getText().isEmpty() || jTextFieldEmailProvee.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            ProveedoresEntity proveedoresEntity = new ProveedoresEntity();
            proveedoresEntity.setIdProveedor(Integer.parseInt(jTextFieldIDProveedor.getText()));
            proveedoresEntity.setNombre(jTextFieldNombreProvee.getText());
            proveedoresEntity.setTelefono(jTextFieldTelefonoProvee.getText());
            proveedoresEntity.setDireccion(jTextFieldDireccionProvee.getText());
            proveedoresEntity.setEmail(jTextFieldEmailProvee.getText());

            String mensaje = proveedorBO.modificarProveedor(proveedoresEntity);
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarProveedores();
            listarProveedores();
        }

    }//GEN-LAST:event_jBtnModificarProveeActionPerformed

    private void jBtnLimpiarProveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarProveeActionPerformed
        // TODO add your handling code here:
        limpiarProveedores();
    }//GEN-LAST:event_jBtnLimpiarProveeActionPerformed

    private void jTextFieldIDProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDProveedorActionPerformed

    private void jBtnEliminarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarMedicoActionPerformed
        // TODO add your handling code here:
        if (jTextFieldNombre.getText().isEmpty() || jTextFieldApellido.getText().isEmpty()
                || jTextFieldCedula.getText().isEmpty() || jTextFieldTelefono.getText().isEmpty() || jTextFieldTurno.getText().isEmpty()
                || jTextFieldEspecialidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {

            String mensaje = medicoBO.eliminarMedico(Integer.parseInt(jTextFieldIDMedico.getText()));
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarMedico();
            listarMedico();
        }
    }//GEN-LAST:event_jBtnEliminarMedicoActionPerformed

    private void jTblMedicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblMedicosMouseClicked
        // TODO add your handling code here:
        int seleccion = jTblMedicos.rowAtPoint(evt.getPoint());
        jTextFieldIDMedico.setText(jTblMedicos.getValueAt(seleccion, 0) + "");
        jTextFieldNombre.setText(jTblMedicos.getValueAt(seleccion, 1) + "");
        jTextFieldApellido.setText(jTblMedicos.getValueAt(seleccion, 2) + "");
        jTextFieldCedula.setText(jTblMedicos.getValueAt(seleccion, 3) + "");
        jTextFieldTelefono.setText(jTblMedicos.getValueAt(seleccion, 4) + "");
        jTextFieldTurno.setText(jTblMedicos.getValueAt(seleccion, 5) + "");
        jTextFieldEspecialidad.setText(jTblMedicos.getValueAt(seleccion, 6) + "");
    }//GEN-LAST:event_jTblMedicosMouseClicked

    private void jBtnEliminarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarPagoActionPerformed
        // EIMINAR PAGO
        if (jDateChooserFechaPagos.getDateFormatString().isEmpty() || jDateChooserHoraPagos.getDateFormatString().isEmpty()
                || jTextFieldIDPacientePago.getText().isEmpty() || jTextFieldIDMedicoPago.getText().isEmpty() || jTextFieldIDCitaPago.getText().isEmpty()
                || jTextFieldIDInsumoPago.getText().isEmpty() || jTextFieldPago.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {

            String mensaje = pagoBO.eliminarPago(Integer.parseInt(jTextFieldIDPago.getText()));
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarPagos();
            listarPagos();
        }
    }//GEN-LAST:event_jBtnEliminarPagoActionPerformed

    private void jTblPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblPagoMouseClicked
        try {
            // mouse click pagos
            int seleccion = jTblPago.rowAtPoint(evt.getPoint());
            jTextFieldIDPago.setText(jTblPago.getValueAt(seleccion, 0) + "");
            jDateChooserFechaPagos.setDate(ff.parse(jTblPago.getValueAt(seleccion, 1) + ""));
            jDateChooserHoraPagos.setDate(sdf.parse(jTblPago.getValueAt(seleccion, 2) + ""));
            jTextFieldIDPacientePago.setText(jTblPago.getValueAt(seleccion, 3) + "");
            jTextFieldIDMedicoPago.setText(jTblPago.getValueAt(seleccion, 4) + "");
            jTextFieldIDCitaPago.setText(jTblPago.getValueAt(seleccion, 5) + "");
            jTextFieldIDInsumoPago.setText(jTblPago.getValueAt(seleccion, 6) + "");
            jTextFieldPago.setText(jTblPago.getValueAt(seleccion, 7) + "");
        } catch (ParseException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTblPagoMouseClicked

    private void jBtnEliminarMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarMedicamentosActionPerformed
        // MEDICAMENTOS ELIMINAR
        if (jTextFieldMedicamentos.getText().isEmpty() || jTextFieldMedicamentosTipo.getText().isEmpty()
                || jTextFieldDosisMedicamentos.getText().isEmpty() || jTextFieldDescriMedicamentos.getText().isEmpty() || jTextFieldProveedorIDMed.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            MedicamentosEntity medicamentosEntity = new MedicamentosEntity();
            medicamentosEntity.setIdMedicamentos(Integer.parseInt(jTextFieldIDMedicamentos.getText()));
            medicamentosEntity.setNombre(jTextFieldMedicamentos.getText());
            medicamentosEntity.setTipo(jTextFieldMedicamentosTipo.getText());
            medicamentosEntity.setDosis(jTextFieldDosisMedicamentos.getText());
            medicamentosEntity.setDescripcion(jTextFieldDescriMedicamentos.getText());
            medicamentosEntity.setIdproveedor(Integer.parseInt(jTextFieldProveedorIDMed.getText()));

            String mensaje = medicamentosBO.eliminarMedicamento(Integer.parseInt(jTextFieldIDMedicamentos.getText()));
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarMedicamentos();
            listarMedicamentos();
        }

    }//GEN-LAST:event_jBtnEliminarMedicamentosActionPerformed

    private void jTblMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblMedicamentosMouseClicked
        // MEDICAMENTOS EVENTO MOUSE
        int seleccion = jTblMedicamentos.rowAtPoint(evt.getPoint());
        jTextFieldIDMedicamentos.setText(jTblMedicamentos.getValueAt(seleccion, 0) + "");
        jTextFieldMedicamentos.setText(jTblMedicamentos.getValueAt(seleccion, 1) + "");
        jTextFieldMedicamentosTipo.setText(jTblMedicamentos.getValueAt(seleccion, 2) + "");
        jTextFieldDosisMedicamentos.setText(jTblMedicamentos.getValueAt(seleccion, 3) + "");
        jTextFieldDescriMedicamentos.setText(jTblMedicamentos.getValueAt(seleccion, 4) + "");
        jTextFieldProveedorIDMed.setText(jTblMedicamentos.getValueAt(seleccion, 5) + "");


    }//GEN-LAST:event_jTblMedicamentosMouseClicked

    private void jBtnEliminarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarCitasActionPerformed
        // Eliminar CITAS
        if (jDateChooserHoraCitas.getDateFormatString().isEmpty() || jDateChooserFechaCitas.getDateFormatString().isEmpty()
                || jTextFieldConsultorioCita.getText().isEmpty() || jTextFieldIDPacienteCita.getText().isEmpty() || jTextFieldIDMedicoCita.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {

            String mensaje = citasBO.eliminarCita(Integer.parseInt(jTextFieldIDCitas.getText()));
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarCitas();
            listarCitas();
        }
    }//GEN-LAST:event_jBtnEliminarCitasActionPerformed

    private void jTblCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblCitasMouseClicked
        try {
            // CLICKED CITAS
            int seleccion = jTblCitas.rowAtPoint(evt.getPoint());
            jTextFieldIDCitas.setText(jTblCitas.getValueAt(seleccion, 0) + "");
            jDateChooserHoraCitas.setDate(sdf.parse(jTblCitas.getValueAt(seleccion, 1) + ""));
            jDateChooserFechaCitas.setDate(ff.parse(jTblCitas.getValueAt(seleccion, 2) + ""));
            jTextFieldConsultorioCita.setText(jTblCitas.getValueAt(seleccion, 3) + "");
            jTextFieldIDPacienteCita.setText(jTblCitas.getValueAt(seleccion, 4) + "");
            jTextFieldIDMedicoCita.setText(jTblCitas.getValueAt(seleccion, 5) + "");
        } catch (ParseException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      

    }//GEN-LAST:event_jTblCitasMouseClicked

    private void jBtnEliminarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarInsumosActionPerformed
        // TODO add your handling code here:

        if (jTextFieldIDInsumos.getText().isEmpty() || jTextFieldNombreInsumos.getText().isEmpty()
                || jTextFieldCostoInsumos.getText().isEmpty() || jTextFieldUbiInsumos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {

            String mensaje = insumosBO.eliminarInsumo(Integer.parseInt(jTextFieldIDInsumos.getText()));
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarInsumos();
            listarInsumos();
        }
    }//GEN-LAST:event_jBtnEliminarInsumosActionPerformed

    private void jTblTratamientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblTratamientosMouseClicked
        // CLICKED DE TRATAMIENTO
        int seleccion = jTblTratamientos.rowAtPoint(evt.getPoint());
        jTextFieldIDTratamiento.setText(jTblTratamientos.getValueAt(seleccion, 0) + "");
        jTextFieldNombreTrata.setText(jTblTratamientos.getValueAt(seleccion, 1) + "");
        jTextFieldDescripcionTrata.setText(jTblTratamientos.getValueAt(seleccion, 2) + "");
        jTextFieldCostoTrata.setText(jTblTratamientos.getValueAt(seleccion, 3) + "");
        jTextFieldIDInsumoTrata.setText(jTblTratamientos.getValueAt(seleccion, 4) + "");

    }//GEN-LAST:event_jTblTratamientosMouseClicked

    private void jBtnEliminarTrataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarTrataActionPerformed
        // ELIMINAR TRATAMIENTO
        if (jTextFieldNombreTrata.getText().isEmpty() || jTextFieldDescripcionTrata.getText().isEmpty()
                || jTextFieldCostoTrata.getText().isEmpty() || jTextFieldIDInsumoTrata.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {

            String mensaje = tratamientoBO.eliminarTratamiento(Integer.parseInt(jTextFieldIDTratamiento.getText()));
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarTratamientos();
            listarTratamientos();
        }
    }//GEN-LAST:event_jBtnEliminarTrataActionPerformed

    private void jTblPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblPacienteMouseClicked
        // PACIENTE EVENTO MOUSE
        int seleccion = jTblPaciente.rowAtPoint(evt.getPoint());
        jTextFieldIDPaciente.setText(jTblPaciente.getValueAt(seleccion, 0) + "");
        jTextFieldCedulaPaciente.setText(jTblPaciente.getValueAt(seleccion, 1) + "");
        jTextFieldNombrePaciente.setText(jTblPaciente.getValueAt(seleccion, 2) + "");
        jTextFieldApellidoPaciente.setText(jTblPaciente.getValueAt(seleccion, 3) + "");
        jTextFieldDireccionPaciente.setText(jTblPaciente.getValueAt(seleccion, 4) + "");
        jTextFieldTelefonoPaciente.setText(jTblPaciente.getValueAt(seleccion, 5) + "");
        jTextFieldAlergiasPaciente.setText(jTblPaciente.getValueAt(seleccion, 6) + "");
        jTextFieldEfermedadPaciente.setText(jTblPaciente.getValueAt(seleccion, 7) + "");
    }//GEN-LAST:event_jTblPacienteMouseClicked

    private void jBtnEliminarMedico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarMedico1ActionPerformed
        // ELIMINAR PACIENTE
        if (jTextFieldCedulaPaciente.getText().isEmpty()
                || jTextFieldNombrePaciente.getText().isEmpty() || jTextFieldApellidoPaciente.getText().isEmpty() || jTextFieldDireccionPaciente.getText().isEmpty()
                || jTextFieldTelefonoPaciente.getText().isEmpty()
                || jTextFieldAlergiasPaciente.getText().isEmpty()
                || jTextFieldEfermedadPaciente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            String mensaje = pacienteBO.eliminarPaciente(Integer.parseInt(jTextFieldIDPaciente.getText()));
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarPaciente();
            listarPacientes();
        }
    }//GEN-LAST:event_jBtnEliminarMedico1ActionPerformed

    private void jBtnEliminarComenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarComenActionPerformed
        // ELIMINAR COMENTARIOS
        if (jTextFieldCitaComen.getText().isEmpty() || jTextFieldPaciComen.getText().isEmpty()
                || jDateChooserComenta.getDateFormatString().isEmpty() || jTextFieldComen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {
            try {

                String mensaje = comentariosBO.eliminarComentario(Integer.parseInt(jTextFieldIDComentarios.getText()));
                JOptionPane.showMessageDialog(null, mensaje);
                limpiarComentarios();
                listarComentarios();
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha u hora incorrecto. Utilice el formato adecuado. ERROR:" + e);
            }
        }
    }//GEN-LAST:event_jBtnEliminarComenActionPerformed

    private void jTblComenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblComenMouseClicked
        try {
            // CLICKED COMENTARIOS
            int seleccion = jTblComen.rowAtPoint(evt.getPoint());
            jTextFieldIDComentarios.setText(jTblComen.getValueAt(seleccion, 0) + "");
            jTextFieldCitaComen.setText(jTblComen.getValueAt(seleccion, 1) + "");
            jTextFieldPaciComen.setText(jTblComen.getValueAt(seleccion, 2) + "");
            jDateChooserComenta.setDate(ff.parse(jTblComen.getValueAt(seleccion, 3) + ""));
            jTextFieldComen.setText(jTblComen.getValueAt(seleccion, 4) + "");
        } catch (ParseException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTblComenMouseClicked

    private void jTblProveeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblProveeMouseClicked
        // CLICKED PROVEEDORES
        int seleccion = jTblProvee.rowAtPoint(evt.getPoint());
        jTextFieldIDProveedor.setText(jTblProvee.getValueAt(seleccion, 0) + "");
        jTextFieldNombreProvee.setText(jTblProvee.getValueAt(seleccion, 1) + "");
        jTextFieldTelefonoProvee.setText(jTblProvee.getValueAt(seleccion, 2) + "");
        jTextFieldDireccionProvee.setText(jTblProvee.getValueAt(seleccion, 3) + "");
        jTextFieldEmailProvee.setText(jTblProvee.getValueAt(seleccion, 4) + "");
    }//GEN-LAST:event_jTblProveeMouseClicked

    private void jBtnEliminarProveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarProveeActionPerformed
        // ELIMINAR PROVEEDOR

        if (jTextFieldIDProveedor.getText().isEmpty() || jTextFieldNombreProvee.getText().isEmpty()
                || jTextFieldTelefonoProvee.getText().isEmpty() || jTextFieldDireccionProvee.getText().isEmpty() || jTextFieldEmailProvee.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {

            String mensaje = proveedorBO.eliminarProveedor(Integer.parseInt(jTextFieldIDProveedor.getText()));
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarProveedores();
            listarProveedores();
        }
    }//GEN-LAST:event_jBtnEliminarProveeActionPerformed

    private void jTblInsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblInsumosMouseClicked
        try {
            int seleccion = jTblInsumos.rowAtPoint(evt.getPoint());
            jTextFieldIDInsumos.setText(jTblInsumos.getValueAt(seleccion, 0) + "");
            jTextFieldNombreInsumos.setText(jTblInsumos.getValueAt(seleccion, 1) + "");
            jTextFieldCostoInsumos.setText(jTblInsumos.getValueAt(seleccion, 2) + "");
            jTextFieldUbiInsumos.setText(jTblInsumos.getValueAt(seleccion, 3) + "");
            jDateChooserInsumo.setDate(ff.parse(jTblInsumos.getValueAt(seleccion, 4) + ""));
        } catch (ParseException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTblInsumosMouseClicked

    private void jTblExamenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblExamenesMouseClicked
        try {
            // TODO add your handling code here:
            // visualizacion de Examenes:

            int seleccion = jTblExamenes.rowAtPoint(evt.getPoint());
            jTextFieldIDExamenes.setText(jTblExamenes.getValueAt(seleccion, 0) + "");
            jTextFieldExamen.setText(jTblExamenes.getValueAt(seleccion, 1) + "");
            jTextFieldResultadoExamen.setText(jTblExamenes.getValueAt(seleccion, 2) + "");
            jDateChooserExam.setDate(ff.parse(jTblExamenes.getValueAt(seleccion, 3) + ""));
            jTextFieldPacienteExamen.setText(jTblExamenes.getValueAt(seleccion, 4) + "");
        } catch (ParseException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTblExamenesMouseClicked

    private void jBtnEliminarExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarExamenesActionPerformed
        // Eliminar examenes:

        if (jTextFieldIDExamenes.getText().isEmpty() || jTextFieldExamen.getText().isEmpty()
                || jTextFieldResultadoExamen.getText().isEmpty() || jDateChooserInsumo.getDateFormatString().isEmpty() || jTextFieldPacienteExamen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los espacios vacios");

        } else {

            String mensaje = examenesBO.eliminarExamenes(Integer.parseInt(jTextFieldIDExamenes.getText()));
            JOptionPane.showMessageDialog(null, mensaje);
            limpiarExamenes();
            listarExamenes();
        }
    }//GEN-LAST:event_jBtnEliminarExamenesActionPerformed

    public void limpiarMedico() {
        jTextFieldIDMedico.setText("");
        jTextFieldNombre.setText("");
        jTextFieldApellido.setText("");
        jTextFieldCedula.setText("");
        jTextFieldTelefono.setText("");
        jTextFieldTurno.setText("");
        jTextFieldEspecialidad.setText("");
        idMaxMedico();
    }

    public void limpiarPaciente() {
        jTextFieldIDPaciente.setText("");
        jTextFieldCedulaPaciente.setText("");
        jTextFieldNombrePaciente.setText("");
        jTextFieldApellidoPaciente.setText("");
        jTextFieldDireccionPaciente.setText("");
        jTextFieldTelefonoPaciente.setText("");
        jTextFieldAlergiasPaciente.setText("");
        jTextFieldEfermedadPaciente.setText("");
        idMaxPacientes();
    }

    public void limpiarCitas() {
        jTextFieldIDCitas.setText("");
        jDateChooserHoraCitas.setDate(null);
        jDateChooserFechaCitas.setDate(null);
        jTextFieldConsultorioCita.setText("");
        jTextFieldIDPacienteCita.setText("");
        jTextFieldIDMedicoCita.setText("");
        idMaxCitas();
    }

    public void limpiarComentarios() {
        jTextFieldIDComentarios.setText("");
        jTextFieldCitaComen.setText("");
        jTextFieldPaciComen.setText("");
        jDateChooserComenta.setDate(null);
        jTextFieldComen.setText("");
        idMaxComentarios();
    }

    public void limpiarExamenes() {
        jTextFieldIDExamenes.setText("");
        jTextFieldExamen.setText("");
        jTextFieldResultadoExamen.setText("");
        jDateChooserExam.setDate(null);
        jTextFieldPacienteExamen.setText("");
        idMaxExamenes();
    }

    public void limpiarInsumos() {
        jTextFieldIDInsumos.setText("");
        jTextFieldNombreInsumos.setText("");
        jTextFieldCostoInsumos.setText("");
        jTextFieldUbiInsumos.setText("");
        jDateChooserInsumo.setDate(null);
        idMaxInsumos();
    }

    public void limpiarMedicamentos() {
        jTextFieldIDMedicamentos.setText("");
        jTextFieldMedicamentos.setText("");
        jTextFieldMedicamentosTipo.setText("");
        jTextFieldDosisMedicamentos.setText("");
        jTextFieldDescriMedicamentos.setText("");
        jTextFieldProveedorIDMed.setText("");
        idMaxMedicamentos();
    }

    public void limpiarPagos() {
        jTextFieldIDPago.setText("");
        jDateChooserFechaPagos.setDate(null);
        jDateChooserHoraPagos.setDate(null);
        jTextFieldIDPacientePago.setText("");
        jTextFieldIDMedicoPago.setText("");
        jTextFieldIDCitaPago.setText("");
        jTextFieldEspecialidad.setText("");
        jTextFieldIDInsumoPago.setText("");
        jTextFieldPago.setText("");
        idMaxPagos();
    }

    public void limpiarProveedores() {
        jTextFieldIDProveedor.setText("");
        jTextFieldNombreProvee.setText("");
        jTextFieldTelefonoProvee.setText("");
        jTextFieldDireccionProvee.setText("");
        jTextFieldEmailProvee.setText("");
        idMaxProveedores();
    }

    public void limpiarTratamientos() {
        jTextFieldIDTratamiento.setText("");
        jTextFieldNombreTrata.setText("");
        jTextFieldDescripcionTrata.setText("");
        jTextFieldCostoTrata.setText("");
        jTextFieldIDInsumoTrata.setText("");
        idMaxTratamientos();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administracion().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Medicos;
    private javax.swing.JButton jBtnEliminarCitas;
    private javax.swing.JButton jBtnEliminarComen;
    private javax.swing.JButton jBtnEliminarExamenes;
    private javax.swing.JButton jBtnEliminarInsumos;
    private javax.swing.JButton jBtnEliminarMedicamentos;
    private javax.swing.JButton jBtnEliminarMedico;
    private javax.swing.JButton jBtnEliminarMedico1;
    private javax.swing.JButton jBtnEliminarPago;
    private javax.swing.JButton jBtnEliminarProvee;
    private javax.swing.JButton jBtnEliminarTrata;
    private javax.swing.JButton jBtnGuardarCitas;
    private javax.swing.JButton jBtnGuardarComen;
    private javax.swing.JButton jBtnGuardarExamenes;
    private javax.swing.JButton jBtnGuardarInsumos;
    private javax.swing.JButton jBtnGuardarMedicamentos;
    private javax.swing.JButton jBtnGuardarMedico;
    private javax.swing.JButton jBtnGuardarMedico1;
    private javax.swing.JButton jBtnGuardarPago;
    private javax.swing.JButton jBtnGuardarPrevee;
    private javax.swing.JButton jBtnGuardarTrata;
    private javax.swing.JButton jBtnLimpiarCitas;
    private javax.swing.JButton jBtnLimpiarComen;
    private javax.swing.JButton jBtnLimpiarExamenes;
    private javax.swing.JButton jBtnLimpiarInsumos;
    private javax.swing.JButton jBtnLimpiarMedicamentos;
    private javax.swing.JButton jBtnLimpiarMedico;
    private javax.swing.JButton jBtnLimpiarMedico1;
    private javax.swing.JButton jBtnLimpiarPago;
    private javax.swing.JButton jBtnLimpiarProvee;
    private javax.swing.JButton jBtnLimpiarTrata;
    private javax.swing.JButton jBtnModificarCitas;
    private javax.swing.JButton jBtnModificarComen;
    private javax.swing.JButton jBtnModificarExamenes;
    private javax.swing.JButton jBtnModificarInsumos;
    private javax.swing.JButton jBtnModificarMedicamentos;
    private javax.swing.JButton jBtnModificarMedico;
    private javax.swing.JButton jBtnModificarMedico1;
    private javax.swing.JButton jBtnModificarPago;
    private javax.swing.JButton jBtnModificarProvee;
    private javax.swing.JButton jBtnModificarTrata;
    private com.toedter.calendar.JDateChooser jDateChooserComenta;
    private com.toedter.calendar.JDateChooser jDateChooserExam;
    private com.toedter.calendar.JDateChooser jDateChooserFechaCitas;
    private com.toedter.calendar.JDateChooser jDateChooserFechaPagos;
    private com.toedter.calendar.JDateChooser jDateChooserHoraCitas;
    private com.toedter.calendar.JDateChooser jDateChooserHoraPagos;
    private com.toedter.calendar.JDateChooser jDateChooserInsumo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTblCitas;
    private javax.swing.JTable jTblComen;
    private javax.swing.JTable jTblExamenes;
    private javax.swing.JTable jTblInsumos;
    private javax.swing.JTable jTblMedicamentos;
    private javax.swing.JTable jTblMedicos;
    private javax.swing.JTable jTblPaciente;
    private javax.swing.JTable jTblPago;
    private javax.swing.JTable jTblProvee;
    private javax.swing.JTable jTblTratamientos;
    private javax.swing.JTextField jTextFieldAlergiasPaciente;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldApellidoPaciente;
    private javax.swing.JTextField jTextFieldCedula;
    private javax.swing.JTextField jTextFieldCedulaPaciente;
    private javax.swing.JTextField jTextFieldCitaComen;
    private javax.swing.JTextField jTextFieldComen;
    private javax.swing.JTextField jTextFieldConsultorioCita;
    private javax.swing.JTextField jTextFieldCostoInsumos;
    private javax.swing.JTextField jTextFieldCostoTrata;
    private javax.swing.JTextField jTextFieldDescriMedicamentos;
    private javax.swing.JTextField jTextFieldDescripcionTrata;
    private javax.swing.JTextField jTextFieldDireccionPaciente;
    private javax.swing.JTextField jTextFieldDireccionProvee;
    private javax.swing.JTextField jTextFieldDosisMedicamentos;
    private javax.swing.JTextField jTextFieldEfermedadPaciente;
    private javax.swing.JTextField jTextFieldEmailProvee;
    private javax.swing.JTextField jTextFieldEspecialidad;
    private javax.swing.JTextField jTextFieldExamen;
    private javax.swing.JTextField jTextFieldIDCitaPago;
    private javax.swing.JTextField jTextFieldIDCitas;
    private javax.swing.JTextField jTextFieldIDComentarios;
    private javax.swing.JTextField jTextFieldIDExamenes;
    private javax.swing.JTextField jTextFieldIDInsumoPago;
    private javax.swing.JTextField jTextFieldIDInsumoTrata;
    private javax.swing.JTextField jTextFieldIDInsumos;
    private javax.swing.JTextField jTextFieldIDMedicamentos;
    private javax.swing.JTextField jTextFieldIDMedico;
    private javax.swing.JTextField jTextFieldIDMedicoCita;
    private javax.swing.JTextField jTextFieldIDMedicoPago;
    private javax.swing.JTextField jTextFieldIDPaciente;
    private javax.swing.JTextField jTextFieldIDPacienteCita;
    private javax.swing.JTextField jTextFieldIDPacientePago;
    private javax.swing.JTextField jTextFieldIDPago;
    private javax.swing.JTextField jTextFieldIDProveedor;
    private javax.swing.JTextField jTextFieldIDTratamiento;
    private javax.swing.JTextField jTextFieldMedicamentos;
    private javax.swing.JTextField jTextFieldMedicamentosTipo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombreInsumos;
    private javax.swing.JTextField jTextFieldNombrePaciente;
    private javax.swing.JTextField jTextFieldNombreProvee;
    private javax.swing.JTextField jTextFieldNombreTrata;
    private javax.swing.JTextField jTextFieldPaciComen;
    private javax.swing.JTextField jTextFieldPacienteExamen;
    private javax.swing.JTextField jTextFieldPago;
    private javax.swing.JTextField jTextFieldProveedorIDMed;
    private javax.swing.JTextField jTextFieldResultadoExamen;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JTextField jTextFieldTelefonoPaciente;
    private javax.swing.JTextField jTextFieldTelefonoProvee;
    private javax.swing.JTextField jTextFieldTurno;
    private javax.swing.JTextField jTextFieldUbiInsumos;
    // End of variables declaration//GEN-END:variables
}

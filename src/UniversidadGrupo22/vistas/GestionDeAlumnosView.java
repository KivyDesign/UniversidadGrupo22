/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadGrupo22.vistas;

import UniversidadGrupo22.accesoADatos.AlumnoData;
import UniversidadGrupo22.entidades.Alumno;
import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author german
 */
public class GestionDeAlumnosView extends javax.swing.JInternalFrame {

    private AlumnoData aluData;

    /**
     * Creates new form GestionDeAlumnosView
     */
    public GestionDeAlumnosView() {
        initComponents();
        jbGuardar.setEnabled(false);
        jbEliminar.setEnabled(false);
        aluData = new AlumnoData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jrbEstado = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jlStatusBar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jdcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jtid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setClosable(true);
        setTitle("Gestion de Alumno");

        jPanel1.setBackground(new java.awt.Color(36, 86, 109));

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/32x32.png"))); // NOI18N
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DNI:");

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre:");

        jrbEstado.setForeground(new java.awt.Color(255, 255, 255));
        jrbEstado.setText("Activo");

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha de Nacimiento:");

        jbNuevo.setBackground(new java.awt.Color(194, 165, 121));
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbEliminar.setBackground(new java.awt.Color(194, 165, 121));
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbGuardar.setBackground(new java.awt.Color(194, 165, 121));
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(194, 165, 121));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(45, 65, 88));
        jPanel2.setPreferredSize(new java.awt.Dimension(124, 79));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Formulario de Alumno");

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Bienvenido de Vuelta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(45, 65, 88));
        jPanel3.setPreferredSize(new java.awt.Dimension(424, 34));

        jlStatusBar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlStatusBar.setForeground(new java.awt.Color(0, 153, 102));
        jlStatusBar.setText("Ingrese el DNI a buscar o Complete los datos para crear un nuevo alumno");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlStatusBar)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jdcFechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        jdcFechaNacimiento.setForeground(new java.awt.Color(0, 102, 153));
        jdcFechaNacimiento.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jdcFechaNacimiento.setMaxSelectableDate(new java.util.Date(1199156481000L));
        jdcFechaNacimiento.setMinSelectableDate(new java.util.Date(-2208969711000L));

        jtid.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("id:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbNuevo)
                        .addGap(66, 66, 66)
                        .addComponent(jbGuardar)
                        .addGap(72, 72, 72)
                        .addComponent(jbEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbEstado)
                                .addGap(247, 247, 247))
                            .addComponent(jtDni, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtApellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtid, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscar)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(103, 103, 103))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrbEstado)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(54, 54, 54)))
                .addGap(26, 26, 26)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(8, 8, 8)
                .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbGuardar)
                    .addComponent(jbEliminar)
                    .addComponent(jbSalir))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // Desabilito RadioButon porque el sistema utiliza borrado lógico
        jrbEstado.setEnabled(false);
        try {
            Alumno alumno = aluData.buscarAlumnoPorID(Integer.parseInt(jtid.getText()));
            if (jdcFechaNacimiento.getDate() == null) {
                MensajeSB(2, "Falta completar Fecha de Nacimiento");
            } else if (jtDni.getText().length() != 8) {
                MensajeSB(2, "Debe ser un DNI valido 8 Digitos");
                jtDni.requestFocus();
                jtDni.selectAll();
            } else if (PruebaDeCaracteres(jtApellido.getText()) == false) {
                jtApellido.requestFocus();
                jtApellido.selectAll();
            } else if (PruebaDeCaracteres(jtNombre.getText()) == false) {
                jtNombre.requestFocus();
                jtNombre.selectAll();
            } else {
                alumno.setDni(Integer.parseInt(jtDni.getText()));
                alumno.setApellido(jtApellido.getText());
                alumno.setNombre(jtNombre.getText());
                alumno.setFechaNacimiento(jdcFechaNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                alumno.setEstado(true);
                aluData.modificarAlumno(alumno);
                MensajeSB(1, "El alumno ha sido guardado! Busque por DNI o cargue un nuevo Alumno");
                LimpiarCampos();
                jbNuevo.setEnabled(true);
            }
        } catch (NumberFormatException ex) {
            MensajeSB(2, "El DNI debe ser un número");
            jtDni.requestFocus();
            jtDni.selectAll();
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            Alumno alum = aluData.buscarAlumnoPorDni(Integer.parseInt(jtDni.getText()));
            if (alum != null) {
                aluData.eliminarAlumno(alum.getIdAlumno());
                jrbEstado.setSelected(false);
                MensajeSB(1, "Alumno eliminado con exito! Busque por DNI o cargue un nuevo Alumno");
                LimpiarCampos();
                jbNuevo.setEnabled(true);
            } else {
                MensajeSB(2, "El alumno no Existe");
            }
        } catch (NumberFormatException e) {
            MensajeSB(2, "El DNI debe ser un número");
            jtDni.requestFocus();
            jtDni.selectAll();
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        if (jdcFechaNacimiento.getDate() == null) {
            MensajeSB(2, "Falta completar Fecha de Nacimiento");
        } else if (jtDni.getText().length() != 8) {
            MensajeSB(2, "Debe ser un DNI valido 8 Digitos");
            jtDni.requestFocus();
            jtDni.selectAll();
        } else if (aluData.buscarAlumnoPorDni(Integer.parseInt(jtDni.getText())) != null) {
            MensajeSB(2, "El DNI ya esta utilizado en otro alumno");
            jtDni.requestFocus();
            jtDni.selectAll();
        } else if (PruebaDeCaracteres(jtApellido.getText()) == false) {
            jtApellido.requestFocus();
            jtApellido.selectAll();
        } else if (PruebaDeCaracteres(jtNombre.getText()) == false) {
            jtNombre.requestFocus();
            jtNombre.selectAll();
        } else {
            try {
                LocalDate fechan = jdcFechaNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                Alumno alumno = new Alumno(
                        Integer.parseInt(jtDni.getText()),
                        jtApellido.getText(),
                        jtNombre.getText(),
                        fechan,
                        true);

                // Primero busco si existe para no agregarlo repetido y lo
                // inserto al alumno
                aluData.guardarAlumno(alumno);
                // Si lo agregue con exito no es null y se lo informo al DataEntry
                if (aluData.buscarAlumnoPorDni(Integer.parseInt(jtDni.getText())) != null) {
                    MensajeSB(1, "Alumno agregado con exito! Busque por DNI o cargue un nuevo Alumno");
                    LimpiarCampos();
                } else {
                    MensajeSB(2, "ERROR: El alumno no se pudo agregar");
                }
            } catch (NumberFormatException e) {
                MensajeSB(2, "El DNI debe ser un número");
                jtDni.requestFocus();
                jtDni.selectAll();
            }
        }
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        try {
            if (jtDni.getText().length() != 8) {
                MensajeSB(2, "Debe ser un DNI valido 8 Digitos");
                jtDni.requestFocus();
                jtDni.selectAll();
            } else {
                // Busco alumno por DNI
                Alumno alumno = aluData.buscarAlumnoPorDni(Integer.parseInt(jtDni.getText()));
                // Busco si el alumno no esta vacio
                if (alumno != null) {
                    jtid.setText(alumno.getIdAlumno() + "");
                    jtApellido.setText(alumno.getApellido());
                    jtNombre.setText(alumno.getNombre());
                    jdcFechaNacimiento.setDate(Date.from(alumno.getFechaNacimiento().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                    if (alumno.isEstado() == true) {
                        jrbEstado.setSelected(true);
                        jbGuardar.setEnabled(true);
                        jbEliminar.setEnabled(true);
                        jbNuevo.setEnabled(false);
                        MensajeSB(1, "Alumno encontrado");
                    } else {
                        MensajeSB(2, "El DNI no es de un Alumno activo");
                    }
                } else {
                    MensajeSB(2, "El DNI no es de un Alumno activo");
                    jtDni.requestFocus();
                    jtDni.selectAll();
                }
            }
        } catch (NumberFormatException e) {
            MensajeSB(2, "El DNI debe ser un número");
            jtDni.requestFocus();
            jtDni.selectAll();
        }
    }//GEN-LAST:event_jbBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JDateChooser jdcFechaNacimiento;
    private javax.swing.JLabel jlStatusBar;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtid;
    // End of variables declaration//GEN-END:variables

    public void LimpiarCampos() {
        jtDni.setText("");
        jtApellido.setText("");
        jtNombre.setText("");
        jrbEstado.setSelected(false);
        jdcFechaNacimiento.setDate(null);
        jtid.setText("");
        jbGuardar.setEnabled(false);
        jbEliminar.setEnabled(false);
    }

    public void MensajeSB(int color, String mensaje) {

        // Los valores pueden variar de 0 a 255
        if (color == 1) {
            // Si el color es igual a 1 entonces es = a verde
            // En este caso Red = 0, Green = 153, Blue = 102.
            jlStatusBar.setForeground(new Color(0, 153, 102));
        } else if (color == 2) {
            // Si el color es igual a 2 entonces es = a rojo
            // Los valores pueden variar de 0 a 255. En este caso Red = 153, Green = 51, Blue = 0.
            jlStatusBar.setForeground(new Color(255, 50, 0));
        }
        // Aquí cargo el texto del mensaje en el Label
        // Si el texto del mensaje esta vacio entonces no muestro texto en
        // el Label pero limpio el texto anterior que pueda haber quedado
        jlStatusBar.setText(mensaje);
    }

    public boolean PruebaDeCaracteres(String texto) {
        // Busco si los caracteres ingresados son letras
        int b = 0;
        int i = 0;
        for (i = 0; i < texto.length(); i++) {
            if (!(texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') && !(texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') && texto.charAt(i) != ' ') {
                b++;
            }
        }
        if (b > 0 || texto.isEmpty()) {
            MensajeSB(2, "Los campos Nombre y Apellido deben completarse con letras");
            return false;
        } else {
            return true;
        }

    }
}

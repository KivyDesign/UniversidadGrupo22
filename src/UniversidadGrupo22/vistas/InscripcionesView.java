/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadGrupo22.vistas;

import UniversidadGrupo22.accesoADatos.AlumnoData;
import UniversidadGrupo22.accesoADatos.InscripcionData;
import UniversidadGrupo22.accesoADatos.MateriaData;
import UniversidadGrupo22.entidades.Alumno;
import UniversidadGrupo22.entidades.Inscripcion;
import UniversidadGrupo22.entidades.Materia;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author javier
 */
public class InscripcionesView extends javax.swing.JInternalFrame {

    // Declaro el modelo que hereda de DefaultTableModel
    private DefaultTableModel modelo;
    
    private AlumnoData alumnoData;
    private List<Alumno> listarAlumnos;
    private MateriaData materiaData;
    private InscripcionData inscripcionData;

    /**
     * Creates new form InscripcionesView
     */
    public InscripcionesView() {
        initComponents();
        
        // Inicializo el nuevo modelo para acceder a los metodos de
        // DefaultTableModel()
        modelo = new DefaultTableModel();

//        // Quito la barra de titulo del JInternalFrame
//        //((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
//        // Quito los bordes de la ventana
//        //this.setBorder(null);
//        putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
//        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
//        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
//        this.setBorder(null);

        // Inicializo el acceso a los datos de las tablas alumno e inscripción
        // que se utilizan en este Frame interno
        alumnoData = new AlumnoData();
        listarAlumnos = alumnoData.listarAlumnos();
        inscripcionData = new InscripcionData();
        
        // Cargo los alumnos que necesito mostrar en el ComboBox
        // La idea es que por defecto se carguen los alumnos activos con el
        // flag de estado = 1
        cargarAlumnos();
        
        // Defino el jrbMateriasNoInscriptas como seleccionado y cargo los
        // datos de las materias en las que el alumno que este seleccionado en
        // el ComboBox no este inscripto aún
        //jrbMateriasNoInscriptas.setSelected(true);
        RadioButtonNoInscriptos();
        
        // Armo la cabecera de la tabla para que se lean bien los campos ID,
        // Nombre y Año que necesito mostrarle al usuario para que seleccione
        // una materia asi puede inscribir o desinscribir un alumno
        armarCabeceraDeLaTabla();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbSeleccioneAlumno = new javax.swing.JComboBox<>();
        jrbMateriasInscriptas = new javax.swing.JRadioButton();
        jrbMateriasNoInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jbInscribir = new javax.swing.JButton();
        jbAnularInscripcion = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jlStatusBar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setTitle("Formulario de Inscripciones");

        jPanel1.setBackground(new java.awt.Color(36, 86, 109));

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seleccione un Alumno:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Listado de Materias");

        jrbMateriasInscriptas.setForeground(new java.awt.Color(255, 255, 255));
        jrbMateriasInscriptas.setText("Materias Inscriptas");
        jrbMateriasInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMateriasInscriptasActionPerformed(evt);
            }
        });

        jrbMateriasNoInscriptas.setForeground(new java.awt.Color(255, 255, 255));
        jrbMateriasNoInscriptas.setText("Materias No Inscriptas");
        jrbMateriasNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMateriasNoInscriptasActionPerformed(evt);
            }
        });

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Año"
            }
        ));
        jScrollPane1.setViewportView(jtMaterias);

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jbInscribir.setBackground(new java.awt.Color(194, 165, 121));
        jbInscribir.setText("Inscribir");
        jbInscribir.setEnabled(false);
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        jbAnularInscripcion.setBackground(new java.awt.Color(194, 165, 121));
        jbAnularInscripcion.setText("Anular Inscripción");
        jbAnularInscripcion.setEnabled(false);
        jbAnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularInscripcionActionPerformed(evt);
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

        jlStatusBar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlStatusBar.setForeground(new java.awt.Color(0, 153, 102));
        jlStatusBar.setText("Barra de estado");
        jlStatusBar.setToolTipText("zxy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlStatusBar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(45, 65, 88));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Formulario de Inscripción");

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Bienvenido de Vuelta");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Seleccione una materia para inscribir o desinscribir un alumno");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrbMateriasNoInscriptas))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbInscribir)
                                .addGap(85, 85, 85)
                                .addComponent(jbAnularInscripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbSalir))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jrbMateriasInscriptas)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcbSeleccioneAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jSeparator1))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jcbSeleccioneAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMateriasInscriptas)
                    .addComponent(jrbMateriasNoInscriptas))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInscribir)
                    .addComponent(jbAnularInscripcion)
                    .addComponent(jbSalir))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbMateriasNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMateriasNoInscriptasActionPerformed
        // Ejecuto todo en un metodo para mejorar la logica y poder reutilizar
        // el codigo desde varios eventos
        RadioButtonNoInscriptos();
    }//GEN-LAST:event_jrbMateriasNoInscriptasActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // Código para cerrar una ventana
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jrbMateriasInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMateriasInscriptasActionPerformed
        // Ejecuto todo en un metodo para mejorar la logica y poder reutilizar
        // el codigo desde varios eventos
        RadioButtonInscriptos();
    }//GEN-LAST:event_jrbMateriasInscriptasActionPerformed

    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
        // Quiero el alumno seleccionado en el ComboBox
        Alumno alu = (Alumno) jcbSeleccioneAlumno.getSelectedItem();

        // Cargo la fila que seleccione
        int filaSeleccionada = jtMaterias.getSelectedRow();

        // Aqui quiero saber si hay una fila seleccionada y si el ComboBox no
        // esta vacio que seria null si esta vacio
        if (filaSeleccionada != -1 && alu != null) {
            // Extraigo del modelo con getValueAt los datos que me interesan
            // y los casteo al tipo de dato que necesito
            int idMateria = (Integer) modelo.getValueAt(filaSeleccionada, 0);
            String nombreMateria = (String) modelo.getValueAt(filaSeleccionada, 1);
            int anio = (Integer) modelo.getValueAt(filaSeleccionada, 2);

            // Compongo el Object mat con los datos de la materia
            Materia mat = new Materia(idMateria, nombreMateria, anio, true);

            // Compongo el Object inscribir con los objetos alumno y materia
            // El valor -1 significa que aún no tiene nota en esa materia
            // en la que se inscribe el alumno
            Inscripcion inscribir = new Inscripcion(-1, alu, mat);

            // Por fin lo inscribo al alumno en la materia seleccionada
            inscripcionData.guardarInscripcion(inscribir);

            // Limpio el desastre
            borrarFilasTabla();
            
            // Aqui seria buen idea recargar el modelo y con el la jTable
            // jtMaterias para que refleje al usuario las materias en las que
            // aún no se inscribio
        } else {
//            JOptionPane.showMessageDialog(null, "Primero seleccione un Alumno y una Materia");
            // Prueba de concepto StatusBar ----------------------------------------
            PruebaDeConceptoStatusBar(2, "Primero seleccione un Alumno y una Materia");
            // ---------------------------------------------------------------------
        }
    }//GEN-LAST:event_jbInscribirActionPerformed

    private void jbAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularInscripcionActionPerformed
        // Quiero el alumno seleccionado en el ComboBox
        Alumno alu = (Alumno) jcbSeleccioneAlumno.getSelectedItem();

        // Cargo la fila que seleccione
        int filaSeleccionada = jtMaterias.getSelectedRow();

        // Aqui quiero saber si hay una fila seleccionada y si el ComboBox no
        // esta vacio, que seria null si esta vacio (O)bvio
        if (filaSeleccionada != -1 && alu != null) {
            // Extraigo del modelo con getValueAt los datos que me interesan
            // y los casteo al tipo de dato que necesito
            int idMateria = (Integer) modelo.getValueAt(filaSeleccionada, 0);

            // Por fin lo Des(inscribo) al alumno en la materia seleccionada
            inscripcionData.borrarInscripcionMateriaAlumno(alu.getIdAlumno(), idMateria);

            // Limpio el desastre
            borrarFilasTabla();

            // Aqui deberia aprovechar y cargar una nueva lista de matrias en
            // la que el alumno aún no se Des(inscribo). De esta forma no
            // quedaria el jTable vacio, que es poco profesional de nuestra
            // parte obligar al DataEntry a alegir al alumno en el ComboBox
            // para refrescar las materias en las que sigue inscripto
        } else {
            // En caso de que no este seleccionado un alumno y una materia,
            // entonces muestro este molesto dialogo para que se acuerden de
            // nosotros. La idea de una barra de estado seria muy bien apreciada
            // a la altura del desarrollo de este proyecto
//            JOptionPane.showMessageDialog(null, "Primero seleccione un Alumno y una Materia");
            // Prueba de concepto StatusBar ----------------------------------------
            PruebaDeConceptoStatusBar(2, "Primero seleccione un Alumno y una Materia");
            // ---------------------------------------------------------------------
        }
    }//GEN-LAST:event_jbAnularInscripcionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbAnularInscripcion;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbSeleccioneAlumno;
    private javax.swing.JLabel jlStatusBar;
    private javax.swing.JRadioButton jrbMateriasInscriptas;
    private javax.swing.JRadioButton jrbMateriasNoInscriptas;
    private javax.swing.JTable jtMaterias;
    // End of variables declaration//GEN-END:variables

    public void cargarInscriptos() {
        // Primero me aseguro de que esten limpias las filas de la tabla
        borrarFilasTabla();

        Alumno seleccionado = (Alumno) jcbSeleccioneAlumno.getSelectedItem();
        if (seleccionado != null) {
            ArrayList<Materia> lista = (ArrayList) inscripcionData.obtenerMateriasInscriptas(seleccionado);

            for (Materia mat : lista) {
                modelo.addRow(new Object[]{mat.getIdMateria(), mat.getNombre(), mat.getAnioMateria()});
            }
        } else {
            // Prueba de concepto StatusBar ----------------------------------------
            PruebaDeConceptoStatusBar(2, "Seleccione primero un alumno");
            // ---------------------------------------------------------------------
//            JOptionPane.showMessageDialog(null, "Seleccione primero un alumno");
        }
    }

    public void cargarNoInscriptos() {
        // Primero me aseguro de que esten limpias las filas de la tabla
        borrarFilasTabla();

        Alumno seleccionado = (Alumno) jcbSeleccioneAlumno.getSelectedItem();
        if (seleccionado != null) {
            ArrayList<Materia> lista = (ArrayList) inscripcionData.obtenerMateriaNoInscriptas(seleccionado);

            for (Materia mat : lista) {
                modelo.addRow(new Object[]{mat.getIdMateria(), mat.getNombre(), mat.getAnioMateria()});
            }
        } else {
            // Prueba de concepto StatusBar ----------------------------------------
            PruebaDeConceptoStatusBar(2, "Seleccione primero un alumno");
            // ---------------------------------------------------------------------
//            JOptionPane.showMessageDialog(null, "Seleccione primero un alumno");
        }
    }

    public void cargarAlumnos() {
        // Cargamos los alumnos en el ComboBox
        for (Alumno listarAlumno : listarAlumnos) {
            //System.out.println(listarAlumno.getIdAlumno() + " " + listarAlumno.getNombre() + " " + listarAlumno.getApellido());
            jcbSeleccioneAlumno.addItem(listarAlumno);
        }
    }

    public void armarCabeceraDeLaTabla() {
        // Al modelo le agregamos las siguientes columnas:
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");

        // Y a nuestra Tabla le seteamos el modelo
        jtMaterias.setModel(modelo);

        // Ajusto el tamaño de las columnas de la tabla
        jtMaterias.getColumnModel().getColumn(0).setPreferredWidth(30);
        jtMaterias.getColumnModel().getColumn(1).setPreferredWidth(220);
        jtMaterias.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    public void borrarFilasTabla() {
        // Con este metodo puedo borrar una fila especifica al recorrer el modelo
        // Controlar que no este vacio o cargarlo desde el comienzo
        if (modelo != null) {
            int a = modelo.getRowCount() - 1;
            
            if (modelo.getRowCount() > 0) {
                for (int i = a; i >= 0; i--) {
                    modelo.removeRow(i);
                }
            }

        }
    }

    public void borrarFilasTablaEze() {
        int nFilas = modelo.getRowCount() - 1;

        for (int i = nFilas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    // /////////////////////////////////////////////////////////////////////////
    // Aqui centralizo el manejo de los botones de radio, bien lejos de los
    // ActionPerformed
    // /////////////////////////////////////////////////////////////////////////
    public void RadioButtonNoInscriptos() {
        // Deselecciono el jrbMateriasInscriptas
        jrbMateriasInscriptas.setSelected(false);
        
        // Selecciono el jrbMateriasNoInscriptas
        jrbMateriasNoInscriptas.setSelected(true);

        // Activo el boton Inscribir
        jbInscribir.setEnabled(true);

        // Desactivo el boton Anular Inscripción
        jbAnularInscripcion.setEnabled(false);

        // Prueba de concepto StatusBar ----------------------------------------
        PruebaDeConceptoStatusBar(2,"Se selecciono jrbMateriasNoInscriptasActionPerformed");
        // ---------------------------------------------------------------------

        // Cargo la jTable jtMaterias con las materias en las que el alumno no
        // se inscribio utilizando el metodo:
        cargarNoInscriptos();
    }
    
    public void RadioButtonInscriptos() {
        // Deselecciono el jrbMateriasNoInscriptas
        jrbMateriasNoInscriptas.setSelected(false);
        
        // Selecciono el jrbMateriasInscriptas
        jrbMateriasInscriptas.setSelected(true);

        // Desactivo el boton Inscribir
        jbInscribir.setEnabled(false);

        // Activo el boton Anular Inscripción
        jbAnularInscripcion.setEnabled(true);

        // Prueba de concepto StatusBar ----------------------------------------
        PruebaDeConceptoStatusBar(1, "Se selecciono jrbMateriasInscriptasActionPerformed");
        // ---------------------------------------------------------------------

        // Cargo la jTable jtMaterias con las materias en las que el alumno se
        // inscribio utilizando el metodo:
        cargarInscriptos();
    }
    
    public void PruebaDeConceptoStatusBar(int color, String mensaje) {
        // Prueba de concepto StatusBar ----------------------------------------
        
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
}

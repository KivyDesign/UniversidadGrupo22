/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadGrupo22.vistas;

import UniversidadGrupo22.accesoADatos.AlumnoData;
import UniversidadGrupo22.accesoADatos.InscripcionData;
import UniversidadGrupo22.entidades.Alumno;
import UniversidadGrupo22.entidades.Materia;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author javier
 */
public class ActualizacionDeNotasView extends javax.swing.JInternalFrame {

    // Declaro e Inicializo el modelo que hereda de DefaultTableModel
    // para acceder a sus metodos
    private DefaultTableModel modelo = new DefaultTableModel() {

        // Clase Interna Anónima
        public boolean isCellEditable(int fila, int columna) {

            // Si retorno true las celdas son todas editables, con false
            // ninguna celda es editable
            if (columna == 2) {
                return true;
            }
            return false;
        }
    };
    private AlumnoData aluData;
    private InscripcionData insData;
    private ArrayList<Alumno> listarAlumnos;
    private int idAlu;
    private double nuevaNota;
    private int idMat;

    /**
     * Creates new form ActualizacionDeNotasView
     */
    public ActualizacionDeNotasView() {
        initComponents();
        
        // Inicializo el acceso a los datos de las tablas alumno e inscripción
        aluData = new AlumnoData();
        insData = new InscripcionData();
        
        // Con el aluData inicializado puedo llenar el ArrayList a través del
        // siguiente método:
        listarAlumnos = aluData.listarAlumnos();

        // Cargo los alumnos que necesito mostrar en el ComboBox
        cargarAlumnos();

        // Armo la cabecera de la tabla para que se lean bien los campos ID,
        // Nombre y Nota que necesito mostrarle al usuario
        armarCabeceraDeLaTabla();

        // En el jTable se cargan las materias por defecto
        cargarMaterias();
        
        // Al modelo de nuestra jTable le agrego un ListSelectionListener para 
        // operar sobre la celda seleccionada
        listSelectionListener();
        
        // Al modelo de la jTable le agrego un ListModelListener que me permite
        // operar sobre los cambios realizados en una celda
        anadeListenerAlModelo();

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtNotas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jlStatusBar = new javax.swing.JLabel();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 155, 255));
        setTitle("Carga de Notas");

        jPanel1.setBackground(new java.awt.Color(36, 86, 109));
        jPanel1.setPreferredSize(new java.awt.Dimension(448, 87));

        jtNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtNotas);

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccione un alumno:");

        jcbAlumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbAlumnoItemStateChanged(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(45, 65, 88));

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Carga de Notas");

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Bienvenido de Vuelta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(45, 65, 88));

        jlStatusBar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jlStatusBar.setForeground(new java.awt.Color(0, 153, 102));
        jlStatusBar.setText("Mensaje de prueba");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlStatusBar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jlStatusBar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jbGuardar.setBackground(new java.awt.Color(194, 165, 121));
        jbGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(194, 165, 121));
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jbGuardar)
                        .addGap(82, 82, 82)
                        .addComponent(jbSalir)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addGap(51, 51, 51)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed

        insData.actualizarNota(nuevaNota, idAlu, idMat);

    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcbAlumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbAlumnoItemStateChanged
        cargarMaterias();

    }//GEN-LAST:event_jcbAlumnoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumno;
    private javax.swing.JLabel jlStatusBar;
    private javax.swing.JTable jtNotas;
    // End of variables declaration//GEN-END:variables

    public void cargarAlumnos() {
        jcbAlumno.removeAllItems();
        // Cargamos los alumnos en el ComboBox
        for (Alumno listar : listarAlumnos) {
            jcbAlumno.addItem(listar);
        }
    }

    public void armarCabeceraDeLaTabla() {
        // =====================================================================
        // Creación del metodo para modificar las caracteristicas de la Tabla
        // =====================================================================

        // Al modelo le agregamos las siguientes columnas:
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");

        // Y a nuestra Tabla le seteamos el modelo
        jtNotas.setModel(modelo);

        jtNotas.getColumnModel().getColumn(0).setPreferredWidth(100);
        jtNotas.getColumnModel().getColumn(1).setPreferredWidth(150);
        jtNotas.getColumnModel().getColumn(2).setPreferredWidth(80);
    }

    public void cargarMaterias() {
        // Limpio las filas de la tabla
        borrarFilasTabla();

        Alumno seleccionada = (Alumno) jcbAlumno.getSelectedItem();

        idAlu = seleccionada.getIdAlumno();

        if (seleccionada != null) {
            ArrayList<Object[]> lista = (ArrayList) insData.obtenerMateriasCursadasAriel(idAlu);

            for (Object[] fila : lista) {
                modelo.addRow(fila);

            }
        } else {
//            JOptionPane.showMessageDialog(null, "Seleccione primero un alumno");
            MensajeSB(1,"Seleccione primero un alumno");
        }
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

    public void anadeListenerAlModelo() {
        System.out.println("entró al anadelistener");
        jtNotas.getModel().addTableModelListener(new TableModelListener() {
            //Object valorViejo = jtNotas.getValueAt(jtNotas.getSelectedRow(), jtNotas.getSelectedColumn());
            @Override
            public void tableChanged(TableModelEvent evento) {
                System.out.println("entro al tableChanged");
                cambioNota(evento);
            }
        });
    }

    public void cambioNota(TableModelEvent evento) {
        System.out.println("entro al cambioNota");
        // Solo se trata el evento UPDATE, correspondiente al cambio de valor
        // de una celda.
        if (evento.getType() == TableModelEvent.UPDATE) {

            // Se obtiene el modelo de la tabla y la fila/columna que han cambiado.
            //TableModel modelo = ((TableModel) (evento.getSource()));
            int fila = evento.getFirstRow();
            int columna = evento.getColumn();

            try {
                Object nueva = jtNotas.getValueAt(fila, columna);
                double pars = Double.parseDouble(nueva.toString());
                if (pars >= 0 && pars <= 10) {
                    nuevaNota = pars;
                } else {
//                    JOptionPane.showMessageDialog(null, "El valor ingresado no es válido(0-10)");
                    MensajeSB(1,"El valor ingresado no es válido(0-10)");
                    jtNotas.setValueAt(nuevaNota, fila, columna);
                }

            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null, "El valor ingresado no es válido");
                MensajeSB(1,"El valor ingresado no es válido");
                jtNotas.setValueAt(nuevaNota, fila, columna);
            }
            idMat = (int) jtNotas.getValueAt(fila, 0);
        }
    }

    public void listSelectionListener() {
//        JTable tabla = jtNotas;
//        ListSelectionModel modeloSeleccion = jtNotas.getSelectionModel();
        jtNotas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evento) {

                int filaSeleccionada = jtNotas.getSelectedRow();
                int columnaSeleccionada = jtNotas.getSelectedColumn();

                if (jtNotas.isCellEditable(filaSeleccionada, columnaSeleccionada) && filaSeleccionada >= 0 && columnaSeleccionada >= 0) {
                    Object valor = jtNotas.getValueAt(filaSeleccionada, columnaSeleccionada);
                    nuevaNota = Double.parseDouble(valor.toString());
                }

            }
        });
    }

    public void MensajeSB(int color, String mensaje) {
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
        } else if (color == 3) {
            // Usado al iniciar el Form para que no se vea el texto dummy 45,65,88
            jlStatusBar.setForeground(new Color(45, 65, 88));
        }
        // Aquí cargo el texto del mensaje en el Label
        // Si el texto del mensaje esta vacio entonces no muestro texto en
        // el Label pero limpio el texto anterior que pueda haber quedado
        jlStatusBar.setText(mensaje);
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadGrupo22.vistas;

import UniversidadGrupo22.accesoADatos.MateriaData;
import UniversidadGrupo22.entidades.Materia;
import java.awt.Color;

/**
 *
 * @author javier
 */
public class GestionDeMateriasView extends javax.swing.JInternalFrame {

    private MateriaData matData;

    public GestionDeMateriasView() {
        initComponents();
        matData = new MateriaData();
        jbGuardar.setEnabled(false);
        jbEliminar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jRestadoMat = new javax.swing.JRadioButton();
        jBbuscar = new javax.swing.JButton();
        jtNombre = new javax.swing.JTextField();
        jtCodigo = new javax.swing.JTextField();
        jtAnio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jStatusBar = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setTitle("Gestión de Materias");

        jPanel1.setBackground(new java.awt.Color(36, 86, 109));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jRestadoMat.setForeground(new java.awt.Color(255, 255, 255));
        jRestadoMat.setText("Activo");

        jBbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/32x32.png"))); // NOI18N
        jBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Año:");

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado:");

        jbSalir.setBackground(new java.awt.Color(194, 165, 121));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbGuardar.setBackground(new java.awt.Color(194, 165, 121));
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbEliminar.setBackground(new java.awt.Color(194, 165, 121));
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbNuevo.setBackground(new java.awt.Color(194, 165, 121));
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(45, 65, 88));
        jPanel2.setPreferredSize(new java.awt.Dimension(124, 79));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Formulario de Materia");

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Bienvenido de Vuelta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(45, 65, 88));

        jStatusBar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jStatusBar.setForeground(new java.awt.Color(0, 153, 102));
        jStatusBar.setText("Ingrese el ID de la materia a buscar o Complete los datos para una nueva");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jStatusBar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtNombre)
                            .addComponent(jtAnio, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(jRestadoMat, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtCodigo))
                        .addGap(35, 35, 35)
                        .addComponent(jBbuscar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jbNuevo)
                            .addGap(63, 63, 63)
                            .addComponent(jbGuardar)
                            .addGap(46, 46, 46)
                            .addComponent(jbEliminar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbSalir))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRestadoMat)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbGuardar)
                    .addComponent(jbEliminar)
                    .addComponent(jbSalir))
                .addGap(42, 42, 42)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        try {
            if (jtAnio.getText().isEmpty() || jtNombre.getText().isEmpty()) {
                MensajeSB(2, "Los campos deben ser completados");
                jtNombre.requestFocus();
                jtNombre.selectAll();
            } else if (!jtCodigo.getText().isEmpty()) {
                MensajeSB(2, "El campo ID se asigna automaticamente cuando la materia es nueva");
                jtCodigo.setText("");
            } else if (Integer.parseInt(jtAnio.getText()) > 7 || Integer.parseInt(jtAnio.getText()) < 1) {
                MensajeSB(2, "El año debe ser un numero entre 1 y 7");
            } else if (PruebaDeCaracteres(jtNombre.getText()) == false) {
                jtNombre.requestFocus();
                jtNombre.selectAll();
            } else {
                Materia mat = new Materia(jtNombre.getText(), Integer.parseInt(jtAnio.getText()), true);
                matData.guardarMateria(mat);
                MensajeSB(1, "Materia agregada con exito, busque por ID o ingrese datos de una nueva");
                LimpiarCampos();
            }
        } catch (NumberFormatException e) {
            MensajeSB(2, "El año debe ser un número entre 1 y 7");
        }
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            matData.eliminarMateria(Integer.parseInt(jtCodigo.getText()));
            MensajeSB(1, "Materia eliminada con exito, busque por ID o ingrese datos de una nueva");
            jRestadoMat.setSelected(false);
            jbNuevo.setEnabled(true);
            jtCodigo.setEditable(true);
        } catch (NumberFormatException e) {
            MensajeSB(2, "El id debe ser un número");
            jtCodigo.requestFocus();
            jtCodigo.selectAll();
        }
        LimpiarCampos();
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        jRestadoMat.setEnabled(false);
        try {
            Materia materia = matData.buscarMateria(Integer.parseInt(jtCodigo.getText()));
            if (materia == null) {
                MensajeSB(2, "El ID debe ser de una Materia activa");
                jtCodigo.requestFocus();
                jtCodigo.selectAll();
            } else if (jtAnio.getText().isEmpty() || jtNombre.getText().isEmpty()) {
                MensajeSB(2, "Los campos deben ser completados");
                jtNombre.requestFocus();
                jtNombre.selectAll();
            } else if (Integer.parseInt(jtAnio.getText()) > 7 || Integer.parseInt(jtAnio.getText()) < 1) {
                MensajeSB(2, "El año debe ser un número entre 1 y 7");
                jtAnio.requestFocus();
                jtAnio.selectAll();
            } else if (PruebaDeCaracteres(jtNombre.getText()) == false) {
                jtNombre.requestFocus();
                jtNombre.selectAll();
            } else if (materia != null) {
                materia.setNombre(jtNombre.getText());
                materia.setAnioMateria(Integer.parseInt(jtAnio.getText()));
                matData.modificarMateria(materia);
                MensajeSB(1, "Materia guardada con exito, busque por ID o ingrese datos de una nueva");
                LimpiarCampos();
                jbNuevo.setEnabled(true);
                jtCodigo.setEditable(true);
            }
        } catch (NumberFormatException e) {
            MensajeSB(2, "El ID y el año deben ser un numero");
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarActionPerformed
        try {
            Materia materia = matData.buscarMateria(Integer.parseInt(jtCodigo.getText()));
            
            if (materia != null) {
                jtNombre.setText(materia.getNombre());
                jtAnio.setText(materia.getAnioMateria() + "");
                MensajeSB(1, "Materia Encontrada");
                jRestadoMat.setSelected(true);
                jbGuardar.setEnabled(true);
                jbEliminar.setEnabled(true);
                jtCodigo.setEditable(false);
                jbNuevo.setEnabled(false);
            } else {
                MensajeSB(2, "El id debe ser de una Materia activa");
                jtCodigo.requestFocus();
                jtCodigo.selectAll();
            }
        } catch (NumberFormatException e) {
            MensajeSB(2, "El id debe ser un numero");
            jtCodigo.requestFocus();
            jtCodigo.selectAll();
        }
    }//GEN-LAST:event_jBbuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRestadoMat;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jStatusBar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTextField jtAnio;
    private javax.swing.JTextField jtCodigo;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables

    public void LimpiarCampos() {
        jtNombre.setText("");
        jtAnio.setText("");
        jtCodigo.setText("");
        jRestadoMat.setSelected(false);
        jbGuardar.setEnabled(false);
        jbEliminar.setEnabled(false);
    }

    public boolean PruebaDeCaracteres(String texto) {
        int b = 0;
        int i = 0;
        for (i = 0; i < texto.length(); i++) {
            if (!(texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z')
                    && !(texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z')
                    && !(texto.charAt(i) >= '1' && texto.charAt(i) <= '9') && texto.charAt(i) != ' ' && texto.charAt(i) != '.') {
                b++;
            }
        }
        if (b > 0) {
            MensajeSB(2, "El campo nombre solo debe tener letras y números");
            return false;
        } else {
            return true;
        }
    }

    public void MensajeSB(int color, String mensaje) {
        // Los valores pueden variar de 0 a 255
        if (color == 1) {
            // Si el color es igual a 1 entonces es = a verde
            // En este caso Red = 0, Green = 153, Blue = 102.
            jStatusBar.setForeground(new Color(0, 153, 102));
        } else if (color == 2) {
            // Si el color es igual a 2 entonces es = a rojo
            jStatusBar.setForeground(new Color(255, 50, 0));
        }
        jStatusBar.setText(mensaje);
    }
}

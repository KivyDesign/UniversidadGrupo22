/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadGrupo22.vistas;

import UniversidadGrupo22.accesoADatos.AlumnoData;
import UniversidadGrupo22.accesoADatos.Conexion;
import UniversidadGrupo22.entidades.Alumno;
import java.awt.Color;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

// Las 2 clases necesarias para usar regex
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Guido Sosa
 */
public class X01FormView extends javax.swing.JFrame {

    // Declaro los atributos para acceder a los metodos que necesito
    // Para alumno
    private AlumnoData aluData;

    // Para el modelo de la tabla
    private DefaultTableModel modelo;

    private ArrayList<Alumno> listarAlumnos;

    private int seleccionFilaEnLaTabla;

    /**
     * Creates new form X01FormView
     */
    public X01FormView() {
        initComponents();

        // Aqui los conecto a los metodos
        modelo = (DefaultTableModel) jtAlumnos.getModel();
        aluData = new AlumnoData();
        listarAlumnos = aluData.listarAlumnos();

        // =====================================================================
        // Realizo la coneccion a la DB
        Connection con = Conexion.getConexion();

        // Si la conexion fue exitosa lo informo como conectado con un (sout)
        // para no tener ese molesto dialogo de conexion
        if (con != null) {
            this.setTitle("Sistema de Gestión para la Universidad de La Punta - Estado: Conectado");
        } else {
            this.setTitle("Sistema de Gestión para la Universidad de La Punta - Estado: Error");
        }

        // Centro la ventana en la pantalla
        this.setLocationRelativeTo(this);

        // =====================================================================
        
        // Prueba de concepto StatusBar ----------------------------------------
        PruebaDeConceptoStatusBar(3, "Mensaje");
        // ---------------------------------------------------------------------
        
        // Cargar alumnos en el ComboBox
        cargarAlumnos();

        // Cargo el alumno en los TextFiels
        cargarAlumnoTF();

        // Armo la cabecera de la tabla
        armarCabeceraDeLaTabla();

        // Cargar alumnos en la tabla
        cargarTabla();
    }

    public void cargarAlumnos() {
        // Remuevo todos los items del comboBox
        jcbCargarAlumnos.removeAllItems();

        // Pido que desde aquí se seleccione un alumno
//        jcbCargarAlumnos.addItem("Seleccione un alumno");
        // Elimina el primer item.
//        jcbCargarAlumnos.removeItemAt(0);
        // Recorro la lista de alumnos y voy agregando cada item en el ComboBox
        aluData.listarAlumnos().forEach(item -> {
            jcbCargarAlumnos.addItem(item.getIdAlumno() + " - " + item.getApellido() + " " + item.getNombre() + " " + item.getDni());
//            System.out.println(item.getIdAlumno());
        });
        // ---------------------------------------------------------------------
        // Busco el ID en la cadena de texto
        // https://es.stackoverflow.com/questions/123704/c%C3%B3mo-extraer-parte-de-una-cadena-seg%C3%BAn-un-patr%C3%B3n
        // 
//        System.out.println("String seleccionada: " + jcbCargarAlumnos.getSelectedItem());
//        System.out.println(jcbCargarAlumnos.getSelectedItem().toString());
        // En tu código sería:
        //     String cadena = JTextField.getText();
        // Pero como ejemplo, lo asignamos a:
        String cadena = jcbCargarAlumnos.getSelectedItem().toString();

        // Compilamos el regex y el matcher al texto, ignorando mayúsculas/minúsculas (esto es estándar)
        Pattern pattern = Pattern.compile("([0-9]+) - ", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cadena);

        // Ahora sí, vemos si coincide el patrón con el texto
        if (matcher.find()) {
            // Coincidió => obtener el valor del grupo 1
            String obtengoID = matcher.group(1);
//            System.out.println("ID: " + obtengoID);
            // Aqui intento buscar y cargar los datos segun lo que se seleccione
            // en el ComboBox
            cargarCampos(Integer.parseInt(obtengoID));
        } else {
            // No coincidió
            System.out.println("No enontre el ID");
        }
        // ---------------------------------------------------------------------
//        // Cargamos los alumnos en el ComboBox
//        for (Alumno listarAlumno : listarAlumnos) {
//            System.out.println(listarAlumno.getIdAlumno() + " " + listarAlumno.getNombre() + " " + listarAlumno.getApellido());
//            jcbCargarAlumnos.addItem(listarAlumno.toString());
//        }
    }

    public void cargarAlumnoTF() {
        // Aqui según lo que encuentre, llamo al metodo con el DNI para que
        // busque y actualice los TextFields
        
        // Busco el alumno por el DNI
        Alumno alumno = aluData.buscarAlumnoPorDni(Integer.parseInt(jtfDNI.getText()));

        // Busco si el alumno no esta vacio
        jtfApellido.setText(alumno.getApellido());
        jtfNombre.setText(alumno.getNombre());
        jdcFechaNacimiento.setDate(Date.from(alumno.getFechaNacimiento().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        if (alumno.isEstado() == true) {
            jrbEstado.setSelected(true);
            // Existen otras formas tanto de colocar el texto en un RadioButton
            // como de configurar si este estará seleccionado por defecto
            // o el color del texto
            jrbEstado.setText("Activo");
            jrbEstado.setForeground(Color.white);
        } else if (alumno.isEstado() == false) {
            jrbEstado.setSelected(false);
            jrbEstado.setText("Inactivo");
            jrbEstado.setForeground(Color.gray);
        }
        seleccionarItemComboBox(Integer.parseInt(jtfDNI.getText()));
        
        // Prueba de concepto StatusBar ----------------------------------------
        PruebaDeConceptoStatusBar(1, "El DNI del Alumno se ha podido cargar con exito");
        // ---------------------------------------------------------------------
    }

    public void cargarCampos(int obtengoID) {
        // Aqui recibo el ID para buscar el alumno y cargar los campos de texto
        // Busco el alumno por el DNI
        Alumno alumno = aluData.buscarAlumnoPorID(obtengoID);

        // Busco si el alumno no esta vacio
        if (alumno != null) {
            jtfDNI.setText(String.valueOf(alumno.getDni()));
            jtfApellido.setText(alumno.getApellido());
            jtfNombre.setText(alumno.getNombre());
            jdcFechaNacimiento.setDate(Date.from(alumno.getFechaNacimiento().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            if (alumno.isEstado() == true) {
                jrbEstado.setSelected(true);
                // Existen otras formas tanto de colocar el texto en un
                // RadioButton como de configurar si este estará
                // seleccionado por defecto o el color del texto
                jrbEstado.setText("Activo");
                jrbEstado.setForeground(Color.white);
            } else if (alumno.isEstado() == false) {
                jrbEstado.setSelected(false);
                jrbEstado.setText("Inactivo");
                jrbEstado.setForeground(Color.gray);
            }
        }
    }

    public void cargarTabla() {
//        if (!aluData.listarAlumnos().isEmpty()) {
//            System.out.println(".");
//        }
//        for (Alumno alumno : aluData.listarAlumnos()) {
//            System.out.println("DNI: " + alumno.getDni());
//            System.out.println("Apellido: " + alumno.getApellido());
//            System.out.println("Nombre: " + alumno.getNombre());
//            System.out.println("Fecha de Nacimiento: " + alumno.getFechaNacimiento());
//        }
//        if (aluData.listarAlumnos().size() > 0) {
//            System.out.println(aluData.listarAlumnos());
//        }
        aluData.listarAlumnos().forEach(alumno -> {
            modelo.addRow(new Object[]{
                alumno.getIdAlumno(),
                alumno.getDni(),
                alumno.getApellido(),
                alumno.getNombre(),
                alumno.getFechaNacimiento(),
                alumno.isEstado()
            });
        });
    }

    public void armarCabeceraDeLaTabla() {
        // =====================================================================
        // Creación del metodo para modificar las caracteristicas de la Tabla
        // =====================================================================

        // Al modelo le agregamos las siguientes columnas:
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha Nacimiento");
        modelo.addColumn("Estado");

        // Y a nuestra Tabla le seteamos el modelo
        jtAlumnos.setModel(modelo);

        // Ajusto el tamaño de las columnas de la tabla
        jtAlumnos.getColumnModel().getColumn(0).setPreferredWidth(20);
        jtAlumnos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jtAlumnos.getColumnModel().getColumn(2).setPreferredWidth(100);
        jtAlumnos.getColumnModel().getColumn(3).setPreferredWidth(100);
        jtAlumnos.getColumnModel().getColumn(4).setPreferredWidth(100);
        jtAlumnos.getColumnModel().getColumn(5).setPreferredWidth(50);
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
        } else if (color == 3) {
            // Usado al iniciar el Form para que no se vea el texto dummy 45,65,88
            jlStatusBar.setForeground(new Color(45, 65, 88));
        }
        // Aquí cargo el texto del mensaje en el Label
        // Si el texto del mensaje esta vacio entonces no muestro texto en
        // el Label pero limpio el texto anterior que pueda haber quedado
        jlStatusBar.setText(mensaje);
    }

    public void seleccionarItemComboBox(int DNI) {
        // Aqui recibo un DNI, lo busco en la lista de alumnos agregados al
        // ComboBox y averigua su numero de item para marcarlo como
        // seleccionado
        System.out.println("DNI: " + DNI);

        // Cuantos items hay en el ComboBox?
//        int itemsEnElComboBox = jcbCargarAlumnos.getItemCount();
//        System.out.println("Items en el ComboBox: " + itemsEnElComboBox);
        // Recorro la lista de alumnos y voy leyendo cada item en el ComboBox
        aluData.listarAlumnos().forEach(item -> {
            if (DNI == item.getDni()) {
//                int obtengoID = item.getIdAlumno();
//                System.out.println(item.getIdAlumno());
                // Aqui intento buscar y cargar los datos segun lo que se
                // seleccione en el ComboBox
//                cargarCampos(obtengoID);

                // ERROR: getSelectedIndex() solo devuelve la opcion que este
                // seleccionada
                seleccionFilaEnLaTabla = jcbCargarAlumnos.getSelectedIndex();
//                return;
            }
        });

        // Pero como ejemplo, lo asignamos a:
        jcbCargarAlumnos.setSelectedIndex(seleccionFilaEnLaTabla);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfDNI = new javax.swing.JTextField();
        jtfApellido = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jrbEstado = new javax.swing.JRadioButton();
        jdcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();
        jcbCargarAlumnos = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
        jlSubTitle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jlStatusBar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(36, 86, 109));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Documento:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apellido:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estado:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de Nacimiento:");

        jrbEstado.setForeground(new java.awt.Color(255, 255, 255));
        jrbEstado.setText("Inactivo");

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/32x32.png"))); // NOI18N
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jtAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtAlumnos);

        jcbCargarAlumnos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCargarAlumnosItemStateChanged(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Alumno:");

        jPanel2.setBackground(new java.awt.Color(45, 65, 88));
        jPanel2.setPreferredSize(new java.awt.Dimension(567, 80));

        jlTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jlTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlTitle.setText("Formulario de Alumno");

        jlSubTitle.setForeground(new java.awt.Color(153, 153, 153));
        jlSubTitle.setText("Bienvenido de vuelta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jlTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlSubTitle)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(45, 65, 88));

        jlStatusBar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlStatusBar.setForeground(new java.awt.Color(0, 153, 102));
        jlStatusBar.setText("Texto de prueba");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jlStatusBar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jbNuevo)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jbGuardar)
                            .addGap(72, 72, 72)
                            .addComponent(jbEliminar)
                            .addGap(78, 78, 78)
                            .addComponent(jbSalir))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jrbEstado)
                                .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcbCargarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jtfNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfDNI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addComponent(jbBuscar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCargarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbBuscar))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jrbEstado))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbGuardar)
                    .addComponent(jbEliminar)
                    .addComponent(jbSalir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        try {
            // Si jtfDNI no esta vacio
            if (!jtfDNI.getText().isEmpty()) {
                // Busco el alumno por el DNI
                Alumno alumno = aluData.buscarAlumnoPorDni(Integer.parseInt(jtfDNI.getText()));

                // Busco si el alumno no esta vacio
                if (alumno != null) {
                    jtfApellido.setText(alumno.getApellido());
                    jtfNombre.setText(alumno.getNombre());
                    jdcFechaNacimiento.setDate(Date.from(alumno.getFechaNacimiento().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

                    // En el caso de necesitar una validación
//                    if (jrbEstado.isSelected() == true) {
//                        System.out.print("Seleccionó opción 1");
//                    } else if (jrbEstado.isSelected() == false) {
//                        System.out.print("Seleccionó opción 2");
//                    }
                    if (alumno.isEstado() == true) {
                        jrbEstado.setSelected(true);
                        // Existen otras formas tanto de colocar el texto en un
                        // RadioButton como de configurar si este estará
                        // seleccionado por defecto o el color del texto
                        jrbEstado.setText("Activo");
                        jrbEstado.setForeground(Color.white);
                    } else if (alumno.isEstado() == false) {
                        jrbEstado.setSelected(false);
                        jrbEstado.setText("Inactivo");
                        jrbEstado.setForeground(Color.gray);
                    }
                    // Prueba de concepto StatusBar ----------------------------------------
                    PruebaDeConceptoStatusBar(1, "El DNI del Alumno se ha podido cargar con exito");
                    // ---------------------------------------------------------------------
                } else {
                    jtfDNI.setText("");
                    jtfApellido.setText("");
                    jtfNombre.setText("");
                    jdcFechaNacimiento.setDate(null);
                    jrbEstado.setSelected(false);
                    // Prueba de concepto StatusBar ----------------------------------------
                    PruebaDeConceptoStatusBar(2, "El DNI del Alumno no se ha podido localizar");
                    // ---------------------------------------------------------------------
                }
            } else {
                jtfDNI.setText("");
                jtfApellido.setText("");
                jtfNombre.setText("");
                jdcFechaNacimiento.setDate(null);
                jrbEstado.setSelected(false);
                // Prueba de concepto StatusBar ----------------------------------------
                PruebaDeConceptoStatusBar(2, "Debe Colocar un número de DNI");
                // ---------------------------------------------------------------------
            }
        } catch (NumberFormatException ex) {
            jtfDNI.setText("");
            jtfApellido.setText("");
            jtfNombre.setText("");
            jdcFechaNacimiento.setDate(null);
            jrbEstado.setSelected(false);
            // Prueba de concepto StatusBar ----------------------------------------
            PruebaDeConceptoStatusBar(2, "El DNI debe ser un número");
            // ---------------------------------------------------------------------
        }

        // Aqui según lo que encuentre, Llamo al metodo con el DNI para que
        // busque y actualice el ComboBox
        seleccionarItemComboBox(Integer.parseInt(jtfDNI.getText()));
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        try {
            Alumno alumno = aluData.buscarAlumnoPorDni(Integer.parseInt(jtfDNI.getText()));

            if (alumno != null) {
                alumno.setDni(Integer.parseInt(jtfDNI.getText()));
                alumno.setApellido(jtfApellido.getText());
                alumno.setNombre(jtfNombre.getText());
                alumno.setFechaNacimiento(jdcFechaNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                alumno.setEstado(jrbEstado.isSelected());

                aluData.modificarAlumno(alumno);
            }
        } catch (NumberFormatException ex) {
            // Prueba de concepto StatusBar ----------------------------------------
            PruebaDeConceptoStatusBar(2, "El DNI debe ser un número");
            // ---------------------------------------------------------------------
            jtfDNI.setText("");
        }
        jtfDNI.setText("");
        jtfApellido.setText("");
        jtfNombre.setText("");
        jdcFechaNacimiento.setDate(null);

        // Cargar alumnos en el ComboBox
        cargarAlumnos();

        // Limpio las filas de la tabla
        borrarFilasTabla();

        // Cargar alumnos en la tabla
        cargarTabla();
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jcbCargarAlumnosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCargarAlumnosItemStateChanged
        // Aqui va el codigo para cuando cambie la seleccion del ComboBox
        // Quiero el alumno seleccionado en el ComboBox
//        String seleccionado = (String) jcbCargarAlumnos.getSelectedItem();
//        System.out.println("Alumno: " + seleccionado);

        // Recorro la lista de alumnos y voy agregando cada item en el ComboBox
//        aluData.listarAlumnos().forEach(item -> {
//            jcbCargarAlumnos.addItem(item.getIdAlumno() + " - " + item.getApellido() + " " + item.getNombre() + " " + item.getDni());
//            System.out.println(item.getIdAlumno());
//        });
        // Cargamos los alumnos en el ComboBox
        //System.out.println("INDEX: " + jcbCargarAlumnos.getSelectedIndex());
        //boolean idSeleccionado = false;
//        for (Alumno listarAlumno : listarAlumnos) {
////            System.out.println(listarAlumno.getIdAlumno() + " " + listarAlumno.getNombre() + " " + listarAlumno.getApellido());
////            jcbCargarAlumnos.addItem(listarAlumno.toString());
//            if (idSeleccionado == jcbCargarAlumnos) {
//                idSeleccionado = listarAlumno.getIdAlumno();
//            }
//        }
        // ---------------------------------------------------------------------
        // Busco el ID en la cadena de texto
        // https://es.stackoverflow.com/questions/123704/c%C3%B3mo-extraer-parte-de-una-cadena-seg%C3%BAn-un-patr%C3%B3n
        // 
//        System.out.println("String seleccionada: " + jcbCargarAlumnos.getSelectedItem());
//        System.out.println(jcbCargarAlumnos.getSelectedItem().toString());
        // En tu código sería:
        //     String cadena = JTextField.getText();
        // Pero como ejemplo, lo asignamos a:
        String cadena = jcbCargarAlumnos.getSelectedItem().toString();

        // Compilamos el regex y el matcher al texto, ignorando mayúsculas/minúsculas (esto es estándar)
        Pattern pattern = Pattern.compile("([0-9]+) - ", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cadena);

        // Ahora sí, vemos si coincide el patrón con el texto
        if (matcher.find()) {
            // Coincidió => obtener el valor del grupo 1
            String obtengoID = matcher.group(1);
//            System.out.println("ID: " + obtengoID);
            // Aqui intento buscar y cargar los datos segun lo que se seleccione
            // en el ComboBox
            cargarCampos(Integer.parseInt(obtengoID));
        } else {
            // No coincidió
            System.out.println("No enontre el ID");
        }
    }//GEN-LAST:event_jcbCargarAlumnosItemStateChanged

    private void jtAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAlumnosMouseClicked
        // Obtenemos el número de fila seleccionada al realizar un click en la tabla
        seleccionFilaEnLaTabla = jtAlumnos.rowAtPoint(evt.getPoint());
        System.out.println("Seleccion Fila En La Tabla: " + seleccionFilaEnLaTabla);

        // Lo convierto de Object a int
        int valorID = (Integer) jtAlumnos.getValueAt(seleccionFilaEnLaTabla, 0);
        System.out.println("Valor ID: " + valorID);

        // Aqui intento buscar y cargar los datos segun lo que se seleccione
        // en la tabla
        cargarCampos(valorID);

        // Tratare de hacer que se deseleccione la fila de la tabla o en el
        // mejor de los casos que quede resaltada la fila que corresponda
        // segun cambien los datos con el ComboBox o el boton Buscar
        jtAlumnos.setSelectionForeground(Color.black);
        jtAlumnos.setSelectionBackground(Color.white);

        // Pero como ejemplo, lo asignamos a:
        jcbCargarAlumnos.setSelectedIndex(seleccionFilaEnLaTabla);
    }//GEN-LAST:event_jtAlumnosMouseClicked

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            Alumno alum = aluData.buscarAlumnoPorDni(Integer.parseInt(jtfDNI.getText()));
            if (alum != null) {
                aluData.eliminarAlumno(alum.getIdAlumno());
                jrbEstado.setSelected(false);
                PruebaDeConceptoStatusBar(1, "Alumno eliminado con exito");
            } else {
                PruebaDeConceptoStatusBar(2, "El alumno no Existe");
            }
        } catch (NumberFormatException ex) {
            PruebaDeConceptoStatusBar(2, "El DNI debe ser un número");
            jtfDNI.setText("");
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        if (jtfDNI.getText().isEmpty() || jtfApellido.getText().isEmpty() || jtfNombre.getText().isEmpty() || jdcFechaNacimiento.getDate() == null) {
            // Prueba de concepto StatusBar ----------------------------------------
            PruebaDeConceptoStatusBar(2, "Los campos primero deben estar completos");
            // ---------------------------------------------------------------------
        } else {
            try {
                LocalDate fechan = jdcFechaNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                Alumno alumno = new Alumno(
                        Integer.parseInt(jtfDNI.getText()),
                        jtfApellido.getText(),
                        jtfNombre.getText(),
                        fechan,
                        true);

                // Primero busco si existe para no agregarlo repetido
                if (aluData.buscarAlumnoPorDni(Integer.parseInt(jtfDNI.getText())) == null) {
                    // Agrego el alumno
                    aluData.guardarAlumno(alumno);
                    // Si lo agregue con exito no es null y se lo informo al DataEntry
                    if (aluData.buscarAlumnoPorDni(Integer.parseInt(jtfDNI.getText())) != null) {
                        // Prueba de concepto StatusBar ----------------------------------------
                        PruebaDeConceptoStatusBar(1, "Alumno agregado de forma exitosa");
                        // ---------------------------------------------------------------------
                    } else {
                        // Prueba de concepto StatusBar ----------------------------------------
                        PruebaDeConceptoStatusBar(2, "ERROR: El alumno no se pudo agregar");
                        // ---------------------------------------------------------------------
                    }

                } else {
                    // Prueba de concepto StatusBar ----------------------------------------
                    PruebaDeConceptoStatusBar(2, "Ya existe un alumno con ese DNI");
                    // ---------------------------------------------------------------------
                }
            } catch (NumberFormatException ex) {
                // Prueba de concepto StatusBar ----------------------------------------
                PruebaDeConceptoStatusBar(2, "El DNI debe ser un número");
                // ---------------------------------------------------------------------
            }
        }
    }//GEN-LAST:event_jbNuevoActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(X01FormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(X01FormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(X01FormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(X01FormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new X01FormView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbCargarAlumnos;
    private com.toedter.calendar.JDateChooser jdcFechaNacimiento;
    private javax.swing.JLabel jlStatusBar;
    private javax.swing.JLabel jlSubTitle;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTable jtAlumnos;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfDNI;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}

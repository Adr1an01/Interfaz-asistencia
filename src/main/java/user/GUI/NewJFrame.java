/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package user.GUI;

import ConecToBD.ConexionBD;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adrian
 */
public class NewJFrame extends javax.swing.JFrame {

    String cursos[];
    ArrayList<Registro> listaRegistro = new ArrayList<Registro>();

    DefaultTableModel modelo = new DefaultTableModel();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    ConexionBD obj = new ConexionBD();
    private ExportarExcel objeto;

    String asistencia = "";

    public NewJFrame() {
        initComponents();

        this.cursos = new String[]{"CANTO 09:00-10:00 AM", "CANTO 12:00-01:00 PM", "COMU REFOR 12x:20-01:20 PM"};
        jButton3.setEnabled(false);
        this.setTitle("Registro de asistencias");
        this.setLocationRelativeTo(null);
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Curso");
        modelo.addColumn("Fecha");
        modelo.addColumn("Asistencia");
        this.jTable1.setModel(modelo);

        DefaultComboBoxModel comboModel = new DefaultComboBoxModel(cursos);
        jComboBox2.setModel(comboModel);
        String[] modalidad = {"VIRTUAL", "PRESENCIAL"};
        DefaultComboBoxModel combo2 = new DefaultComboBoxModel(modalidad);
        jComboBox1.setModel(combo2);

        jCheckBox1.setSelected(true);
        jCheckBox2.setSelected(false);

        jCheckBox1.isSelected();
        asistencia = "Asistio";
        Date hoy = new Date();
        jTextField2.setText(formatoFecha.format(hoy));

        fechaSet();
        actualizarTable();
    }

    private void actualizarTable() {

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        for (Registro r : listaRegistro) {
            Object x[] = new Object[5];
            x[0] = r.getNombres();
            x[1] = r.getApellido();
            x[2] = r.getCurso();
            x[3] = r.getFecha();
            x[4] = r.getAsistencia();
            modelo.addRow(x);
        }
        jTable1.setModel(modelo);
    }

    private void precargarTabla(ArrayList<Registro> DATOS) {

        Date fechah = jCalendar1.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        listaRegistro.clear();
        if (!DATOS.isEmpty()) {
            jTextField2.setEditable(false);
            for (Registro user : DATOS) {
                if (user.getAsistencia().equals("1")) {
                    user.setAsistencia("Asistio");
                } else {
                    user.setAsistencia("Falta");
                }
                listaRegistro.add(user);
            }
        }
    }

    private void llenarColumna(ArrayList<String> DATOS) {
        listaRegistro.clear();
        jLabel6.setText("");
        Date fecaSeleccion = fechaSet();
        String cursoSeleccion = jComboBox2.getSelectedItem().toString();
        jButton3.setEnabled(true);
        String[] nombres = DATOS.toArray(String[]::new);
        DefaultComboBoxModel comboModel3 = new DefaultComboBoxModel(nombres);
        jComboBox3.setModel(comboModel3);
        for (String nombreApellido : DATOS) {
            String[] partes = nombreApellido.split(",");
            String nom = partes[0].trim();
            String ape = partes[1].trim();
            Registro valoresDefecto = new Registro();
            valoresDefecto.setAsistencia("Falta");
            valoresDefecto.setNombres(nom);
            valoresDefecto.setFecha(fecaSeleccion);
            valoresDefecto.setApellido(ape);
            valoresDefecto.setCurso(cursoSeleccion);
            listaRegistro.add(valoresDefecto);
        }
        actualizarTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de asistencias");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Modalidad :");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Lista de alumnos :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Curso :");

        jButton3.setText("Tomar asistencia");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Exportar a excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar1PropertyChange(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fecha a registrar :");

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jButton2.setText("Registrar asistencia");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Asistio");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Falta");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("  ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jCalendar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(277, 277, 277)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar1PropertyChange

        if (evt.getOldValue() != null) {
            jTextField2.setText(formatoFecha.format(jCalendar1.getCalendar().getTime()));
        }
        for (Registro registro : listaRegistro) {
            registro.setFecha(fechaSet());
        }

        try {
            ArrayList<String> Lista = obj.listaNombres(jComboBox2.getSelectedItem().toString(), jComboBox1.getSelectedItem().toString());
            llenarColumna(Lista);
            actualizarTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar a la base de datos");
        }

        actualizarTable();

    }//GEN-LAST:event_jCalendar1PropertyChange

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        jButton3.setEnabled(true);
        jLabel6.setText("");

        String curso = jComboBox2.getSelectedItem().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechah = jCalendar1.getDate();
        String fechaString = dateFormat.format(fechah);
        jButton2.setEnabled(true);
        try {
            ArrayList<String> listaNombre = obj.listaNombres(codigoCurso(curso), jComboBox1.getSelectedItem().toString());
            ArrayList<Registro> datosLista = obj.consultaAsistencia(jComboBox2.getSelectedItem().toString(), jComboBox1.getSelectedItem().toString(), fechaString);
            if (listaNombre.isEmpty()) {
                jButton3.setEnabled(false);
                JOptionPane.showMessageDialog(null, "No se encontraron alumnos en : " + curso);
                jButton2.setEnabled(false);
                jComboBox3.removeAllItems();
                listaRegistro.clear();
                actualizarTable();
                return;
            }
            String[] nombres = listaNombre.toArray(String[]::new);
            DefaultComboBoxModel comboModel3 = new DefaultComboBoxModel(nombres);
            jComboBox3.setModel(comboModel3);

            if (!datosLista.isEmpty()) {
                precargarTabla(datosLista);

                jLabel6.setText("Cantidad de matriculados : " + datosLista.size() + ". Asistencia ya registrada.");
                Color darkerGreen = new Color(0, 128, 0);
                jLabel6.setForeground(darkerGreen);

            } else {
                llenarColumna(listaNombre);
                jLabel6.setText("Cantidad de matriculados : " + listaNombre.size() + ". Asistencia sin registrar.");
                Color color = new Color(255, 0, 0); 
                jLabel6.setForeground(color);
            }
            actualizarTable();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos: " + ex.toString());
        }
        actualizarTable();
    }//GEN-LAST:event_jComboBox2ActionPerformed


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            objeto = new ExportarExcel();
            objeto.exportarExcel(jTable1);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al exportar" + ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Date fecha_ = fechaSet();
        String cursoSeleccionado = jComboBox2.getSelectedItem().toString();
        String seleccion = jComboBox3.getSelectedItem().toString();

        if (seleccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un alumno antes de tomar asistencia.");
            return;
        }

        for (int i = 0; i < listaRegistro.size(); i++) {
            Registro alumno = listaRegistro.get(i);
            String txt = alumno.getNombres() + "," + alumno.getApellido();
            if (txt.trim().equals(seleccion)) {
                listaRegistro.get(i).setCurso(cursoSeleccionado);
                listaRegistro.get(i).setFecha(fecha_);
                listaRegistro.get(i).setAsistencia(asistencia);
            }
        }
        actualizarTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private Date fechaSet() {
        Date fechah = jCalendar1.getDate();
        long fecha = fechah.getTime();
        java.sql.Date fecha_sql = new java.sql.Date(fecha);
        return fecha_sql;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (listaRegistro.isEmpty()) {
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechah = jCalendar1.getDate();
        String fechaString = dateFormat.format(fechah);
        jButton2.setEnabled(true);
        try {
            ArrayList<Registro> datosLista = obj.consultaAsistencia(jComboBox2.getSelectedItem().toString(), jComboBox1.getSelectedItem().toString(), fechaString);
            if (!datosLista.isEmpty()) {
                jLabel6.setText("");
                obj.resanarLista(listaRegistro);
                System.out.println("resanarlista");
            } else {
                obj.enviarDatos(listaRegistro, jComboBox1.getSelectedItem().toString());
                System.out.println("enviarDatos");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta a la base de datos: " + ex.toString());
        }

        listaRegistro.clear();
        jComboBox3.removeAllItems();
        actualizarTable();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:        
        asistencia = jCheckBox1.isSelected() ? "Asistio" : "";
        jCheckBox2.setSelected(!jCheckBox1.isSelected());
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        asistencia = jCheckBox2.isSelected() ? "Falta" : "";
        jCheckBox1.setSelected(!jCheckBox2.isSelected());

    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String mod = jComboBox1.getSelectedItem().toString();

        if (mod.equals("PRESENCIAL")) {
            this.cursos = new String[]{"ORATORIA ,LUNES - MIÉRCOLES,9:00 - 11:00 AM",
                "ORATORIA ,LUNES - MIÉRCOLES,11:00 - 1:00 AM"};
        } else if (mod.equals("VIRTUAL")) {
            this.cursos = new String[]{"CANTO 09:00-10:00 AM", "CANTO 12:00-01:00 PM", "COMU REFOR 12x:20-01:20 PM"};
        }
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel(cursos);
        jComboBox2.setModel(comboModel);
        listaRegistro.clear();
        actualizarTable();
        jComboBox3.removeAllItems();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private String codigoCurso(String curso) {
        String curso_cod = "";
        switch (curso) {
            case "CANTO 09:00-10:00 AM" -> {
                curso_cod = "CANTO1";
            }
            case "CANTO 12:00-01:00 PM" -> {
                curso_cod = "CANTO2";
            }
            case "COMU REFOR 12:20-01:20 PM" -> {
                curso_cod = "COMUREFOR1";
            }
            
            case "ORATORIA ,LUNES - MIERCOLES,9:00 - 11:00 AM" -> {
                curso_cod = "ORT-1";
            }

            case "ORATORIA ,LUNES - MIERCOLES,11:00 - 1:00 AM" -> {
                curso_cod = "ORT-2";
            }
        }
        return curso_cod;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}

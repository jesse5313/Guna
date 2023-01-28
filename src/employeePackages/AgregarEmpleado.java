
package employeePackages;


import java.sql.*;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

public class AgregarEmpleado extends javax.swing.JInternalFrame {

   Conexion enlace = new Conexion();
   Connection conect = enlace.conectar();
    
    public AgregarEmpleado() {
        initComponents();
    }
    
    public void agEmp(){
        String fecha;
        String fecha1;
        String fecha2;
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        
        fecha=f.format(dateFechaEnt.getDate());
        fecha1=f.format(dateFechaInicio.getDate());
        fecha2=f.format(dateFechaFin.getDate());
        
        try {
            PreparedStatement guardar = conect.prepareStatement("insert into employees(telefono, chip, imei, nombre, modelo_de_negocio, puesto, cedi, numero_de_empleado, ruta, fecha_de_entrega, descuentos, operador, modelo_del_equipo, fecha_de_inicio_de_plazo, fecha_de_fin_de_plazo, plazo, estatus, observaciones) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            guardar.setString(1, campTel.getText());
            guardar.setString(2, campChip.getText());
            guardar.setString(3, campImei.getText());
            guardar.setString(4, campNom.getText());
            guardar.setString(5, combModNeg.getSelectedItem().toString());
            guardar.setString(6, combPues.getSelectedItem().toString());
            guardar.setString(7, combCedi.getSelectedItem().toString());
            guardar.setString(8, campNumEmp.getText());
            guardar.setString(9, campRuta.getText());
            guardar.setString(10, fecha);
            guardar.setString(11, campDes.getText());
            guardar.setString(12, campOperador.getText());
            guardar.setString(13, campModeloDelEquipo.getText());
            guardar.setString(14, fecha1);
            guardar.setString(15, fecha2);
            guardar.setString(16, campPlazo.getText());
            guardar.setString(17, combEstatus.getSelectedItem().toString());
            guardar.setString(18, campObser.getText());
            guardar.executeUpdate();
            
            //GUARDAR EN TABLA HISTORY
            PreparedStatement guardarH = conect.prepareStatement("insert into history(telefono, chip, imei, nombre, modelo_de_negocio, puesto, cedi, numero_de_empleado, ruta, fecha_de_entrega, descuentos, operador, modelo_del_equipo, fecha_de_inicio_de_plazo, fecha_de_fin_de_plazo, plazo, estatus, observaciones) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            guardarH.setString(1, campTel.getText());
            guardarH.setString(2, campChip.getText());
            guardarH.setString(3, campImei.getText());
            guardarH.setString(4, campNom.getText());
            guardarH.setString(5, combModNeg.getSelectedItem().toString());
            guardarH.setString(6, combPues.getSelectedItem().toString());
            guardarH.setString(7, combCedi.getSelectedItem().toString());
            guardarH.setString(8, campNumEmp.getText());
            guardarH.setString(9, campRuta.getText());
            guardarH.setString(10, fecha);
            guardarH.setString(11, campDes.getText());
            guardarH.setString(12, campOperador.getText());
            guardarH.setString(13, campModeloDelEquipo.getText());
            guardarH.setString(14, fecha1);
            guardarH.setString(15, fecha2);
            guardarH.setString(16, campPlazo.getText());
            guardarH.setString(17, combEstatus.getSelectedItem().toString());
            guardarH.setString(18, campObser.getText());
            guardarH.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Empleado registrado");
            //reiniciar datos
            campTel.setText("");
            campChip.setText("");
            campImei.setText("");
            campNom.setText("");
            campNumEmp.setText("");
            campRuta.setText("");
            dateFechaEnt.setCalendar(null);
            campDes.setText("");
            campOperador.setText("");
            campModeloDelEquipo.setText("");
            dateFechaInicio.setCalendar(null);
            dateFechaFin.setCalendar(null);
            campPlazo.setText("");
            campObser.setText("");
            campTel.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "No se logro registrar el cliente");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        campTel = new javax.swing.JTextField();
        campImei = new javax.swing.JTextField();
        combCedi = new javax.swing.JComboBox<>();
        campNumEmp = new javax.swing.JTextField();
        campNom = new javax.swing.JTextField();
        combModNeg = new javax.swing.JComboBox<>();
        combPues = new javax.swing.JComboBox<>();
        dateFechaEnt = new com.toedter.calendar.JDateChooser();
        combEstatus = new javax.swing.JComboBox<>();
        campDes = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        campObser = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        campRuta = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        campChip = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        campOperador = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        campModeloDelEquipo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        dateFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        dateFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        campPlazo = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Agregar");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel3.setText("Registro de empleados");

        jLabel4.setText("Numero de empleado");

        jLabel5.setText("IMEI");

        jLabel6.setText("CEDI");

        jLabel7.setText("Telefono");

        jLabel8.setText("Nombre");

        jLabel9.setText("Modelo de negocio");

        jLabel10.setText("Puesto");

        jLabel11.setText("Fecha de entrega");

        jLabel12.setText("Estatus");

        jLabel13.setText("Descuentos");

        jLabel15.setText("Observaciones");

        campTel.setToolTipText("");
        campTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campTelActionPerformed(evt);
            }
        });

        campImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campImeiActionPerformed(evt);
            }
        });

        combCedi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acapulco", "Atizapan", "Chilpancingo", "Coacalco", "Cuautla", "Cuernavaca", "Guadalajara", "Ixtapaluca", "Iztapalapa", "Leon", "Monterrey", "Morelia", "Oriente", "Pachuca", "Puebla", "Tlalpan", "Tlaxcala", "Toluca", "Tubo azul", "Tula", "Vallejo" }));

        campNumEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campNumEmpActionPerformed(evt);
            }
        });

        campNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campNomActionPerformed(evt);
            }
        });

        combModNeg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Colgate", "Conagra", "Jefe de R.H.", "Jefe de taller", "Multimarca", "Pedigree" }));

        combPues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Autoventa", "Gerente", "Jefe de R.H.", "Lider Colgate", "Preventa", "Supervisor", "Supervisor Autoventas", "Supervisor Preventas" }));

        combEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Asignado", "Pendiente", "Sin asignar" }));
        combEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combEstatusActionPerformed(evt);
            }
        });

        campObser.setColumns(20);
        campObser.setRows(5);
        jScrollPane1.setViewportView(campObser);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel16.setText("$");

        campRuta.setToolTipText("");
        campRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campRutaActionPerformed(evt);
            }
        });

        jLabel17.setText("Ruta");

        campChip.setToolTipText("");
        campChip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campChipActionPerformed(evt);
            }
        });

        jLabel14.setText("Chip");

        jLabel18.setText("Operador");

        campOperador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campOperadorActionPerformed(evt);
            }
        });

        jLabel19.setText("Modelo del equipo");

        campModeloDelEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campModeloDelEquipoActionPerformed(evt);
            }
        });

        jLabel20.setText("Fecha de inicio de plazo");

        jLabel21.setText("Fecha de fin de plazo");

        jLabel22.setText("Plazo");

        campPlazo.setToolTipText("");
        campPlazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campPlazoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(211, 211, 211))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel18)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel16)))
                                    .addComponent(jLabel11))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(dateFechaEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campModeloDelEquipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campOperador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campDes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campRuta)
                                    .addComponent(campNumEmp)
                                    .addComponent(combCedi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combPues, 0, 212, Short.MAX_VALUE)
                                    .addComponent(combModNeg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campNom)
                                    .addComponent(campImei)
                                    .addComponent(campChip)
                                    .addComponent(campTel)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(21, 21, 21))
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnGuardar)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(58, 58, 58)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel22)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(campPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(dateFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(combEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campChip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(combModNeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combPues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(combCedi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateFechaEnt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(campDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campModeloDelEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campTelActionPerformed

    private void campImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campImeiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campImeiActionPerformed

    private void campNumEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campNumEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campNumEmpActionPerformed

    private void campNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campNomActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        agEmp();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void campRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campRutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campRutaActionPerformed

    private void campChipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campChipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campChipActionPerformed

    private void campOperadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campOperadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campOperadorActionPerformed

    private void campModeloDelEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campModeloDelEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campModeloDelEquipoActionPerformed

    private void campPlazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campPlazoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campPlazoActionPerformed

    private void combEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combEstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combEstatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField campChip;
    private javax.swing.JTextField campDes;
    private javax.swing.JTextField campImei;
    private javax.swing.JTextField campModeloDelEquipo;
    private javax.swing.JTextField campNom;
    private javax.swing.JTextField campNumEmp;
    private javax.swing.JTextArea campObser;
    private javax.swing.JTextField campOperador;
    private javax.swing.JTextField campPlazo;
    private javax.swing.JTextField campRuta;
    private javax.swing.JTextField campTel;
    private javax.swing.JComboBox<String> combCedi;
    private javax.swing.JComboBox<String> combEstatus;
    private javax.swing.JComboBox<String> combModNeg;
    private javax.swing.JComboBox<String> combPues;
    private com.toedter.calendar.JDateChooser dateFechaEnt;
    private com.toedter.calendar.JDateChooser dateFechaFin;
    private com.toedter.calendar.JDateChooser dateFechaInicio;
    private javax.swing.JComboBox<String> jComboBox5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

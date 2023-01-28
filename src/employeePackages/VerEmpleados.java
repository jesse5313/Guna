
package employeePackages;

import java.awt.Component;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class VerEmpleados extends javax.swing.JInternalFrame {

    static String idHist;

   Conexion enlace = new Conexion();
   Connection conect = enlace.conectar();
   
   Historial v;
   
   
    public VerEmpleados() {
        initComponents();
        mostrarDatosEmpleado(0,null);
        centrar_datos();
        ajustarCol();
    }
    
    public void ajustarCol(){
        //ajusta ancho de columnas
        resizeColumnWidth(tablaEmpleados);
        tablaEmpleados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablaEmpleados.setRowHeight(25);
    }
    
    public void mostrarDatosEmpleado(int opbuscar, String valor){
        DefaultTableModel templeado = new DefaultTableModel();
     
        templeado.addColumn("Telefono");
        templeado.addColumn("Chip");
        templeado.addColumn("IMEI");
        templeado.addColumn("Nombre");
        templeado.addColumn("Modelo de negocio");
        templeado.addColumn("Puesto");
        templeado.addColumn("CEDI");
        templeado.addColumn("Numero de empleado");
        templeado.addColumn("Ruta");
        templeado.addColumn("Fecha de entrega");
        templeado.addColumn("Descuentos");
        templeado.addColumn("Operador");
        templeado.addColumn("Modelo del equipo");
        templeado.addColumn("Fecha de inicio de plazo");
        templeado.addColumn("Fecha de fin de plazo");
        templeado.addColumn("Plazo");
        templeado.addColumn("Estatus");
        templeado.addColumn("Observaciones");
        tablaEmpleados.setModel(templeado);
        
        //centrar cabecera de la tabla
        ((DefaultTableCellRenderer) tablaEmpleados.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        
        String codsql;
        
        if(opbuscar == 0 && valor == null){
            codsql = "select * from employees";
        }else{
        if(opbuscar == 1 && valor != null){
        codsql = "select * from employees where telefono = '"+valor+"'";
        }else{
        if(opbuscar == 2 && valor != null){
        codsql = "select * from employees where chip = '"+valor+"'";
        }else{
        if(opbuscar == 3 && valor != null){
        codsql = "select * from employees where imei = '"+valor+"'";
        }else{
        if(opbuscar == 4 && valor != null){
        codsql = "select * from employees where nombre = '"+valor+"'";
        }else{ 
        if(opbuscar == 5 && valor != null){
        codsql = "select * from employees where modelo_de_negocio = '"+valor+"'";
        }else{
        if(opbuscar == 6 && valor != null){
        codsql = "select * from employees where puesto = '"+valor+"'";
        }else{
        if(opbuscar == 7 && valor != null){
        codsql = "select * from employees where cedi = '"+valor+"'";
        }else{
        if(opbuscar == 8 && valor != null){
        codsql = "select * from employees where numero_de_empleado = '"+valor+"'";
        }else{
        if(opbuscar == 9 && valor != null){
        codsql = "select * from employees where ruta = '"+valor+"'";
        }else{ 
        if(opbuscar == 10 && valor != null){
        codsql = "select * from employees where fecha_de_entrega = '"+valor+"'";
        }else{
        if(opbuscar == 11 && valor != null){
        codsql = "select * from employees where descuentos = '"+valor+"'";
        }else{
        if(opbuscar == 12 && valor != null){
        codsql = "select * from employees where operador = '"+valor+"'";
        }else{
        if(opbuscar == 13 && valor != null){
        codsql = "select * from employees where modelo_del_equipo = '"+valor+"'";
        }else{    
        if(opbuscar == 14 && valor != null){
        codsql = "select * from employees where fecha_de_inicio_de_plazo = '"+valor+"'";
        }else{
        if(opbuscar == 15 && valor != null){
        codsql = "select * from employees where fecha_de_fin_de_plazo = '"+valor+"'";
        }else{
        if(opbuscar == 16 && valor != null){
        codsql = "select * from employees where plazo = '"+valor+"'";
        }else{
        if(opbuscar == 17 && valor != null){
        codsql = "select * from employees where estatus = '"+valor+"'";
        }else{
        
        codsql = "select * from employees";
        }}}}}}}}}}}}}}}}}}
        
        String[] datos=new String[18];
        
        try {
            Statement leer = conect.createStatement();
            ResultSet resultado = leer.executeQuery(codsql);
            
            while(resultado.next()){
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(4);
                datos[4] = resultado.getString(5);
                datos[5] = resultado.getString(6);
                datos[6] = resultado.getString(7);
                datos[7] = resultado.getString(8);
                datos[8] = resultado.getString(9);
                datos[9] = resultado.getString(10);
                datos[10] = resultado.getString(11);
                datos[11] = resultado.getString(12);
                datos[12] = resultado.getString(13);
                datos[13] = resultado.getString(14);
                datos[14] = resultado.getString(15);
                datos[15] = resultado.getString(16);
                datos[16] = resultado.getString(17);
                datos[17] = resultado.getString(18);
                templeado.addRow(datos);
            }
            tablaEmpleados.setModel(templeado);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Error en la consulta");
        }
    }
    
    public void eliminarEmpleado(){
        int fila = tablaEmpleados.getSelectedRow();
        String valor = tablaEmpleados.getValueAt(fila, 0).toString();
        
        try {
            PreparedStatement elim0 = conect.prepareStatement("delete from history where telefono='"+valor+"'");
            elim0.executeUpdate();
            PreparedStatement elim = conect.prepareStatement("delete from employees where telefono='"+valor+"'");
            elim.executeUpdate();
            
            
            mostrarDatosEmpleado(0,null);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "No se logro eliminar el registro");
        }
    }
    
    public void historial(){
       int fHistorial = tablaEmpleados.getSelectedRow();
       
       if(fHistorial>-1){
       //guarda valor del tel
       idHist = this.tablaEmpleados.getValueAt(fHistorial,0).toString();
       
       //guardar valor cedi
       String fCedi = this.tablaEmpleados.getValueAt(fHistorial,6).toString();
       
       v = new Historial(idHist,fCedi);
       Principal.desk.add(v);
       v.toFront();
       v.setVisible(true);
       }
    }
    
    public void actualizarDatos(){
        
        int fila = tablaEmpleados.getSelectedRow();
        if(fila>-1){
        String id = this.tablaEmpleados.getValueAt(fila, 0).toString();
        
        String a = tablaEmpleados.getValueAt(fila, 1).toString();
        String b = tablaEmpleados.getValueAt(fila, 2).toString();
        String c = tablaEmpleados.getValueAt(fila, 3).toString();
        String d = tablaEmpleados.getValueAt(fila, 4).toString();
        String f = tablaEmpleados.getValueAt(fila, 5).toString();
        String g = tablaEmpleados.getValueAt(fila, 6).toString();
        String h = tablaEmpleados.getValueAt(fila, 7).toString();
        String i = tablaEmpleados.getValueAt(fila, 8).toString();
        String j = tablaEmpleados.getValueAt(fila, 9).toString();
        String k = tablaEmpleados.getValueAt(fila, 10).toString();
        String l = tablaEmpleados.getValueAt(fila, 11).toString();
        String m = tablaEmpleados.getValueAt(fila, 12).toString();
        String n = tablaEmpleados.getValueAt(fila, 13).toString();
        String o = tablaEmpleados.getValueAt(fila, 14).toString();
        String p = tablaEmpleados.getValueAt(fila, 15).toString();
        String q = tablaEmpleados.getValueAt(fila, 16).toString();
        String r = tablaEmpleados.getValueAt(fila, 17).toString();
        
        try {
            PreparedStatement actu = conect.prepareStatement("update employees set chip='"+a+"',imei='"+b+"',nombre='"+c+"',modelo_de_negocio='"+d+"',puesto='"+f+"',cedi='"+g+"',numero_de_empleado='"+h+"',ruta='"+i+"',fecha_de_entrega='"+j+"',descuentos='"+k+"',operador='"+l+"',modelo_del_equipo='"+m+"',fecha_de_inicio_de_plazo='"+n+"',fecha_de_fin_de_plazo='"+o+"',plazo='"+p+"',estatus='"+q+"',observaciones='"+r+"' where telefono='"+id+"'");
            actu.executeUpdate();
            mostrarDatosEmpleado(0,null);
            
            //GUARDAR EN TABLA HISTORY
            PreparedStatement guardarH = conect.prepareStatement("insert into history(telefono, chip, imei, nombre, modelo_de_negocio, puesto, cedi, numero_de_empleado, ruta, fecha_de_entrega, descuentos, operador, modelo_del_equipo, fecha_de_inicio_de_plazo, fecha_de_fin_de_plazo, plazo, estatus, observaciones) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            guardarH.setString(1, id);
            guardarH.setString(2, a);
            guardarH.setString(3, b);
            guardarH.setString(4, c);
            guardarH.setString(5, d);
            guardarH.setString(6, f);
            guardarH.setString(7, g);
            guardarH.setString(8, h);
            guardarH.setString(9, i);
            guardarH.setString(10, j);
            guardarH.setString(11, k);
            guardarH.setString(12, l);
            guardarH.setString(13, m);
            guardarH.setString(14, n);
            guardarH.setString(15, o);
            guardarH.setString(16, p);
            guardarH.setString(17, q);
            guardarH.setString(18, r);
            guardarH.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "No se logro actualizar los datos");
        }
        }
        
    }
    
    public void centrar_datos(){  
    for (int col = 0; col < 12; col++) {
    DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer(); 
    modelocentrar.setHorizontalAlignment(SwingConstants.CENTER); 
    tablaEmpleados.getColumnModel().getColumn(col).setCellRenderer(modelocentrar);
    }
    }
    
    private void resizeColumnWidth(JTable table) {
    //Se obtiene el modelo de la columna
    TableColumnModel columnModel = table.getColumnModel();
    //Se obtiene el total de las columnas
    for (int column = 0; column < table.getColumnCount(); column++) {
    //Establecemos un valor minimo para el ancho de la columna
    int width = 135; //Min Width
    //Obtenemos el numero de filas de la tabla
    for (int row = 0; row < table.getRowCount(); row++) {
    //Obtenemos el renderizador de la tabla
    TableCellRenderer renderer = table.getCellRenderer(row, column);
    //Creamos un objeto para preparar el renderer
    Component comp = table.prepareRenderer(renderer, row, column);
    //Establecemos el width segun el valor maximo del ancho de la columna
    width = Math.max(comp.getPreferredSize().width + 1, width);
    }
    //Se establece una condicion para no sobrepasar el valor de 300
    //Esto es Opcional
    if (width > 300) {
        width = 300;
    }
    //Se establece el ancho de la columna
    columnModel.getColumn(column).setPreferredWidth(width);
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        comboOpcion = new javax.swing.JComboBox<>();
        campoBuscar = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnActDatos = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Administrar empleados");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N

        comboOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar todos", "Telefono", "Chip", "IMEI", "Nombre", "Modelo de negocio", "Puesto", "CEDI", "Numero de empleado", "Ruta", "Fecha de entrega", "Descuentos", "Operador", "Modelo del equipo", "Fecha de inicio de plazo", "Fecha de fin de plazo", "Plazo", "Estatus", "Cantidad de celulares" }));

        campoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnHistorial.setText("Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        btnActDatos.setText("Actualizar datos");
        btnActDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActDatosActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(351, 351, 351)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHistorial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnActDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(121, 121, 121))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHistorial)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActDatos)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaEmpleados.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tablaEmpleadosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(tablaEmpleados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        JFrame frame = new JFrame("Eliminar");
        if(JOptionPane.showConfirmDialog(frame, "¿Seguro que quieres elimiar?", "Eliminar",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
        eliminarEmpleado();
        centrar_datos();
        ajustarCol();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaEmpleadosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tablaEmpleadosAncestorAdded
        
    }//GEN-LAST:event_tablaEmpleadosAncestorAdded

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        historial();
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnActDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActDatosActionPerformed
        actualizarDatos();
        centrar_datos();
        ajustarCol();
    }//GEN-LAST:event_btnActDatosActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int opcion = comboOpcion.getSelectedIndex();
        String valorbus = campoBuscar.getText();
        mostrarDatosEmpleado(opcion,valorbus);
        centrar_datos();
        ajustarCol();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActDatos;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JComboBox<String> comboOpcion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}

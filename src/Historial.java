
package employeePackages;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


public class Historial extends javax.swing.JInternalFrame {

    Conexion enlace = new Conexion();
   Connection conect = enlace.conectar();
   //valor de idHistorial pero public
   public String a = employeePackages.VerEmpleados.idHist;
   
    
    public Historial(String val, String ced) {
        String v=val;
        
        initComponents();
        mostrarDatosEmpleado(v);
        ajustarCol();
        centrar_datos();
        
        labelTel.setText(v);
        labelCedi.setText(ced);
    }
    
    public void eliminarEmpleadoHis(){
        int fila = tableHistorial.getSelectedRow();
        String valor = tableHistorial.getValueAt(fila, 0).toString();
        
        try {
            PreparedStatement elim = conect.prepareStatement("delete from history where id_his='"+valor+"'");
            elim.executeUpdate();
            
            mostrarDatosEmpleado(null);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "No se logro eliminar el registro");
        }
    }
    
    public void ajustarCol(){
        //ajusta ancho de columnas
        resizeColumnWidth(tableHistorial);
        tableHistorial.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableHistorial.setRowHeight(25);
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
    
    public void centrar_datos(){  
    for (int col = 0; col < 18; col++) {
    DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer(); 
    modelocentrar.setHorizontalAlignment(SwingConstants.CENTER); 
    tableHistorial.getColumnModel().getColumn(col).setCellRenderer(modelocentrar);
    }
    }
    
    public void mostrarDatosEmpleado(String valor){
        DefaultTableModel templeado = new DefaultTableModel();
     
        templeado.addColumn("ID Historial");
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
        tableHistorial.setModel(templeado);
        
        //centrar cabecera de la tabla
        ((DefaultTableCellRenderer) tableHistorial.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        
        String codsql;
        codsql = "select * from history where telefono = '"+valor+"'";
        
        String[] datos=new String[19];
        
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
                datos[18] = resultado.getString(19);
                templeado.addRow(datos);
            }
            tableHistorial.setModel(templeado);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Error en la consulta");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableHistorial = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        labelTel = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        labelCedi = new javax.swing.JLabel();
        btnEliminarHis = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        tableHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableHistorial);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Historial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14))); // NOI18N

        label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("CEDI:");

        labelTel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        label1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("Numero de telefono:");

        labelCedi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCedi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnEliminarHis.setText("Eliminar");
        btnEliminarHis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarHisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTel, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCedi, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(btnEliminarHis, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(labelCedi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnEliminarHis, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarHisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHisActionPerformed
        JFrame frame = new JFrame("Eliminar");
        if(JOptionPane.showConfirmDialog(frame, "¿Seguro que quieres elimiar?", "Eliminar",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
        eliminarEmpleadoHis();
        mostrarDatosEmpleado(a);
        centrar_datos();
        ajustarCol();
        
        }
        
    }//GEN-LAST:event_btnEliminarHisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarHis;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel labelCedi;
    private javax.swing.JLabel labelTel;
    private javax.swing.JTable tableHistorial;
    // End of variables declaration//GEN-END:variables
}


package employeePackages;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class Principal extends javax.swing.JFrame {
    
    AgregarEmpleado verventana;
    VerEmpleados verventana1;

    Conexion enlace = new Conexion();
    Connection conect = enlace.conectar();
    
    public Principal() {
        initComponents();
        setIconImage(getIconImage());
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public void probar_conexion(){
        if(conect == null){
            JOptionPane.showMessageDialog(null, "No se logro la conexión");
        }else{
            JOptionPane.showMessageDialog(null, "Conexión establecida satisfactoriamente");
        }
    }
    
    public void centrarVentana(JInternalFrame internalFrame){
        int x = (desk.getWidth()/2) - internalFrame.getWidth()/2;
        int y = (desk.getHeight()/2) - internalFrame.getHeight()/2;
        
        if(internalFrame.isShowing()){
            internalFrame.setLocation(x, y);
        }else{
            desk.add(internalFrame);
            internalFrame.setLocation(x, y);
            internalFrame.show();
        }
    }

    //icono jFrame
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/Guna.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desk = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        mini = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        editar = new javax.swing.JMenu();
        agregarEmpleado = new javax.swing.JMenuItem();
        ver = new javax.swing.JMenuItem();
        ayuda = new javax.swing.JMenu();
        evaluarConexion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        javax.swing.GroupLayout deskLayout = new javax.swing.GroupLayout(desk);
        desk.setLayout(deskLayout);
        deskLayout.setHorizontalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 682, Short.MAX_VALUE)
        );
        deskLayout.setVerticalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        archivo.setText("Archivo");
        archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoActionPerformed(evt);
            }
        });

        mini.setText("Minimizar");
        mini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miniActionPerformed(evt);
            }
        });
        archivo.add(mini);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        archivo.add(salir);

        jMenuBar1.add(archivo);

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        agregarEmpleado.setText("Agregar");
        agregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEmpleadoActionPerformed(evt);
            }
        });
        editar.add(agregarEmpleado);

        ver.setText("Administrar");
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });
        editar.add(ver);

        jMenuBar1.add(editar);

        ayuda.setText("Ayuda");

        evaluarConexion.setText("Evaluar conexión");
        evaluarConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluarConexionActionPerformed(evt);
            }
        });
        ayuda.add(evaluarConexion);

        jMenuBar1.add(ayuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desk)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desk, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoActionPerformed
        //
    }//GEN-LAST:event_archivoActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        
    }//GEN-LAST:event_editarActionPerformed

    private void agregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEmpleadoActionPerformed
        if(!(verventana instanceof AgregarEmpleado)){
        verventana = new AgregarEmpleado();
        }
        centrarVentana(verventana);
    }//GEN-LAST:event_agregarEmpleadoActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        JFrame frame = new JFrame("Salir");
        if(JOptionPane.showConfirmDialog(frame, "¿Seguro que quieres salir?", "Salir",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            System.exit(0);
        }     
    }//GEN-LAST:event_salirActionPerformed

    private void evaluarConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluarConexionActionPerformed
        probar_conexion();
    }//GEN-LAST:event_evaluarConexionActionPerformed

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        if(!(verventana1 instanceof VerEmpleados)){
        verventana1 = new VerEmpleados();
        }
        centrarVentana(verventana1);
    }//GEN-LAST:event_verActionPerformed

    private void miniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miniActionPerformed
        setExtendedState(ICONIFIED | MAXIMIZED_BOTH);
    }//GEN-LAST:event_miniActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem agregarEmpleado;
    private javax.swing.JMenu archivo;
    private javax.swing.JMenu ayuda;
    public static javax.swing.JDesktopPane desk;
    private javax.swing.JMenu editar;
    private javax.swing.JMenuItem evaluarConexion;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mini;
    private javax.swing.JMenuItem salir;
    private javax.swing.JMenuItem ver;
    // End of variables declaration//GEN-END:variables
}

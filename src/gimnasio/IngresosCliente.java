package gimnasio;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class IngresosCliente extends javax.swing.JFrame {

    public IngresosCliente() {
        initComponents();
        setIcono();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingreso de socio");
        setFocusable(false);
        setResizable(false);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setText("Verificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero de cliente");

        jLabel2.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
BdPostgresql psql = new BdPostgresql();
public void setIcono(){
        ImageIcon icono=new ImageIcon(getClass().getResource("Accept Male User.png"));
        this.setIconImage(icono.getImage());

}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Locale.setDefault(Locale.US);
        int num=Integer.parseInt(jTextField1.getText());
        Connection conn = psql.conectar();
        
        java.util.Date fecha=null;
        java.util.Date hoy=new java.util.Date();
        int dia=0;
        try {
            ResultSet rs = psql.consulta("SELECT dias, fec_pago FROM cliente WHERE id_cliente='"+num+"';");
            while(rs.next()){
            fecha=rs.getDate("fec_pago");
            dia=rs.getInt("dias");
                System.out.println("fecha de pago"+fecha);
            }
            System.out.println("fecha actual"+hoy);
           
            
    if (dia<=30&&dia>0){
            JOptionPane.showMessageDialog(rootPane, "El cliente puede ingresar","Correcto",JOptionPane.INFORMATION_MESSAGE);
            Statement stmt=conn.createStatement();
            stmt.execute("UPDATE cliente SET dias='"+(dia-1)+"' WHERE id_cliente='"+num+"';");
             
    
    }
    else{

            JOptionPane.showMessageDialog(rootPane, "El cliente debe pagar su deuda para poder ingresar","Advertencia", JOptionPane.WARNING_MESSAGE);
            cobrar.main(num);
             
             
             
    }   
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "El cliente no se encuentra registrado en el sistema", "Error de sistema", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(IngresosCliente.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){
        JOptionPane.showMessageDialog(rootPane, "El cliente no se encuentra registrado en el sistema", "Error de sistema", JOptionPane.ERROR_MESSAGE);
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
char car = evt.getKeyChar();

if(!((car<'a' || car>'z') && (car<'A' || car>'Z')&&car !=(char)KeyEvent.VK_SPACE)){

    jLabel2.setText("Debe ingresar numeros solamente");
    evt.setKeyChar((char)KeyEvent.VK_BACK_SPACE);
}
else if(!(car<'0' || car>'9')) {
    jLabel2.setText("");
    }          }//GEN-LAST:event_jTextField1KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main() {
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
            java.util.logging.Logger.getLogger(IngresosCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresosCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresosCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresosCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        IngresosCliente in = new IngresosCliente();
        in.setVisible(true);
        in. setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

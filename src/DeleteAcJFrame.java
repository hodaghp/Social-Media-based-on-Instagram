
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hoda
 */
public class DeleteAcJFrame extends javax.swing.JFrame {

    /**
     * Creates new form DeleteAcJFrame
     */
    public DeleteAcJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();

        setTitle("Delete Account");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Are you sure you want to delete your account?");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Warning!");

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setText("Yes");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/socialnetwork","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");
            String sql="DELETE FROM user WHERE username=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, FirstJFrame.UN);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "The account was successfully deleted");
            connect.close();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/socialnetwork","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");
            String sql="DELETE FROM post WHERE username=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, FirstJFrame.UN);
            ps.executeUpdate();
            connect.close();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/socialnetwork","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");
            String sql="DELETE FROM comment WHERE username1=? OR username2=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, FirstJFrame.UN);
            ps.setString(2, FirstJFrame.UN);
            ps.executeUpdate();
            connect.close();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/socialnetwork","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");
            String sql="DELETE FROM follow WHERE username1=? OR username2=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, FirstJFrame.UN);
            ps.setString(2, FirstJFrame.UN);
            ps.executeUpdate();
            connect.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/socialnetwork","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");
            String sql="DELETE FROM likepost WHERE username1=? OR username2=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, FirstJFrame.UN);
            ps.setString(2, FirstJFrame.UN);
            ps.executeUpdate();
            connect.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
                
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/socialnetwork","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");
            String sql="DELETE FROM privatemessage WHERE username1=? OR username2=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, FirstJFrame.UN);
            ps.setString(2, FirstJFrame.UN);
            ps.executeUpdate();
            FirstJFrame frmf = new FirstJFrame();
            frmf.show();
            connect.close();
            this.hide();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteAcJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteAcJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteAcJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteAcJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteAcJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

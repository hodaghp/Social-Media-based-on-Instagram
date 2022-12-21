
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hoda
 */
public class ProfileJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ProfileJFrame
     */
    public ProfileJFrame() {
        initComponents();
        lblUserName.setText(FirstJFrame.UN);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/socialnetwork","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");
            String sql="SELECT post.username,post.txt,post.date FROM post,follow WHERE post.username = follow.username2 AND follow.username1=? ORDER BY date DESC";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, FirstJFrame.UN);
            ResultSet rs = ps.executeQuery();
            
            while(jTable1.getRowCount()>0){
                ((DefaultTableModel)jTable1.getModel()).removeRow(0);
            }
            
            while(rs.next()){
                ((DefaultTableModel)jTable1.getModel()).addRow(new Object[]{rs.getString("username"),rs.getString("txt"),rs.getString("date")});
            }
            connect.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRefresh = new javax.swing.JButton();
        btnPrivateMessage = new javax.swing.JButton();
        btnMyPost = new javax.swing.JButton();
        lblUserName = new javax.swing.JLabel();
        btnSerach = new javax.swing.JButton();
        btnFollower = new javax.swing.JButton();
        btnFollowing = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Profile");
        setResizable(false);

        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnPrivateMessage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPrivateMessage.setText("Message");
        btnPrivateMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrivateMessageActionPerformed(evt);
            }
        });

        btnMyPost.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMyPost.setText("My Posts");
        btnMyPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyPostActionPerformed(evt);
            }
        });

        lblUserName.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblUserName.setText("jLabel1");

        btnSerach.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSerach.setText("Search");
        btnSerach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSerachActionPerformed(evt);
            }
        });

        btnFollower.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnFollower.setText("Followers");
        btnFollower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFollowerActionPerformed(evt);
            }
        });

        btnFollowing.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnFollowing.setText("Following");
        btnFollowing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFollowingActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Delet Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "username", "post content", "date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPrivateMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMyPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSerach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFollower, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(btnFollowing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnPrivateMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnMyPost, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnSerach, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnFollower, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnFollowing, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        ProfileJFrame frmp = new ProfileJFrame();
        frmp.show();
        this.hide();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnPrivateMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrivateMessageActionPerformed
        // TODO add your handling code here:
        MessageBoxJFrame frmmb = new MessageBoxJFrame();
        frmmb.show();
    }//GEN-LAST:event_btnPrivateMessageActionPerformed

    private void btnMyPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyPostActionPerformed
        // TODO add your handling code here:
        MyPostJFrame frmmp = new MyPostJFrame();
        frmmp.show();
    }//GEN-LAST:event_btnMyPostActionPerformed

    private void btnSerachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSerachActionPerformed
        // TODO add your handling code here:
        SearchJFrame frms = new SearchJFrame();
        frms.show();
    }//GEN-LAST:event_btnSerachActionPerformed

    private void btnFollowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFollowerActionPerformed
        // TODO add your handling code here:
        FollowerJFrame frmfollower = new FollowerJFrame();
        frmfollower.show();
    }//GEN-LAST:event_btnFollowerActionPerformed

    private void btnFollowingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFollowingActionPerformed
        // TODO add your handling code here:
        FollowingJFrame frmfollowing = new FollowingJFrame();
        frmfollowing.show();
    }//GEN-LAST:event_btnFollowingActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DeleteAcJFrame frmd = new DeleteAcJFrame();
        frmd.show();
        this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRow = jTable1.getSelectedRow();
        String username = model.getValueAt(selectedRow, 0).toString();
        String post = model.getValueAt(selectedRow, 1).toString();
        String date = model.getValueAt(selectedRow, 2).toString();
        PostJFrame frmpost = new PostJFrame(username,post,date);
        frmpost.show();
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(ProfileJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfileJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFollower;
    private javax.swing.JButton btnFollowing;
    private javax.swing.JButton btnMyPost;
    private javax.swing.JButton btnPrivateMessage;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSerach;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblUserName;
    // End of variables declaration//GEN-END:variables
}
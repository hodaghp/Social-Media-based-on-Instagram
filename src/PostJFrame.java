
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
public class PostJFrame extends javax.swing.JFrame {

    /**
     * Creates new form PostJFrame
     */
    static String Pusername;
    static String Ppost;
    static String Pdate;
    public PostJFrame(String username,String post,String date) {
        initComponents();
        Pusername=username;
        Ppost=post;
        Pdate=date;
        lblDate.setText(date);
        txtPost.setText(post);
        Integer commentNumber = 0;
        Integer likeNumber = 0;
        //display comment and commentnumber
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/socialnetwork","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");  
            String sql="SELECT username1,comment FROM comment WHERE username2=? AND post=? AND date=? ORDER BY datecomment DESC";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Pusername);
            ps.setString(2, Ppost);
            ps.setString(3, Pdate);
            ResultSet rs = ps.executeQuery();
            
            while(jTable1.getRowCount()>0){
                ((DefaultTableModel)jTable1.getModel()).removeRow(0);
            }
            
            while(rs.next()){
                commentNumber++;
                lblCommentNumber.setText(commentNumber.toString());
                ((DefaultTableModel)jTable1.getModel()).addRow(new Object[]{rs.getString("username1"),rs.getString("comment")});
            }
            connect.close();
             
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        //LikeNumber
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/socialnetwork","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");  
            String sql="SELECT * FROM likepost WHERE username2=? AND post=? AND date=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Pusername);
            ps.setString(2, Ppost);
            ps.setString(3, Pdate);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                likeNumber++;
                lblLikeNumber.setText(likeNumber.toString());
            }
            connect.close();
             
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error1");
        }
        
        //display image
       try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/socialnetwork","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");  
            String sql="SELECT * FROM post WHERE username=? AND txt=? AND date=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Pusername);
            ps.setString(2, Ppost);
            ps.setString(3, Pdate);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                InputStream getImage = rs.getBinaryStream("pic");
                BufferedImage im = ImageIO.read(getImage);
                Image scaleImage = im.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), 0);
                ImageIcon icon = new ImageIcon(scaleImage);
                lblImage.setIcon(icon);
            }
            connect.close();
             
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error2");
        }
                
       //check like
       try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/socialnetwork","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");  
            String sql="SELECT * FROM likepost WHERE username1=? AND username2=? AND post=? AND date=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, FirstJFrame.UN);
            ps.setString(2,Pusername);
            ps.setString(3,Ppost);
            ps.setString(4, Pdate);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                btnLike.setSelected(true);
            }
            else{
                btnLike.setSelected(false);
            }
            connect.close();

       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error3");
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

        jLabel1 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPost = new javax.swing.JTextPane();
        lblImage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblLikeNumber = new javax.swing.JLabel();
        txtComment = new javax.swing.JTextField();
        btnComment = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblCommentNumber = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnLike = new javax.swing.JToggleButton();

        setTitle("Post");
        setPreferredSize(new java.awt.Dimension(969, 1020));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText(":Post Date");

        lblDate.setText("jLabel2");

        txtPost.setEnabled(false);
        jScrollPane1.setViewportView(txtPost);

        lblImage.setPreferredSize(new java.awt.Dimension(408, 439));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText(":Likes");

        lblLikeNumber.setText("0");

        btnComment.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnComment.setText("Comment");
        btnComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommentActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText(":Comments");

        lblCommentNumber.setText("0");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "username", "comment content"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        btnLike.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnLike.setForeground(new java.awt.Color(255, 51, 51));
        btnLike.setText("Like");
        btnLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLikeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtComment, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnComment)))
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(btnLike, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLikeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCommentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLikeNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCommentNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnLike, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComment, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommentActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/socialnetwork","root","");
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");  
            String sql="INSERT INTO comment(username1,username2,post,date,comment) VALUES(?,?,?,?,?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, FirstJFrame.UN);
            ps.setString(2,Pusername);
            ps.setString(3,Ppost);
            ps.setString(4, Pdate);
            ps.setString(5, txtComment.getText());
            ps.executeUpdate();
            
            PostJFrame frmp = new PostJFrame(Pusername, Ppost, Pdate);
            frmp.show();
            this.hide();
            connect.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btnCommentActionPerformed

    private void btnLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLikeActionPerformed
        // TODO add your handling code here:
        if(btnLike.isSelected()){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/socialnetwork","root","");
                //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");  
                String sql="INSERT INTO likepost VALUES(?,?,?,?)";
                PreparedStatement ps = connect.prepareStatement(sql);
                ps.setString(1, FirstJFrame.UN);
                ps.setString(2,Pusername);
                ps.setString(3,Ppost);
                ps.setString(4, Pdate);
                ps.executeUpdate();

                PostJFrame frmp = new PostJFrame(Pusername, Ppost, Pdate);
                frmp.show();
                this.hide();
                connect.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        else{
             try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/socialnetwork","root","");
                //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://your ip/Database Name","UserName","Password");  
                String sql="Delete FROM likepost WHERE username1=? AND username2=? AND post=? AND date=?";
                PreparedStatement ps = connect.prepareStatement(sql);
                ps.setString(1, FirstJFrame.UN);
                ps.setString(2,Pusername);
                ps.setString(3,Ppost);
                ps.setString(4, Pdate);
                ps.executeUpdate();

                PostJFrame frmp = new PostJFrame(Pusername, Ppost, Pdate);
                frmp.show();
                this.hide();
                connect.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }//GEN-LAST:event_btnLikeActionPerformed

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
            java.util.logging.Logger.getLogger(PostJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PostJFrame(Pusername,Ppost,Pdate).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComment;
    private javax.swing.JToggleButton btnLike;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCommentNumber;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblLikeNumber;
    private javax.swing.JTextField txtComment;
    private javax.swing.JTextPane txtPost;
    // End of variables declaration//GEN-END:variables
}

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Devjyot Singh Sidhu
 */
public class Veiw_passbook extends javax.swing.JFrame {

    /**
     * Creates new form Veiw_passbook
     */
    public Veiw_passbook() {
        initComponents();
        //color codes start
     
     Color backGround= new Color(74, 35, 90);
     this.getContentPane().setBackground(backGround);
        
     Color heading= new Color(210, 180, 222);
     jLabel1.setForeground(heading);
       
     Color font= new Color(155, 89, 182);
     jLabel2.setForeground(font);
     you_tf.setForeground(font);
        
     Color tf=new Color(232, 218, 239);
     you_tf.setBackground(tf);
       
     Color button= new Color(81, 46, 95);
     jButton2.setBackground(button);
     
     //color codes end

        
     try
     { 
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
     }
     catch (Exception e)
     { 
      e.printStackTrace(); 
     }
     
      passbook_tab.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 11 ));
    }
    
public Veiw_passbook(String username)
{
 initComponents();
 
 //color codes start
     
     Color backGround= new Color(74, 35, 90);
     this.getContentPane().setBackground(backGround);
        
     Color heading= new Color(210, 180, 222);
     jLabel1.setForeground(heading);
       
     Color font= new Color(155, 89, 182);
     jLabel2.setForeground(font);
     you_tf.setForeground(font);
        
     Color tf=new Color(232, 218, 239);
     you_tf.setBackground(tf);
       
     Color button= new Color(81, 46, 95);
     jButton2.setBackground(button);
     
     //color codes end


 you_tf.setText(username);
 DefaultTableModel model=(DefaultTableModel)passbook_tab.getModel();
 try
 {
 Class.forName("java.sql.DriverManager");
 Connection con;
 con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","amity");
 Statement smt=(Statement)con.createStatement();
 String query="Select * from transactions where username_sent='"+username+"' or username_recieved='"+username+"';";
 ResultSet rs=smt.executeQuery(query);
 while(rs.next())
 {
  String transaction_id=rs.getString("trans_id");
  String amount=rs.getString("amount");
  String username_sent=rs.getString("username_sent");
  String username_recieved=rs.getString("username_recieved");
  String transaction_date=rs.getString("trans_date");
  model.addRow
  (
   new Object[]
   {
    transaction_id, amount, username_sent, username_recieved, transaction_date
   }
  );
 }
 }
 catch(Exception e)
 {
  JOptionPane.showMessageDialog(this, e.getMessage());
 }
 
 try
 { 
  UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
 }
 catch (Exception e)
 { 
  e.printStackTrace(); 
 }
 
 passbook_tab.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 11 ));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        passbook_tab = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        you_tf = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Syndicate");

        passbook_tab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        passbook_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction Id", "Amount", "Sent to", "Recieved By", "Trasaction Date (yyyy-mm-dd)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(passbook_tab);
        if (passbook_tab.getColumnModel().getColumnCount() > 0) {
            passbook_tab.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Your Username");

        you_tf.setEditable(false);
        you_tf.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Go Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(you_tf)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(you_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//will take back to user home screen

String username=you_tf.getText();
new Home_screen(username).setVisible(true);
this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Veiw_passbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Veiw_passbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Veiw_passbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Veiw_passbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Veiw_passbook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable passbook_tab;
    private javax.swing.JTextField you_tf;
    // End of variables declaration//GEN-END:variables
}

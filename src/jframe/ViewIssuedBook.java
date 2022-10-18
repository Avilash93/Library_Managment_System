/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import java.awt.Color;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Avilash
 */
public class ViewIssuedBook extends javax.swing.JFrame {

    /**
     * Creates new form ViewIssuedBook
     */
    public ViewIssuedBook() {
        initComponents();
        setIssuedBookDetailsToTable();
    }

    //Get issued book details from DB and display it into table
    private void setIssuedBookDetailsToTable(){
          try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","12345");
           Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from issued_book where status='"+"pending"+"'");
            while(rs.next()){
                String issueId=rs.getString("id");
                String bookName=rs.getString("book_name");
                String studentName=rs.getString("student_name");
                String issueDate=rs.getString("issue_date");
                String dueDate=rs.getString("due_date");
                String status=rs.getString("status");
                
               DefaultTableModel tablemodel=(DefaultTableModel)table_issuedBook.getModel();
                Object[] table_contents={issueId,bookName,studentName,issueDate,dueDate,status};
                /*
                Adds a row to the end of the model. The new row will contain null values unless rowData
                is specified. Notification of the row being added will be generated.
                */
                tablemodel.addRow(table_contents);
            }
            
        } catch (Exception e) {
            
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

        jPanel1 = new javax.swing.JPanel();
        label_bookDetails = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_issuedBook = new rojerusan.RSTableMetro();
        jLabel13 = new javax.swing.JLabel();
        label_exit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(54, 60, 73));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_bookDetails.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_bookDetails.setForeground(new java.awt.Color(106, 110, 127));
        label_bookDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-book-60.png"))); // NOI18N
        label_bookDetails.setText("Iissued Book");
        jPanel1.add(label_bookDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 220, -1));

        table_issuedBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue Id", "Book Name ", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        table_issuedBook.setColorBackgoundHead(new java.awt.Color(40, 45, 55));
        table_issuedBook.setColorBordeFilas(new java.awt.Color(54, 60, 73));
        table_issuedBook.setColorBordeHead(new java.awt.Color(54, 60, 73));
        table_issuedBook.setColorFilasBackgound1(new java.awt.Color(40, 45, 55));
        table_issuedBook.setColorFilasBackgound2(new java.awt.Color(40, 45, 55));
        table_issuedBook.setColorForegroundHead(new java.awt.Color(106, 110, 127));
        table_issuedBook.setRowHeight(62);
        table_issuedBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_issuedBookMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_issuedBook);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 1040, 480));

        jLabel13.setBackground(new java.awt.Color(40, 45, 55));
        jLabel13.setForeground(new java.awt.Color(106, 110, 127));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Back");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(106, 110, 127)));
        jLabel13.setOpaque(true);
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, 110, 30));

        label_exit.setBackground(new java.awt.Color(54, 60, 73));
        label_exit.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        label_exit.setForeground(new java.awt.Color(255, 255, 255));
        label_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_exit.setText("X");
        label_exit.setOpaque(true);
        label_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_exitMouseExited(evt);
            }
        });
        jPanel1.add(label_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 50, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 680));

        setSize(new java.awt.Dimension(1185, 678));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table_issuedBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_issuedBookMouseClicked
       
    }//GEN-LAST:event_table_issuedBookMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void label_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_label_exitMouseClicked

    private void label_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_exitMouseEntered
        label_exit.setBackground(Color.red);
    }//GEN-LAST:event_label_exitMouseEntered

    private void label_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_exitMouseExited
        label_exit.setBackground(new Color(54,60,73));
    }//GEN-LAST:event_label_exitMouseExited

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
            java.util.logging.Logger.getLogger(ViewIssuedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewIssuedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewIssuedBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_bookDetails;
    private javax.swing.JLabel label_exit;
    private rojerusan.RSTableMetro table_issuedBook;
    // End of variables declaration//GEN-END:variables
}

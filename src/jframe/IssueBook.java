/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Owner
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }

    //Method to get book details
    private void getBookDetails(){
     
        int book_id=Integer.parseInt(txt_bookId.getText());
        try {
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","12345");
            PreparedStatement pstm=con.prepareStatement("select * from book_details where book_id=?");
            pstm.setInt(1, book_id);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
               label_bookId.setText(rs.getString("book_id"));
               label_bookName.setText(rs.getString("book_name"));
               label_author.setText(rs.getString("author_name"));
               label_quantity.setText(rs.getString("quantity"));
                 
            }
           
            } catch (Exception e) {
             e.printStackTrace();
            }
  
    }
    
    //Method to get Student details
    private void getStudentDetails(){  
        int student_id=Integer.parseInt(txt_studentId.getText());
        try {
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","12345");
            PreparedStatement pstm=con.prepareStatement("select * from student_details where student_id=?");
            pstm.setInt(1, student_id);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
              label_studentId.setText(rs.getString("student_id"));
              label_studentName.setText(rs.getString("name"));
              label_course.setText(rs.getString("course"));
              label_branch.setText(rs.getString("branch"));
              
               }                  
            }catch (Exception e) {
            e.printStackTrace();
            }
 
    }
    
    //method too enter issue book details to database
    private boolean  issueBook(){
        //getDatoFecha(), Custom dateChoser componet method to fetch selected date and return java.util.Date type
        java.util.Date utilIssueDate=dateC_issueDate.getDatoFecha();
        java.util.Date utilDueDate=dateC_dueDate.getDatoFecha();
        Long l1=utilIssueDate.getTime();
        long l2=utilDueDate.getTime();
        //But database supported date format is sql package date
        //Convert java.util.Date date format to java.sql.date format
        java.sql.Date sqlIssueDate=new java.sql.Date(l1);
        java.sql.Date sqlDueDate=new java.sql.Date(l2);
        try {
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","12345");
            PreparedStatement pstm=con.prepareStatement("insert into issued_book(student_id, student_name, book_id, book_name, issue_date, due_date, status)"
                    + "values(?,?,?,?,?,?,?)");
            
            pstm.setInt(1, Integer.parseInt(txt_studentId.getText()));
            pstm.setString(2, label_studentName.getText());
            pstm.setInt(3, Integer.parseInt(txt_bookId.getText()));
            pstm.setString(4, label_bookName.getText());
            pstm.setDate(5, sqlIssueDate);
            pstm.setDate(6, sqlDueDate);
             pstm.setString(7, "pending");
             int rowCount =pstm.executeUpdate();
             if(rowCount>0){
                 
                 return true;
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //Update book count after issuing corresponding book and update the display label_quantity count
    private void updateBookCount(){
        int book_id=Integer.parseInt(txt_bookId.getText());
         try {
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","12345");
            PreparedStatement pstm=con.prepareStatement("update book_details set quantity=quantity-1 where book_id=?");
            pstm.setInt(1, book_id);
            int rowCount=pstm.executeUpdate();
            if(rowCount>0){
                JOptionPane.showMessageDialog(this, "Book count updated");
                int quantity=Integer.parseInt(label_quantity.getText());
                label_quantity.setText(Integer.toString(quantity-1)); //update the display qunatity_label count
            }
            else{
                JOptionPane.showMessageDialog(this, "Book count updation failed");
            }
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Check if book is already issued to student or not
    private boolean isAlreadyIssued(){
          try {
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","12345");
            PreparedStatement pstm=con.prepareStatement("select * from issued_book where student_id=? and book_id=? and status=?");
            pstm.setInt(1, Integer.parseInt(txt_studentId.getText()));
            pstm.setInt(2, Integer.parseInt(txt_bookId.getText()));
            pstm.setString(3, "pending");
             ResultSet rs =pstm.executeQuery();
             if(rs.next()){ 
                 return true;
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        panel_bookDetails = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        label_bookDetails = new javax.swing.JLabel();
        label_quantity = new javax.swing.JLabel();
        label_bookId = new javax.swing.JLabel();
        label_bookName = new javax.swing.JLabel();
        label_author = new javax.swing.JLabel();
        panel_bookDetails1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        label_branch = new javax.swing.JLabel();
        label_studentId = new javax.swing.JLabel();
        label_studentName = new javax.swing.JLabel();
        label_course = new javax.swing.JLabel();
        label_bookDetails2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        label_bookIdError = new javax.swing.JLabel();
        txt_bookId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_studentId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        bttn_issueBook = new javax.swing.JButton();
        label_bookDetails1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        label_studentIdError = new javax.swing.JLabel();
        dateC_dueDate = new rojeru_san.componentes.RSDateChooser();
        dateC_issueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel13 = new javax.swing.JLabel();
        label_exit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(54, 60, 73));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_bookDetails.setBackground(new java.awt.Color(40, 45, 55));
        panel_bookDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(106, 110, 127));
        jLabel1.setText("Book Id");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panel_bookDetails.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 60, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(106, 110, 127));
        jLabel2.setText("Book Name");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panel_bookDetails.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 80, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(106, 110, 127));
        jLabel3.setText("Author Name");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panel_bookDetails.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 100, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(106, 110, 127));
        jLabel4.setText("Quantity");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panel_bookDetails.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 60, 30));

        label_bookDetails.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_bookDetails.setForeground(new java.awt.Color(106, 110, 127));
        label_bookDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManageBookIcon/icons8-book-60.png"))); // NOI18N
        label_bookDetails.setText("    Book Details");
        panel_bookDetails.add(label_bookDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 280, -1));

        label_quantity.setBackground(new java.awt.Color(40, 45, 55));
        label_quantity.setForeground(new java.awt.Color(106, 110, 127));
        label_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(54, 60, 73)));
        panel_bookDetails.add(label_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 295, 30));

        label_bookId.setBackground(new java.awt.Color(40, 45, 55));
        label_bookId.setForeground(new java.awt.Color(106, 110, 127));
        label_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(54, 60, 73)));
        panel_bookDetails.add(label_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 295, 30));

        label_bookName.setBackground(new java.awt.Color(40, 45, 55));
        label_bookName.setForeground(new java.awt.Color(106, 110, 127));
        label_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(54, 60, 73)));
        panel_bookDetails.add(label_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 295, 30));

        label_author.setBackground(new java.awt.Color(40, 45, 55));
        label_author.setForeground(new java.awt.Color(106, 110, 127));
        label_author.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(54, 60, 73)));
        panel_bookDetails.add(label_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 295, 30));

        panel_main.add(panel_bookDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 420, 600));

        panel_bookDetails1.setBackground(new java.awt.Color(40, 45, 55));
        panel_bookDetails1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(106, 110, 127));
        jLabel5.setText("Student Id");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panel_bookDetails1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 80, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(106, 110, 127));
        jLabel6.setText("Student Name");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panel_bookDetails1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(106, 110, 127));
        jLabel7.setText("Course");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panel_bookDetails1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 100, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(106, 110, 127));
        jLabel8.setText("Branch");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panel_bookDetails1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 60, 30));

        label_branch.setBackground(new java.awt.Color(40, 45, 55));
        label_branch.setForeground(new java.awt.Color(106, 110, 127));
        label_branch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(54, 60, 73)));
        panel_bookDetails1.add(label_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 295, 30));

        label_studentId.setBackground(new java.awt.Color(40, 45, 55));
        label_studentId.setForeground(new java.awt.Color(106, 110, 127));
        label_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(54, 60, 73)));
        panel_bookDetails1.add(label_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 295, 30));

        label_studentName.setBackground(new java.awt.Color(40, 45, 55));
        label_studentName.setForeground(new java.awt.Color(106, 110, 127));
        label_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(54, 60, 73)));
        panel_bookDetails1.add(label_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 295, 30));

        label_course.setBackground(new java.awt.Color(40, 45, 55));
        label_course.setForeground(new java.awt.Color(106, 110, 127));
        label_course.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(54, 60, 73)));
        panel_bookDetails1.add(label_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 295, 30));

        label_bookDetails2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_bookDetails2.setForeground(new java.awt.Color(106, 110, 127));
        label_bookDetails2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManageStudentIcon/icons8-student-60.png"))); // NOI18N
        label_bookDetails2.setText("    Student Details");
        panel_bookDetails1.add(label_bookDetails2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 280, -1));

        panel_main.add(panel_bookDetails1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 420, 600));

        jPanel2.setBackground(new java.awt.Color(40, 45, 55));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_bookIdError.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_bookIdError.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(label_bookIdError, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 200, 30));

        txt_bookId.setBackground(new java.awt.Color(40, 45, 55));
        txt_bookId.setForeground(new java.awt.Color(106, 110, 127));
        txt_bookId.setText("Enter Book Id");
        txt_bookId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 60, 73), 1, true));
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_bookIdMouseClicked(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        jPanel2.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 300, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(106, 110, 127));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManageStudentIcon/icons8-name-20.png"))); // NOI18N
        jLabel10.setText("Student Id");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 130, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(106, 110, 127));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManageStudentIcon/icons8-course-20.png"))); // NOI18N
        jLabel11.setText("Issue Date");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 130, 30));

        txt_studentId.setBackground(new java.awt.Color(40, 45, 55));
        txt_studentId.setForeground(new java.awt.Color(106, 110, 127));
        txt_studentId.setText("Enter Student Id");
        txt_studentId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 60, 73), 1, true));
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_studentIdMouseClicked(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel2.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 300, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(106, 110, 127));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManageStudentIcon/icons8-branching-arrows-20.png"))); // NOI18N
        jLabel12.setText("Due Date");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 120, 30));

        bttn_issueBook.setBackground(new java.awt.Color(40, 45, 55));
        bttn_issueBook.setForeground(new java.awt.Color(106, 110, 127));
        bttn_issueBook.setText("Issue Book");
        bttn_issueBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(106, 110, 127)));
        bttn_issueBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttn_issueBookActionPerformed(evt);
            }
        });
        jPanel2.add(bttn_issueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 110, 30));

        label_bookDetails1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_bookDetails1.setForeground(new java.awt.Color(106, 110, 127));
        label_bookDetails1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManageStudentIcon/icons8-student-60.png"))); // NOI18N
        label_bookDetails1.setText("    Student Details");
        jPanel2.add(label_bookDetails1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 280, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(106, 110, 127));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManageBookIcon/icons8-id-20.png"))); // NOI18N
        jLabel14.setText("Book Id");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, 30));

        label_studentIdError.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_studentIdError.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(label_studentIdError, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 200, 30));

        dateC_dueDate.setBackground(new java.awt.Color(102, 102, 102));
        dateC_dueDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 60, 73)));
        dateC_dueDate.setColorBackground(new java.awt.Color(40, 45, 55));
        dateC_dueDate.setColorForeground(new java.awt.Color(0, 0, 0));
        dateC_dueDate.setColorSelForeground(new java.awt.Color(204, 204, 204));
        dateC_dueDate.setColorTextDiaActual(new java.awt.Color(153, 153, 153));
        dateC_dueDate.setFuente(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(dateC_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 300, 30));

        dateC_issueDate.setBackground(new java.awt.Color(102, 102, 102));
        dateC_issueDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 60, 73)));
        dateC_issueDate.setColorBackground(new java.awt.Color(40, 45, 55));
        dateC_issueDate.setColorForeground(new java.awt.Color(0, 0, 0));
        dateC_issueDate.setColorSelForeground(new java.awt.Color(204, 204, 204));
        dateC_issueDate.setColorTextDiaActual(new java.awt.Color(153, 153, 153));
        dateC_issueDate.setFuente(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(dateC_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 300, 30));

        panel_main.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 420, 600));

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
        panel_main.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 110, 30));

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
        panel_main.add(label_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 0, 50, 30));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 700));

        setSize(new java.awt.Dimension(1352, 707));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bttn_issueBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttn_issueBookActionPerformed
      if(label_quantity.getText().equals("0")){
        JOptionPane.showMessageDialog(this, "Book not available");
      }
      else{
        if(!isAlreadyIssued()==true){ 
                if(issueBook()==true){
                    JOptionPane.showMessageDialog(this, "Book issued successfully");
                    updateBookCount();
                                    }
                else{
                     JOptionPane.showMessageDialog(this, "Failed to issue a book");
                     }
        }
      else{
          JOptionPane.showMessageDialog(this, "Student already have this book"); 
          }
      }
    
    }//GEN-LAST:event_bttn_issueBookActionPerformed

    private void txt_bookIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusGained
                if(txt_bookId.getText().equals("Enter Book Id")){
            txt_bookId.setText("");
        }
       else if(txt_bookId.getText().equals("")){
            label_bookIdError.setText("");
        }
    }//GEN-LAST:event_txt_bookIdFocusGained

    private void txt_bookIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_bookIdMouseClicked

    }//GEN-LAST:event_txt_bookIdMouseClicked

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusGained
        if(txt_studentId.getText().equals("Enter Student Id")){
            txt_studentId.setText("");
        }
         else if(txt_studentId.getText().equals("")){
            label_studentIdError.setText("");
        }
    }//GEN-LAST:event_txt_studentIdFocusGained

    private void txt_studentIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_studentIdMouseClicked
        if(txt_studentId.getText().equals("Enter Book Name")){
            txt_studentId.setText("");
        }
    }//GEN-LAST:event_txt_studentIdMouseClicked

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
      if(!txt_bookId.getText().equals("")){
          getBookDetails();
      }
       else{
           label_bookIdError.setText("BookId cannot be empty"); 
        }
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
      if(!txt_studentId.getText().equals("")){
          getStudentDetails();
      }
       else{
          label_studentIdError.setText("StudentId cannot be empty");
      }
           
    }//GEN-LAST:event_txt_studentIdFocusLost

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttn_issueBook;
    private rojeru_san.componentes.RSDateChooser dateC_dueDate;
    private rojeru_san.componentes.RSDateChooser dateC_issueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_author;
    private javax.swing.JLabel label_bookDetails;
    private javax.swing.JLabel label_bookDetails1;
    private javax.swing.JLabel label_bookDetails2;
    private javax.swing.JLabel label_bookId;
    private javax.swing.JLabel label_bookIdError;
    private javax.swing.JLabel label_bookName;
    private javax.swing.JLabel label_branch;
    private javax.swing.JLabel label_course;
    private javax.swing.JLabel label_exit;
    private javax.swing.JLabel label_quantity;
    private javax.swing.JLabel label_studentId;
    private javax.swing.JLabel label_studentIdError;
    private javax.swing.JLabel label_studentName;
    private javax.swing.JPanel panel_bookDetails;
    private javax.swing.JPanel panel_bookDetails1;
    private javax.swing.JPanel panel_main;
    private javax.swing.JTextField txt_bookId;
    private javax.swing.JTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import com.mysql.cj.protocol.Resultset;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Owner
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    
    Color mouseEnterColor=new Color(0,0,0);
    Color mouseExitColor=new Color(40,45,55);
    public HomePage() {
        initComponents();
        setBookDetailsToTable();
        setStudentDetailsToTable();
        setDataCard();
//        showPieChart();
    }
    
//    public void showPieChart(){
//        
//        //create dataset
//      DefaultPieDataset barDataset = new DefaultPieDataset( );
//      barDataset.setValue( "IPhone 5s" , new Double( 20 ) );  
//      barDataset.setValue( "SamSung Grand" , new Double( 20 ) );   
//      barDataset.setValue( "MotoG" , new Double( 40 ) );    
//      barDataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
//      
//      //create chart
//       JFreeChart piechart = ChartFactory.createPieChart("mobile sales",barDataset, false,true,false);//explain
//      
//        PiePlot piePlot =(PiePlot) piechart.getPlot();
//      
//       //changing pie chart blocks colors
//       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
//        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
//        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
//        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
//      
//       
//        piePlot.setBackgroundPaint(new Color(54,60,73));
//        
//        //create chartPanel to display chart(graph)
//        ChartPanel barChartPanel = new ChartPanel(piechart);
//        panelPieChart.removeAll();
//        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
//        panelPieChart.validate();
//    }

    
     //Setting Book details to table
    private void setStudentDetailsToTable(){
        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","12345");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from student_details");
            while(rs.next()){
                int studentid=rs.getInt("student_id");
                String name=rs.getString("name");
                String course=rs.getString("course");
                String branch=rs.getString("branch");
                DefaultTableModel tablemodel=(DefaultTableModel)table_studentDetails.getModel();
                Object[] table_contents={studentid,name,course,branch};
                /*
                Adds a row to the end of the model. The new row will contain null values unless rowData
                is specified. Notification of the row being added will be generated.
                */
                tablemodel.addRow(table_contents);
            }
            
        } catch (Exception e) {
            
        }
    }
    
    //Setting Book details to table
    private void setBookDetailsToTable(){
        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","12345");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from book_details");
            while(rs.next()){
                int bookid=rs.getInt("book_id");
                int quantity=rs.getInt("quantity");
                String name=rs.getString("book_name");
                String author=rs.getString("author_name");
                DefaultTableModel tablemodel=(DefaultTableModel)table_bookDetails.getModel();
                Object[] table_contents={bookid,name,author,quantity};
                /*
                Adds a row to the end of the model. The new row will contain null values unless rowData
                is specified. Notification of the row being added will be generated.
                */
                tablemodel.addRow(table_contents);
            }
            
        } catch (Exception e) {
            
        }
    }
    
    //Set No of details to small card
    private void setDataCard(){
         Long l= System.currentTimeMillis();
        Date todayDate=new Date(l);
        Statement st=null;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","12345");
            st=con.createStatement();
            //setting no of book label
            rs=st.executeQuery("select * from student_details");
            if(rs.last()){
                label_noOfBook.setText(Integer.toString(rs.getRow()));
            }
            //setting no of student label
             rs=st.executeQuery("select * from book_details");
            if(rs.last()){
                label_noOfStudent.setText(Integer.toString(rs.getRow()));
            }
            //set issue date label
             rs=st.executeQuery("select * from issued_book where status ='"+"pending"+"'");
            if(rs.last()){
                label_noOfIssuedBook.setText(Integer.toString(rs.getRow()));
            }
            
            //set defaulter list label
             rs=st.executeQuery("select * from issued_book where due_date < '"+todayDate+"' and status='"+"pending"+"'");
            if(rs.last()){
                label_noOfDefaulterList.setText(Integer.toString(rs.getRow()));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        label_exit = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panel_logout = new javax.swing.JPanel();
        label_logoout = new javax.swing.JLabel();
        panel_home = new javax.swing.JPanel();
        label_home = new javax.swing.JLabel();
        panel_manageBook = new javax.swing.JPanel();
        label_manageBooks = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panel_manageStudent = new javax.swing.JPanel();
        label_manageStudent = new javax.swing.JLabel();
        panel_issueBook = new javax.swing.JPanel();
        label_issueBook = new javax.swing.JLabel();
        panel_returnBook = new javax.swing.JPanel();
        label_returnBook = new javax.swing.JLabel();
        panel_viewRecord = new javax.swing.JPanel();
        label_viewRecord = new javax.swing.JLabel();
        panel_viewIssuedBook = new javax.swing.JPanel();
        label_viewIssuedBook = new javax.swing.JLabel();
        panel_defaulterList = new javax.swing.JPanel();
        label_defaulterList = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        label_noOfIssuedBook = new javax.swing.JLabel();
        label_noOfBook = new javax.swing.JLabel();
        label_noOfDefaulterList = new javax.swing.JLabel();
        label_noOfStudent = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_bookDetails = new rojerusan.RSTableMetro();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_studentDetails = new rojerusan.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(32, 36, 45));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 0, 20, 20));

        jLabel14.setForeground(new java.awt.Color(106, 110, 127));
        jLabel14.setText("Library  managment System");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 30));

        jLabel15.setForeground(new java.awt.Color(106, 110, 127));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/icons8-admin-settings-male-30.png"))); // NOI18N
        jLabel15.setText("Welcome,Admin");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 130, 30));

        label_exit.setBackground(new java.awt.Color(32, 36, 45));
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
        jPanel1.add(label_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 0, 50, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1260, 50));
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        jPanel2.setBackground(new java.awt.Color(40, 45, 55));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_logout.setBackground(new java.awt.Color(40, 45, 55));
        panel_logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_logoout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_logoout.setForeground(new java.awt.Color(106, 110, 127));
        label_logoout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/icons8-logout-20.png"))); // NOI18N
        label_logoout.setText("  Log out");
        label_logoout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_logooutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_logooutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_logooutMouseExited(evt);
            }
        });
        panel_logout.add(label_logoout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 50));

        jPanel2.add(panel_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 240, 50));

        panel_home.setBackground(new java.awt.Color(40, 45, 55));
        panel_home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_home.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_home.setForeground(new java.awt.Color(106, 110, 127));
        label_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/icons8-home-20.png"))); // NOI18N
        label_home.setText("  Home");
        label_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_homeMouseExited(evt);
            }
        });
        panel_home.add(label_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 50));

        jPanel2.add(panel_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 240, 50));

        panel_manageBook.setBackground(new java.awt.Color(40, 45, 55));
        panel_manageBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_manageBooks.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_manageBooks.setForeground(new java.awt.Color(106, 110, 127));
        label_manageBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/icons8-managebooks-20.png"))); // NOI18N
        label_manageBooks.setText("  Manage Books");
        label_manageBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_manageBooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_manageBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_manageBooksMouseExited(evt);
            }
        });
        panel_manageBook.add(label_manageBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 50));

        jPanel2.add(panel_manageBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 240, 50));

        jPanel5.setBackground(new java.awt.Color(40, 45, 55));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(106, 110, 127));
        jLabel6.setText("Features");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 240, 50));

        panel_manageStudent.setBackground(new java.awt.Color(40, 45, 55));
        panel_manageStudent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_manageStudent.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_manageStudent.setForeground(new java.awt.Color(106, 110, 127));
        label_manageStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/icons8-management-20.png"))); // NOI18N
        label_manageStudent.setText("   Manage Students");
        label_manageStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_manageStudentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_manageStudentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_manageStudentMouseExited(evt);
            }
        });
        panel_manageStudent.add(label_manageStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 50));

        jPanel2.add(panel_manageStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 240, 50));

        panel_issueBook.setBackground(new java.awt.Color(40, 45, 55));
        panel_issueBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_issueBook.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_issueBook.setForeground(new java.awt.Color(106, 110, 127));
        label_issueBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/icons8-issue-cart-20.png"))); // NOI18N
        label_issueBook.setText("   Issue Book");
        label_issueBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_issueBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_issueBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_issueBookMouseExited(evt);
            }
        });
        panel_issueBook.add(label_issueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 50));

        jPanel2.add(panel_issueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 240, 50));

        panel_returnBook.setBackground(new java.awt.Color(40, 45, 55));
        panel_returnBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_returnBook.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_returnBook.setForeground(new java.awt.Color(106, 110, 127));
        label_returnBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/icons8-return-purchase-20.png"))); // NOI18N
        label_returnBook.setText("  Return Book");
        label_returnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_returnBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_returnBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_returnBookMouseExited(evt);
            }
        });
        panel_returnBook.add(label_returnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 50));

        jPanel2.add(panel_returnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 240, 50));

        panel_viewRecord.setBackground(new java.awt.Color(40, 45, 55));
        panel_viewRecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_viewRecord.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_viewRecord.setForeground(new java.awt.Color(106, 110, 127));
        label_viewRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/icons8-day-view-20.png"))); // NOI18N
        label_viewRecord.setText("  View Records");
        label_viewRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_viewRecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_viewRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_viewRecordMouseExited(evt);
            }
        });
        panel_viewRecord.add(label_viewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 50));

        jPanel2.add(panel_viewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 240, 50));

        panel_viewIssuedBook.setBackground(new java.awt.Color(40, 45, 55));
        panel_viewIssuedBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_viewIssuedBook.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_viewIssuedBook.setForeground(new java.awt.Color(106, 110, 127));
        label_viewIssuedBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/icons8-issue-books-20.png"))); // NOI18N
        label_viewIssuedBook.setText("   View Issued Book");
        label_viewIssuedBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_viewIssuedBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_viewIssuedBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_viewIssuedBookMouseExited(evt);
            }
        });
        panel_viewIssuedBook.add(label_viewIssuedBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 50));

        jPanel2.add(panel_viewIssuedBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 240, 50));

        panel_defaulterList.setBackground(new java.awt.Color(40, 45, 55));
        panel_defaulterList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_defaulterList.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_defaulterList.setForeground(new java.awt.Color(106, 110, 127));
        label_defaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/icons8-default-list-20.png"))); // NOI18N
        label_defaulterList.setText("   Defaulter List");
        label_defaulterList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_defaulterListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_defaulterListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_defaulterListMouseExited(evt);
            }
        });
        panel_defaulterList.add(label_defaulterList, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 50));

        jPanel2.add(panel_defaulterList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 240, 50));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/Gift-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 930));

        jPanel9.setBackground(new java.awt.Color(54, 60, 73));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(106, 110, 127));
        jLabel17.setText("Book Details");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 130, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(106, 110, 127));
        jLabel18.setText("Student Details");
        jPanel9.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 130, -1));

        jPanel15.setBackground(new java.awt.Color(40, 45, 55));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(40, 45, 55));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(106, 110, 127));
        jLabel20.setText("No. Of Books");
        jPanel15.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        jLabel22.setBackground(new java.awt.Color(40, 45, 55));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(106, 110, 127));
        jLabel22.setText("No. Of Students");
        jPanel15.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 140, 30));

        jLabel24.setBackground(new java.awt.Color(40, 45, 55));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(106, 110, 127));
        jLabel24.setText("Issued Books");
        jPanel15.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 140, 30));

        jLabel26.setBackground(new java.awt.Color(40, 45, 55));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(106, 110, 127));
        jLabel26.setText("Defaulter List");
        jPanel15.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 100, 30));

        label_noOfIssuedBook.setBackground(new java.awt.Color(40, 45, 55));
        label_noOfIssuedBook.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_noOfIssuedBook.setForeground(new java.awt.Color(106, 110, 127));
        label_noOfIssuedBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/icons8-knowledge-sharing-20.png"))); // NOI18N
        label_noOfIssuedBook.setText("  10");
        label_noOfIssuedBook.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 60, 73), 1, true));
        jPanel15.add(label_noOfIssuedBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 80, 30));

        label_noOfBook.setBackground(new java.awt.Color(40, 45, 55));
        label_noOfBook.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_noOfBook.setForeground(new java.awt.Color(106, 110, 127));
        label_noOfBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/icons8-tidy-shelf-20.png"))); // NOI18N
        label_noOfBook.setText("  10");
        label_noOfBook.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 60, 73), 1, true));
        jPanel15.add(label_noOfBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 30));

        label_noOfDefaulterList.setBackground(new java.awt.Color(40, 45, 55));
        label_noOfDefaulterList.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_noOfDefaulterList.setForeground(new java.awt.Color(106, 110, 127));
        label_noOfDefaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/icons8-treatment-list-20.png"))); // NOI18N
        label_noOfDefaulterList.setText("  10");
        label_noOfDefaulterList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 60, 73), 1, true));
        jPanel15.add(label_noOfDefaulterList, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 50, 80, 30));

        label_noOfStudent.setBackground(new java.awt.Color(40, 45, 55));
        label_noOfStudent.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_noOfStudent.setForeground(new java.awt.Color(106, 110, 127));
        label_noOfStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin icon/icons8-people-20.png"))); // NOI18N
        label_noOfStudent.setText("  10");
        label_noOfStudent.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 60, 73), 1, true));
        jPanel15.add(label_noOfStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 80, 30));

        jPanel9.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 1120, 100));

        table_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name ", "Author Name", "Quantity"
            }
        ));
        table_bookDetails.setColorBackgoundHead(new java.awt.Color(40, 45, 55));
        table_bookDetails.setColorBordeFilas(new java.awt.Color(54, 60, 73));
        table_bookDetails.setColorBordeHead(new java.awt.Color(54, 60, 73));
        table_bookDetails.setColorFilasBackgound1(new java.awt.Color(40, 45, 55));
        table_bookDetails.setColorFilasBackgound2(new java.awt.Color(40, 45, 55));
        table_bookDetails.setColorForegroundHead(new java.awt.Color(106, 110, 127));
        table_bookDetails.setRowHeight(62);
        table_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_bookDetails);

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 1110, 240));

        table_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Student Name ", "Course", "Branch"
            }
        ));
        table_studentDetails.setColorBackgoundHead(new java.awt.Color(40, 45, 55));
        table_studentDetails.setColorBordeFilas(new java.awt.Color(54, 60, 73));
        table_studentDetails.setColorBordeHead(new java.awt.Color(54, 60, 73));
        table_studentDetails.setColorFilasBackgound1(new java.awt.Color(40, 45, 55));
        table_studentDetails.setColorFilasBackgound2(new java.awt.Color(40, 45, 55));
        table_studentDetails.setColorForegroundHead(new java.awt.Color(106, 110, 127));
        table_studentDetails.setRowHeight(62);
        table_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_studentDetails);

        jPanel9.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 1110, 240));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 1260, 800));

        setSize(new java.awt.Dimension(1500, 783));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void label_manageBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_manageBooksMouseClicked
        ManageBooks managebooks=new ManageBooks();
        managebooks.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_label_manageBooksMouseClicked

    private void label_manageBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_manageBooksMouseEntered
        panel_manageBook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_label_manageBooksMouseEntered

    private void label_manageStudentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_manageStudentMouseEntered
       panel_manageStudent.setBackground(mouseEnterColor);
    }//GEN-LAST:event_label_manageStudentMouseEntered

    private void label_manageStudentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_manageStudentMouseExited
         panel_manageStudent.setBackground(mouseExitColor);
    }//GEN-LAST:event_label_manageStudentMouseExited

    private void label_manageBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_manageBooksMouseExited
       panel_manageBook.setBackground(mouseExitColor);
    }//GEN-LAST:event_label_manageBooksMouseExited

    private void label_logooutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_logooutMouseEntered
      panel_logout.setBackground(mouseEnterColor);
    }//GEN-LAST:event_label_logooutMouseEntered

    private void label_logooutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_logooutMouseExited
          panel_logout.setBackground(mouseExitColor);
    }//GEN-LAST:event_label_logooutMouseExited

    private void label_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_homeMouseEntered
        panel_home.setBackground(mouseEnterColor);
    }//GEN-LAST:event_label_homeMouseEntered

    private void label_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_homeMouseExited
       panel_home.setBackground(mouseExitColor);
    }//GEN-LAST:event_label_homeMouseExited

    private void label_issueBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_issueBookMouseEntered
        panel_issueBook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_label_issueBookMouseEntered

    private void label_issueBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_issueBookMouseExited
     panel_issueBook.setBackground(mouseExitColor);
    }//GEN-LAST:event_label_issueBookMouseExited

    private void label_returnBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_returnBookMouseEntered
      panel_returnBook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_label_returnBookMouseEntered

    private void label_returnBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_returnBookMouseExited
      panel_returnBook.setBackground(mouseExitColor);
    }//GEN-LAST:event_label_returnBookMouseExited

    private void label_viewRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_viewRecordMouseEntered
         panel_viewRecord.setBackground(mouseEnterColor);
    }//GEN-LAST:event_label_viewRecordMouseEntered

    private void label_viewRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_viewRecordMouseExited
      panel_viewRecord.setBackground(mouseExitColor);
    }//GEN-LAST:event_label_viewRecordMouseExited

    private void label_viewIssuedBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_viewIssuedBookMouseEntered
        panel_viewIssuedBook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_label_viewIssuedBookMouseEntered

    private void label_viewIssuedBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_viewIssuedBookMouseExited
        panel_viewIssuedBook.setBackground(mouseExitColor);
    }//GEN-LAST:event_label_viewIssuedBookMouseExited

    private void label_defaulterListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_defaulterListMouseEntered
        panel_defaulterList.setBackground(mouseEnterColor);
    }//GEN-LAST:event_label_defaulterListMouseEntered

    private void label_defaulterListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_defaulterListMouseExited
      panel_defaulterList.setBackground(mouseExitColor);
    }//GEN-LAST:event_label_defaulterListMouseExited

    private void label_manageStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_manageStudentMouseClicked
        ManageStudents mngStudent=new ManageStudents();
        mngStudent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_label_manageStudentMouseClicked

    private void label_issueBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_issueBookMouseClicked
       IssueBook issuebook=new IssueBook();
       issuebook.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_label_issueBookMouseClicked

    private void label_viewRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_viewRecordMouseClicked
       ViewRecord record =new ViewRecord();
       record.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_label_viewRecordMouseClicked

    private void label_defaulterListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_defaulterListMouseClicked
       DefaulterList list=new DefaulterList();
       list.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_label_defaulterListMouseClicked

    private void table_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_bookDetailsMouseClicked

    }//GEN-LAST:event_table_bookDetailsMouseClicked

    private void table_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_studentDetailsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_studentDetailsMouseClicked

    private void label_returnBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_returnBookMouseClicked
        ReturnBook returnbook =new ReturnBook();
        returnbook.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_label_returnBookMouseClicked

    private void label_logooutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_logooutMouseClicked
       SignIn_Page signIn=new SignIn_Page();
       signIn.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_label_logooutMouseClicked

    private void label_viewIssuedBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_viewIssuedBookMouseClicked
       ViewIssuedBook issuedbook=new ViewIssuedBook();
       issuedbook.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_label_viewIssuedBookMouseClicked

    private void label_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_label_exitMouseClicked

    private void label_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_exitMouseEntered
        label_exit.setBackground(Color.red);
    }//GEN-LAST:event_label_exitMouseEntered

    private void label_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_exitMouseExited
        label_exit.setBackground(new Color(32,36,45));
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_defaulterList;
    private javax.swing.JLabel label_exit;
    private javax.swing.JLabel label_home;
    private javax.swing.JLabel label_issueBook;
    private javax.swing.JLabel label_logoout;
    private javax.swing.JLabel label_manageBooks;
    private javax.swing.JLabel label_manageStudent;
    private javax.swing.JLabel label_noOfBook;
    private javax.swing.JLabel label_noOfDefaulterList;
    private javax.swing.JLabel label_noOfIssuedBook;
    private javax.swing.JLabel label_noOfStudent;
    private javax.swing.JLabel label_returnBook;
    private javax.swing.JLabel label_viewIssuedBook;
    private javax.swing.JLabel label_viewRecord;
    private javax.swing.JPanel panel_defaulterList;
    private javax.swing.JPanel panel_home;
    private javax.swing.JPanel panel_issueBook;
    private javax.swing.JPanel panel_logout;
    private javax.swing.JPanel panel_manageBook;
    private javax.swing.JPanel panel_manageStudent;
    private javax.swing.JPanel panel_returnBook;
    private javax.swing.JPanel panel_viewIssuedBook;
    private javax.swing.JPanel panel_viewRecord;
    private rojerusan.RSTableMetro table_bookDetails;
    private rojerusan.RSTableMetro table_studentDetails;
    // End of variables declaration//GEN-END:variables
}

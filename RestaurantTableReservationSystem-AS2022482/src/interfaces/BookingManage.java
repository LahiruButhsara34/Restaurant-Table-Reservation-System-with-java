/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import codes.databaseConnection;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author user
 */
public class BookingManage extends javax.swing.JFrame {
   Connection conn = null;                                             
   PreparedStatement  pst=null; 
    /**
     * Creates new form Admin
     */
    public BookingManage() {
        initComponents();
        conn = databaseConnection.connect();
        bookingDetailsTableload();
   }
 public final void bookingDetailsTableload(){
        try {
            String sql="SELECT id AS ID,username AS Name,contact AS Contact,address AS Address ,email AS Email,date AS Booked_Date,"
                    + "timeSlotNo AS Time_Slot,tableA AS TableA,tableB AS TableB,tableC AS TableC,tableD AS TableD,"
                    + "tableE AS TableE,tableF AS TableF,price AS Price,submitday AS Submit_Day,submittime AS Submit_Time   FROM  customermanager"; 
            pst=conn.prepareStatement(sql);                     
            Resultset rs =  (Resultset) pst.executeQuery();                    
            bookingDetailsTable.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));
        } catch (Exception e) {
            System.out.println(e);
        }
   }
 public void bookingDetailsTabledata(){                                                        
        
        int row=bookingDetailsTable.getSelectedRow();                                              
        String cId=bookingDetailsTable.getValueAt(row, 0).toString();                     
        String cName=bookingDetailsTable.getValueAt(row, 1).toString();                   
        String cContact=bookingDetailsTable.getValueAt(row, 2).toString();                     
        String cAddress=bookingDetailsTable.getValueAt(row, 3).toString();
         String cEmail=bookingDetailsTable.getValueAt(row, 4).toString();                     
        String cDate=bookingDetailsTable.getValueAt(row, 5).toString();                 
        String cTimeSlotNo=bookingDetailsTable.getValueAt(row, 6).toString();                     
        String cTableA=bookingDetailsTable.getValueAt(row, 7).toString();  
         String cTableB=bookingDetailsTable.getValueAt(row, 8).toString();                     
        String cTableC=bookingDetailsTable.getValueAt(row, 9).toString();                   
        String cTableD=bookingDetailsTable.getValueAt(row, 10).toString();
         String cTableE=bookingDetailsTable.getValueAt(row, 11).toString();                   
        String cTableF=bookingDetailsTable.getValueAt(row, 12).toString();  
        String cPrice=bookingDetailsTable.getValueAt(row, 13).toString();
        String cSubmitday=bookingDetailsTable.getValueAt(row, 14).toString();  
        String cSubmittime=bookingDetailsTable.getValueAt(row, 15).toString();  
        
        txtID.setText(cId);
        txtName.setText(cName);
        txtContact.setText(cContact);
        txtAddress.setText(cAddress);
        txtEmail.setText(cEmail);
        txtBookedDate.setText(cDate);
        txtTimeSlot.setText(cTimeSlotNo);
        txtTableA.setText(cTableA);
        txtTableB.setText(cTableB);
        txtTableC.setText(cTableC);
        txtTableD.setText(cTableD);
        txtTableE.setText(cTableE);
        txtTableF.setText(cTableF);
        lblPrice.setText(cPrice);
        lblSubmitDate.setText(cSubmitday);
        lblSubmitTime.setText(cSubmittime);
 }
 public void search(){                                                                    
        
        String srch=txtSearchBox.getText();                                                     
        try {
            String sql="SELECT id AS ID,username AS Name,contact AS Contact,address AS Address ,email AS Email,date AS Booked_Date,"
                    + "timeSlotNo AS Time_Slot,tableA AS TableA,tableB AS TableB,tableC AS TableC,tableD AS TableD,"
                    + "tableE AS TableE,tableF AS TableF,price AS Price,submitday AS Submit_Day,submittime AS Submit_Time   FROM  "
                    + "customermanager WHERE  date LIKE '%"+srch+"%' OR username LIKE '%"+srch+"%'  OR contact LIKE '%"+srch+"%' "; 
            pst=conn.prepareStatement(sql);                                                       
            Resultset rs = (Resultset) pst.executeQuery();                                                          
           bookingDetailsTable.setModel(DbUtils.resultSetToTableModel((ResultSet) rs));                     
            
        } catch (Exception e) {                                                                        
            System.out.println(e);                                  
        }
  }
 private void delete() {     
        
    int response=JOptionPane.showConfirmDialog(this,"Are you Sure to Delete this record?" ,"Confirm", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                       if(response==JOptionPane.YES_OPTION) {
                            int cId = Integer.parseInt(txtID.getText());
                                try {
                                  String sql="DELETE FROM customermanager WHERE id='"+cId+"'  " ;  
                                  pst=conn.prepareStatement(sql);                                                      
                                  pst.execute(); 
                                  JOptionPane.showMessageDialog(null, "Deleted");  
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                bookingDetailsTableload();
                                clear();    
                        }
                       
 } 
 public void clear(){
          
        txtID.setText("");
        txtName.setText("");
        txtContact.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
        txtBookedDate.setText("");
        txtTimeSlot.setText("");
        txtTableA.setText("");
        txtTableB.setText("");
        txtTableC.setText("");
        txtTableD.setText("");
        txtTableE.setText("");
        txtTableF.setText("");
        lblPrice.setText("");
        lblSubmitDate.setText("");
        lblSubmitTime.setText("");
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookingDetailsTable = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtSearchBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTableA = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTableE = new javax.swing.JTextField();
        txtTableD = new javax.swing.JTextField();
        txtTableB = new javax.swing.JTextField();
        txtTableC = new javax.swing.JTextField();
        txtTableF = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTimeSlot = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblSubmitDate = new javax.swing.JLabel();
        lblSubmitTime = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        txtBookedDate = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        cmdClear = new javax.swing.JButton();
        cmdExit = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        cmdInsert = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cmdLogout = new javax.swing.JButton();
        cmdAdmin = new javax.swing.JButton();
        lblClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(102, 0, 102)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookingDetailsTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        bookingDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"23", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Contact", "Address", "Email", "Booked Date", "Time Slot", "Table A", "Table B", "Table C", "Table D", "Table E", "Table F", "Price", "Submit Day", "Submit Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookingDetailsTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        bookingDetailsTable.setColorFilasForeground1(new java.awt.Color(0, 51, 153));
        bookingDetailsTable.setColorFilasForeground2(new java.awt.Color(0, 51, 153));
        bookingDetailsTable.setFont(new java.awt.Font("Segoe UI", 0, 5)); // NOI18N
        bookingDetailsTable.setFuenteFilas(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bookingDetailsTable.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bookingDetailsTable.setFuenteHead(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        bookingDetailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingDetailsTableMouseClicked(evt);
            }
        });
        bookingDetailsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bookingDetailsTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(bookingDetailsTable);
        if (bookingDetailsTable.getColumnModel().getColumnCount() > 0) {
            bookingDetailsTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            bookingDetailsTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            bookingDetailsTable.getColumnModel().getColumn(2).setPreferredWidth(30);
            bookingDetailsTable.getColumnModel().getColumn(3).setPreferredWidth(300);
            bookingDetailsTable.getColumnModel().getColumn(4).setPreferredWidth(30);
            bookingDetailsTable.getColumnModel().getColumn(5).setPreferredWidth(30);
            bookingDetailsTable.getColumnModel().getColumn(6).setPreferredWidth(5);
            bookingDetailsTable.getColumnModel().getColumn(7).setPreferredWidth(5);
            bookingDetailsTable.getColumnModel().getColumn(8).setPreferredWidth(5);
            bookingDetailsTable.getColumnModel().getColumn(9).setResizable(false);
            bookingDetailsTable.getColumnModel().getColumn(9).setPreferredWidth(5);
            bookingDetailsTable.getColumnModel().getColumn(10).setResizable(false);
            bookingDetailsTable.getColumnModel().getColumn(10).setPreferredWidth(5);
            bookingDetailsTable.getColumnModel().getColumn(11).setPreferredWidth(5);
            bookingDetailsTable.getColumnModel().getColumn(12).setResizable(false);
            bookingDetailsTable.getColumnModel().getColumn(12).setPreferredWidth(2);
            bookingDetailsTable.getColumnModel().getColumn(13).setResizable(false);
            bookingDetailsTable.getColumnModel().getColumn(13).setPreferredWidth(30);
            bookingDetailsTable.getColumnModel().getColumn(14).setResizable(false);
            bookingDetailsTable.getColumnModel().getColumn(14).setPreferredWidth(30);
            bookingDetailsTable.getColumnModel().getColumn(15).setPreferredWidth(30);
        }

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1500, 450));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Booking Details");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBoxKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 40));

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("You can seach according  to Booked Date or  Name or Contact");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jPanel6.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 810, 80));

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("ID");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Contact");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Address");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Email");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Booked Date");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txtID.setForeground(new java.awt.Color(51, 0, 102));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 70, -1));

        txtName.setForeground(new java.awt.Color(51, 0, 102));
        jPanel2.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 320, -1));

        txtContact.setForeground(new java.awt.Color(51, 0, 102));
        jPanel2.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 120, -1));

        txtAddress.setForeground(new java.awt.Color(51, 0, 102));
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 470, -1));

        txtEmail.setForeground(new java.awt.Color(51, 0, 102));
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 180, -1));

        txtTableA.setForeground(new java.awt.Color(51, 0, 102));
        jPanel2.add(txtTableA, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 20, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Tables");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 60, 20));

        txtTableE.setForeground(new java.awt.Color(51, 0, 102));
        txtTableE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTableEActionPerformed(evt);
            }
        });
        jPanel2.add(txtTableE, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 20, -1));

        txtTableD.setForeground(new java.awt.Color(51, 0, 102));
        jPanel2.add(txtTableD, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 20, -1));

        txtTableB.setForeground(new java.awt.Color(51, 0, 102));
        jPanel2.add(txtTableB, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 20, -1));

        txtTableC.setForeground(new java.awt.Color(51, 0, 102));
        jPanel2.add(txtTableC, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 20, -1));

        txtTableF.setForeground(new java.awt.Color(51, 0, 102));
        jPanel2.add(txtTableF, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 20, -1));

        jLabel19.setText("A");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 760, -1, -1));

        jLabel23.setText("D");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        jLabel25.setText("E");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 10, -1));

        jLabel24.setText("C");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 20, -1));

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setText("ID");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel27.setText("Name");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel28.setText("Contact");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel29.setText("Address");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel30.setText("Email");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel31.setText("Booked Date");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));
        jPanel3.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));
        jPanel3.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));
        jPanel3.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));
        jPanel3.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));
        jPanel3.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 20, -1));

        jLabel32.setText("Tables");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 20, -1));
        jPanel3.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 20, -1));
        jPanel3.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 20, -1));
        jPanel3.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 20, -1));
        jPanel3.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 20, -1));

        jLabel33.setText("A");
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 760, -1, -1));

        jLabel34.setText("A");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        jLabel35.setText("B");
        jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 10, -1));

        jLabel36.setText("C");
        jPanel3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 590, 540, 270));

        jLabel37.setText("B");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 10, -1));

        jLabel38.setText("A");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jLabel39.setText("F");
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Time Slot");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        txtTimeSlot.setForeground(new java.awt.Color(51, 0, 102));
        jPanel2.add(txtTimeSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 40, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Submit Date");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Total Price");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 80, -1));

        lblSubmitDate.setForeground(new java.awt.Color(51, 0, 102));
        lblSubmitDate.setText("xxxx-xx-xx");
        jPanel2.add(lblSubmitDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        lblSubmitTime.setForeground(new java.awt.Color(51, 0, 102));
        lblSubmitTime.setText("xx:xx:xx xx");
        jPanel2.add(lblSubmitTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 70, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Submit Time");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 80, -1));

        jLabel10.setText(".00");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 20, -1));

        lblPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrice.setText("xxx");
        jPanel2.add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 260, 60, -1));

        txtBookedDate.setForeground(new java.awt.Color(51, 0, 102));
        jPanel2.add(txtBookedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 100, -1));

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 620, 280));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 5, true));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmdClear.setBackground(new java.awt.Color(0, 0, 204));
        cmdClear.setForeground(new java.awt.Color(204, 255, 255));
        cmdClear.setText("Clear");
        cmdClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmdClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdClearActionPerformed(evt);
            }
        });
        jPanel4.add(cmdClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 90, 40));

        cmdExit.setBackground(new java.awt.Color(0, 0, 204));
        cmdExit.setForeground(new java.awt.Color(204, 255, 255));
        cmdExit.setText("Exit");
        cmdExit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmdExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExitActionPerformed(evt);
            }
        });
        jPanel4.add(cmdExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 100, 50));

        cmdDelete.setBackground(new java.awt.Color(0, 0, 204));
        cmdDelete.setForeground(new java.awt.Color(204, 255, 255));
        cmdDelete.setText("Delete");
        cmdDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });
        jPanel4.add(cmdDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 90, 40));

        cmdInsert.setBackground(new java.awt.Color(0, 0, 204));
        cmdInsert.setForeground(new java.awt.Color(204, 255, 255));
        cmdInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/icons8_Home_26px_2.png"))); // NOI18N
        cmdInsert.setText("Insert");
        cmdInsert.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmdInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdInsertActionPerformed(evt);
            }
        });
        jPanel4.add(cmdInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 150, 50));

        jPanel6.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 600, 430, 230));

        jLabel12.setText("xxxxxxx");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, -1, -1));

        cmdLogout.setBackground(new java.awt.Color(255, 204, 204));
        cmdLogout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdLogout.setForeground(new java.awt.Color(204, 0, 51));
        cmdLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/icons8_Exit_26px_2.png"))); // NOI18N
        cmdLogout.setText("Log Out");
        cmdLogout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 153), 1, true));
        cmdLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLogoutActionPerformed(evt);
            }
        });
        jPanel6.add(cmdLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 780, 150, 50));

        cmdAdmin.setBackground(new java.awt.Color(255, 204, 204));
        cmdAdmin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdAdmin.setForeground(new java.awt.Color(204, 0, 51));
        cmdAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/Admin.png"))); // NOI18N
        cmdAdmin.setText("Admin");
        cmdAdmin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 153), 1, true));
        cmdAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAdminActionPerformed(evt);
            }
        });
        jPanel6.add(cmdAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 700, 150, 50));

        lblClose.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblClose.setForeground(new java.awt.Color(255, 0, 0));
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setText("X");
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        jPanel6.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 20, 40, 40));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 860));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtTableEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTableEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTableEActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void cmdInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdInsertActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Home view=new Home();
        view.setVisible(true); 
    }//GEN-LAST:event_cmdInsertActionPerformed

    private void bookingDetailsTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookingDetailsTableKeyReleased
        // TODO add your handling code here:
        bookingDetailsTabledata();
    }//GEN-LAST:event_bookingDetailsTableKeyReleased

    private void bookingDetailsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingDetailsTableMouseClicked
        // TODO add your handling code here:
        bookingDetailsTabledata();
    }//GEN-LAST:event_bookingDetailsTableMouseClicked

    private void txtSearchBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBoxKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txtSearchBoxKeyReleased

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void cmdClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdClearActionPerformed
        // TODO add your handling code here:
         clear(); 
    }//GEN-LAST:event_cmdClearActionPerformed

    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExitActionPerformed
        // TODO add your handling code here:
         System.exit(0);  
    }//GEN-LAST:event_cmdExitActionPerformed

    private void cmdLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLogoutActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Login view=new Login();
        view.setVisible(true);
    }//GEN-LAST:event_cmdLogoutActionPerformed

    private void cmdAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAdminActionPerformed
        // TODO add your handling code here:
         setVisible(false);
         Admin view=new Admin();
         view.setVisible(true);
    }//GEN-LAST:event_cmdAdminActionPerformed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

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
            java.util.logging.Logger.getLogger(BookingManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingManage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSTableMetro bookingDetailsTable;
    private javax.swing.JButton cmdAdmin;
    private javax.swing.JButton cmdClear;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdInsert;
    private javax.swing.JButton cmdLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSubmitDate;
    private javax.swing.JLabel lblSubmitTime;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBookedDate;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearchBox;
    private javax.swing.JTextField txtTableA;
    private javax.swing.JTextField txtTableB;
    private javax.swing.JTextField txtTableC;
    private javax.swing.JTextField txtTableD;
    private javax.swing.JTextField txtTableE;
    private javax.swing.JTextField txtTableF;
    private javax.swing.JTextField txtTimeSlot;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import codes.databaseConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author user
 */
public  class TableManager extends javax.swing.JFrame {
   Connection conn = null;                                             
   PreparedStatement  pst=null; 
   
    /**
     * Creates new form Home
     */
    public TableManager() {
        initComponents();
        conn = databaseConnection.connect();  
        currentDate();
        currentTime();
        textboxPermenentDisplay();
    }
    // current date setting
    public final void currentDate(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MMM-dd");
        String todaydate=sdf.format(date);
        lblDate.setText(todaydate);
     }
    // current time setting
    public final void currentTime(){
       new Timer(0,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss a");
             String nowtime=sdf.format(date);
             lblTime.setText(nowtime);
            }
        }).start();
        
    }
    public void updateTableDetails(){
          
            
             int cVipNormalTable = Integer.parseInt(txtVipNormalTable.getText());
             int cVipSpecialTable = Integer.parseInt(txtVipSpecialTable.getText());
             int cVipNormalSeats = Integer.parseInt(txtVipNormalSeats.getText());
             int cVipSpecialSeats = Integer.parseInt(txtVipSpecialSeats.getText());
             int cVipNormalPrice = Integer.parseInt(txtVipNormalPrice.getText());
             int cVipSpecialPrice = Integer.parseInt(txtVipSpecialPrice.getText());
             
             int cOutdoorNormalTable= Integer.parseInt(txtOutdoorNormalTable.getText());
             int cOutdoorSpecialTable = Integer.parseInt(txtOutdoorSpecialTable.getText());
             int cOutdoorNormalSeats = Integer.parseInt(txtOutdoorNormalSeats.getText());
             int cOutdoorSpecialSeats = Integer.parseInt(txtOutdoorSpecialSeats.getText());
             int cOutdoorNormalPrice= Integer.parseInt(txtOutdoorNormalPrice.getText());
             int cOutdoorSpecialPrice= Integer.parseInt(txtOutdoorSpecialPrice.getText());
             
             int cFirstfloorNormalTable = Integer.parseInt(txtFirstfloorNormalTable.getText());
             int cFirstfloorSpecialTable = Integer.parseInt(txtFirstfloorSpecialTable.getText());
             int cFirstfloorNormalSeats = Integer.parseInt( txtFirstfloorNormalSeats.getText());
             int cFirstfloorSpecialSeats = Integer.parseInt( txtFirstfloorSpecialSeats.getText());
             int cFirstfloorNormalPrice = Integer.parseInt( txtFirstfloorNormalPrice.getText());
             int cFirstfloorSpecialPrice = Integer.parseInt( txtFirstfloorSpecialPrice.getText());
             int number=1;
    
            
          try { 
              String query = "UPDATE tablemanager SET vipNormalTableCount=?,vipSpecialTableCount=?,vipNormalSeatCount=?,vipSpecialSeatCount=?,"
                      + "vipNormalTablePrice=?,vipSpecialTablePrice=?,outdoorNormalTableCount=?,outdoorSpecialTableCount=?,outdoorNormalSeatCount=?,"
                      + "outdoorSpecialSeatCount=?,outdoorNormalTablePrice=?,outdoorSpecialTablePrice=?,firstFloorNormalTableCount=?,"
                      + "firstFloorSpecialTableCount=?,firstFloorNormalSeatCount=?,firstFloorSpecialSeatCount=?,firstFloorNormalTablePrice=?,"
                      + "firstFloorSpecialTablePrice=? WHERE no=?";
              
              pst = conn.prepareStatement(query);
              pst.setInt(1, cVipNormalTable );
              pst.setInt(2, cVipSpecialTable);
              pst.setInt(3, cVipNormalSeats );
              pst.setInt(4, cVipSpecialSeats);
              pst.setInt(5, cVipNormalPrice);
              pst.setInt(6, cVipSpecialPrice);
              pst.setInt(7, cOutdoorNormalTable);
              pst.setInt(8, cOutdoorSpecialTable);
              pst.setInt(9, cOutdoorNormalSeats);
              pst.setInt(10, cOutdoorSpecialSeats);
              pst.setInt(11, cOutdoorNormalPrice);
              pst.setInt(12, cOutdoorSpecialPrice);
              pst.setInt(13, cFirstfloorNormalTable);
              pst.setInt(14, cFirstfloorSpecialTable);
              pst.setInt(15, cFirstfloorNormalSeats);
              pst.setInt(16, cFirstfloorSpecialSeats );
              pst.setInt(17, cFirstfloorNormalPrice);
              pst.setInt(18, cFirstfloorSpecialPrice); 
              pst.setInt(19, number);
              
              pst.executeUpdate();
              JOptionPane.showMessageDialog(null, "UPDATED");
            } 
           catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Try Again");
            } 
    }
      public final void textboxPermenentDisplay(){
           int number = 1;
          
           try {                                                        
            String query = "SELECT * FROM tablemanager ";
            pst=conn.prepareStatement(query); 
            ResultSet rs=pst.executeQuery(query);        

            while (rs.next()) {
                if (number==rs.getInt("no")) {
                    txtVipNormalTable.setText(String.valueOf(rs.getInt("vipNormalTableCount")));
                    txtVipSpecialTable.setText(String.valueOf(rs.getInt("vipSpecialTableCount")));
                    txtVipNormalSeats.setText(String.valueOf(rs.getInt("vipNormalSeatCount")));
                    txtVipSpecialSeats.setText(String.valueOf(rs.getInt("vipSpecialSeatCount")));
                    txtVipNormalPrice.setText(String.valueOf(rs.getInt("vipNormalTablePrice")));
                    txtVipSpecialPrice.setText(String.valueOf(rs.getInt("vipSpecialTablePrice")));

                    txtOutdoorNormalTable.setText(String.valueOf(rs.getInt("outdoorNormalTableCount")));
                    txtOutdoorSpecialTable.setText(String.valueOf(rs.getInt("outdoorSpecialTableCount")));
                    txtOutdoorNormalSeats.setText(String.valueOf(rs.getInt("outdoorNormalSeatCount")));
                    txtOutdoorSpecialSeats.setText(String.valueOf(rs.getInt("outdoorSpecialSeatCount")));
                    txtOutdoorNormalPrice.setText(String.valueOf(rs.getInt("outdoorNormalTablePrice")));
                    txtOutdoorSpecialPrice.setText(String.valueOf(rs.getInt("outdoorSpecialTablePrice")));

                    txtFirstfloorNormalTable.setText(String.valueOf(rs.getInt("firstFloorNormalTableCount")));
                    txtFirstfloorSpecialTable.setText(String.valueOf(rs.getInt("firstFloorSpecialTableCount")));
                    txtFirstfloorNormalSeats.setText(String.valueOf(rs.getInt("firstFloorNormalSeatCount")));
                    txtFirstfloorSpecialSeats.setText(String.valueOf(rs.getInt("firstFloorSpecialSeatCount")));
                    txtFirstfloorNormalPrice.setText(String.valueOf(rs.getInt("firstFloorNormalTablePrice")));
                    txtFirstfloorSpecialPrice.setText(String.valueOf(rs.getInt("firstFloorSpecialTablePrice")));
              }
            }
        }catch (Exception e) {
            System.out.println(e);
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
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDisplayUsername = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblTables = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        lblLogout = new javax.swing.JLabel();
        panelFirstFloorTables = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblFirstFloorTables = new javax.swing.JLabel();
        panelHomePage = new javax.swing.JPanel();
        lblHomePage = new javax.swing.JLabel();
        panelOutdoorTables = new javax.swing.JPanel();
        lblOutdoorables = new javax.swing.JLabel();
        panelVipFloorTables = new javax.swing.JPanel();
        lblVipFloorTabless = new javax.swing.JLabel();
        txtVipNormalPrice = new javax.swing.JTextField();
        lblFirstFloorTables1 = new javax.swing.JLabel();
        lblOutdoorables1 = new javax.swing.JLabel();
        txtVipNormalSeats = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtVipSpecialTable = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtOutdoorNormalTable = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtOutdoorNormalSeats = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtOutdoorNormalPrice = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtFirstfloorNormalTable = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtFirstfloorNormalSeats = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtFirstfloorNormalPrice = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtVipNormalTable = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtVipSpecialSeats = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtVipSpecialPrice = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtOutdoorSpecialTable = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtOutdoorSpecialSeats = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtOutdoorSpecialPrice = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtFirstfloorSpecialTable = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtFirstfloorSpecialSeats = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtFirstfloorSpecialPrice = new javax.swing.JTextField();
        cmdUpdate = new javax.swing.JButton();
        lblVipFloorTables2 = new javax.swing.JLabel();
        cmdAdmin = new javax.swing.JButton();
        cmdLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/icons8_menu_48px_1.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 5, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 10, 50, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TABLE MANAGER");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 420, 50));

        lblDisplayUsername.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblDisplayUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblDisplayUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/male_user_50px.png"))); // NOI18N
        lblDisplayUsername.setText("Welcome, XXX");
        jPanel4.add(lblDisplayUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, 240, 50));

        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("Date of Today ");
        jPanel4.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 190, 50));

        lblTime.setBackground(new java.awt.Color(51, 0, 51));
        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setText("Time Now");
        jPanel4.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 190, 50));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 70));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTables.setBackground(new java.awt.Color(255, 204, 204));
        lblTables.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTables.setForeground(new java.awt.Color(0, 204, 255));
        lblTables.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/table6.png"))); // NOI18N
        lblTables.setText("Table Dashboard");
        lblTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTablesMouseClicked(evt);
            }
        });
        jPanel7.add(lblTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 260, 40));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 340, 60));

        jLabel7.setBackground(new java.awt.Color(255, 204, 204));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Features");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 240, 40));

        panelLogout.setBackground(new java.awt.Color(0, 204, 204));
        panelLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelLogoutMouseClicked(evt);
            }
        });
        panelLogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogout.setBackground(new java.awt.Color(255, 204, 204));
        lblLogout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(204, 0, 51));
        lblLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/icons8_Exit_26px_2.png"))); // NOI18N
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });
        panelLogout.add(lblLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 240, -1));

        jPanel6.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 340, 70));

        panelFirstFloorTables.setBackground(new java.awt.Color(0, 0, 0));
        panelFirstFloorTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelFirstFloorTablesMouseClicked(evt);
            }
        });
        panelFirstFloorTables.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 204, 204));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/icons8_Home_26px_2.png"))); // NOI18N
        jLabel9.setText("Home Page");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, -1));

        panelFirstFloorTables.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 340, 60));

        lblFirstFloorTables.setBackground(new java.awt.Color(0, 0, 0));
        lblFirstFloorTables.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFirstFloorTables.setForeground(new java.awt.Color(0, 204, 255));
        lblFirstFloorTables.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFirstFloorTables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/table1.png"))); // NOI18N
        lblFirstFloorTables.setText("First Floor  Tables");
        lblFirstFloorTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFirstFloorTablesMouseClicked(evt);
            }
        });
        panelFirstFloorTables.add(lblFirstFloorTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 240, -1));

        jPanel6.add(panelFirstFloorTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 340, 60));

        panelHomePage.setBackground(new java.awt.Color(204, 204, 255));
        panelHomePage.setForeground(new java.awt.Color(0, 0, 51));
        panelHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelHomePageMouseClicked(evt);
            }
        });
        panelHomePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHomePage.setBackground(new java.awt.Color(255, 204, 204));
        lblHomePage.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHomePage.setForeground(new java.awt.Color(204, 0, 51));
        lblHomePage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/icons8_Home_26px_2.png"))); // NOI18N
        lblHomePage.setText("Home Page");
        lblHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomePageMouseClicked(evt);
            }
        });
        panelHomePage.add(lblHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 30));

        jPanel6.add(panelHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 340, 70));

        panelOutdoorTables.setBackground(new java.awt.Color(0, 0, 0));
        panelOutdoorTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelOutdoorTablesMouseClicked(evt);
            }
        });
        panelOutdoorTables.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOutdoorables.setBackground(new java.awt.Color(0, 0, 0));
        lblOutdoorables.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblOutdoorables.setForeground(new java.awt.Color(0, 204, 255));
        lblOutdoorables.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOutdoorables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/table1.png"))); // NOI18N
        lblOutdoorables.setText("Outdoor  Tables");
        lblOutdoorables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOutdoorablesMouseClicked(evt);
            }
        });
        panelOutdoorTables.add(lblOutdoorables, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 200, -1));

        jPanel6.add(panelOutdoorTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 340, 60));

        panelVipFloorTables.setBackground(new java.awt.Color(0, 0, 0));
        panelVipFloorTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelVipFloorTablesMouseClicked(evt);
            }
        });
        panelVipFloorTables.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVipFloorTabless.setBackground(new java.awt.Color(255, 204, 204));
        lblVipFloorTabless.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVipFloorTabless.setForeground(new java.awt.Color(0, 204, 255));
        lblVipFloorTabless.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVipFloorTabless.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/table1.png"))); // NOI18N
        lblVipFloorTabless.setText("VIP Floor  Tables");
        lblVipFloorTabless.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVipFloorTablessMouseClicked(evt);
            }
        });
        panelVipFloorTables.add(lblVipFloorTabless, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 18, 240, 30));

        jPanel6.add(panelVipFloorTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 340, 60));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 790));
        jPanel1.add(txtVipNormalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 190, 140, 40));

        lblFirstFloorTables1.setBackground(new java.awt.Color(0, 0, 0));
        lblFirstFloorTables1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFirstFloorTables1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFirstFloorTables1.setText("First Floor  Tables");
        lblFirstFloorTables1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFirstFloorTables1MouseClicked(evt);
            }
        });
        jPanel1.add(lblFirstFloorTables1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 600, 240, -1));

        lblOutdoorables1.setBackground(new java.awt.Color(0, 0, 0));
        lblOutdoorables1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblOutdoorables1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOutdoorables1.setText("Outdoor  Tables");
        lblOutdoorables1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOutdoorables1MouseClicked(evt);
            }
        });
        jPanel1.add(lblOutdoorables1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 220, -1));
        jPanel1.add(txtVipNormalSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 190, 140, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("Seats of one Table");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 170, 130, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Price of One Table");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 170, 130, -1));

        txtVipSpecialTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVipSpecialTableActionPerformed(evt);
            }
        });
        jPanel1.add(txtVipSpecialTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 140, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Number of Tables");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 140, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 102));
        jLabel11.setText("Normal");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 670, 200, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 0, 102));
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 200, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 102));
        jLabel8.setText("Normal");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 200, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setText("Number of Tables");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 140, -1));
        jPanel1.add(txtOutdoorNormalTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 140, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("Seats of one Table");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 410, 130, -1));
        jPanel1.add(txtOutdoorNormalSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 430, 140, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("Price of One Table");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 410, 130, -1));
        jPanel1.add(txtOutdoorNormalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 440, 140, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 0));
        jLabel17.setText("Number of Tables");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 660, 140, -1));
        jPanel1.add(txtFirstfloorNormalTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 680, 140, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("Seats of one Table");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 660, 130, -1));
        jPanel1.add(txtFirstfloorNormalSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 680, 140, 40));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("Price of One Table");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 660, 130, -1));
        jPanel1.add(txtFirstfloorNormalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 680, 140, 40));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 0, 102));
        jLabel20.setText("Normal");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 200, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setText("Number of Tables");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 140, -1));

        txtVipNormalTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVipNormalTableActionPerformed(evt);
            }
        });
        jPanel1.add(txtVipNormalTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 140, 40));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 0, 0));
        jLabel22.setText("Seats of one Table");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 170, 130, -1));
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 190, 120, 40));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 0, 0));
        jLabel23.setText("Price of One Table");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 170, 130, -1));
        jPanel1.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 190, 120, 40));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 0, 102));
        jLabel24.setText("Normal");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 200, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 0, 0));
        jLabel25.setText("Number of Tables");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 140, -1));
        jPanel1.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 140, 40));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 0, 0));
        jLabel26.setText("Seats of one Table");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 170, 130, -1));
        jPanel1.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 190, 120, 40));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 0, 0));
        jLabel27.setText("Price of One Table");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 170, 130, -1));
        jPanel1.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 190, 120, 40));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 0, 102));
        jLabel28.setText("Special");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 200, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 0, 0));
        jLabel29.setText("Number of Tables");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 140, -1));
        jPanel1.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 140, 40));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 0, 0));
        jLabel30.setText("Seats of one Table");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, 130, -1));
        jPanel1.add(txtVipSpecialSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 280, 140, 40));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(204, 0, 0));
        jLabel31.setText("Price of One Table");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 260, 130, -1));
        jPanel1.add(txtVipSpecialPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 280, 140, 40));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 0, 102));
        jLabel32.setText("Special");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 530, 200, -1));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(204, 0, 0));
        jLabel33.setText("Number of Tables");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 500, 140, -1));
        jPanel1.add(txtOutdoorSpecialTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 520, 140, 40));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(204, 0, 0));
        jLabel34.setText("Seats of one Table");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 500, 130, -1));
        jPanel1.add(txtOutdoorSpecialSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 520, 140, 40));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(204, 0, 0));
        jLabel35.setText("Price of One Table");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 500, 130, -1));
        jPanel1.add(txtOutdoorSpecialPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 520, 140, 40));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 0, 102));
        jLabel36.setText("Special");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 780, 200, -1));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(204, 0, 0));
        jLabel37.setText("Number of Tables");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 750, 140, -1));
        jPanel1.add(txtFirstfloorSpecialTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 770, 140, 40));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(204, 0, 0));
        jLabel38.setText("Seats of one Table");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 750, 130, -1));
        jPanel1.add(txtFirstfloorSpecialSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 770, 140, 40));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(204, 0, 0));
        jLabel39.setText("Price of One Table");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 750, 130, -1));
        jPanel1.add(txtFirstfloorSpecialPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 770, 140, 40));

        cmdUpdate.setBackground(new java.awt.Color(204, 204, 255));
        cmdUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmdUpdate.setText("UPDATE");
        cmdUpdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 8, true));
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(cmdUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 330, 150, 80));

        lblVipFloorTables2.setBackground(new java.awt.Color(255, 204, 204));
        lblVipFloorTables2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblVipFloorTables2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVipFloorTables2.setText("VIP Floor  Tables");
        lblVipFloorTables2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVipFloorTables2MouseClicked(evt);
            }
        });
        jPanel1.add(lblVipFloorTables2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 240, -1));

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
        jPanel1.add(cmdAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 680, 150, 50));

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
        jPanel1.add(cmdLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 770, 150, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 860));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
      System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void lblFirstFloorTables1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFirstFloorTables1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblFirstFloorTables1MouseClicked

    private void lblOutdoorables1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutdoorables1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblOutdoorables1MouseClicked

    private void txtVipSpecialTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVipSpecialTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVipSpecialTableActionPerformed

    private void txtVipNormalTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVipNormalTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVipNormalTableActionPerformed

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
        // TODO add your handling code here:
        updateTableDetails();
        textboxPermenentDisplay();
        
        
       
        
        
        
        
    }//GEN-LAST:event_cmdUpdateActionPerformed

    private void panelVipFloorTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVipFloorTablesMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_panelVipFloorTablesMouseClicked

    private void lblVipFloorTablessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVipFloorTablessMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        VipFloorTables view=new VipFloorTables();
        view.setVisible(true);
    }//GEN-LAST:event_lblVipFloorTablessMouseClicked

    private void panelOutdoorTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOutdoorTablesMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_panelOutdoorTablesMouseClicked

    private void lblOutdoorablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutdoorablesMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        OutdoorTables view=new OutdoorTables();
        view.setVisible(true);
    }//GEN-LAST:event_lblOutdoorablesMouseClicked

    private void panelHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHomePageMouseClicked
        // TODO add your handling code here:
        

    }//GEN-LAST:event_panelHomePageMouseClicked

    private void lblHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        Home view=new Home();
        view.setVisible(true);
    }//GEN-LAST:event_lblHomePageMouseClicked

    private void panelFirstFloorTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFirstFloorTablesMouseClicked
        // TODO add your handling code here:
       
       
    }//GEN-LAST:event_panelFirstFloorTablesMouseClicked

    private void lblFirstFloorTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFirstFloorTablesMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        FirstFloorTables view=new FirstFloorTables();
        view.setVisible(true);

    }//GEN-LAST:event_lblFirstFloorTablesMouseClicked

    private void panelLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLogoutMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_panelLogoutMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        // TODO add your handling code here:
          setVisible(false);
          Login view=new Login();
          view.setVisible(true);
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTablesMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_lblTablesMouseClicked

    private void lblVipFloorTables2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVipFloorTables2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblVipFloorTables2MouseClicked

    private void cmdAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAdminActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Admin view=new Admin();
        view.setVisible(true);
    }//GEN-LAST:event_cmdAdminActionPerformed

    private void cmdLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLogoutActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Login view=new Login();
        view.setVisible(true);
    }//GEN-LAST:event_cmdLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(TableManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAdmin;
    private javax.swing.JButton cmdLogout;
    private javax.swing.JButton cmdUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JLabel lblDate;
    public javax.swing.JLabel lblDisplayUsername;
    private javax.swing.JLabel lblFirstFloorTables;
    private javax.swing.JLabel lblFirstFloorTables1;
    private javax.swing.JLabel lblHomePage;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblOutdoorables;
    private javax.swing.JLabel lblOutdoorables1;
    private javax.swing.JLabel lblTables;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblVipFloorTables2;
    private javax.swing.JLabel lblVipFloorTabless;
    private javax.swing.JPanel panelFirstFloorTables;
    private javax.swing.JPanel panelHomePage;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelOutdoorTables;
    private javax.swing.JPanel panelVipFloorTables;
    private javax.swing.JTextField txtFirstfloorNormalPrice;
    private javax.swing.JTextField txtFirstfloorNormalSeats;
    private javax.swing.JTextField txtFirstfloorNormalTable;
    private javax.swing.JTextField txtFirstfloorSpecialPrice;
    private javax.swing.JTextField txtFirstfloorSpecialSeats;
    private javax.swing.JTextField txtFirstfloorSpecialTable;
    private javax.swing.JTextField txtOutdoorNormalPrice;
    private javax.swing.JTextField txtOutdoorNormalSeats;
    private javax.swing.JTextField txtOutdoorNormalTable;
    private javax.swing.JTextField txtOutdoorSpecialPrice;
    private javax.swing.JTextField txtOutdoorSpecialSeats;
    private javax.swing.JTextField txtOutdoorSpecialTable;
    private javax.swing.JTextField txtVipNormalPrice;
    private javax.swing.JTextField txtVipNormalSeats;
    private javax.swing.JTextField txtVipNormalTable;
    private javax.swing.JTextField txtVipSpecialPrice;
    private javax.swing.JTextField txtVipSpecialSeats;
    private javax.swing.JTextField txtVipSpecialTable;
    // End of variables declaration//GEN-END:variables
}

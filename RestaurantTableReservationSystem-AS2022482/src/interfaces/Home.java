/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import codes.databaseConnection;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 *
 * @author user
 */
public class Home extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        conn = databaseConnection.connect();
        currentDate();
        currentTime();
        selectChooseTimeunclick();
        forOneDayBookingItemSeenFalse();
        forDateRangeBookingItemSeenFalse();
        cmdOk.setVisible(false);

    }

    // current date setting
    public final void currentDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
        String todaydate = sdf.format(date);
        lblDate.setText(todaydate);
    }

    // current time setting
    public final void currentTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                String nowtime = sdf.format(date);
                lblTime.setText(nowtime);
            }
        }).start();

    }

    public final void selectChooseTimeunclick() {
        lblForChooseTime.setVisible(false);
        lblmsg.setVisible(false);
        chkTime1.setVisible(false);
        chkTime2.setVisible(false);
        chkTime3.setVisible(false);
        chkTime4.setVisible(false);
        chkTime5.setVisible(false);
        chkTime6.setVisible(false);
        chkTime7.setVisible(false);
        chkTime8.setVisible(false);
        chkTime9.setVisible(false);
        chkTime10.setVisible(false);
        chkTime11.setVisible(false);
        chkTime12.setVisible(false);
    }

    public void selectChooseTimeclick() {
        lblForChooseTime.setVisible(true);
        lblmsg.setVisible(true);
        chkTime1.setVisible(true);
        chkTime2.setVisible(true);
        chkTime3.setVisible(true);
        chkTime4.setVisible(true);
        chkTime5.setVisible(true);
        chkTime6.setVisible(true);
        chkTime7.setVisible(true);
        chkTime8.setVisible(true);
        chkTime9.setVisible(true);
        chkTime10.setVisible(true);
        chkTime11.setVisible(true);
        chkTime12.setVisible(true);
    }

    public final void forOneDayBookingItemSeenFalse() {
        dateChooserCalender1.setVisible(false);
    }

    public void forOneDayBookingItemSeenTrue() {
        dateChooserCalender1.setVisible(true);
    }

    public final void forDateRangeBookingItemSeenFalse() {
        dateChooserCalender2.setVisible(false);
        dateChooserCalender3.setVisible(false);
        lblFrom.setVisible(false);
        lblTo.setVisible(false);
    }

    public void forDateRangeBookingItemSeenTrue() {
        dateChooserCalender2.setVisible(true);
        dateChooserCalender3.setVisible(true);
        lblFrom.setVisible(true);
        lblTo.setVisible(true);
    }

    String cName;
    String cContact;
    String cAddress;
    String cEmail;
    String cBookingTime = "";
    String cBookingType = "";
    String cStartDay = "";
    String cEndDay = "";
    String cTableA = "";
    String cTableB = "";
    String cTableC = "";
    String cTableD = "";
    String cTableE = "";
    String cTableF = "";
    String cBookDate;
    int timerange ;
    String submitDate;
    String submitTime;
    int countTableA = 0, countTableB = 0, countTableC = 0, countTableD = 0, countTableE = 0, countTableF = 0;
    int totalpayment ;
    
    private void getDataFormValues() throws ParseException, SQLException {
        submitdateAndTime();
        cName = txtName.getText();
        cContact = txtContactNo.getText();
        cAddress = txtAddress.getText();
        cEmail = txtEmail.getText();

        try {
            if (optForOneDay.isSelected()) {

                cBookingType = optForOneDay.getText();

                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                cStartDay = sdf1.format(dateChooserCalender1.getDate());

            } else if (optForDateRange.isSelected()) {
                cBookingType = optForDateRange.getText();
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                cStartDay = sdf1.format(dateChooserCalender2.getDate());
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                cEndDay = sdf2.format(dateChooserCalender3.getDate());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Date insert correctly!");
        }

        if (optChooseTime.isSelected()) {

            if (chkTime1.isSelected()) {
                cBookingTime = "choose1";

            } else if (chkTime2.isSelected()) {
                cBookingTime = "choose2";
            } else if (chkTime3.isSelected()) {
                cBookingTime = "choose3";
            } else if (chkTime4.isSelected()) {
                cBookingTime = "choose4";
            } else if (chkTime5.isSelected()) {
                cBookingTime = "choose5";
            } else if (chkTime6.isSelected()) {
                cBookingTime = "choose6";
            } else if (chkTime7.isSelected()) {
                cBookingTime = "choose7";
            } else if (chkTime8.isSelected()) {
                cBookingTime = "choose8";
            } else if (chkTime9.isSelected()) {
                cBookingTime = "choose9";
            } else if (chkTime10.isSelected()) {
                cBookingTime = "choose10";
            } else if (chkTime11.isSelected()) {
                cBookingTime = "choose11";
            } else if (chkTime12.isSelected()) {
                cBookingTime = "choose12";
            }
        } else if (optFullDay.isSelected()) {
            cBookingTime = "FullDay";
        } else if (optFirstHalf.isSelected()) {
            cBookingTime = "FirstHalf";
        } else if (optSecondHalf.isSelected()) {
            cBookingTime = "SecondHalf";
        }

     }

   
/////////////////////////////////////////////////////////////////////////   DayRange main Start/////////////////////////////////////////////////////////////////////////////
    
   
 public void dayRangetimerangeValue() throws ParseException, SQLException {
                                                                                            //System.out.println("Check line 220");
        Date from = new SimpleDateFormat("yyyy-MM-dd").parse(cStartDay);
        Date to = new SimpleDateFormat("yyyy-MM-dd").parse(cEndDay);

        long t1 = from.getTime();
        long t2 = to.getTime();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (t1 < t2) {
            for (long i = t1; i <= t2; i += 86400000) {
                cBookDate = format.format(i);
                System.out.println(format.format(i));
                if (optChooseTime.isSelected()) {

                    if (chkTime1.isSelected()) {
                        timerange = 1;
                                                                                            //System.out.println("Check line 236");
                        try {
                            getDataFormValues();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                            //System.out.println("Check line 242");
                        try {
                            insertValuesFordatabaseType2();

                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                             //System.out.println("Check line 249");
                    } else if (chkTime2.isSelected()) {
                        timerange = 2;
                                                                                              //System.out.println("Check line 252");
                         try {
                            getDataFormValues();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                              //System.out.println("Check line 258");
                        try {
                            insertValuesFordatabaseType2();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                               //System.out.println("Check line 264");
                    } else if (chkTime3.isSelected()) {
                        timerange = 3;
                                                                                               //System.out.println("Check line 267");
                       try {
                            getDataFormValues();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                               //System.out.println("Check line 273");
                        try {
                           insertValuesFordatabaseType2();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                               //System.out.println("Check line 279");
                    } else if (chkTime4.isSelected()) {
                        timerange = 4;
                                                                                               //System.out.println("Check line 282");
                        try {
                            getDataFormValues();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                               //System.out.println("Check line 288");
                        try {
                            insertValuesFordatabaseType2();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                              //System.out.println("Check line 294");
                    } else if (chkTime5.isSelected()) {
                        timerange = 5;
                                                                                              //System.out.println("Check line 297");
                        try {
                            getDataFormValues();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                               //System.out.println("Check line 303");
                        try {
                            insertValuesFordatabaseType2();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                              //System.out.println("Check line 309");
                    } else if (chkTime6.isSelected()) {
                        timerange = 6;
                                                                                              //System.out.println("Check line 312);
                        try {
                            getDataFormValues();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                               //System.out.println("Check line 318");
                        try {
                           insertValuesFordatabaseType2();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                               //System.out.println("Check line 324");
                    } else if (chkTime7.isSelected()) {
                        timerange = 7;
                                                                                               //System.out.println("Check line 327");
                        try {
                            getDataFormValues();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                               //System.out.println("Check line 333");
                        try {
                            insertValuesFordatabaseType2();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                               //System.out.println("Check line 339");
                    } else if (chkTime8.isSelected()) {
                        timerange = 8;
                                                                                               //System.out.println("Check line 342");
                        try {
                            getDataFormValues();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                               //System.out.println("Check line 348");
                        try {
                            insertValuesFordatabaseType2();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                               //System.out.println("Check line 354");
                    } else if (chkTime9.isSelected()) {
                         timerange = 9;
                                                                                               //System.out.println("Check line 357");
                        try {
                            getDataFormValues();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                                //System.out.println("Check line 363");
                        try {
                            insertValuesFordatabaseType2();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                                //System.out.println("Check line 369");
                    } else if (chkTime10.isSelected()) {
                        timerange = 10;
                                                                                               //System.out.println("Check line 372");
                        try {
                            getDataFormValues();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                                //System.out.println("Check line 378");
                        try {
                            insertValuesFordatabaseType2();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                                 //System.out.println("Check line 384");
                    } else if (chkTime11.isSelected()) {
                         timerange = 11;
                                                                                                 //System.out.println("Check line 387");
                        try {
                            getDataFormValues();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                                  //System.out.println("Check line 393");
                        try {
                            insertValuesFordatabaseType2();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                                   //System.out.println("Check line 399");
                    } else if (chkTime12.isSelected()) {
                        timerange = 12;
                                                                                                    //System.out.println("Check line 402");
                        try {
                            getDataFormValues();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                                    //System.out.println("Check line 408");
                        try {
                             insertValuesFordatabaseType2();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                                    //System.out.println("Check line 414");
                    }
                    

                } else if (optFullDay.isSelected()) {
                    for (int j = 1; j <= 12; j++) {
                        timerange = j;
                                                                                                   //System.out.println("Check line 421");
                        try {
                            getDataFormValues();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                                    //System.out.println("Check line 427");
                        try {
                            insertValuesFordatabaseType2();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                                    //System.out.println("Check line 433");
                    }
                } else if (optFirstHalf.isSelected()) {
                    for (int j = 1; j <= 6; j++) {
                        timerange = j;
                                                                                                    //System.out.println("Check line 438");
                        try {
                            getDataFormValues();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                                    //System.out.println("Check line 444");
                        try {
                            insertValuesFordatabaseType2();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                                                                                                    //System.out.println("Check line 450");
                     }
                } else if (optSecondHalf.isSelected()) {
                   for (int j = 7; j <= 12; j++) {
                    timerange = j;
                                                                                                    //System.out.println("Check line 455");
                    try {
                        getDataFormValues();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                                                                                                    //System.out.println("Check line 461");
                    try {
                        insertValuesFordatabaseType2();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                                                                                                   //System.out.println("Check line 467");
                 }
              }
            }
        } 
    }
 ////////////////////////////////////////////////////////////////////////////////////   DayRange main end/////////////////////////////////////////////////////////////////////////////
  
 /////////////////////////////////////////////////////////////////////////   OneDay main Start/////////////////////////////////////////////////////////////////////////////

    public void onedaytimerangeValue() {
         if (optChooseTime.isSelected()) {

            if (chkTime1.isSelected()) {
                timerange = 1;
                                                                                               //System.out.println("Check line 482");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                                //System.out.println("Check line 488");
                try {
                    insertValuesFordatabaseType1();
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                                 //System.out.println("Check line 495");
              
            } else if (chkTime2.isSelected()) {
                timerange = 2;
                                                                                                //System.out.println("Check line 499");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                                //System.out.println("Check line 505");
                try {
                   insertValuesFordatabaseType1();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                                //System.out.println("Check line 511");
            } else if (chkTime3.isSelected()) {
                timerange = 3;
                                                                                                //System.out.println("Check line 514");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                               //System.out.println("Check line 520");
                try {
                    insertValuesFordatabaseType1();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                               //System.out.println("Check line 526");
            } else if (chkTime4.isSelected()) {
                timerange = 4;
                                                                                              //System.out.println("Check line 529");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                              //System.out.println("Check line 535");
                try {
                   insertValuesFordatabaseType1();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                              //System.out.println("Check line 541");
            } else if (chkTime5.isSelected()) {
                timerange = 5;
                                                                                              //System.out.println("Check line 544");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                               //System.out.println("Check line 550");
                try {
                    insertValuesFordatabaseType1();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                               //System.out.println("Check line 556");
            } else if (chkTime6.isSelected()) {
                timerange = 6;
                                                                                              //System.out.println("Check line 559");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                              //System.out.println("Check line 565");
                try {
                    insertValuesFordatabaseType1();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                              //System.out.println("Check line 571");
            } else if (chkTime7.isSelected()) {
                timerange = 7;
                                                                                             //System.out.println("Check line 574");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                             //System.out.println("Check line 580");
                try {
                    insertValuesFordatabaseType1();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                            //System.out.println("Check line 586");
            } else if (chkTime8.isSelected()) {
                timerange = 8;
                                                                                            //System.out.println("Check line 589");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                             //System.out.println("Check line 595");
                try {
                    insertValuesFordatabaseType1();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                             //System.out.println("Check line 601");
            } else if (chkTime9.isSelected()) {
                timerange = 9;
                                                                                             //System.out.println("Check line 604");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                            //System.out.println("Check line 610");
                try {
                    insertValuesFordatabaseType1();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                           //System.out.println("Check line 616");
            } else if (chkTime10.isSelected()) {
                timerange = 10;
                                                                                           //System.out.println("Check line 619");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                           //System.out.println("Check line 625");
                try {
                    insertValuesFordatabaseType1();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                            //System.out.println("Check line 631");
            } else if (chkTime11.isSelected()) {
                timerange = 11;
                                                                                            //System.out.println("Check line 634");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                            //System.out.println("Check line 640");
                try {
                  insertValuesFordatabaseType1();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                            //System.out.println("Check line 646");
            } else if (chkTime12.isSelected()) {
                timerange = 12;
                                                                                            //System.out.println("Check line 649");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                             //System.out.println("Check line 655");
                try {
                    insertValuesFordatabaseType1();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                             //System.out.println("Check line 661");
            }
            
        } else if (optFullDay.isSelected()) {
            for (int j = 1; j <= 12; j++) {
                timerange = j;
                                                                                             //System.out.println("Check line 667");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                            //System.out.println("Check line 673");
                try {
                    insertValuesFordatabaseType1();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                            //System.out.println("Check line 679");
            }
        } else if (optFirstHalf.isSelected()) {
            for (int j = 1; j <= 6; j++) {
                timerange = j;
                                                                                           //System.out.println("Check line 684");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                           //System.out.println("Check line 690");
                try {
                    insertValuesFordatabaseType1();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                          //System.out.println("Check line 696");
            }
        } else if (optSecondHalf.isSelected()) {
            for (int j = 7; j <= 12; j++) {
                timerange = j;
                                                                                          //System.out.println("Check line 701");
                try {
                    getDataFormValues();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                          //System.out.println("Check line 707");
                try {
                    insertValuesFordatabaseType1();
                } catch (Exception e) {
                    System.out.println(e);
                }
                                                                                         //System.out.println("Check line 713");
            }

        }
   }
 //////////////////////////////////////////////////////////////////////////////////////OneDay main end///////////////////////////////////////////////////////////////////////////////
   
    
//////////////////////////////////////////////////////////////////////////////////////Payment calculate Start/////////////////////////////////////////////////////////////////////////////////////
    private void customerpayment() {
        if (txtName.getText().equals("Enter  your name...")) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Name");
        }
        if (txtContactNo.getText().equals("Enter Contact No...")) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Phone number");
        }
        if (txtAddress.getText().equals("Enter your Address...")) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Address");
        }
        if (txtEmail.getText().equals("Enter your Email...")) {
            JOptionPane.showMessageDialog(null, "Please Enter Your Email");
        }
        if (!optForOneDay.isSelected() && !optForDateRange.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please Select Booking Date Format");
        }

        if (!optChooseTime.isSelected() && !optFullDay.isSelected() && !optFirstHalf.isSelected() && !optSecondHalf.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please Select Booking Time Format");
        }
        if (optChooseTime.isSelected()) {
            if (!chkTime1.isSelected() && !chkTime2.isSelected() && !chkTime3.isSelected() && !chkTime4.isSelected() && !chkTime5.isSelected() && !chkTime6.isSelected()
                    && !chkTime7.isSelected() && !chkTime8.isSelected() && !chkTime9.isSelected()
                    && !chkTime10.isSelected() && !chkTime11.isSelected() && !chkTime12.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please Select Your Time Slot");
            }
        }
        if (!ChkTableA.isSelected() && !ChkTableB.isSelected() && !ChkTableC.isSelected() && !ChkTableD.isSelected() && !ChkTableE.isSelected() && !ChkTableF.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please Select Your Tables");
        }
        System.out.println("payment");//
        totalpayment = getPaymentValue();
        lblIntDigit.setText(String.valueOf(totalpayment));
    }
////////////////////////////////////////////////////Payment calculate End/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    private final int getPaymentValue() {
        int number = 1;
        int totalprice = 0;
        int priceTableA = 0, priceTableB = 0, priceTableC = 0, priceTableD = 0, priceTableE = 0, priceTableF = 0;
        int custtomerSelectTablesOneHourPrice = 0;
        try {
            String query = "SELECT * FROM tablemanager";
            pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery(query);

            while (rs.next()) {
                if (number == rs.getInt("no")) {
                    if (ChkTableA.isSelected()) {
                        priceTableA = rs.getInt("firstFloorNormalTablePrice");
                    }
                    if (ChkTableB.isSelected()) {
                        priceTableB = rs.getInt("firstFloorSpecialTablePrice");
                    }
                    if (ChkTableC.isSelected()) {
                        priceTableC = rs.getInt("outdoorNormalTablePrice");
                    }
                    if (ChkTableD.isSelected()) {
                        priceTableD = rs.getInt("outdoorSpecialTablePrice");
                    }
                    if (ChkTableE.isSelected()) {
                        priceTableE = rs.getInt("vipNormalTablePrice");
                    }
                    if (ChkTableF.isSelected()) {
                        priceTableE = rs.getInt("vipSpecialTablePrice");
                    }

                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        custtomerSelectTablesOneHourPrice = priceTableA + priceTableB + priceTableC + priceTableD + priceTableE + priceTableF;
        System.out.println( custtomerSelectTablesOneHourPrice);//delete after
        int hourTotal = 0;

        switch (cBookingTime) {
            case "choose1":
                hourTotal = 1;
                break;
            case "choose2":
                hourTotal = 1;
                break;
            case "choose3":
                hourTotal = 1;
                break;
            case "choose4":
                hourTotal = 1;
                break;
            case "choose5":
                hourTotal = 1;
                break;
            case "choose6":
                hourTotal = 1;
                break;
            case "choose7":
                hourTotal = 1;
                break;
            case "choose8":
                hourTotal = 1;
                break;
            case "choose9":
                hourTotal = 1;
                break;
            case "choose10":
                hourTotal = 1;
                break;
            case "choose11":
                hourTotal = 1;
                break;
            case "choose12":
                hourTotal = 1;
                break;
            case "FullDay":
                hourTotal = 12;
                break;
            case "FirstHalf":
                hourTotal = 6;
                break;
            case "SecondHalf":
                hourTotal = 6;
                break;
            default:
                break;
        }
        if (optForOneDay.isSelected()) {
            totalprice = custtomerSelectTablesOneHourPrice * hourTotal;
            System.out.println(hourTotal);//after Delete
        } else if (optForDateRange.isSelected()) {
            totalprice = custtomerSelectTablesOneHourPrice * hourTotal * noOfDaysWithRange();
        }
        return totalprice;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //for calculate no of days
 public int noOfDaysWithRange() {
        int noOfDays = 0;

        try {

            if (cStartDay != null && cEndDay != null) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date customerStartDate = dateChooserCalender2.getDate();
                Date customerEndDate = dateChooserCalender3.getDate();

                long diffInMillies = Math.abs(customerEndDate.getTime() - customerStartDate.getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

                noOfDays = (int) diff + 1;
                System.out.println(noOfDays);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return noOfDays;
    }
 
//Below method use to get table count of  First Floor Tables,Outdoor Tables & Vip Floor Tables 
    public void tableCount() {                                                                
        int number = 1;
        //int countTableA=0,countTableB=0,countTableC=0,countTableD=0,countTableE=0,countTableF=0;

        try {
            String query = "SELECT * FROM tablemanager";
            pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery(query);

            while (rs.next()) {
                if (number == rs.getInt("no")) {
                    countTableA = rs.getInt("firstFloorNormalTableCount");
                    countTableB = rs.getInt("firstFloorSpecialTableCount");
                    countTableC = rs.getInt("outdoorNormalTableCount");
                    countTableD = rs.getInt("outdoorSpecialTableCount");
                    countTableE = rs.getInt("vipNormalTableCount");
                    countTableF = rs.getInt("vipSpecialTableCount");
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void insertValuesFordatabaseType1() throws ParseException, SQLException {
        tableCount();
        int bookedTablecount;
  if (optForOneDay.isSelected()) {
      if (ChkTableA.isSelected()) {
                                                                                                       //System.out.println("Check line 914");//for error chekeing-delete
        try{
            String sql = "SELECT count(tableA) FROM customermanager WHERE date = ? AND timeSlotNo = ? AND tableA = ? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1,cStartDay);
            pst.setInt(2, timerange);
            pst.setString(3, "Y");
            ResultSet rs = pst.executeQuery();
                                                                                                        //System.out.println(timerange);//for timerange   cheking-delete
          
            if (rs.next()) {
                 bookedTablecount= rs.getInt("count(tableA)");
                if(bookedTablecount<countTableA){
                    cTableA="Y";
                    cTableB="";
                    cTableC="";
                    cTableD="";
                    cTableE="";
                    cTableF="";
                    onedayquery() ;
                }
                else{
                   JOptionPane.showMessageDialog(rootPane, " All Table A are already  Booked.Please select Other Option" , "Error", 0);
                   System.exit(0);
                 }
            }
        }catch(Exception e){
           System.out.println(e);
       }
     }
    
   if (ChkTableB.isSelected()) {
                                                                                                    //System.out.println("Check line 946");//for error chekeing-delete
      try{
        String sql = "SELECT count(tableB) FROM customermanager WHERE date = ? AND timeSlotNo = ? AND tableB = ? ";
        pst = conn.prepareStatement(sql);
        pst.setString(1,cStartDay);
        pst.setInt(2, timerange);
        pst.setString(3, "Y");
        ResultSet rs = pst.executeQuery();
       
        if (rs.next()) {
            bookedTablecount= rs.getInt("count(tableB)");
           if(bookedTablecount<countTableB){
                cTableA="";
                cTableB="Y";
                cTableC="";
                cTableD="";
                cTableE="";
                cTableF="";
                onedayquery() ;
          }
           else{
                JOptionPane.showMessageDialog(rootPane, " All Table B are already  Booked.Please select Other Option" , "Error", 0);
                System.exit(0);
          }
        }
      }catch(Exception e){ 
       System.out.println(e);
     }
   }
    
  
      if (ChkTableC.isSelected()) {
                                                                                                              //System.out.println("Check line 978");//for error chekeing-delete
       try{
            String sql = "SELECT count(tableC) FROM customermanager WHERE date = ? AND timeSlotNo = ? AND tableC = ? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1,cStartDay);
            pst.setInt(2, timerange);
            pst.setString(3, "Y");
            ResultSet rs = pst.executeQuery();
                
           if (rs.next()) {
                   bookedTablecount= rs.getInt("count(tableC)");
                if(bookedTablecount<countTableC){
                    cTableA="";
                    cTableB="";
                    cTableC="Y";
                    cTableD="";
                    cTableE="";
                    cTableF="";
                    onedayquery() ;
                 }
                else{
                   JOptionPane.showMessageDialog(rootPane, " All Table C are already  Booked.Please select Other Option" , "Error", 0);
                   System.exit(0);
                }
            }
        }catch(Exception e){
           System.out.println(e);
       }
     }
    
   
      if (ChkTableD.isSelected()) {
                                                                                                            //System.out.println("Check line 1010");//for error chekeing-delete
         try{
            String sql = "SELECT count(tableD) FROM customermanager WHERE date = ? AND timeSlotNo = ? AND tableD = ? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1,cStartDay);
            pst.setInt(2, timerange);
            pst.setString(3, "Y");
            ResultSet rs = pst.executeQuery();
                
           if (rs.next()) {
                 bookedTablecount= rs.getInt("count(tableD)");
                if(bookedTablecount<countTableD){
                    cTableA="";
                    cTableB="";
                    cTableC="";
                    cTableD="Y";
                    cTableE="";
                    cTableF="";
                    onedayquery() ;
                 }
                else{
                    JOptionPane.showMessageDialog(rootPane, " All Table D are already  Booked.Please select Other Option" , "Error", 0);
                    System.exit(0);
               }
           }
        }catch(Exception e){
           System.out.println(e);
       }
     }
   
  
       if (ChkTableE.isSelected()) {
                                                                                                           //System.out.println("Check line 1042");//for error chekeing-delete
         try{
            String sql = "SELECT count(tableE) FROM customermanager WHERE date = ? AND timeSlotNo = ? AND tableE = ? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1,cStartDay);
            pst.setInt(2, timerange);
            pst.setString(3, "Y");
            ResultSet rs = pst.executeQuery();
               
           if (rs.next()) {
                 bookedTablecount= rs.getInt("count(tableE)");
               if(bookedTablecount<countTableE){
                    cTableA="";
                    cTableB="";
                    cTableC="";
                    cTableD="";
                    cTableE="Y";
                    cTableF="";
                   onedayquery() ;
               }
               else{
                    JOptionPane.showMessageDialog(rootPane, " All Table E are already  Booked.Please select Other Option" , "Error", 0);
                    System.exit(0);
               }
           }
        }catch(Exception e){
           System.out.println(e);
       }
     }
     
  
      if (ChkTableF.isSelected()) {
                                                                                                          //System.out.println("Check line 1074");//for error chekeing-delete
       try{
            String sql = "SELECT count(tableF) FROM customermanager WHERE date = ? AND timeSlotNo = ? AND tableF = ? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1,cStartDay);
            pst.setInt(2, timerange);
            pst.setString(3, "Y");
            ResultSet rs = pst.executeQuery();
               
            if (rs.next()) {
                 bookedTablecount= rs.getInt("count(tableF)");
                if(bookedTablecount<countTableF){
                    cTableA="";
                    cTableB="";
                    cTableC="";
                    cTableD="";
                    cTableE="";
                    cTableF="Y";
                    onedayquery() ;
                     
                }
               else{
                 JOptionPane.showMessageDialog(rootPane, " All Table F are already  Booked.Please select Other Option" , "Error", 0);
                 System.exit(0);
              }
            }
          }catch(Exception e){
           System.out.println(e);
         }
     }
  }  
}  
public void insertValuesFordatabaseType2() throws ParseException, SQLException {
                                                                                                             //System.out.println("Check line 1107");//for error chekeing-delete
        tableCount();
        int bookedTablecount=0;
  if (optForDateRange.isSelected()) {
      if (ChkTableA.isSelected()) {
                                                                                                            //System.out.println("Check line 1112");//for error chekeing-delete
        try{
            String sql = "SELECT count(tableA) FROM customermanager WHERE date = ? AND timeSlotNo = ? AND tableA = ? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1,cBookDate);
            pst.setInt(2, timerange);
            pst.setString(3, "Y");
            ResultSet rs = pst.executeQuery();
            System.out.println(timerange);//for timerange   cheking-delete
          
            if (rs.next()) {
                bookedTablecount= rs.getInt("count(tableA)");
                if(bookedTablecount<countTableA){
                    cTableA="Y";
                    cTableB="";
                    cTableC="";
                    cTableD="";
                    cTableE="";
                    cTableF="";
                    dateRangequery();
                }
                else{
                   JOptionPane.showMessageDialog(rootPane, " All Table A are already  Booked.Please select Other Option" , "Error", 0);
                   System.exit(0);
                }
            }
        }catch(Exception e){
           System.out.println(e);
       }
     }
    
   if (ChkTableB.isSelected()) {
                                                                                                            //System.out.println("Check line 1144");//for error chekeing-delete
      try{
        String sql = "SELECT count(tableB) FROM customermanager WHERE date = ? AND timeSlotNo = ? AND tableB = ? ";
        pst = conn.prepareStatement(sql);
        pst.setString(1,cBookDate);
        pst.setInt(2, timerange);
        pst.setString(3, "Y");
        ResultSet rs = pst.executeQuery();
       
        if (rs.next()) {
            System.out.println("u");
            bookedTablecount= rs.getInt("count(tableB)");
           if(bookedTablecount<countTableB){
                cTableA="";
                cTableB="Y";
                cTableC="";
                cTableD="";
                cTableE="";
                cTableF="";
                dateRangequery();
           }
           else{
              JOptionPane.showMessageDialog(rootPane, " All Table B are already  Booked.Please select Other Option" , "Error", 0);
              System.exit(0);              
          }
        }
      }catch(Exception e){
       System.out.println(e);
     }
   }
    
  
      if (ChkTableC.isSelected()) {
                                                                                                          //System.out.println("Check line 1177");//for error chekeing-delete
       try{
            String sql = "SELECT count(tableC) FROM customermanager WHERE date = ? AND timeSlotNo = ? AND tableC = ? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1,cBookDate);
            pst.setInt(2, timerange);
            pst.setString(3, "Y");
            ResultSet rs = pst.executeQuery();
                
           if (rs.next()) {
                   bookedTablecount= rs.getInt("count(tableC)");
                if(bookedTablecount<countTableC){
                    cTableA="";
                    cTableB="";
                    cTableC="Y";
                    cTableD="";
                    cTableE="";
                    cTableF="";
                    dateRangequery();
                }
                else{
                  JOptionPane.showMessageDialog(rootPane, " All Table C are already  Booked.Please select Other Option" , "Error", 0);
                  System.exit(0);
                }
            }
        }catch(Exception e){
           System.out.println(e);
       }
     }
    
   
      if (ChkTableD.isSelected()) {
                                                                                                          //System.out.println("Check line 1209");//for error chekeing-delete
         try{
            String sql = "SELECT count(tableD) FROM customermanager WHERE date = ? AND timeSlotNo = ? AND tableD = ? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1,cBookDate);
            pst.setInt(2, timerange);
            pst.setString(3, "Y");
            ResultSet rs = pst.executeQuery();
                
           if (rs.next()) {
                 bookedTablecount= rs.getInt("count(tableD)");
                if(bookedTablecount<countTableD){
                     cTableA="";
                    cTableB="";
                    cTableC="";
                    cTableD="Y";
                    cTableE="";
                    cTableF="";
                    dateRangequery();
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, " All Table D are already  Booked.Please select Other Option" , "Error", 0);
                    System.exit(0);
               }
           }
        }catch(Exception e){
           System.out.println(e);
       }
     }
   
  
       if (ChkTableE.isSelected()) {
                                                                                                    //System.out.println("Check line 1241");//for error chekeing-delete
         try{
            String sql = "SELECT count(tableE) FROM customermanager WHERE date = ? AND timeSlotNo = ? AND tableE = ? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1,cBookDate);
            pst.setInt(2, timerange);
            pst.setString(3, "Y");
            ResultSet rs = pst.executeQuery();
               
           if (rs.next()) {
                 bookedTablecount= rs.getInt("count(tableE)");
               if(bookedTablecount<countTableE){
                    cTableA="";
                    cTableB="";
                    cTableC="";
                    cTableD="";
                    cTableE="Y";
                    cTableF="";
                    dateRangequery();
                }
               else{
                    JOptionPane.showMessageDialog(rootPane, " All Table E are already  Booked.Please select Other Option" , "Error", 0);
                    System.exit(0);
               }
           }
        }catch(Exception e){
           System.out.println(e);
       }
     }
     
  
      if (ChkTableF.isSelected()) {
                                                                                                        //System.out.println("Check line 1273");//for error chekeing-delete
       try{
            String sql = "SELECT count(tableF) FROM customermanager WHERE date = ? AND timeSlotNo = ? AND tableF = ? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1,cBookDate);
            pst.setInt(2, timerange);
            pst.setString(3, "Y");
            ResultSet rs = pst.executeQuery();
               
            if (rs.next()) {
                bookedTablecount= rs.getInt("count(tableF)");
                System.out.println(" ////////////////////////////////////////////////HGHHHHHHHHHHHHHHHHHHHHHHHHHHH"+bookedTablecount);
                if(bookedTablecount<countTableF){
                    cTableA="";
                    cTableB="";
                    cTableC="";
                    cTableD="";
                    cTableE="";
                    cTableF="Y";
                    dateRangequery();
                }
               else{
                  JOptionPane.showMessageDialog(rootPane, " All Table F are already  Booked.Please select Other Option" , "Error", 0);
                 System.exit(0);
              }
            }
          }catch(Exception e){
           System.out.println(e);
         }
     }
  }  
}  

public void submitdateAndTime() {
        submitDate= lblDate.getText();
        submitTime = lblTime.getText();
}

  public void dateRangequery() throws SQLException {
                                                                                                                              //System.out.println("Check line 1312");//delete
        String query = "INSERT INTO customermanager (username,contact,address,email,date,timeSlotNo,tableA,tableB,tableC,tableD,tableE,tableF,price,submitDay,submittime) VALUES (?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?)";
        pst = conn.prepareStatement(query);
        pst.setString(1, cName);
        pst.setString(2, cContact);
        pst.setString(3, cAddress);
        pst.setString(4, cEmail);
        pst.setString(5, cBookDate);
        pst.setInt(6, timerange);
        pst.setString(7, cTableA);
        pst.setString(8, cTableB);
        pst.setString(9, cTableC);
        pst.setString(10, cTableD);
        pst.setString(11, cTableE);
        pst.setString(12, cTableF);
        pst.setInt(13, totalpayment);
        pst.setString(14, submitDate);
        pst.setString(15, submitTime);
        pst.execute();
    }

    public void onedayquery() throws SQLException {

        String query = "INSERT INTO customermanager (username,contact,address,email,date,timeSlotNo,tableA,tableB,tableC,tableD,tableE,tableF,price,submitDay,submitTime) VALUES (?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
        pst = conn.prepareStatement(query);
        pst.setString(1, cName);
        pst.setString(2, cContact);
        pst.setString(3, cAddress);
        pst.setString(4, cEmail);
        pst.setString(5, cStartDay);
        pst.setInt(6, timerange);
        pst.setString(7, cTableA);
        pst.setString(8, cTableB);
        pst.setString(9, cTableC);
        pst.setString(10, cTableD);
        pst.setString(11, cTableE);
        pst.setString(12, cTableF);
        pst.setInt(13,  totalpayment);
        pst.setString(14, submitDate);
        pst.setString(15, submitTime);
        System.out.println("k");
        pst.execute();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooserCellEditor1 = new com.toedter.calendar.JDateChooserCellEditor();
        dateTypeSelectGroup = new javax.swing.ButtonGroup();
        selectBookingTimeGroup = new javax.swing.ButtonGroup();
        timeSlotSelectGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDisplayUsername = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblTables = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        lblLogout = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblFirstFloorTables = new javax.swing.JLabel();
        panelHomePage = new javax.swing.JPanel();
        lblHomePage = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lblOutdoortables = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lblVipFloorTables = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        cmdTableShow = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cmdOk = new javax.swing.JButton();
        lblfloatDigit = new javax.swing.JLabel();
        optForDateRange = new javax.swing.JRadioButton();
        optForOneDay = new javax.swing.JRadioButton();
        dateChooserCalender1 = new com.toedter.calendar.JDateChooser();
        dateChooserCalender2 = new com.toedter.calendar.JDateChooser();
        dateChooserCalender3 = new com.toedter.calendar.JDateChooser();
        lblTo = new javax.swing.JLabel();
        lblForChooseTime = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        chkTime2 = new javax.swing.JCheckBox();
        chkTime1 = new javax.swing.JCheckBox();
        chkTime3 = new javax.swing.JCheckBox();
        chkTime7 = new javax.swing.JCheckBox();
        chkTime12 = new javax.swing.JCheckBox();
        chkTime6 = new javax.swing.JCheckBox();
        chkTime4 = new javax.swing.JCheckBox();
        chkTime11 = new javax.swing.JCheckBox();
        chkTime8 = new javax.swing.JCheckBox();
        chkTime9 = new javax.swing.JCheckBox();
        chkTime10 = new javax.swing.JCheckBox();
        chkTime5 = new javax.swing.JCheckBox();
        lblFrom = new javax.swing.JLabel();
        optFullDay = new javax.swing.JRadioButton();
        optFirstHalf = new javax.swing.JRadioButton();
        optSecondHalf = new javax.swing.JRadioButton();
        optChooseTime = new javax.swing.JRadioButton();
        jlable20 = new javax.swing.JLabel();
        cmdSeeBill = new javax.swing.JButton();
        lblIntDigit = new javax.swing.JLabel();
        lblmsg = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ChkTableC = new javax.swing.JCheckBox();
        ChkTableA = new javax.swing.JCheckBox();
        ChkTableF = new javax.swing.JCheckBox();
        ChkTableE = new javax.swing.JCheckBox();
        ChkTableB = new javax.swing.JCheckBox();
        ChkTableD = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        cmdClear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 0, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 0, 153));
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
        jLabel3.setText(" RESERVATION FORM");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 420, 50));

        lblDisplayUsername.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblDisplayUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblDisplayUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/male_user_50px.png"))); // NOI18N
        lblDisplayUsername.setText("Welcome, XXXXX");
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

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 70));

        jPanel3.setBackground(new java.awt.Color(51, 0, 153));
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 790, 1540, 70));

        jPanel6.setBackground(new java.awt.Color(102, 204, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(102, 204, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTables.setBackground(new java.awt.Color(255, 204, 204));
        lblTables.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTables.setForeground(new java.awt.Color(204, 0, 51));
        lblTables.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/table6.png"))); // NOI18N
        lblTables.setText("Table Dashboard");
        lblTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTablesMouseClicked(evt);
            }
        });
        jPanel7.add(lblTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 220, 40));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 340, 60));

        jLabel7.setBackground(new java.awt.Color(255, 204, 204));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Features");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 240, -1));

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
        panelLogout.add(lblLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 40));

        jPanel6.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 340, 70));

        jPanel9.setBackground(new java.awt.Color(102, 204, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 340, 60));

        lblFirstFloorTables.setBackground(new java.awt.Color(255, 204, 204));
        lblFirstFloorTables.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFirstFloorTables.setForeground(new java.awt.Color(204, 0, 51));
        lblFirstFloorTables.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFirstFloorTables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/table1.png"))); // NOI18N
        lblFirstFloorTables.setText("First Floor  Tables");
        lblFirstFloorTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFirstFloorTablesMouseClicked(evt);
            }
        });
        jPanel9.add(lblFirstFloorTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 240, 30));

        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 340, 60));

        panelHomePage.setBackground(new java.awt.Color(255, 204, 204));
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
        panelHomePage.add(lblHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 40));

        jPanel6.add(panelHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 80));

        jPanel12.setBackground(new java.awt.Color(102, 204, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOutdoortables.setBackground(new java.awt.Color(255, 204, 204));
        lblOutdoortables.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblOutdoortables.setForeground(new java.awt.Color(204, 0, 51));
        lblOutdoortables.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOutdoortables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/table1.png"))); // NOI18N
        lblOutdoortables.setText("Outdoor  Tables");
        lblOutdoortables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOutdoortablesMouseClicked(evt);
            }
        });
        jPanel12.add(lblOutdoortables, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 210, -1));

        jPanel6.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 340, 60));

        jPanel13.setBackground(new java.awt.Color(102, 204, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVipFloorTables.setBackground(new java.awt.Color(255, 204, 204));
        lblVipFloorTables.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVipFloorTables.setForeground(new java.awt.Color(204, 0, 51));
        lblVipFloorTables.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVipFloorTables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icon/table1.png"))); // NOI18N
        lblVipFloorTables.setText("VIP Floor  Tables");
        lblVipFloorTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVipFloorTablesMouseClicked(evt);
            }
        });
        jPanel13.add(lblVipFloorTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, -1));

        jPanel6.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 340, 60));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/puppytalesphotos-puppytales.gif"))); // NOI18N
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 180, 90));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 790));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel14.setForeground(new java.awt.Color(0, 0, 153));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtName.setText("Enter  your name...");
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel14.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 450, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Full Name");
        jPanel14.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Contact No");
        jPanel14.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txtContactNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtContactNo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtContactNo.setText("Enter Contact No...");
        txtContactNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContactNoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContactNoFocusLost(evt);
            }
        });
        jPanel14.add(txtContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 460, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Address");
        jPanel14.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAddress.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtAddress.setText("Enter your Address...");
        txtAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAddressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAddressFocusLost(evt);
            }
        });
        jPanel14.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 580, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Email");
        jPanel14.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEmail.setText("Enter your Email...");
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel14.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 400, 40));

        cmdTableShow.setBackground(new java.awt.Color(255, 204, 204));
        cmdTableShow.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdTableShow.setText("Table Show");
        cmdTableShow.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 153), 10, true));
        cmdTableShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTableShowActionPerformed(evt);
            }
        });
        jPanel14.add(cmdTableShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 430, 110, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Booking Tables");
        jPanel14.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, -1, -1));

        cmdOk.setBackground(new java.awt.Color(0, 204, 0));
        cmdOk.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        cmdOk.setText("SUBMIT");
        cmdOk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 0), 15));
        cmdOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOkActionPerformed(evt);
            }
        });
        jPanel14.add(cmdOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 630, 210, -1));

        lblfloatDigit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblfloatDigit.setForeground(new java.awt.Color(0, 153, 153));
        lblfloatDigit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblfloatDigit.setText(".00");
        lblfloatDigit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel14.add(lblfloatDigit, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 580, 40, 40));

        optForDateRange.setBackground(new java.awt.Color(0, 204, 204));
        dateTypeSelectGroup.add(optForDateRange);
        optForDateRange.setText("For Date Range");
        optForDateRange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optForDateRangeMouseClicked(evt);
            }
        });
        jPanel14.add(optForDateRange, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 110, 30));

        optForOneDay.setBackground(new java.awt.Color(0, 204, 204));
        dateTypeSelectGroup.add(optForOneDay);
        optForOneDay.setText("For One Day");
        optForOneDay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optForOneDayMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                optForOneDayMouseReleased(evt);
            }
        });
        jPanel14.add(optForOneDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 110, 30));

        dateChooserCalender1.setBackground(new java.awt.Color(153, 0, 153));
        dateChooserCalender1.setToolTipText("Select Booking Date");
        jPanel14.add(dateChooserCalender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 170, 40));

        dateChooserCalender2.setBackground(new java.awt.Color(153, 0, 153));
        jPanel14.add(dateChooserCalender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 150, 40));

        dateChooserCalender3.setBackground(new java.awt.Color(153, 0, 153));
        jPanel14.add(dateChooserCalender3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 110, 140, 40));

        lblTo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTo.setText("To");
        jPanel14.add(lblTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 90, 20, -1));

        lblForChooseTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblForChooseTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblForChooseTime.setText("For Choose Time");
        lblForChooseTime.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(255, 51, 51)));
        jPanel14.add(lblForChooseTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 130, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Booking Date");
        jPanel14.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        timeSlotSelectGroup.add(chkTime2);
        chkTime2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkTime2.setText("9.00am-10.00am");
        jPanel14.add(chkTime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 250, -1, -1));

        timeSlotSelectGroup.add(chkTime1);
        chkTime1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkTime1.setText("8.00am-9.00am");
        jPanel14.add(chkTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 220, -1, -1));

        timeSlotSelectGroup.add(chkTime3);
        chkTime3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkTime3.setText("10.00am-11.00am");
        jPanel14.add(chkTime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 280, -1, -1));

        timeSlotSelectGroup.add(chkTime7);
        chkTime7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkTime7.setText("2.00pm-3.00pm");
        jPanel14.add(chkTime7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 220, -1, -1));

        timeSlotSelectGroup.add(chkTime12);
        chkTime12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkTime12.setText("7.00pm-8.00pm");
        jPanel14.add(chkTime12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 370, -1, -1));

        timeSlotSelectGroup.add(chkTime6);
        chkTime6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkTime6.setText("1.00pm-2.00pm");
        jPanel14.add(chkTime6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 370, -1, -1));

        timeSlotSelectGroup.add(chkTime4);
        chkTime4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkTime4.setText("11.00am-12.00pm");
        jPanel14.add(chkTime4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 310, -1, -1));

        timeSlotSelectGroup.add(chkTime11);
        chkTime11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkTime11.setText("6.00pm-7.00pm");
        jPanel14.add(chkTime11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 340, -1, 30));

        timeSlotSelectGroup.add(chkTime8);
        chkTime8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkTime8.setText("3.00pm-4.00pm");
        jPanel14.add(chkTime8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 250, -1, -1));

        timeSlotSelectGroup.add(chkTime9);
        chkTime9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkTime9.setText("4.00pm-5.00pm");
        jPanel14.add(chkTime9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 280, -1, -1));

        timeSlotSelectGroup.add(chkTime10);
        chkTime10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkTime10.setText("5.00pm-6.00pm");
        jPanel14.add(chkTime10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 310, -1, -1));

        timeSlotSelectGroup.add(chkTime5);
        chkTime5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkTime5.setText("12.00pm-1.00pm");
        jPanel14.add(chkTime5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, -1, -1));

        lblFrom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFrom.setText("From");
        jPanel14.add(lblFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, -1, -1));

        selectBookingTimeGroup.add(optFullDay);
        optFullDay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        optFullDay.setForeground(new java.awt.Color(0, 0, 153));
        optFullDay.setText("Full Day");
        optFullDay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optFullDayMouseClicked(evt);
            }
        });
        jPanel14.add(optFullDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 305, -1, 20));

        selectBookingTimeGroup.add(optFirstHalf);
        optFirstHalf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        optFirstHalf.setForeground(new java.awt.Color(0, 0, 153));
        optFirstHalf.setText("For 1st Half of Day(8.00am-2.00pm)");
        optFirstHalf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optFirstHalfMouseClicked(evt);
            }
        });
        jPanel14.add(optFirstHalf, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, -1, -1));

        selectBookingTimeGroup.add(optSecondHalf);
        optSecondHalf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        optSecondHalf.setForeground(new java.awt.Color(0, 0, 153));
        optSecondHalf.setText("For 2st Half of Day(2.00pm-8.00pm)");
        optSecondHalf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optSecondHalfMouseClicked(evt);
            }
        });
        jPanel14.add(optSecondHalf, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, -1, -1));

        selectBookingTimeGroup.add(optChooseTime);
        optChooseTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        optChooseTime.setForeground(new java.awt.Color(0, 0, 153));
        optChooseTime.setText("Choose Time");
        optChooseTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optChooseTimeMouseClicked(evt);
            }
        });
        jPanel14.add(optChooseTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 275, -1, 20));

        jlable20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlable20.setText("Total Payment");
        jPanel14.add(jlable20, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 530, 140, -1));

        cmdSeeBill.setBackground(new java.awt.Color(255, 204, 204));
        cmdSeeBill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdSeeBill.setText("See Payment");
        cmdSeeBill.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 153), 10, true));
        cmdSeeBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSeeBillActionPerformed(evt);
            }
        });
        jPanel14.add(cmdSeeBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 580, 110, 40));

        lblIntDigit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblIntDigit.setForeground(new java.awt.Color(0, 153, 153));
        lblIntDigit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIntDigit.setText("0");
        lblIntDigit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel14.add(lblIntDigit, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 580, 240, 40));

        lblmsg.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblmsg.setForeground(new java.awt.Color(255, 0, 51));
        lblmsg.setText("You can choose  one time slot below.Oterwise you have to choose other Booking Time option");
        jPanel14.add(lblmsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Booking Time");
        jPanel14.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, -1, -1));

        ChkTableC.setText("Table C");
        jPanel14.add(ChkTableC, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, -1, -1));

        ChkTableA.setText("Table A");
        jPanel14.add(ChkTableA, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, -1, -1));

        ChkTableF.setText("Table F");
        jPanel14.add(ChkTableF, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 480, 70, -1));

        ChkTableE.setText("Table E");
        jPanel14.add(ChkTableE, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, -1, -1));

        ChkTableB.setText("Table B");
        jPanel14.add(ChkTableB, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, -1, -1));

        ChkTableD.setText("Table D");
        jPanel14.add(ChkTableD, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 480, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Click  the button table  select");
        jPanel14.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 480, -1, -1));

        cmdClear.setBackground(new java.awt.Color(0, 255, 204));
        cmdClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmdClear.setText("Clear");
        cmdClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), 5));
        cmdClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdClearActionPerformed(evt);
            }
        });
        jPanel14.add(cmdClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 670, 90, 40));

        jLabel8.setForeground(new java.awt.Color(0, 51, 153));
        jLabel8.setText("Please show  the tables first befor filling this form.You can show table type  by Menu bar in left hand side");
        jPanel14.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 570, -1));

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 1200, 720));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 860));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void lblTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTablesMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        FirstFloorTables view = new FirstFloorTables();
        view.setVisible(true);
    }//GEN-LAST:event_lblTablesMouseClicked

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void cmdTableShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTableShowActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        FirstFloorTables view = new FirstFloorTables();
        view.setVisible(true);
    }//GEN-LAST:event_cmdTableShowActionPerformed

    private void lblFirstFloorTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFirstFloorTablesMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        FirstFloorTables view = new FirstFloorTables();
        view.setVisible(true);
    }//GEN-LAST:event_lblFirstFloorTablesMouseClicked

    private void lblOutdoortablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutdoortablesMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        OutdoorTables view = new OutdoorTables();
        view.setVisible(true);
    }//GEN-LAST:event_lblOutdoortablesMouseClicked

    private void lblVipFloorTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVipFloorTablesMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        VipFloorTables view = new VipFloorTables();
        view.setVisible(true);
    }//GEN-LAST:event_lblVipFloorTablesMouseClicked

    private void lblHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomePageMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "This is a Home page");
    }//GEN-LAST:event_lblHomePageMouseClicked

    private void cmdOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOkActionPerformed
            JOptionPane.showMessageDialog(rootPane, "Are you Sure to submit this form?" , "Question", 3);
            cmdOk.setVisible(false);
            try {
                if (optForOneDay.isSelected()) {
                  onedaytimerangeValue();
                } 
                else if (optForDateRange.isSelected()) {
                      dayRangetimerangeValue();
                 }
                 JOptionPane.showMessageDialog(null, " Your Booking Details Submit Sucessfully");
                 setVisible(false);
                 ResturantDetails view = new ResturantDetails();
                 view.setVisible(true);
                 
             } catch (Exception e) {
                      System.out.println(e);
             } 
            
    }//GEN-LAST:event_cmdOkActionPerformed

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        // TODO add your handling code here:
        if (txtName.getText().equals("Enter  your name...")) {
            txtName.setText("");
            txtName.setForeground(new Color(0, 51, 204));
        }
    }//GEN-LAST:event_txtNameFocusGained

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        // TODO add your handling code here:
        if (txtName.getText().equals("")) {
            txtName.setText("Enter  your name...");
            txtName.setForeground(new Color(51, 204, 0));
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtContactNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactNoFocusGained
        // TODO add your handling code here:
        if (txtContactNo.getText().equals("Enter Contact No...")) {
            txtContactNo.setText("");
            txtContactNo.setForeground(new Color(0, 51, 204));
        }
    }//GEN-LAST:event_txtContactNoFocusGained

    private void txtContactNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactNoFocusLost
        // TODO add your handling code here:
        if (txtContactNo.getText().equals("")) {
            txtContactNo.setText("Enter Contact No...");
            txtContactNo.setForeground(new Color(51, 204, 0));
        }
    }//GEN-LAST:event_txtContactNoFocusLost

    private void txtAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusGained
        // TODO add your handling code here:
        if (txtAddress.getText().equals("Enter your Address...")) {
            txtAddress.setText("");
            txtAddress.setForeground(new Color(0, 51, 204));
        }
    }//GEN-LAST:event_txtAddressFocusGained

    private void txtAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusLost
        // TODO add your handling code here:
        if (txtAddress.getText().equals("")) {
            txtAddress.setText("Enter your Address...");
            txtAddress.setForeground(new Color(51, 204, 0));
        }
    }//GEN-LAST:event_txtAddressFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        // TODO add your handling code here:
        if (txtEmail.getText().equals("Enter your Email...")) {
            txtEmail.setText("");
            txtEmail.setForeground(new Color(0, 51, 204));
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:
        if (txtEmail.getText().equals("")) {
            txtEmail.setText("Enter your Email...");
            txtEmail.setForeground(new Color(51, 204, 0));
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void panelLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLogoutMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_panelLogoutMouseClicked

    private void optForOneDayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optForOneDayMouseClicked
        // TODO add your handling code here:

        forOneDayBookingItemSeenTrue();
        dateChooserCalender1.setVisible(true);
        forDateRangeBookingItemSeenFalse();

    }//GEN-LAST:event_optForOneDayMouseClicked

    private void optForDateRangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optForDateRangeMouseClicked
        // TODO add your handling code here:

        forDateRangeBookingItemSeenTrue();
        forOneDayBookingItemSeenFalse();

    }//GEN-LAST:event_optForDateRangeMouseClicked

    private void optForOneDayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optForOneDayMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_optForOneDayMouseReleased

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        Login view = new Login();
        view.setVisible(true);
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void panelHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHomePageMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_panelHomePageMouseClicked

    private void optChooseTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optChooseTimeMouseClicked
        // TODO add your handling code here:
        selectChooseTimeclick();
    }//GEN-LAST:event_optChooseTimeMouseClicked

    private void optFullDayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optFullDayMouseClicked
        // TODO add your handling code here:
        selectChooseTimeunclick();
    }//GEN-LAST:event_optFullDayMouseClicked

    private void optFirstHalfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optFirstHalfMouseClicked
        // TODO add your handling code here:
        selectChooseTimeunclick();
    }//GEN-LAST:event_optFirstHalfMouseClicked

    private void optSecondHalfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optSecondHalfMouseClicked
        // TODO add your handling code here:
        selectChooseTimeunclick();
    }//GEN-LAST:event_optSecondHalfMouseClicked

    private void cmdSeeBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSeeBillActionPerformed
        try {
            getDataFormValues();
       } catch (ParseException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) { 
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        customerpayment();
        JOptionPane.showMessageDialog(rootPane, "Please take a Screenshot Before Submit this form","Warning",2);
        cmdOk.setVisible(true);  
    }//GEN-LAST:event_cmdSeeBillActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void cmdClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdClearActionPerformed
        // TODO add your handling code here:
         txtName.setText("Enter  your name...");
         txtName.setForeground(new Color(0, 0, 0));
         txtContactNo.setText("Enter Contact No...");
         txtContactNo.setForeground(new Color(0, 0, 0));
         txtAddress.setText("Enter your Address...");
         txtAddress.setForeground(new Color(0, 0, 0));
         txtEmail.setText("Enter your Email...");
         txtEmail.setForeground(new Color(0, 0, 0));
         dateTypeSelectGroup.clearSelection();
         dateChooserCalender1.setDate(null);
         dateChooserCalender2.setDate(null);
         dateChooserCalender3.setDate(null);
         selectBookingTimeGroup.clearSelection(); 
         timeSlotSelectGroup.clearSelection();
         ChkTableA.setSelected(false);
         ChkTableB.setSelected(false);
         ChkTableC.setSelected(false);
         ChkTableD.setSelected(false);
         ChkTableE.setSelected(false);
         ChkTableF.setSelected(false);
         lblIntDigit.setText("0");
         
    }//GEN-LAST:event_cmdClearActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ChkTableA;
    private javax.swing.JCheckBox ChkTableB;
    private javax.swing.JCheckBox ChkTableC;
    private javax.swing.JCheckBox ChkTableD;
    private javax.swing.JCheckBox ChkTableE;
    private javax.swing.JCheckBox ChkTableF;
    private javax.swing.JCheckBox chkTime1;
    private javax.swing.JCheckBox chkTime10;
    private javax.swing.JCheckBox chkTime11;
    private javax.swing.JCheckBox chkTime12;
    private javax.swing.JCheckBox chkTime2;
    private javax.swing.JCheckBox chkTime3;
    private javax.swing.JCheckBox chkTime4;
    private javax.swing.JCheckBox chkTime5;
    private javax.swing.JCheckBox chkTime6;
    private javax.swing.JCheckBox chkTime7;
    private javax.swing.JCheckBox chkTime8;
    private javax.swing.JCheckBox chkTime9;
    private javax.swing.JButton cmdClear;
    private javax.swing.JButton cmdOk;
    private javax.swing.JButton cmdSeeBill;
    private javax.swing.JButton cmdTableShow;
    private com.toedter.calendar.JDateChooser dateChooserCalender1;
    private com.toedter.calendar.JDateChooser dateChooserCalender2;
    private com.toedter.calendar.JDateChooser dateChooserCalender3;
    private javax.swing.ButtonGroup dateTypeSelectGroup;
    private com.toedter.calendar.JDateChooserCellEditor jDateChooserCellEditor1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jlable20;
    private javax.swing.JLabel lblDate;
    public javax.swing.JLabel lblDisplayUsername;
    private javax.swing.JLabel lblFirstFloorTables;
    private javax.swing.JLabel lblForChooseTime;
    private javax.swing.JLabel lblFrom;
    private javax.swing.JLabel lblHomePage;
    private javax.swing.JLabel lblIntDigit;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblOutdoortables;
    private javax.swing.JLabel lblTables;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTo;
    private javax.swing.JLabel lblVipFloorTables;
    private javax.swing.JLabel lblfloatDigit;
    private javax.swing.JLabel lblmsg;
    private javax.swing.JRadioButton optChooseTime;
    private javax.swing.JRadioButton optFirstHalf;
    private javax.swing.JRadioButton optForDateRange;
    private javax.swing.JRadioButton optForOneDay;
    private javax.swing.JRadioButton optFullDay;
    private javax.swing.JRadioButton optSecondHalf;
    private javax.swing.JPanel panelHomePage;
    private javax.swing.JPanel panelLogout;
    private javax.swing.ButtonGroup selectBookingTimeGroup;
    private javax.swing.ButtonGroup timeSlotSelectGroup;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

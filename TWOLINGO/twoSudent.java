import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class twoSudent extends javax.swing.JFrame {
    CSVReader readerUA = new CSVReader(new FileReader(guiTwo.user_In + ".csv"));
    List<String[]> rowsUA = readerUA.readAll();
    int indexQues = 0, indexChoices = 0, indexAns = 0, indexLockR = 0, indexLockC = 0, indexTL = 0;
    static int coins;
    String home_Choice, cCoin = rowsUA.get(4)[1], id = rowsUA.get(0)[1], sCoin ="", proVersion = rowsUA.get(1)[1];
    static String holdQuiz = "";
    public twoSudent() throws IOException, CsvException {
        initComponents();
    }
                       
    private void initComponents() throws IOException, CsvException {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        twolingo_Quiz = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanTwolingoQuiz = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tagalogTwoBut = new javax.swing.JButton();
        chineseTwoBut = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        PanTwolingoMagicShop = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        twoMS_Coins = new javax.swing.JLabel();
        twoMS_BuyPV = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        PanLeaderboards = new javax.swing.JPanel();
        spLeaderboards = new javax.swing.JScrollPane();
        jLabel21 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        PanTwolingoProfile = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        twoTP_TwoAcc = new javax.swing.JLabel();
        twoTP_TwoID = new javax.swing.JLabel();
        twoTP_TwoCoins = new javax.swing.JLabel();
        twoTP_AccCreate = new javax.swing.JLabel();
        twoTP_CEL = new javax.swing.JLabel();
        twoTP_TEL = new javax.swing.JLabel();
        twoTP_TML = new javax.swing.JLabel();
        twoTP_THL = new javax.swing.JLabel();
        twoTP_CHL = new javax.swing.JLabel();
        twoTP_CML = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); 
        jLabel1.setText("S T U D E N T    A C C O U N T");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(370, 120, 300, 30);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 100)); 
        jLabel2.setText("T W O L I N G O");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 20, 670, 120);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jButton1.setText("Profile");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(330, 160, 100, 40);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); 
        jButton2.setText("Leaderboards");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(220, 160, 100, 40);

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); 
        jButton3.setText("Magic Shop");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(110, 160, 100, 40);

        twolingo_Quiz.setBackground(new java.awt.Color(204, 204, 204));
        twolingo_Quiz.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); 
        twolingo_Quiz.setText("Enter Quiz");
        twolingo_Quiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twolingo_QuizActionPerformed(evt);
            }
        });
        getContentPane().add(twolingo_Quiz);
        twolingo_Quiz.setBounds(0, 160, 100, 40);

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); 
        jButton4.setText("E X I T   T W O L I N G O");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton4ActionPerformed(evt);
                } catch (IOException | CsvException e) {
                    e.printStackTrace();
                }
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(440, 160, 560, 40);

        PanTwolingoQuiz.setBackground(new java.awt.Color(153, 153, 153));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 85)); 
        jLabel7.setText("T W O L I N G O   Q U I Z");

        tagalogTwoBut.setBackground(new java.awt.Color(204, 204, 204));
        tagalogTwoBut.setFont(new java.awt.Font("Tw Cen MT", 0, 50)); 
        tagalogTwoBut.setText("Tagalog");
        tagalogTwoBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagalogTwoButActionPerformed(evt);
            }
        });

        chineseTwoBut.setBackground(new java.awt.Color(204, 204, 204));
        chineseTwoBut.setFont(new java.awt.Font("Tw Cen MT", 0, 50)); 
        chineseTwoBut.setText("Chinese");
        chineseTwoBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    chineseTwoButActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("- Ñ | bà -");

        javax.swing.GroupLayout PanTwolingoQuizLayout = new javax.swing.GroupLayout(PanTwolingoQuiz);
        PanTwolingoQuiz.setLayout(PanTwolingoQuizLayout);
        PanTwolingoQuizLayout.setHorizontalGroup(
            PanTwolingoQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanTwolingoQuizLayout.createSequentialGroup()
                .addGroup(PanTwolingoQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanTwolingoQuizLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel7))
                    .addGroup(PanTwolingoQuizLayout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addGroup(PanTwolingoQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tagalogTwoBut, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chineseTwoBut, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        PanTwolingoQuizLayout.setVerticalGroup(
            PanTwolingoQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanTwolingoQuizLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(tagalogTwoBut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(chineseTwoBut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel23)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jTabbedPane1.addTab("", PanTwolingoQuiz);

        PanTwolingoMagicShop.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 55)); 
        jLabel3.setText("T W O L I N G O    M A G I C   S H O P");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); 
        jLabel4.setText("C O I N S :");

        twoMS_Coins.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); 

        twoMS_BuyPV.setFont(new java.awt.Font("Segoe UI", 0, 50)); 
        twoMS_BuyPV.setText("B U Y   P R O V E R S I O N");
        twoMS_BuyPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    twoMS_BuyPVActionPerformed(evt);
                } catch (IOException | CsvException e) {
                    e.printStackTrace();
                }
            }
        });

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 0, 30)); 
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("T I R E D  O F  A D S ?   A N D   N E E D   A N   E X T R A   H E A R T ? ");
        cCoin = rowsUA.get(4)[1];
        if (cCoin.equals("A")) coins = 0;
        else if (cCoin.equals("B")) coins = 5;
          else if (cCoin.equals("C")) coins = 10;
            else if (cCoin.equals("D")) coins = 15;
              else if (cCoin.equals("E")) coins = 20;
                else if (cCoin.equals("F")) coins = 25;
                  else if (cCoin.equals("G")) coins = 30;
        twoMS_Coins.setText(String.valueOf(coins));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel9.setText("T R Y   B U Y I N G   T W O L I N G O   P R O  V E R S I O N   F O R   O N L Y   5   C O I N S");

        jLabel24.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Ñ | bà");

        javax.swing.GroupLayout PanTwolingoMagicShopLayout = new javax.swing.GroupLayout(PanTwolingoMagicShop);
        PanTwolingoMagicShop.setLayout(PanTwolingoMagicShopLayout);
        PanTwolingoMagicShopLayout.setHorizontalGroup(
            PanTwolingoMagicShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanTwolingoMagicShopLayout.createSequentialGroup()
                .addGroup(PanTwolingoMagicShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanTwolingoMagicShopLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(PanTwolingoMagicShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanTwolingoMagicShopLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(32, 32, 32)
                                .addComponent(twoMS_Coins, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanTwolingoMagicShopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanTwolingoMagicShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(twoMS_BuyPV, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 80, Short.MAX_VALUE))
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanTwolingoMagicShopLayout.setVerticalGroup(
            PanTwolingoMagicShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanTwolingoMagicShopLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(PanTwolingoMagicShopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(twoMS_Coins, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(38, 38, 38)
                .addComponent(twoMS_BuyPV)
                .addGap(79, 79, 79)
                .addComponent(jLabel24)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", PanTwolingoMagicShop);

        PanLeaderboards.setBackground(new java.awt.Color(153, 153, 153));
            try (BufferedReader br = new BufferedReader(new FileReader("leaderboards.csv"))) {
                DefaultTableModel tableModel = new DefaultTableModel();

                String headerLine = br.readLine();
                if (headerLine != null) {
                    String[] headers = headerLine.split(",");
                    for (String header : headers) {
                        tableModel.addColumn(header);
                    }
                }

                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    tableModel.addRow(data);
                }

                JTable jTable1 = new JTable(tableModel);
                jTable1.setEnabled(false);
                spLeaderboards.setViewportView(jTable1);
            } catch (Exception e) {
                e.printStackTrace();
            }

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 1, 60)); 
        jLabel21.setText("L E A D E R B O A R D S");

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jButton5.setText("Search Email/Username");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Ñ | bà");

        javax.swing.GroupLayout PanLeaderboardsLayout = new javax.swing.GroupLayout(PanLeaderboards);
        PanLeaderboards.setLayout(PanLeaderboardsLayout);
        PanLeaderboardsLayout.setHorizontalGroup(
            PanLeaderboardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanLeaderboardsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
            .addGroup(PanLeaderboardsLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(PanLeaderboardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spLeaderboards, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addContainerGap(59, Short.MAX_VALUE))
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanLeaderboardsLayout.setVerticalGroup(
            PanLeaderboardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanLeaderboardsLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spLeaderboards, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(37, 37, 37)
                .addComponent(jLabel22)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", PanLeaderboards);

        PanTwolingoProfile.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 70)); 
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("T W O L I N G O   P R O F I L E");

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel6.setText("T W O L I N G O   A C C O U N T : ");

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel10.setText("I D :");

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel11.setText("A C C O U N T   C R E A T E D :");

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel12.setText("C O I N S :");

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); 
        jLabel13.setText("B A D G E S   I N   T A G A L O G");

        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel14.setText("E A S Y   L E V E L :");

        jLabel15.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel15.setText("M E D I U M   L E V E L :");

        jLabel16.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel16.setText("H A R D   L E V E L :");

        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); 
        jLabel17.setText("B A D G E S   I N   C H I N E S E");

        jLabel18.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel18.setText("E A S Y   L E V E L :");

        jLabel19.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel19.setText("M E D I U M   L E V E L :");

        jLabel20.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel20.setText("H A R D   L E V E L :");

        twoTP_TwoID.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); 
        twoTP_TwoID.setText(rowsUA.get(0)[0]);

        twoTP_TwoAcc.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); 
        twoTP_TwoAcc.setText(rowsUA.get(0)[1]);

        twoTP_TwoCoins.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); 
        twoTP_TwoCoins.setText(String.valueOf(coins));

        twoTP_AccCreate.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); 
        twoTP_AccCreate.setText(rowsUA.get(0)[2]);

        twoTP_CEL.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); 
        twoTP_CEL.setText(rowsUA.get(3)[5]);

        twoTP_TEL.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); 
        twoTP_TEL.setText(rowsUA.get(2)[5]);
        
        twoTP_TML.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); 
        twoTP_TML.setText(rowsUA.get(2)[6]);

        twoTP_THL.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); 
        twoTP_THL.setText(rowsUA.get(2)[7]);

        twoTP_CHL.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); 
        twoTP_CHL.setText(rowsUA.get(3)[7]);

        twoTP_CML.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); 
        twoTP_CML.setText(rowsUA.get(3)[6]);

        jLabel25.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); 
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Ñ | bà");

        javax.swing.GroupLayout PanTwolingoProfileLayout = new javax.swing.GroupLayout(PanTwolingoProfile);
        PanTwolingoProfile.setLayout(PanTwolingoProfileLayout);
        PanTwolingoProfileLayout.setHorizontalGroup(
            PanTwolingoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanTwolingoProfileLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(PanTwolingoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanTwolingoProfileLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(twoTP_CHL, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanTwolingoProfileLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(twoTP_CML, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanTwolingoProfileLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(twoTP_CEL, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel17)
                    .addGroup(PanTwolingoProfileLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(twoTP_THL, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanTwolingoProfileLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(twoTP_TML, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanTwolingoProfileLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(twoTP_TEL, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13)
                    .addGroup(PanTwolingoProfileLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(twoTP_TwoCoins, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanTwolingoProfileLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(twoTP_AccCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanTwolingoProfileLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(twoTP_TwoAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanTwolingoProfileLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(twoTP_TwoID, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(238, 238, 238))
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanTwolingoProfileLayout.setVerticalGroup(
            PanTwolingoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanTwolingoProfileLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanTwolingoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(twoTP_TwoID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanTwolingoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(twoTP_TwoAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanTwolingoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(twoTP_AccCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanTwolingoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(twoTP_TwoCoins, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanTwolingoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(twoTP_TEL, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanTwolingoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(twoTP_TML, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanTwolingoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(twoTP_THL, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanTwolingoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(twoTP_CEL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanTwolingoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(twoTP_CML, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanTwolingoProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(twoTP_CHL, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", PanTwolingoProfile);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 160, 1000, 590);

        pack();
    }                       

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jTabbedPane1.setSelectedIndex(3);
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jTabbedPane1.setSelectedIndex(2);
    }                                        

    private void twolingo_QuizActionPerformed(java.awt.event.ActionEvent evt) {                                              
        jTabbedPane1.setSelectedIndex(0);
    }                                             

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jTabbedPane1.setSelectedIndex(1);
    }                                        

    private void tagalogTwoButActionPerformed(java.awt.event.ActionEvent evt) {     
        holdQuiz = "T";                                         
        TwoQuiz eightFrame = new TwoQuiz();
        eightFrame.setVisible(true);
        eightFrame.pack();
        eightFrame.setLocationRelativeTo(null);
        this.dispose();
    }                                             

    private void chineseTwoButActionPerformed(java.awt.event.ActionEvent evt) {  
        holdQuiz = "C";    
        TwoQuiz nineFrame = new TwoQuiz();
        nineFrame.setVisible(true);
        nineFrame.pack();
        nineFrame.setLocationRelativeTo(null);    
        this.dispose();                                      
    }                                             

    private void twoMS_BuyPVActionPerformed(java.awt.event.ActionEvent evt) throws IOException, CsvException {                                            
        if (coins >= 5){
            if (proVersion.equals("F")) {
                JOptionPane.showMessageDialog(this,"Congratulations you purchased Pro Version TWOLINGO you have now an extra Heart and you are free from ads.");
                JOptionPane.showMessageDialog(this,"You have now " + (coins - 5) + " coins");
                coins = coins - 5;

                rowsUA.get(1)[1] = "T";
                proVersion = "T";
                CSVWriter writer = new CSVWriter(new FileWriter(new File(guiTwo.user_In + ".csv")));
                checkCoins(coins);
                writer.writeAll(rowsUA); 
                writer.flush();
                twoMS_Coins.setText(String.valueOf(coins));
            } else {
                JOptionPane.showMessageDialog(this,"You already have Pro Version TWOLINGO");
            }
        } else {
            JOptionPane.showMessageDialog(this,"Sorry but you don't have enough coins to purchase this Pro Version TWOLINGO, you need 5 coins");
            JOptionPane.showMessageDialog(this,"You have " + (coins) + " coins");
        }
        twoSudent sixFrame = new twoSudent();
        sixFrame.setVisible(true);
        sixFrame.pack();
        sixFrame.setLocationRelativeTo(null);
        this.dispose();
    }                                           

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        leaderboardSearched sixFrame = new leaderboardSearched();
        sixFrame.setVisible(true);
        sixFrame.pack();
        sixFrame.setLocationRelativeTo(null);
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) throws IOException, CsvException {                                         
        guiTwo sevenFrame = new guiTwo();
        sevenFrame.setVisible(true);
        sevenFrame.pack();
        sevenFrame.setLocationRelativeTo(null);
        this.dispose();
    }         
    
    private void checkCoins(int coins) throws IOException{
        if(coins == 0) sCoin = "A";
        else if(coins == 5) sCoin = "B";
            else if(coins == 10) sCoin = "C";
                else if(coins == 15) sCoin = "D";
                    else if(coins == 20) sCoin = "E";
                        else if(coins == 25) sCoin = "F";
                            else if(coins == 30) sCoin = "G";
            rowsUA.get(4)[1] = sCoin;
            CSVWriter writer = new CSVWriter(new FileWriter(new File(guiTwo.user_In + ".csv")));
            writer.writeAll(rowsUA); 
            writer.flush();
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(twoSudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(twoSudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(twoSudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(twoSudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new twoSudent().setVisible(true);
                } catch (IOException | CsvException e) {
                    e.printStackTrace();
                }
            }
        });
    }
                   
    private javax.swing.JPanel PanLeaderboards;
    private javax.swing.JPanel PanTwolingoMagicShop;
    private javax.swing.JPanel PanTwolingoProfile;
    private javax.swing.JPanel PanTwolingoQuiz;
    private javax.swing.JButton chineseTwoBut;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane spLeaderboards;
    private javax.swing.JButton tagalogTwoBut;
    private javax.swing.JButton twoMS_BuyPV;
    private javax.swing.JLabel twoMS_Coins;
    private javax.swing.JLabel twoTP_AccCreate;
    private javax.swing.JLabel twoTP_CEL;
    private javax.swing.JLabel twoTP_CHL;
    private javax.swing.JLabel twoTP_CML;
    private javax.swing.JLabel twoTP_TEL;
    private javax.swing.JLabel twoTP_THL;
    private javax.swing.JLabel twoTP_TML;
    private javax.swing.JLabel twoTP_TwoAcc;
    private javax.swing.JLabel twoTP_TwoCoins;
    private javax.swing.JLabel twoTP_TwoID;
    private javax.swing.JButton twolingo_Quiz;                
}


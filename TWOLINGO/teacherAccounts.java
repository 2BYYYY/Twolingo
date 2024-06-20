import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class teacherAccounts extends javax.swing.JFrame {

    public teacherAccounts() {
        initComponents();
    }                       
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        EDITbutt = new javax.swing.JButton();
        EXITta = new javax.swing.JButton();
        USLSRecButt = new javax.swing.JButton();
        SJIRecButt = new javax.swing.JButton();
        OTHERRecButt = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        spLeaderboards2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        spLeaderboards3 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        spLeaderboards4 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        textArea1 = new java.awt.TextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        QCAEditbutt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 100)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("T W O L I N G O");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 36, 1000, 80);

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("T E A C H E R   A C C O U N T ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 110, 1012, 27);

        EDITbutt.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        EDITbutt.setText("Edit Quiz");
        EDITbutt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITbuttActionPerformed(evt);
            }
        });
        getContentPane().add(EDITbutt);
        EDITbutt.setBounds(440, 150, 140, 40);

        EXITta.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        EXITta.setText("Exit Teacher Account");
        EXITta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXITtaActionPerformed(evt);
            }
        });
        getContentPane().add(EXITta);
        EXITta.setBounds(591, 150, 410, 40);

        USLSRecButt.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        USLSRecButt.setText("USLS Records");
        USLSRecButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USLSRecButtActionPerformed(evt);
            }
        });
        getContentPane().add(USLSRecButt);
        USLSRecButt.setBounds(0, 150, 130, 40);

        SJIRecButt.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        SJIRecButt.setText("SJI Records");
        SJIRecButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SJIRecButtActionPerformed(evt);
            }
        });
        getContentPane().add(SJIRecButt);
        SJIRecButt.setBounds(140, 150, 140, 40);

        OTHERRecButt.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        OTHERRecButt.setText("OTHER Records");
        OTHERRecButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OTHERRecButtActionPerformed(evt);
            }
        });
        getContentPane().add(OTHERRecButt);
        OTHERRecButt.setBounds(290, 150, 140, 40);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel22.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Ñ | bà");

        try (BufferedReader br = new BufferedReader(new FileReader("usls_Student_Records.csv"))) {
            DefaultTableModel tableModel1 = new DefaultTableModel();
            String headerLine = br.readLine();
            if (headerLine != null) {
                String[] headers = headerLine.split(",");
                for (String header : headers) {
                    tableModel1.addColumn(header);
                }
            }
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                tableModel1.addRow(data);
            }
            JTable jTable3 = new JTable(tableModel1);
            jTable3.setEnabled(false);
            spLeaderboards2.setViewportView(jTable3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 60)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("USLS Student Records");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(spLeaderboards2, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(spLeaderboards2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Ñ | bà");


        try (BufferedReader br = new BufferedReader(new FileReader("sji_Student_Records.csv"))) {
            DefaultTableModel tableModel3 = new DefaultTableModel();
            String headerLine = br.readLine();
            if (headerLine != null) {
                String[] headers = headerLine.split(",");
                for (String header : headers) {
                    tableModel3.addColumn(header);
                }
            }
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                tableModel3.addRow(data);
            }
            JTable jTable4 = new JTable(tableModel3);
            jTable4.setEnabled(false);
            spLeaderboards3.setViewportView(jTable4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 60)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SJI Student Records");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(spLeaderboards3, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(spLeaderboards3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("", jPanel2);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel24.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Ñ | bà");

        try (BufferedReader br = new BufferedReader(new FileReader("other_Student_Records.csv"))) {
            DefaultTableModel tableModel3 = new DefaultTableModel();
            String headerLine = br.readLine();
            if (headerLine != null) {
                String[] headers = headerLine.split(",");
                for (String header : headers) {
                    tableModel3.addColumn(header);
                }
            }
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                tableModel3.addRow(data);
            }
            JTable jTable5 = new JTable(tableModel3);
            jTable5.setEnabled(false);
            spLeaderboards4.setViewportView(jTable5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 60)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("OTHER Student Records");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(spLeaderboards4, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(spLeaderboards4, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(22, 22, 22))
        );

        try (CSVReader reader = new CSVReader(new FileReader("qna.csv"))) {
            String[] leaderSearch;
            while ((leaderSearch = reader.readNext()) != null) {
                textArea1.append(String.join("  --  ", leaderSearch) + "\n");
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        } 

        jTabbedPane1.addTab("", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        textArea1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        textArea1.setEditable(false);
        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 60)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Questions, Choices, and Answer CSV");

        jLabel25.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Ñ | bà");

        QCAEditbutt.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        QCAEditbutt.setText("EDIT");
        QCAEditbutt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    QCAEditbuttActionPerformed(evt);
                } catch (IOException | CsvException e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(QCAEditbutt, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(395, 395, 395))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QCAEditbutt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", jPanel4);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 150, 1010, 530);

        pack();
    }                     

    private void EDITbuttActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jTabbedPane1.setSelectedIndex(3);
    }                                        

    private void EXITtaActionPerformed(java.awt.event.ActionEvent evt) {                                       
        guiTwo tenFrame = new guiTwo();
        tenFrame.setVisible(true);
        tenFrame.pack();
        tenFrame.setLocationRelativeTo(null); 
        this.dispose();
    }                                      

    private void USLSRecButtActionPerformed(java.awt.event.ActionEvent evt) {                                            
        jTabbedPane1.setSelectedIndex(0);
    }                                           

    private void SJIRecButtActionPerformed(java.awt.event.ActionEvent evt) {                                           
        jTabbedPane1.setSelectedIndex(1);
    }                                          

    private void OTHERRecButtActionPerformed(java.awt.event.ActionEvent evt) {                                             
        jTabbedPane1.setSelectedIndex(2);
    }                                            

    private void QCAEditbuttActionPerformed(java.awt.event.ActionEvent evt) throws IOException, CsvException {                                            
        boolean backRunning = true;
        while (backRunning) {
            String userInputDB = showOptionDialog("Select an option:", "TWOLINGO", 
                new String[]{"Tagalog", "Chinese", "Back to Admin Page"});
            
            if (userInputDB == null) continue;

            switch (userInputDB) {
                case "Tagalog":
                    handleLanguageSelection(new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 9});
                    break;
                case "Chinese":
                    JOptionPane.showMessageDialog(null, "! NOTE: YOU CAN'T CHANGE THE CHINESE GUIDE !");
                    handleLanguageSelection(new int[]{12, 13, 14}, new int[]{15, 16, 17}, new int[]{18, 20});
                    break;
                case "Back to Admin Page":
                    backRunning = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input");
            }
        }
        teacherAccounts tenFrame = new teacherAccounts();
        tenFrame.setVisible(true);
        tenFrame.pack();
        tenFrame.setLocationRelativeTo(null); 
        this.dispose();
    }
    
    private static void handleLanguageSelection(int[] easyQCA, int[] mediumQCA, int[] hardQCA) throws IOException, CsvException {
        boolean lsRunning = true;
        while (lsRunning) {
            String userInputDBTag = showOptionDialog("Select an option:", "TWOLINGO Language Level",
                new String[]{"Easy Level", "Medium Level", "Hard Level", "Back to language selection"});
            
            if (userInputDBTag == null) continue;

            switch (userInputDBTag) {
                case "Easy Level":
                    handleQCASelection(easyQCA, "Easy Level");
                    break;
                case "Medium Level":
                    handleQCASelection(mediumQCA, "Medium Level");
                    break;
                case "Hard Level":
                    handleQCASelection(hardQCA, "Hard Level");
                    break;
                case "Back to language selection":
                    lsRunning = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input");
            }
        }
    }

    private static void handleQCASelection(int[] qcaOptions, String level) throws IOException, CsvException {
        boolean sLevelRunning = true;
        while (sLevelRunning) {
            String[] qcaChoices = (qcaOptions.length == 3) ?
                new String[]{"Questions", "Choices", "Answers", "Back to level selection"} :
                new String[]{"Questions", "Answers", "Back to level selection"};

            String userInputDBTagQAC = showOptionDialog("Select an option:", "TWOLINGO " + level,
                qcaChoices);

            if (userInputDBTagQAC == null) continue;

            switch (userInputDBTagQAC) {
                case "Questions":
                    OCA(qcaOptions[0]);
                    break;
                case "Choices":
                    if (qcaOptions.length == 3) OCA(qcaOptions[1]);
                    break;
                case "Answers":
                    OCA(qcaOptions[qcaOptions.length - 1]);
                    break;
                case "Back to level selection":
                    sLevelRunning = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input");
            }
        }
    }

    private static String showOptionDialog(String message, String title, String[] options) {
        return (String) JOptionPane.showInputDialog(null, message, title,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

    private static void OCA(int option) throws IOException, CsvException {
        try {
            CSVReader reader = new CSVReader(new FileReader(new File("qna.csv")));
            List<String[]> data = reader.readAll();
            reader.close();

            int rowToPrint = option;
            String cont;

            do {
                if (rowToPrint < data.size()) {
                    StringBuilder rowContent = new StringBuilder("=====================================================\n");
                    String[] row = data.get(rowToPrint);
                    for (int i = 0; i < row.length; i++) {
                        rowContent.append("[").append(i).append("] ").append(row[i]).append("\n");
                    }
                    rowContent.append("=====================================================");
                    JOptionPane.showMessageDialog(null, rowContent.toString());

                    String choice = JOptionPane.showInputDialog(null, "Input the index to replace:");
                    int qindex = Integer.parseInt(choice);

                    String r_Ques = JOptionPane.showInputDialog(null,
                            "Enter replacement (note: the replaced (answer) MUST BE IN CAPS, FOLLOW THE FORMAT):");

                    data.get(option)[qindex] = r_Ques;

                    try (CSVWriter writer = new CSVWriter(new FileWriter(new File("qna.csv")))) {
                        writer.writeAll(data);
                    }

                    cont = JOptionPane.showInputDialog(null, "Do you want to continue? Y/N:").toUpperCase();
                } else {
                    JOptionPane.showMessageDialog(null, "Row number out of range");
                    cont = "N";
                }
            } while (cont.equals("Y"));
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Invalid input");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Editing QCA option: " + option);
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
            java.util.logging.Logger.getLogger(teacherAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(teacherAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(teacherAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(teacherAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new teacherAccounts().setVisible(true);
            }
        });
    }

    private javax.swing.JButton EDITbutt;
    private javax.swing.JButton EXITta;
    private javax.swing.JButton OTHERRecButt;
    private javax.swing.JButton QCAEditbutt;
    private javax.swing.JButton SJIRecButt;
    private javax.swing.JButton USLSRecButt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JScrollPane spLeaderboards2;
    private javax.swing.JScrollPane spLeaderboards3;
    private javax.swing.JScrollPane spLeaderboards4;
    private java.awt.TextArea textArea1;                  
} 

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class SearchAndDeleteLead extends javax.swing.JFrame {

    public SearchAndDeleteLead() {
        initComponents();
    }                        
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SADSearchBut = new javax.swing.JButton();
        SADTextBox = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        SADSearchButBack = new javax.swing.JButton();
        SADtextArea1 = new java.awt.TextArea();
        SADSearchBut1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 300));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("S E A R C H   A N D   D E L E T E");

        SADSearchBut.setBackground(new java.awt.Color(153, 153, 153));
        SADSearchBut.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        SADSearchBut.setText("Enter");
        SADSearchBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SADSearchButActionPerformed(evt);
            }
        });

        SADTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SADTextBoxActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("- Ñ | bà -");

        SADSearchButBack.setBackground(new java.awt.Color(153, 153, 153));
        SADSearchButBack.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        SADSearchButBack.setText("Go Back");
        SADSearchButBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SADSearchButBackActionPerformed(evt);
            }
        });

        SADSearchBut1.setBackground(new java.awt.Color(153, 153, 153));
        SADSearchBut1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        SADSearchBut1.setText("Delete");
        SADSearchBut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SADSearchBut1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SADtextArea1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SADTextBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SADSearchBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SADSearchBut1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SADSearchButBack, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SADTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SADSearchBut, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SADSearchButBack, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SADSearchBut1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SADtextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel23)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 175, Short.MAX_VALUE))
        );

        pack();
    }                      

    private void SADSearchButActionPerformed(java.awt.event.ActionEvent evt) {  
            SADtextArea1.setText("");                                           
            try (CSVReader reader = new CSVReader(new FileReader("leaderboards.csv"))) {
            String searchName = SADTextBox.getText();
            System.out.println(searchName);
            boolean found = false;
        
            String[] leaderSearch;
            while ((leaderSearch = reader.readNext()) != null) {
                if (leaderSearch[0].equals(searchName)) {
                    SADtextArea1.append(String.join(",                                ", leaderSearch) + "\n");
                    found = true;
                }
            }
            if (!found) {
                SADtextArea1.append("Name not found in the leaderboards.");
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        } 
    }                                            

    private void SADTextBoxActionPerformed(java.awt.event.ActionEvent evt) {}                                          

    private void SADSearchButBackActionPerformed(java.awt.event.ActionEvent evt) {    
        adminAccounts tenFrame = new adminAccounts();
        tenFrame.setVisible(true);
        tenFrame.pack();
        tenFrame.setLocationRelativeTo(null);                                              
        this.dispose();
    }                                                

    private void SADSearchBut1ActionPerformed(java.awt.event.ActionEvent evt) {     
        SADtextArea1.setText("");                                           
        boolean found2 = false;
        List<String[]> delAcc = new ArrayList<>();
        try (CSVReader read = new CSVReader(new FileReader("leaderboards.csv"))) {
            delAcc = read.readAll();
            String searchName = SADTextBox.getText();
            Iterator<String[]> iterator = delAcc.iterator();
            while (iterator.hasNext()) {
                String[] leaderSearchdel = iterator.next();
                if (leaderSearchdel[0].equals(searchName)) {
                    iterator.remove(); 
                    found2 = true;
                }
            }
            if (!found2) {
                SADtextArea1.append("Name not found in the leaderboards.");
            } else {
                try (CSVWriter writer = new CSVWriter(new FileWriter("leaderboards.csv"))) {
                    writer.writeAll(delAcc); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            java.util.logging.Logger.getLogger(SearchAndDeleteLead.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchAndDeleteLead.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchAndDeleteLead.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchAndDeleteLead.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchAndDeleteLead().setVisible(true);
            }
        });
    }
                    
    private javax.swing.JButton SADSearchBut;
    private javax.swing.JButton SADSearchBut1;
    private javax.swing.JButton SADSearchButBack;
    private javax.swing.JTextField SADTextBox;
    private java.awt.TextArea SADtextArea1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;                
}

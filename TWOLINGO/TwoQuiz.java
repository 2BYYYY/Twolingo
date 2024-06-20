import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class TwoQuiz extends javax.swing.JFrame {
    static String holdLevel = "";
    

    public TwoQuiz() {
        initComponents();
    }                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        easy = new javax.swing.JButton();
        medium = new javax.swing.JButton();
        hard = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 300));

        jPanel1.setPreferredSize(new java.awt.Dimension(650, 300));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 48)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("C H O O S E   D I F I C U L T Y");

        easy.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); 
        easy.setText("EASY");
        easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    easyActionPerformed(evt);
                } catch (IOException | CsvException e) {
                    e.printStackTrace();
                }
            }
        });

        medium.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); 
        medium.setText("MEDIUM");
        medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    mediumActionPerformed(evt);
                } catch (IOException | CsvException e) {
                    e.printStackTrace();
                }
            }
        });

        hard.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); 
        hard.setText("HARD");
        hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    hardActionPerformed(evt);
                } catch (IOException | CsvException e) {
                    e.printStackTrace();
                }
            }
        });

        back.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); 
        back.setText("Go back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    backActionPerformed(evt);
                } catch (IOException | CsvException e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(back))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(easy, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(medium)
                                .addGap(38, 38, 38)
                                .addComponent(hard, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(easy)
                    .addComponent(medium)
                    .addComponent(hard))
                .addGap(18, 18, 18)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void hardActionPerformed(java.awt.event.ActionEvent evt) throws IOException, CsvException { 
        CSVReader readerUA = new CSVReader(new FileReader(guiTwo.user_In + ".csv"));
        List<String[]> rowsUA = readerUA.readAll();       
        if(twoSudent.holdQuiz.equals("T")){
            if(rowsUA.get(2)[3].equals("T")){
                holdLevel = "H";
                QuizTwoMain nineFrame = new QuizTwoMain();
                nineFrame.setVisible(true);
                nineFrame.pack();
                nineFrame.setLocationRelativeTo(null);
            } else {
                JOptionPane.showMessageDialog(this, "You haven't unlocked hard mode yet, play the medium mode first");
            }
        } else {
            if(rowsUA.get(3)[3].equals("T")){
                holdLevel = "H";
                QuizTwoMain nineFrame = new QuizTwoMain();
                nineFrame.setVisible(true);
                nineFrame.pack();
                nineFrame.setLocationRelativeTo(null);
            } else {
                JOptionPane.showMessageDialog(this, "You haven't unlocked hard mode yet, play the medium mode first");
            }
        }
    }                                    

    private void mediumActionPerformed(java.awt.event.ActionEvent evt) throws IOException, CsvException {   
        CSVReader readerUA = new CSVReader(new FileReader(guiTwo.user_In + ".csv"));
        List<String[]> rowsUA = readerUA.readAll(); 
        if(twoSudent.holdQuiz.equals("T")){
            if(rowsUA.get(2)[2].equals("T")){
                holdLevel = "M";
                QuizTwoMain nineFrame = new QuizTwoMain();
                nineFrame.setVisible(true);
                nineFrame.pack();
                nineFrame.setLocationRelativeTo(null);
            } else {
                JOptionPane.showMessageDialog(this, "You haven't unlocked medium mode yet, play the easy mode first");
            }
        } else {
            if(rowsUA.get(3)[2].equals("T")){
                holdLevel = "M";
                QuizTwoMain nineFrame = new QuizTwoMain();
                nineFrame.setVisible(true);
                nineFrame.pack();
                nineFrame.setLocationRelativeTo(null);
            } else {
                JOptionPane.showMessageDialog(this, "You haven't unlocked medium mode yet, play the easy mode first");
            }
        }
    }                                      

    private void easyActionPerformed(java.awt.event.ActionEvent evt) throws IOException, CsvException {                                     
        holdLevel = "E";
        QuizTwoMain nineFrame = new QuizTwoMain();
        nineFrame.setVisible(true);
        nineFrame.pack();
        nineFrame.setLocationRelativeTo(null);
    }                                    

    private void backActionPerformed(java.awt.event.ActionEvent evt) throws IOException, CsvException {                                     
        twoSudent nineFrame = new twoSudent();
        nineFrame.setVisible(true);
        nineFrame.pack();
        nineFrame.setLocationRelativeTo(null);
        this.dispose();
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
            java.util.logging.Logger.getLogger(TwoQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TwoQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TwoQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TwoQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TwoQuiz().setVisible(true);
            }
        });
    }
                 
    private javax.swing.JButton back;
    private javax.swing.JButton easy;
    private javax.swing.JButton hard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton medium;               
}

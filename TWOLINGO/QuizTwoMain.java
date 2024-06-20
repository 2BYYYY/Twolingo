import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JOptionPane;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class QuizTwoMain extends javax.swing.JFrame {
    CSVReader readerUA = new CSVReader(new FileReader(guiTwo.user_In + ".csv"));
    List<String[]> rowsUA = readerUA.readAll();
    String proVersion = rowsUA.get(1)[1];
    String Ans0 = "", Ans1 = "", Ans2 = "", Ans3 = "", congrats = "", badge ="", Ctext0 = "", Ctext1 = "", Ctext2 = "", Ctext3 = "";
    int score = 0, run1 = 0, run2 = 0, run3 = 0, run4 = 0, Max_Attepts, SBad, PBad, SMode;

    public QuizTwoMain() throws IOException, CsvException {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws IOException, CsvException {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ModeQues0 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ModeChoi0 = new javax.swing.JLabel();
        ModeAns0 = new javax.swing.JTextField();
        ModeAns1 = new javax.swing.JTextField();
        ModeQues1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ModeChoi1 = new javax.swing.JLabel();
        ModeAns2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ModeQues2 = new javax.swing.JLabel();
        ModeChoi2 = new javax.swing.JLabel();
        ModeQues3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ModeChoi3 = new javax.swing.JLabel();
        ModeAns3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Cguide = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("T W O L I N G O");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        CSVReader readerUA = new CSVReader(new FileReader(guiTwo.user_In + ".csv"));
        List<String[]> rowsUA = readerUA.readAll();
        int ques = 0, choi = 0, answerr = 0;
        if(proVersion.equals("T")) Max_Attepts = 3;
        else Max_Attepts = 2;
        CSVReader readerTM = new CSVReader(new FileReader("qna.csv"));
        List<String[]> allRows = readerTM.readAll();
        if(twoSudent.holdQuiz.equals("T")){
            PBad = 2;
	        if(TwoQuiz.holdLevel.equals("E")){
                ques = 1; choi = 2; answerr = 3; congrats = "You have unlocked Medium mode"; badge =  "Wow! nag tatagalog ka pala eh!"; SBad = 5; SMode = 2;
	        } else if(TwoQuiz.holdLevel.equals("M")){
                ques = 4; choi = 5; answerr = 6; congrats = "You have unlocked Hard mode"; badge =  "Tagalogist!"; SBad = 6; SMode = 3;
	        } else if(TwoQuiz.holdLevel.equals("H")){
                ques = 7; choi = 8; answerr = 9; congrats = "You have Completed Twolingo Tagalog"; badge =  "Kababayan!"; SBad = 7;
	        }
        } else if(twoSudent.holdQuiz.equals("C")){
            PBad = 3;
            Cguide.setText("GUIDE: [1] 1ST TONE ( - ) , [2] 2ND TONE ( / ), [3] THIRD TONE ( V ), FOURTH TONE ( \\ )");
	        if(TwoQuiz.holdLevel.equals("E")){
                ques = 12; choi = 13; answerr = 14; congrats = "You have unlocked Medium mode"; badge =  "xiao dre karate kid"; SBad = 5; SMode = 2;
	        } else if(TwoQuiz.holdLevel.equals("M")){
                ques = 15; choi = 16; answerr = 17; congrats = "You have unlocked Hard mode"; badge =  "Wow! Are you the translator of Xi Jinping?"; SBad = 6; SMode = 3;
	        } else if(TwoQuiz.holdLevel.equals("H")){
                ques = 18; choi = 19; answerr = 20; congrats = "You have Completed Twolingo Chinese"; badge =  "BING CHILLING!"; SBad = 7;
	        }
        }
            ModeQues0.setText(allRows.get(ques)[0]);
            ModeQues1.setText(allRows.get(ques)[1]);
            ModeQues2.setText(allRows.get(ques)[2]);
            ModeQues3.setText(allRows.get(ques)[3]);

            ModeChoi0.setText(allRows.get(choi)[0]);
            ModeChoi1.setText(allRows.get(choi)[1]);
            ModeChoi2.setText(allRows.get(choi)[2]);
            ModeChoi3.setText(allRows.get(choi)[3]);

            Ans0 = allRows.get(answerr)[0];
            Ans1 = allRows.get(answerr)[1];
            Ans2 = allRows.get(answerr)[2];
            Ans3 = allRows.get(answerr)[3];

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel2.setText("H E A R T S:");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText(String.valueOf(Max_Attepts));

        ModeQues0.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel5.setText("1.");

        ModeChoi0.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N

        ModeAns0.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        ModeAns0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModeAns0ActionPerformed(evt);
            }
        });

        ModeAns1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        ModeAns1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModeAns1ActionPerformed(evt);
            }
        });

        ModeQues1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel6.setText("2.");

        ModeChoi1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N

        ModeAns2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        ModeAns2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModeAns2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel7.setText("3.");

        ModeQues2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N

        ModeChoi2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N

        ModeQues3.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel8.setText("4.");

        ModeChoi3.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N

        ModeAns3.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        ModeAns3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModeAns3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jButton1.setText("Confirm Answers");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        jButton2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jButton2.setText("Go Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Cguide.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Cguide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(ModeChoi0, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ModeQues0, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ModeAns0, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModeChoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ModeQues1, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ModeAns1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModeChoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ModeQues2, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ModeAns2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ModeQues3, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ModeChoi3, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModeAns3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(Cguide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ModeQues0)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModeChoi0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModeAns0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ModeQues1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModeChoi1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModeAns1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ModeQues2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModeChoi2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModeAns2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ModeQues3)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModeChoi3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModeAns3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(190, 190, 190))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }                     

    private void ModeAns0ActionPerformed(java.awt.event.ActionEvent evt) {}                                            

    private void ModeAns1ActionPerformed(java.awt.event.ActionEvent evt) {}                                            

    private void ModeAns2ActionPerformed(java.awt.event.ActionEvent evt) {}                                            

    private void ModeAns3ActionPerformed(java.awt.event.ActionEvent evt) {}                                            

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {   
        Ctext0 = ModeAns0.getText();
        Ctext1 = ModeAns1.getText();
        Ctext2 = ModeAns2.getText(); 
        Ctext3 = ModeAns3.getText();

            if (Ctext0.toUpperCase().equals(Ans0)){
                if(run1 == 0){
                    score++; run1 = 1;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Wrong Answer in #1");
            }
            if (Ctext1.toUpperCase().equals(Ans1)){
                if(run2 == 0){
                    score++; run2 = 1;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Wrong Answer in #2");
            }
            if (Ctext2.toUpperCase().equals(Ans2)){
                if(run3 == 0){
                    score++; run3 = 1;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Wrong Answer in #3");
            }
            if (Ctext3.toUpperCase().equals(Ans3)){
                if(run4 == 0){
                    score++; run4 = 1;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Wrong Answer in #4");
            }
            Max_Attepts --;
            String language = "";
            if(twoSudent.holdQuiz.equals("T")){
                language = "Tagalog";
                if (TwoQuiz.holdLevel.equals("H")) rowsUA.get(2)[8] = "T";
            } else if (twoSudent.holdQuiz.equals("C")){
                language = "Chinese";
                if (TwoQuiz.holdLevel.equals("H")) rowsUA.get(3)[8] = "T";
            }
            if(score == 4){
                if (rowsUA.get(PBad)[SBad].equals("N/A")) {
                    rowsUA.get(PBad)[SBad] = badge;
                } else {
                    badge = "You already have this badge";
                    rowsUA.get(3)[8] = "F";
                    rowsUA.get(2)[8] = "F";
                }
                JOptionPane.showMessageDialog(this, "You have answered all questions correctly. Your score is " + score + " out of 4 \nCongratulations:" + congrats + "\nBadge :" + badge);
                rowsUA.get(PBad)[SMode] = "T";
                if(twoSudent.coins >= 30){
                    JOptionPane.showMessageDialog(this,"Maximum coins reached");
                } else {
                    String sCoin = "";
                    twoSudent.coins += 5; 
                    JOptionPane.showMessageDialog(this,"You earned 5 coins");
                    if(twoSudent.coins == 0) sCoin = "A";
                    else if(twoSudent.coins == 5) sCoin = "B";
                        else if(twoSudent.coins == 10) sCoin = "C";
                            else if(twoSudent.coins == 15) sCoin = "D";
                                else if(twoSudent.coins == 20) sCoin = "E";
                                    else if(twoSudent.coins == 25) sCoin = "F";
                                        else if(twoSudent.coins == 30) sCoin = "G";
                                        rowsUA.get(4)[1] = sCoin;
                }
                CSVWriter writer = new CSVWriter(new FileWriter(new File(guiTwo.user_In + ".csv")));
                writer.writeAll(rowsUA); 
                writer.flush();
                Date date = new Date();
                String id = rowsUA.get(0)[1];
                if(rowsUA.get(2)[7].equals("Kababayan!") && rowsUA.get(2)[8].equals("T")|| rowsUA.get(3)[7].equals("BING CHILLING!") && rowsUA.get(3)[8].equals("T")) entermTwolingoRecoded.leaderBoards(guiTwo.user_In,id,language,date);
                if(proVersion.equals("F")){
                    for(int i = 0; i < 5; i++){
                        ads();
                    }
                } 
                this.dispose();
            } else if(Max_Attepts == 0){
                JOptionPane.showMessageDialog(this, "You have used all your attempts. Your score is " + score + " out of 4");
                this.dispose();
            }
            jLabel3.setText(String.valueOf(Max_Attepts));   
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.dispose();
    }

    private void ads() {
        JDialog dialog = new JDialog();
        dialog.setTitle("ADS ADS ADS ADS");

        JLabel label = new JLabel("ADS ADS ADS ADS", SwingConstants.CENTER);
        dialog.add(label);

        dialog.setSize(300, 300);


        Random random = new Random();
        int randomX = random.nextInt(900);
        int randomY = random.nextInt(900);

        dialog.setLocation(randomX, randomY);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
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
            java.util.logging.Logger.getLogger(QuizTwoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizTwoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizTwoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizTwoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QuizTwoMain().setVisible(true);
                } catch (IOException | CsvException e) {
                    e.printStackTrace();
                }
            }
        });
    }
                  
    private javax.swing.JLabel Cguide;
    private javax.swing.JTextField ModeAns0;
    private javax.swing.JTextField ModeAns1;
    private javax.swing.JTextField ModeAns2;
    private javax.swing.JTextField ModeAns3;
    private javax.swing.JLabel ModeChoi0;
    private javax.swing.JLabel ModeChoi1;
    private javax.swing.JLabel ModeChoi2;
    private javax.swing.JLabel ModeChoi3;
    private javax.swing.JLabel ModeQues0;
    private javax.swing.JLabel ModeQues1;
    private javax.swing.JLabel ModeQues2;
    private javax.swing.JLabel ModeQues3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;                 
}

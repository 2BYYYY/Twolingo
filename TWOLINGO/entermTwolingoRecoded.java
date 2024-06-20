import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.ArrayList;
import java.util.Date; 
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.lang3.ObjectUtils;

public class entermTwolingoRecoded{
    public static void main(String[] args) throws IOException, CsvException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Date date = new Date();
        String choice;
        try {
            while (true) {
                
                System.out.println("==========================================================");
                System.out.println("\tTWOLINGO: A Language Learning Tool System");
                System.out.println("==========================================================");
                // Menu
                System.out.println("Please input the number of your choice\n");
                System.out.println("[A] Create new TWOLINGO account || [B] Log in with TWOLINGO account || [C] Exit TWOLINGO System: ");
                choice = br.readLine().toUpperCase();
                // New Account Creation
                if (choice.equals("A")) {
                    System.out.println("Enter New Email/username (maximum 15 letters): ");
                    String newUser = br.readLine();
                    System.out.println("Enter New Password: ");
                    String newPass = br.readLine();
                    if (newUser.length() > 15) {
                        System.out.println("====================================================");
                        System.out.println("Email/Username is too long");
                        System.out.println("====================================================");
                    } else if (checkNameExists(newUser,"all_Student_Records.csv")) {
                        System.out.println("====================================================");
                        System.out.println("You have an ongoing account");
                        System.out.println("====================================================");
                    } else {
                        System.out.println("====================================================");
                        System.out.println("New user created.");
                        System.out.println("====================================================");
                        int aID = ID_num(1);
                        System.out.println("Your Account ID is " + aID);
                        User_CSV(newUser,newPass,aID,date);
                        userAccount(newUser,aID,date);
                    }
                } else if (choice.equals("B")) {
                    // Login Attempts
                    int loginAttempts = 0;
                    final int maxAttempts = 3;
                    String oldUser, oldPass, sRun = "Y";
                    do{
                        System.out.println("Enter TWOLINGO account: ");
                        oldUser = br.readLine();
                        System.out.println("Enter Password: ");
                        oldPass = br.readLine();   
                        if(oldUser.equals("Admin") && oldPass.equals("admin123")){
                            admin_Twolingo();
                            break;
                        } else if (oldUser.equals("Teach") && oldPass.equals("teach123")){
                            teacher_Twolingo();
                            break;
                        } else if(validateLogin(oldUser,oldPass)) {
                            System.out.println("====================================================");
                            System.out.println("Successfully logged in!!");
                            System.out.println("====================================================");

                            twolingo_main(oldUser);
                            break;
                        } else {
                            loginAttempts++;
                            System.out.println("Invalid login credentials, try again or sign up for a new account");
                            System.out.println("You have " + (maxAttempts - loginAttempts) + " attempts left.\n");
                            if (loginAttempts == maxAttempts) {
                                System.out.println("Maximum login attempts reached. Exiting program.");
                                return;
                            }
                            System.out.println("Please select your input");
                            System.out.println("[A] Create new account || [B] Retry attempt: ");
                            String att = br.readLine().toUpperCase();
                                if (att.equals("A")) sRun = "N";
                                else if (att.equals("B")) sRun = "Y";
                                else System.out.println("Invalid input");
                                
                        }
                    } while(sRun.equals("Y"));
                } else if (choice.equals("C")) {
                    System.out.println("Exiting program....");
                    return;
                } else {
                    System.out.println("====================================================");
                    System.out.println("Retry with valid input");
                    System.out.println("====================================================");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, Exiting program....");
        }
    }
        static int ID_num(int i_d){
            boolean r_ID = false;
            try (CSVReader cNE = new CSVReader(new FileReader("all_Student_Records.csv"))) {
                String[] line;
                String ran_IDDD = Integer.toString(i_d);
                while ((line = cNE.readNext()) != null) {
                    // Assuming the name is in the first column (adjust if different)
                    if (line[2].equalsIgnoreCase(ran_IDDD)) {
                        r_ID = true;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading CSV file: " + e.getMessage());
            } catch (CsvValidationException e){

            } catch (NoClassDefFoundError e) {

            }

            Random random = new Random();
            i_d = random.nextInt(99999);
            boolean i_dAgain = true;
            while (i_dAgain) {
                if (i_d == 16 || i_d == 28 || i_d == 9) {
                    i_d = random.nextInt(99999);
                    i_dAgain = false;
                } else if (r_ID){
                    i_d = random.nextInt(99999);
                    i_dAgain = false;
                } else {
                    i_dAgain = false;
                }
            }
            return i_d;
        }

        static void User_CSV(String studentName, String studentPass, int ran_ID, Date date) throws IOException {
            String filePath;
            String school;

            if (studentName.contains("@usls")) {
                filePath = "usls_Student_Records.csv";
                school = "USLS";
            } else if (studentName.contains("@sji")) {
                filePath = "sji_Student_Records.csv";
                school = "SJI";
            } else {
                filePath = "other_Student_Records.csv";
                school = "OTHER";
            }

            // Write to specific school file
            writeToCSV(filePath, studentName, studentPass, ran_ID, school, date);

            // Write to all_Student_Records.csv
            writeToCSV("all_Student_Records.csv", studentName, studentPass, ran_ID, school, date);
        }

        static void writeToCSV(String filePath, String studentName, String studentPass, int ran_ID, String school, Date date) throws IOException {
            try (CSVWriter writer = new CSVWriter(new FileWriter(filePath, true))) {
                String ran_IDD = Integer.toString(ran_ID);
                String[] data = {studentName, studentPass, ran_IDD, school, date.toString()};
                writer.writeNext(data);
            }
        }

        static boolean validateLogin(String username, String password) {
            try (CSVReader vL = new CSVReader(new FileReader("all_Student_Records.csv"))) {
                String[] nextLine;
                while ((nextLine = vL.readNext()) != null) {
                    if (nextLine[0].equals(username) && nextLine[1].equals(password)) {
                        return true;  // Username and password match
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading CSV file: " + e.getMessage());
            } catch (CsvValidationException e){
            } catch (NoClassDefFoundError e) {}

            return false;  // Login failed (credentials not found)
        }

        static boolean checkNameExists(String name, String filePath) {
            if(name.equals("Admin") || name.equals("Teach") ) return true;
            try (CSVReader cNE = new CSVReader(new FileReader(filePath))) {
                String[] line;
                while ((line = cNE.readNext()) != null) {
                    // Assuming the name is in the first column (adjust if different)
                    if (line[0].equalsIgnoreCase(name)) {
                        return true;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading CSV file: " + e.getMessage());
            } catch (CsvValidationException e){
            } catch (NoClassDefFoundError e) {}
    
            return false;
        }

        private static void not_Ads(){
            try {
                System.out.println("hataw sa STING!");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("hataw sa SIKAP!");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("hataw sa ENERY!");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("hataw sa SARAP!");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("STING, hataw sa SIKAP!, hataw sa SARAP!. For only 17 php");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Don't want ads?");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Try TWOLINGO pro version for only 5 coins");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {}
        }

        static void userAccount(String studentName, int ran_ID, Date date){
            try (CSVWriter writer = new CSVWriter(new FileWriter(studentName + ".csv", true))) {
                String ran_IDD = Integer.toString(ran_ID);
                String[] uDataAccount = {studentName, ran_IDD, date.toString()};
                String[] uDataPro = {"PRO VERSION","F"};
                String[] tLock = {"TAGALOG LOCK","T","F","F","TAGALOG BADGES","N/A","N/A","N/A","F"};
                String[] cLock = {"CHINESE LOCK","T","F","F","CHINESE BADGES","N/A","N/A","N/A","F"};
                String[] uDataCoins = {"COINS","A"};

                writer.writeNext(uDataAccount);
                writer.writeNext(uDataPro);
                writer.writeNext(tLock);
                writer.writeNext(cLock);
                writer.writeNext(uDataCoins);

            } catch(IOException e){
                System.out.println("Error reading CSV file: " + e.getMessage());
            }
        }
        static void edit_QCA(int sRow) throws IOException, CsvException {
            CSVReader reader = new CSVReader(new FileReader(new File("qna.csv")));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String cont = "";
            List<String[]> data = reader.readAll();
            int rowToPrint = sRow;
            System.out.println("=====================================================");
            do {
                try {
                        if (rowToPrint < data.size()) {
                            String[] row = data.get(rowToPrint);
                            for (int i = 0; i < row.length; i++) {
                                System.out.println("[" + i + "]" + " " + row[i]);
                            }
                        }
                    System.out.println("=====================================================");
                    System.out.print("Input the index to replace: ");
                    String choice = br.readLine();
                    int qindex = Integer.parseInt(choice);
                    System.out.print("Enter replacement (note: the replaced (answer) MUST BE IN CAPS, FOLLOW THE FORMAT): ");
                    String r_Ques = br.readLine();
            
                    data.get(sRow)[qindex] = r_Ques;
                    try (CSVWriter writer = new CSVWriter(new FileWriter(new File("qna.csv")))) {
                        writer.writeAll(data);
                    }
                    System.out.print("Do you want to continue? Y/N: ");
                    cont = br.readLine().toUpperCase();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input");
                }
            } while (cont.equals("Y"));
        }        
        static void leaderBoards(String studentName,String ran_ID, String language,Date date){
            try {
                CSVWriter lWriter = new CSVWriter(new FileWriter("leaderboards.csv", true));
                String[] DataAccount = {studentName, ran_ID, language, date.toString()};
                lWriter.writeNext(DataAccount);
                lWriter.close();
            } catch (IOException e) {
                System.out.println("Error reading CSV file: " + e.getMessage());
            }
        }  
        private static void show_CSV(String file){
            String[] s_CSV;
            try (CSVReader lReader = new CSVReader(new FileReader(file))) {
                while ((s_CSV = lReader.readNext()) != null) {
                    for (String data : s_CSV) {
                    System.out.printf("%-20s",data);
                    }
                    System.out.println(); 
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        } 
        private static void teacher_Twolingo() throws IOException, CsvException{
            String th_Choice = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            boolean th_Running = true;
            while (th_Running) {
                System.out.println("====================================================");
                System.out.println("\tTWOLINGO Teacher Page");
                System.out.println("====================================================");
                System.out.println("Please input the number of your choice\n");
                System.out.println("[A] USLS Records || [B] SJI Records || [C] Edit Questions, Answer, and Choices || [D] Exit TWOLINGO Teacher Page");
                th_Choice = br.readLine().toUpperCase();

                if(th_Choice.equals("A"))show_CSV("usls_Student_Records.csv");
                else if(th_Choice.equals("B"))show_CSV("sji_Student_Records.csv");
                else if(th_Choice.equals("C")){
                    Boolean back_Running = true;
                    while (back_Running) {
                        System.out.println("[A] TWOLINGO Tagalog");
                        System.out.println("[B] TWOLINGO Chinese");
                        System.out.println("[C] Back to TWOLINGO Admin Page");
                        String userInput_D_B = br.readLine().toUpperCase();
                        if (userInput_D_B.equals("A")) {
                            Boolean ls_Running = true;
                            while (ls_Running) {
                                System.out.println("[A] Easy Level");
                                System.out.println("[B] Medium Level");
                                System.out.println("[C] Hard Level"); 
                                System.out.println("[D] Back to language selection"); 
                                String userInput_D_B_Tag = br.readLine().toUpperCase();
                                Boolean s_Level_Running = true;
                                if (userInput_D_B_Tag.equals("A")) {
                                    s_Level_Running = true;
                                    while (s_Level_Running) {
                                        System.out.println("[A] Questions");
                                        System.out.println("[B] Choices");
                                        System.out.println("[C] Answers");
                                        System.out.println("[D] Back to level selection");
                                        String userInput_D_B_Tag_QAC = br.readLine().toUpperCase();
                                        if (userInput_D_B_Tag_QAC.equals("A")) edit_QCA(1);
                                        else if (userInput_D_B_Tag_QAC.equals("B")) edit_QCA(2);
                                        else if (userInput_D_B_Tag_QAC.equals("C")) edit_QCA(3);
                                        else if (userInput_D_B_Tag_QAC.equals("D")) s_Level_Running = false;
                                        else System.out.print("Invalid input");
                                    }
                                } else if (userInput_D_B_Tag.equals("B")){
                                    s_Level_Running = true;
                                    while (s_Level_Running) {
                                        System.out.println("[A] Questions");
                                        System.out.println("[B] Choices");
                                        System.out.println("[C] Answers");
                                        System.out.println("[D] Back to level selection");
                                        String userInput_D_B_Tag_QAC = br.readLine().toUpperCase();
                                        if (userInput_D_B_Tag_QAC.equals("A")) edit_QCA(4);
                                        else if (userInput_D_B_Tag_QAC.equals("B")) edit_QCA(5);
                                        else if (userInput_D_B_Tag_QAC.equals("C")) edit_QCA(6);
                                        else if (userInput_D_B_Tag_QAC.equals("D")) s_Level_Running = false;
                                        else System.out.print("Invalid input");
                                    }
                                } else if (userInput_D_B_Tag.equals("C")){
                                    s_Level_Running = true;
                                    while (s_Level_Running) {
                                        System.out.println("[A] Questions");
                                        System.out.println("[B] Answers");
                                        System.out.println("[C] Back to level selection");
                                        String userInput_D_B_Tag_QAC = br.readLine().toUpperCase();
                                        if (userInput_D_B_Tag_QAC.equals("A")) edit_QCA(7);
                                        else if (userInput_D_B_Tag_QAC.equals("B")) edit_QCA(9);
                                        else if (userInput_D_B_Tag_QAC.equals("C")) s_Level_Running = false;
                                        else System.out.print("Invalid input");
                                    }
                                } else if (userInput_D_B_Tag.equals("D")){
                                    ls_Running = false;
                                } else {
                                    System.out.println("Invalid input");
                                }
                            }
                        } else if (userInput_D_B.equals("B")){
                            Boolean lss_Running = true;
                            while (lss_Running) {
                                System.out.println("! NOTE: YOU CAN'T CHANGE THE CHINESE GUIDE !");
                                System.out.println("[A] Easy Level");
                                System.out.println("[B] Medium Level");
                                System.out.println("[C] Hard Level"); 
                                System.out.println("[D] Back to language selection"); 
                                String userInput_D_B_Chi = br.readLine().toUpperCase();
                                Boolean s_Level_Running = true;
                                if (userInput_D_B_Chi.equals("A")) {
                                    s_Level_Running = true;
                                    while (s_Level_Running) {
                                        System.out.println("[A] Questions");
                                        System.out.println("[B] Choices");
                                        System.out.println("[C] Answers");
                                        System.out.println("[D] Back to level selection");
                                        String userInput_D_B_Chi_QAC = br.readLine().toUpperCase();
                                        if (userInput_D_B_Chi_QAC.equals("A")) edit_QCA(12);
                                        else if (userInput_D_B_Chi_QAC.equals("B")) edit_QCA(13);
                                        else if (userInput_D_B_Chi_QAC.equals("C")) edit_QCA(14);
                                        else if (userInput_D_B_Chi_QAC.equals("D")) s_Level_Running = false;
                                        else System.out.print("Invalid input");
                                    }
                                } else if (userInput_D_B_Chi.equals("B")){
                                    s_Level_Running = true;
                                    while (s_Level_Running) {
                                        System.out.println("[A] Questions");
                                        System.out.println("[B] Choices");
                                        System.out.println("[C] Answers");
                                        System.out.println("[D] Back to level selection");
                                        String userInput_D_B_Chi_QAC = br.readLine().toUpperCase();
                                        if (userInput_D_B_Chi_QAC.equals("A")) edit_QCA(15);
                                        else if (userInput_D_B_Chi_QAC.equals("B")) edit_QCA(16);
                                        else if (userInput_D_B_Chi_QAC.equals("C")) edit_QCA(17);
                                        else if (userInput_D_B_Chi_QAC.equals("D")) s_Level_Running = false;
                                        else System.out.print("Invalid input");
                                    }
                                } else if (userInput_D_B_Chi.equals("C")){
                                    s_Level_Running = true;
                                    while (s_Level_Running) {
                                        System.out.println("[A] Questions");
                                        System.out.println("[B] Answers");
                                        System.out.println("[C] Back to level selection");
                                        String userInput_D_B_Chi_QAC = br.readLine().toUpperCase();
                                        if (userInput_D_B_Chi_QAC.equals("A")) edit_QCA(18);
                                        else if (userInput_D_B_Chi_QAC.equals("B")) edit_QCA(20);
                                        else if (userInput_D_B_Chi_QAC.equals("C")) s_Level_Running = false;
                                        else System.out.print("Invalid input");
                                    }
                                } else if (userInput_D_B_Chi.equals("D")){
                                    lss_Running = false;
                                } else {
                                    System.out.println("Invalid input");
                                }
                            }
                        } else if (userInput_D_B.equals("C")){
                            back_Running = false;
                        } else {
                            System.out.println("Invalid input");
                        }
                    }
                } else if (th_Choice.equals("D")) th_Running = false;
                else System.out.println("Invalid input");
            }
        }

        private static void admin_Twolingo() throws IOException, CsvException{
            String ad_Choice;
            boolean ad_Running = true;
            while (ad_Running) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("====================================================");
                System.out.println("\tTWOLINGO Admin Page");
                System.out.println("====================================================");
                System.out.println("Please input the number of your choice\n");
                System.out.println("[A] View and Delete Leaderboards || [B] View all Records (CSV) || [C] Exit TWOLINGO Admin Page");
                ad_Choice = br.readLine().toUpperCase();
                
                if (ad_Choice.equals("A")) {
                    while (true) {
                        String[] leaderSearch;
                        System.out.println("====================================================");
                        System.out.println("\tTWOLINGO Leaderboards");
                        System.out.println("====================================================");
                        show_CSV("leaderboards.csv");
                        System.out.println("[A] Search Username/Email || [B] Delete Username/Email || [C] Exit Twolingo Leaderboards");
                        String lChoice = br.readLine();
                        if (lChoice.equalsIgnoreCase("A")) {
                            boolean found = false;
                            try (CSVReader read = new CSVReader(new FileReader("leaderboards.csv"))) {
                                System.out.println("Enter Username/Email");
                                System.out.println("====================================================");
                                String searchName = br.readLine();
                                while ((leaderSearch = read.readNext()) != null) {
                                    if (leaderSearch[0].equals(searchName)) {
                                        System.out.println(String.join(",", leaderSearch));
                                        found = true;
                                    }
                                }
                                if (!found) System.out.println("Name not found in the leaderboards.");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (lChoice.equalsIgnoreCase("B")) {
                            boolean found2 = false;
                            List<String[]> delAcc = new ArrayList<>();
                            try (CSVReader read = new CSVReader(new FileReader("leaderboards.csv"))) {
                                delAcc = read.readAll();
                                System.out.println("Enter Username/Email (TO DELETE): ");
                                String searchName = br.readLine();
                                
                                Iterator<String[]> iterator = delAcc.iterator();
                                while (iterator.hasNext()) {
                                    String[] leaderSearchdel = iterator.next();
                                    if (leaderSearchdel[0].equals(searchName)) {
                                        iterator.remove(); 
                                        found2 = true;
                                    }
                                }
                                
                                if (!found2) {
                                    System.out.println("Name not found in the leaderboards.");
                                } else {
                                    try (CSVWriter writer = new CSVWriter(new FileWriter("leaderboards.csv"))) {
                                        writer.writeAll(delAcc); 
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (lChoice.equalsIgnoreCase("C")){
                            break;
                        } else {
                            System.out.println("Invalid Choice, Please Try Again.");
                        }
                    }

                } else if(ad_Choice.equals("B")){
                    show_CSV("all_Student_Records.csv");
                } else if(ad_Choice.equals("C")){
                    ad_Running = false;
                } else {
                    System.out.println("Invalid Input");
                }
                
                
            }
        }

        private static void twolingo_main(String oldUser) throws IOException, CsvException{
            CSVReader readerUA = new CSVReader(new FileReader(oldUser + ".csv"));
            List<String[]> rowsUA = readerUA.readAll();
            int indexQues = 0, indexChoices = 0, indexAns = 0, coins = 0, indexLockR = 0, indexLockC = 0, indexTL = 0;
            String home_Choice, cCoin = rowsUA.get(4)[1], id = rowsUA.get(0)[1], sCoin ="";
            if (cCoin.equals("A")) coins = 0;
                else if (cCoin.equals("B")) coins = 5;
                    else if (cCoin.equals("C")) coins = 10;
                        else if (cCoin.equals("D")) coins = 15;
                            else if (cCoin.equals("E")) coins = 20;
                                else if (cCoin.equals("F")) coins = 25;
                                    else if (cCoin.equals("G")) coins = 30;
            boolean running_Home_Page = true;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (running_Home_Page) {
                String proVersion = rowsUA.get(1)[1];
                System.out.println("====================================================");
                System.out.println("\tTWOLINGO Home Page");
                System.out.println("====================================================");
                System.out.println("Please input the number of your choice\n");
                System.out.println("[A] Enter TWOLINGO || [B] TWOLINGO magical shop || [C] Leaderboards || [D] Profile || [E] Exit TWOLINGO");
                home_Choice = br.readLine().toUpperCase();
                
                if(home_Choice.equals("A")){
                    String q_Choice, qt_Choice = "";
                    CSVReader readerTM = new CSVReader(new FileReader("qna.csv"));
                    List<String[]> allRows = readerTM.readAll();
                    while(true){
                        try {
                            System.out.println("====================================================");
                            System.out.println("\tWelcome to TWOLINGO");
                            System.out.println("====================================================");
                            System.out.println("Please input the number of your choice\n");
                            System.out.println("[A] Tagalog || [B] Chinese || [C] Exit TWOLINGO Quiz"); 
                            q_Choice = br.readLine().toUpperCase();
                            String language = " ";
                            if(q_Choice.equals("A")) language = "Tagalog";
                            else if(q_Choice.equals("B")) language = "Chinese";
                            else if(q_Choice.equals("C")) break;
                            else System.out.println("Invalid input");
                            while (true) {
                                int score = 0, attempts = 0, Max_Attepts;
                                String cTMedLock = rowsUA.get(2)[2], cTHardLock = rowsUA.get(2)[3], cCMedLock = rowsUA.get(3)[2], cCHardLock = rowsUA.get(3)[3], congrats = "";
                                if(proVersion.equals("T")) Max_Attepts = 3;
                                else Max_Attepts = 2;
                                System.out.println("====================================================");
                                System.out.println("\tWelcome to TWOLINGO " + language);
                                System.out.println("====================================================");
                                System.out.println("Please input the number of your choice\n");
                                System.out.println("[A] Easy || [B] Medium || [C] Hard || [D] Exit TWOLINGO Quiz");

                                qt_Choice = br.readLine().toUpperCase();
                                    if (q_Choice.equals("A")){
                                        indexLockR = 2;
                                        if (qt_Choice.equals("A")) {
                                            indexQues = 1; indexChoices = 2; indexAns = 3; indexLockC = 5; indexTL = 2; congrats = "You have unlocked Medium mode";
                                        } else if (qt_Choice.equals("B")) {
                                            indexQues = 4; indexChoices = 5; indexAns = 6; indexLockC = 6; indexTL = 3; congrats = "You have unlocked Hard mode";
                                            if (cTMedLock.equals("F")) {
                                                System.out.println("Medium mode is not yet available, please finish Easy mode");
                                                break;
                                            }
                                        } else if (qt_Choice.equals("C")) {
                                            indexQues = 7; indexChoices = 8; indexAns = 9; indexLockC = 7; indexTL = 1; congrats = "You have finished Twolingo Tagalog";
                                            if (cTHardLock.equals("F")) {
                                                System.out.println("Hard mode is not yet available, please finish Medium mode"); 
                                                break;
                                            }
                                        } else if (qt_Choice.equals("D")){
                                                break;
                                        } else {
                                            System.out.println("Invalid input");
                                            break;
                                        }
                                        
                                    } else if (q_Choice.equals("B")){
                                        indexLockR = 3;
                                        if (qt_Choice.equals("A")) {
                                            indexQues = 12; indexChoices = 13; indexAns = 14; indexLockC = 5; indexTL = 2; congrats = "You have unlocked Medium mode";
                                        } else if (qt_Choice.equals("B")) {
                                            indexQues = 15; indexChoices = 16; indexAns = 17; indexLockC = 6; indexTL = 3; congrats = "You have unlocked Hard mode";
                                            if (cCMedLock.equals("F")) {
                                                System.out.println("Medium mode is not yet available, please finish Easy mode"); 
                                                break;
                                            }
                                        } else if (qt_Choice.equals("C")) {
                                            indexQues = 18; indexChoices = 19; indexAns = 20; indexLockC = 7; indexTL = 1; congrats = "You have finished Twolingo Chinese";
                                            if (cCHardLock.equals("F")) {
                                                System.out.println("Hard mode is not yet available, please finish Medium mode"); 
                                                break;
                                            }
                                        } else if (qt_Choice.equals("D")){
                                            break;
                                        } else {
                                            System.out.println("Invalid input");
                                        }
                                    }
                                    System.out.println("====================================================");
                                    System.out.println("Hearts: " + Max_Attepts);
                                    System.out.println("====================================================");
                                    for (int i = 0; i < 4; i++) { 
                                        String row = allRows.get(indexQues)[i];
                                        String row2 = allRows.get(indexChoices)[i];
                                        String row3 = allRows.get(indexAns)[i]; 
            
                                        String eTQues = row;  
                                        String eTChoices = row2; 
                                        String eTAns = row3;
                                        if(q_Choice.equals("B")) System.out.println("GUIDE: [1] 1ST TONE ( - ) , [2] 2ND TONE ( / ), [3] THIRD TONE ( V ), FOURTH TONE ( \\ )");
                                        System.out.println(eTQues);
                                        System.out.println(eTChoices);
                                        String qt_userInput = br.readLine().toUpperCase();
                                        System.out.println();
                                        if(qt_userInput.equals(eTAns)){
                                            score++;
                                        } else {
                                            System.out.println("====================================================");
                                            System.out.println("Incorrect Answer!");
                                            attempts += 1;
                                            System.out.println("You have " + (Max_Attepts - attempts) + " Heart/s left");
                                            System.out.println("====================================================\n");
                                        }
            
                                        if (attempts >= Max_Attepts) {
                                            try{
                                                System.out.println("Take a break for 5 seconds as your Heart/s are recharging");
                                                TimeUnit.SECONDS.sleep(5); 
                                                break;
                                            } catch (InterruptedException e){}
                                        }
                                    }
                                    System.out.println("You got the score of " + score + "/4");
                                if (score <= 2) {
                                    System.out.println("It is recommended that you practice again");
                                } else {
                                    Date date = new Date();
                                    String badge = "";
                                    if (proVersion.equals("F")){
                                        not_Ads();
                                    }

                                    if (q_Choice.equals("A")){
                                        if (qt_Choice.equals("A")) {
                                            badge =  "Wow! nag tatagalog ka pala eh!";
                                        } else if (qt_Choice.equals("B")) {
                                            badge =  "Tagalogist!";
                                        } else if (qt_Choice.equals("C")) {
                                            badge =  "Kababayan!"; rowsUA.get(2)[8] = "T";
                                        }
                                    } else if (q_Choice.equals("B")){
                                        if (qt_Choice.equals("A")) {
                                            badge =  "xiao dre karate kid";
                                        } else if (qt_Choice.equals("B")) {
                                            badge =  "Wow! Are you the translator of Xi Jinping?";
                                        } else if (qt_Choice.equals("C")) {
                                            badge =  "BING CHILLING!"; rowsUA.get(3)[8] = "T";
                                        }
                                    }
                                    // congrats =  (rowsUA.get(indexLockR)[indexLockC].equals("T")) ? rowsUA.get(indexLockR)[indexLockC] = congrats : "You already completed this level"; 
                                    rowsUA.get(indexLockR)[indexTL] = "T";
                                    if (rowsUA.get(indexLockR)[indexLockC].equals("N/A")) {
                                        rowsUA.get(indexLockR)[indexLockC] = badge;
                                      } else {
                                        badge = "You already have this badge";
                                        rowsUA.get(3)[8] = "F";
                                        rowsUA.get(2)[8] = "F";
                                      }
                                    CSVWriter writer = new CSVWriter(new FileWriter(new File(oldUser + ".csv")));
                                    writer.writeAll(rowsUA); 
                                    writer.flush(); 
                                    if(rowsUA.get(2)[7].equals("Kababayan!") && rowsUA.get(2)[8].equals("T")|| rowsUA.get(3)[7].equals("BING CHILLING!") && rowsUA.get(3)[8].equals("T")) leaderBoards(oldUser,id,language,date);

                                    System.out.println("===============================================================");
                                    System.out.println("Congratulations: " + congrats);
                                    System.out.println("Badge : " + badge);
                                    if(coins >= 30){
                                        System.out.println("Maximum coins reached");
                                    } else {
                                        coins += 5; 
                                        System.out.println("You earned 5 coins");
                                    }
                                    System.out.println("===============================================================\n");
                                }
                            }
                        } catch (Exception e) {} 
                    }
                } else if(home_Choice.equals("B")){
                    String ms_Choice;
                    boolean running_Magic_Shop = true;
                    try{
                        while (running_Magic_Shop) {
                            System.out.println("====================================================");
                            System.out.println("\tTWOLINGO magical shop");
                            System.out.println("====================================================");
                            System.out.println("Coins: " + coins);
                            System.out.println("Please input the number of your choice\n");
                            System.out.println("[A] Purchase TWOLINGO Pro Version || [B] Exit magic shop"); 
                            ms_Choice = br.readLine().toUpperCase();
                            if(ms_Choice.equals("A")){
                                if (coins >= 5){
                                    if (proVersion.equals("F")) {
                                        System.out.println("Congratulations you purchased Pro Version TWOLINGO you have now an extra Heart and you are free from ads.");
                                        System.out.println("You have now " + (coins - 5) + " coins");
                                        coins = coins - 5;

                                        rowsUA.get(1)[1] = "T";
                                        CSVWriter writer = new CSVWriter(new FileWriter(new File(oldUser + ".csv")));
                                        writer.writeAll(rowsUA); 
                                        writer.flush();
                                    } else {
                                        System.out.println("You already have Pro Version TWOLINGO");
                                    }
                                } else {
                                    System.out.println("Sorry but you don't have enough coins to purchase this Pro Version TWOLINGO, you need 5 coins");
                                    System.out.println("You have " + (coins) + " coins");
                                }
            
                            } else if (ms_Choice.equals("B")){
                                running_Magic_Shop = false;
                            } else {
                                System.out.println("Invalid Choice, Please Try Again.");
                            }
                        } 
                    } catch (NumberFormatException e) {
                        System.out.print("\nInvalid Input");
                    }
                } else if(home_Choice.equals("C")){
                    while (true) {
                        String[] leaderSearch;
                        System.out.println("====================================================");
                        System.out.println("\tTWOLINGO Leaderboards");
                        System.out.println("====================================================");
                        show_CSV("leaderboards.csv");
                        System.out.println("[A] Search Username/Email || [B] Exit Twolingo Leaderboards");
                        String lChoice = br.readLine();
                        if (lChoice.equalsIgnoreCase("A")) {
                            boolean found = false;
                            try (CSVReader read = new CSVReader(new FileReader("leaderboards.csv"))) {
                                System.out.println("Enter Username/Email");
                                String searchName = br.readLine();
                                while ((leaderSearch = read.readNext()) != null) {
                                    if (leaderSearch[0].equals(searchName)) {
                                        System.out.println(String.join(",", leaderSearch));
                                        found = true;
                                    }
                                }
                                if (!found) System.out.println("Name not found in the leaderboards.");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (lChoice.equalsIgnoreCase("B")){
                            break;
                        } else {
                            System.out.println("Invalid Choice, Please Try Again.");
                        }
                    }
                } else if(home_Choice.equals("D")){
                    System.out.println("====================================================");
                    System.out.println("\tTWOLINGO Profile");
                    System.out.println("====================================================");
                    System.out.println("TWOLINGO account: " + rowsUA.get(0)[0]);
                    System.out.println("ID: " + rowsUA.get(0)[1]);
                    System.out.println("Account Created: " + rowsUA.get(0)[2]);
                    System.out.println("====================================================");
                    System.out.println("Coins: " + coins);
                    System.out.println("====================================================");
                    System.out.println("BADGES\n");
                    System.out.println("TAGALOG:");
                    System.out.println("Easy Level: " + rowsUA.get(2)[5]);
                    System.out.println("Medium Level: " + rowsUA.get(2)[6]);
                    System.out.println("Hard Level: " + rowsUA.get(2)[7] + "\n");
                    System.out.println("CHINESE:");
                    System.out.println("Easy Level: " + rowsUA.get(3)[5] );
                    System.out.println("Medium Level: " + rowsUA.get(3)[6] );
                    System.out.println("Hard Level: " + rowsUA.get(3)[7]);
                } else if(home_Choice.equals("E")){
                    running_Home_Page = false;
                }
            }
            if(coins == 0) sCoin = "A";
                    else if(coins == 5) sCoin = "B";
                        else if(coins == 10) sCoin = "C";
                            else if(coins == 15) sCoin = "D";
                                else if(coins == 20) sCoin = "E";
                                    else if(coins == 25) sCoin = "F";
                                        else if(coins == 30) sCoin = "G";
            rowsUA.get(4)[1] = sCoin;
            CSVWriter writer = new CSVWriter(new FileWriter(new File(oldUser + ".csv")));
            writer.writeAll(rowsUA); 
            writer.flush();
        }  

}

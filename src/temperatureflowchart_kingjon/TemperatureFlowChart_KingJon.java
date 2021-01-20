/*
// Jon King
// Covid Temperature Flow Chart
// 17AUG20
// Description of assignment listed below...
// Create a flow chart similar to FTCC's current Covid-19 preparation and 
// isolation methods. 
// (Working Program - 17AUG20)
// (UPDATED Program - 22AUG20)
// (UPDATED Program - 24AUG20)
// (UPDATED Program - 30AUG20)
// (UPDATED Program - 31AUG20)
// (UPDATED Program - 01SEP20)
// (UPDATED Program - 03SEP20)
// (UPDATED Program - 04SEP20) - Current Working (477 Lines without comments)
*/
package temperatureflowchart_kingjon;
// Import Section
import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.nio.file.*;
import java.text.*;
public class TemperatureFlowChart_KingJon {
    // 
    public static void tryAgain(){
        ImageIcon image = new ImageIcon("pics/TryAgain.png");
        JOptionPane.showMessageDialog(null, image, "Display Image", 
                JOptionPane.PLAIN_MESSAGE);
    }
    public static double inputTemp(){
        double answer = 1.12233445566778899;
        try{
            ImageIcon image = new ImageIcon("pics/Input.png");
            String userInput = JOptionPane.showInputDialog(null,
                    image);
            answer = Double.valueOf(userInput);           
        }
        catch(HeadlessException | NumberFormatException e){
            tryAgain();
        }
        return answer;
    }
    // Tempertaure Check Buttons
    public static double tempChoices(double waitInLine){
        //
        ImageIcon image = new ImageIcon("pics/TitleStart.png");
        // Ensure proper decimal placement for doubles after calculations
        DecimalFormat df = new DecimalFormat("0.0");
        // Starting temperature to be used in For Loops in creating buttons.
        double minTemp = 98.0;
        // Initial User Button Options built into an array
        String[] wholeNumberCheck = {"98.0°F-98.9°F", 
            "99.0°F-99.9°F", "100.0°F-100.9°F", "101.0°F-101.9°F\n", 
            "102.0°F-102.9°F", "103.0°F OR HIGHER", "Input Temp", "ReCheck",
            "Quit"};
        // JOptionPane to display initial temperature buttons for user to press.
        int wholeNumberTemp = JOptionPane.showOptionDialog(null, image, "", 
                JOptionPane.PLAIN_MESSAGE, 0, null, wholeNumberCheck, 
                wholeNumberCheck[8]);
        // If Statement to ensure program will return to end program.
        if (wholeNumberTemp >= 8 || wholeNumberTemp < 0){
            if (waitInLine >= 100.4){
                ImageIcon leftOverInfected = new ImageIcon("pics/DontQuit.png");
                JOptionPane.showMessageDialog(null, leftOverInfected);
                double answer = waitInLine;
                return answer;
            }
            else{
                return 0;
            }
            
        }
        else if (wholeNumberTemp == 7 && waitInLine <= 100.4){
            return 3;
        }
        else if (wholeNumberTemp == 7 && waitInLine >= 100.4){
            double answer = waitInLine;
            return answer;
        }
        else if (wholeNumberTemp == 6) {
            double answer = inputTemp();
            while (answer == 1.12233445566778899){
                System.out.println("CallBack:" + answer);
                answer = inputTemp();
            }
            System.out.println("Return Answer:" + answer);
            return answer;
        }
        // Else statement to create more buttons on a smaller scale. 
        else{
            // Create new String Array with 10 slots
            String decimalArray[] = new String[10];
            // For statement to increase starting temperature by 1 that matches 
            // the first selection of the array's position.  
            for(int i = 0; i != (wholeNumberTemp); i++){
                minTemp = minTemp + 1;
            }
            // For statement to increase starting temperature by 0.1 
            // of variable minTemp after first selection. Then creating a new
            // array in string format for the next buttons available for 
            // user in JOptionPane.
            for (int j = 0; j < 10; j++){
                decimalArray[j] = df.format(minTemp);
                minTemp = minTemp + 0.1;
            }
            // Find graphic to use for selection made by user through button
            // operation of the program. 
            String graphicChoice = String.valueOf(decimalArray[0]);
            String fileLink = GraphicsMod(graphicChoice);            
            ImageIcon graphicChoiceImage = new ImageIcon(fileLink);
            
            // Display JOptionPane with the newly created buttons in the array
            // decimalArray
            int decimalNumTemp = JOptionPane.showOptionDialog(null, 
                    graphicChoiceImage, "New Temperature Check",
                    JOptionPane.DEFAULT_OPTION, 0, null, decimalArray,
                    decimalArray[9]);
            // Return variable 'answer' after changing the String in the 
            // position of the array that the user just selected to a double 
            // type variable.
            double answer = Double.valueOf(decimalArray[decimalNumTemp]);
            return answer;
        }
    }
    public static String GraphicsMod(String graphic){
        switch(graphic){
            case "98.0":
                graphic = "pics/98_0-98_9.png";
                break;
            case "99.0":
                graphic = "pics/99_0-99_9.png";
                break;
            case "100.0":
                graphic = "pics/100_0-100_9.png";
                break;
            case "101.0":
                graphic = "pics/101_0-101_9.png";
                break;
            case "102.0":
                graphic = "pics/102_0-102_9.png";
                break;
            case "103.0":
                graphic = "pics/103_0-103_9.png";
                break;
            case "104.0":
                graphic = "pics/104_0-104_9.png";
                break;
            default:
                break;           
        }
        
        return graphic;
    }
    public static double tempChoicesLast(){
        //
        ImageIcon image = new ImageIcon("pics/TitleFollowUp.png");
        // Ensure proper decimal placement for doubles after calculations
        DecimalFormat df = new DecimalFormat("0.0");
        // Starting temperature to be used in For Loops in creating buttons.
        double minTemp = 98.0;
        // Initial User Button Options built into an array
        String[] wholeNumberCheck = {"98.0°F-98.9°F", 
            "99.0°F-99.9°F", "100.0°F-100.9°F", "101.0°F-101.9°F\n", 
            "102.0°F-102.9°F", "103.0°F OR HIGHER", "Input Temp"};
        // JOptionPane to display initial temperature buttons for user to press.
        int wholeNumberTemp = JOptionPane.showOptionDialog(null, image, "", 
                JOptionPane.PLAIN_MESSAGE, 0, null, wholeNumberCheck, 
                wholeNumberCheck[6]);
        // If Statement to ensure program will return to end program.
        if (wholeNumberTemp == 6){
            double answer = inputTemp();
            while (answer == 1.12233445566778899){
                System.out.println("CallBack:" + answer);
                answer = inputTemp();
            }
            System.out.println("Return Answer:" + answer);
            return answer;
        }
        // Else statement to create more buttons on a smaller scale. 
        else{
            // Create new String Array with 10 slots
            String decimalArray[] = new String[10];
            // For statement to increase starting temperature by 1 that matches 
            // the first selection of the array's position.  
            for(int i = 0; i != (wholeNumberTemp); i++){
                minTemp = minTemp + 1;
            }
            // For statement to increase starting temperature by 0.1 
            // of variable minTemp after first selection. Then creating a new
            // array in string format for the next buttons available for 
            // user in JOptionPane.
            for (int j = 0; j < 10; j++){
                decimalArray[j] = df.format(minTemp);
                minTemp = minTemp + 0.1;
            }
            // Find graphic to use for selection made by user through button
            // operation of the program. 
            String graphicChoice = String.valueOf(decimalArray[0]);
            String fileLink = GraphicsMod(graphicChoice);            
            ImageIcon graphicChoiceImage = new ImageIcon(fileLink);
            
            // Display JOptionPane with the newly created buttons in the array
            // decimalArray
            int decimalNumTemp = JOptionPane.showOptionDialog(null, 
                    graphicChoiceImage, "New Temperature Check",
                    JOptionPane.DEFAULT_OPTION, 0, null, decimalArray,
                    decimalArray[9]);
            // Return variable 'answer' after changing the String in the 
            // position of the array that the user just selected to a double 
            // type variable.
            double answer = Double.valueOf(decimalArray[decimalNumTemp]);
            return answer;
        }
    }
    // Open Webpage Counter
    public static void webCounter(){
        /*
        int waitMilSecs = 1000;
        Timer waitTimer = new Timer();
        waitTimer.scheduleAtFixedRate(new TimerTask());
        long test = System.nanoTime();
        System.out.println(test);
        */
        
        // Try to open and start 5 minute timer on Google Search
        try{
            URI timerSite = new URI("https://www.google.com/"
                    + "search?q=five+"
                    + "minute+timer&rlz=1C1CHBF_enUS858US858&oq=five+"
                    + "minute+timer&aqs=chrome..69i57j0l7.2446j0j4&"
                    + "sourceid=chrome&ie=UTF-8");
            java.awt.Desktop.getDesktop().browse(timerSite);
        }
        catch (IOException | URISyntaxException e){
            e.getLocalizedMessage();
        }
        
        /*
        JOptionPane.showMessageDialog(null, "1) Have the individual "
                + "sit in designated area.\n2) Immediately call "
                + "Public Safety at (910) 678-8433. An officer will "
                + "be dispatched.\n3) Wait 3-5 minutes and retake "
                + "temperature.");
        */
    }
    public static void firstBadCheckWindow(){
        // Display instructions for individual who has a temperature 
        // above 100.4°F
        ImageIcon image = new ImageIcon("pics/HurryWait.png");
        JOptionPane.showMessageDialog(null, image);
    }
    public static double goodCheckModule(double waitInLine, double tempCheck,
            double userArray[]){
        for(int i = 0; i < userArray.length; i++){
            if(userArray[i] == 0){
                userArray[i] = tempCheck;
                break;
            }
        }
        for(int j = 0; j < userArray.length; j++){
            System.out.println(userArray[j]);
        }
        int readyCheck = 0;
        String tempCheckStringSecond = null;
        // Convert passed double to String to be stored in a txt file
        String tempCheckString = Double.toString(tempCheck);
        // Create TXT File to determine the healthy people counted.
        try{
            // Check the time and return the answer.
            String answer = timeCheck();
            // Create file named "Healthy Count.doc"
            File file = new File("Healthy Counts.doc");
            // Write into "Healthy Count.doc" file the word "Healthy" and 
            // the date and time the scan took place. Then start a new line  
            // for any additions required while program is running.
            try (FileWriter goodCountWrite = new FileWriter(file, true)) {
                    goodCountWrite.write("Healthy\t"
                            + tempCheckString + "°F\t" 
                            + tempCheckStringSecond +"°F\t" 
                            + answer +"\n");
            }
        }
        // Error message if the file can not be created on computer.
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e + 
                    "\nThere was an error.");
        }
        // Healthy Results Module
        okayCheckResults(waitInLine, readyCheck, userArray);
        return 0;
    }
    //
    public static double firstBadCheckModule(double waitInLine, 
            double tempCheck, double userArray[]){
        if (waitInLine < 100.4){
            webCounter();
            firstBadCheckWindow();
            int readyCheck = 0;
            waitInLine = tempCheck;
            quesOne(waitInLine, readyCheck, userArray);
        }
        else{
            int readyCheck = 0;
            waitInLine = tempCheck;
            quesOne(waitInLine, readyCheck, userArray);
        }
        return 0;
    }
    
    // Start Temperature Questionnaire
    public static double quesOne(double waitInLine, int readyCheck, 
            double userArray[]){
        double tempCheck;
        double waited = 0;
        if (waitInLine >= 100.4){
            waited = quesTwo(waitInLine, readyCheck);
            if (waited == 1.0){
                tempCheck = waitInLine;
            }
            else{
                tempCheck = tempChoices(waitInLine);
            }
        }
        else{
            // Create variable of tempCheck to be used as the temperature the 
            // user had input in 'tempChoices()' Module.
            tempCheck = tempChoices(waitInLine);
        }
        while ((tempCheck >= 104 && tempCheck != 0 
                || (tempCheck < 98 && tempCheck != 0))){
            if (tempCheck >= 104 && tempCheck != 3){
                ImageIcon image = new ImageIcon("pics/TooHot.png");
                JOptionPane.showMessageDialog(null, image, "Display Image", 
                        JOptionPane.PLAIN_MESSAGE);
                tryAgain();
                tempCheck = tempChoices(waitInLine);
            }
            else if (tempCheck == 3){
                ImageIcon image = new ImageIcon("pics/NoOne.png");
                JOptionPane.showMessageDialog(null, image);
                tempCheck = tempChoices(waitInLine);
            }
            else{
                ImageIcon image = new ImageIcon("pics/TooCold.png");
                JOptionPane.showMessageDialog(null, image, "Display Image", 
                        JOptionPane.PLAIN_MESSAGE);
                tryAgain();
                tempCheck = tempChoices(waitInLine);
            }
        }
        if (tempCheck <= 100.3 && tempCheck >= 98.0 && tempCheck != 0){
            goodCheckModule(waitInLine, tempCheck, userArray);
        }
        else if (tempCheck >= 100.4 && tempCheck <= 103.9 && tempCheck != 0
                && waited == 0){
            firstBadCheckModule(waitInLine, tempCheck, userArray);
        }
        else if (tempCheck >= 100.4 && tempCheck <= 103.9 && tempCheck != 0
                && waited == 1.0){
            String tempCheckStringSecond = null;
            // Create variable of tempCheckFollowUp to be used as the 
            // temperature the user had input in 'tempChoicesLast()' Module.
            double tempCheckFollowUp = tempChoicesLast();
            while ((tempCheckFollowUp >= 104 && tempCheckFollowUp != 0 
                || (tempCheckFollowUp < 98 && tempCheckFollowUp != 0))){
                
                if (tempCheckFollowUp >= 104){
                    ImageIcon image = new ImageIcon("pics/TooHot.png");
                    JOptionPane.showMessageDialog(null, image, "Display Image", 
                            JOptionPane.PLAIN_MESSAGE);
                    tryAgain();
                    tempCheckFollowUp = tempChoicesLast();
                }
                else{
                    ImageIcon image = new ImageIcon("pics/TooCold.png");
                    JOptionPane.showMessageDialog(null, image, "Display Image", 
                            JOptionPane.PLAIN_MESSAGE);
                    tryAgain();
                    tempCheckFollowUp = tempChoicesLast();
                }
            }
            // Convert passed double to String to be stored in a txt file
            String tempCheckString = Double.toString(tempCheck);
            // Convert passed double to String to be stored in a txt file
            tempCheckStringSecond = Double.toString(tempCheckFollowUp);
            // 
            if (tempCheckFollowUp < 100.4 && tempCheckFollowUp >=98 
                    && tempCheckFollowUp != 0){
                try{
                    // Check the time and return the answer.
                    String answer = timeCheck();
                    // Create file named "Healthy Count.doc"
                    File file = new File("Healthy Counts.doc");
                    // Write into "Healthy Count.doc" file the word "Healthy" 
                    // and the date and time the scan took place. Then start 
                    // a new line for any additions required while program 
                    // is running.
                    try (FileWriter goodWrite = new FileWriter(file, true)) {
                        goodWrite.write("Healthy\t"
                                + tempCheckString + "°F\t" 
                                + tempCheckStringSecond +"°F\t" 
                                + answer +"\n");
                    }
                }
                // Error message if the file can not be created on computer.
                catch(IOException e){
                    JOptionPane.showMessageDialog(null, e + 
                            "\nThere was an error.");
                }
                // Healthy Results Module
                waitInLine = 0;
                okayCheckResults(waitInLine, readyCheck, userArray);
            }
            else if (tempCheckFollowUp >= 100.4 && tempCheckFollowUp <= 103.9
                    && tempCheckFollowUp != 0){
                try{
                    quesThree();
                    String facStu = quesFour();
                    // Check the time and return the answer.
                    String answer = timeCheck();
                    // Create file named "Healthy Count.doc"
                    File file = new File("Covid Counts.doc");
                    // Write into "Healthy Count.doc" file the word "Healthy" 
                    // and the date and time the scan took place. Then start 
                    // a new line for any additions required while program is 
                    // running.
                    try (FileWriter goodWrite = new FileWriter(file, true)) {
                        goodWrite.write("Covid\t\t"+ facStu + "\t\t" + 
                                tempCheckString + "°F\t" + 
                                tempCheckStringSecond +"°F\t" + answer +"\n");
                    }
                }
                // Error message if the file can not be created on computer.
                catch(IOException e){
                    JOptionPane.showMessageDialog(null, e + 
                            "\nThere was an error.");
                }
                // Restart questions
                waitInLine = 0;
                quesOne(waitInLine, readyCheck, userArray);
            }   
            // Else statement in case user does something off from the program's 
            // original intent.
            else{
                // End Program
                ending();
            }
        }
        return 0;
    }
    // Follow-up Temperature Check Questionnaire
    public static double quesTwo(double waitInLine, double readyCheck){
        ImageIcon image = new ImageIcon("pics/Waited.png");
        String[] yesNoCheck = {"Yes", "No"};
        // Variable used to continue program to if statements
        int quesTwoVar = JOptionPane.showOptionDialog(null,
                image, "UPCOMING FINAL TEMPERATURE CHECK",
                JOptionPane.DEFAULT_OPTION, 0, null, yesNoCheck,
                yesNoCheck[1]);
        //Else If Statement confirming that the individual has waited 3-5 
        // minutes before being tested again.
        if (quesTwoVar == 0){
            readyCheck = 1;
        }
        else{
            ImageIcon imageElse = new ImageIcon("pics/Prepare.png");
            JOptionPane.showMessageDialog(null, imageElse);
            readyCheck = 0;
        }
        return readyCheck;
    }
        

    // Directions for possible infected.
    public static void quesThree(){
        //
        ImageIcon image = new ImageIcon("pics/quesThree.png");
        JOptionPane.showMessageDialog(null, image, "-Brief Individual-", 
                JOptionPane.PLAIN_MESSAGE);
        /*
        // Display directions for individual if 2 bad tempurature results 
        // within a span of 5 minutes are present.
        JOptionPane.showMessageDialog(null, "1) Tell the person "
                            + "they will need to leave campus for everyone's "
                            + "safety.\n2) Instruct the individual to monitor "
                            + "their temperature and health symptoms.\n"
                            + "3) Give the individual a copy of the COVID-19 "
                            + "Campus Exposure Procedures.\n4) Instruct the "
                            + "individual wait for the Public Safety officer."
                            + "\n5) The officer will collect information and "
                            + "escort individual off campus.\n6) If the "
                            + "individual does not have a ride, the officer "
                            + "will escort them to an isolation room.");
        */
    }
    // 
    public static String quesFour(){
        ImageIcon image = new ImageIcon("pics/StuStaff.png");
        // Create strings for buttons
        String[] individualTitle = {"Student?", "Faculty/Staff?"};
        // Variable used to continue program to if statements
        int quesFourVar = JOptionPane.showOptionDialog(null, 
                image, "Individual's Title", 
                JOptionPane.DEFAULT_OPTION, 0, null, individualTitle, 
                individualTitle[1]);
        // If statement to display students final instructions prior to 
        // leaving campus.
        if (quesFourVar == 0){
            String facStu = "Student";
            ImageIcon imageStu = new ImageIcon("pics/StuReminder.png");
            JOptionPane.showMessageDialog(null, imageStu);
            /*
            JOptionPane.showMessageDialog(null, "1) Remind the student to "
                    + "contact instructors to arrange make-up work.");
            */
            return facStu;
        }
        // Else statement to display faculty or staff's final instructions 
        // prior to leaving campus.
        else{
            String facStu = "Faculty";
            ImageIcon imageFac = new ImageIcon("pics/FacReminder.png");
            JOptionPane.showMessageDialog(null, imageFac);            
            /*
            JOptionPane.showMessageDialog(null, "1) Remind them to contact "
                    + "their immediate supervisor and the COVID Coordinator.");
            */
            return facStu;
        }
        
    }
    // Healthy Results Module
    public static double okayCheckResults(double waitInLine, int readyCheck,
            double userArray[]){
        // Display what the individual must do now that they have been verified
        // to be within the safe temperature scale.
        ImageIcon image = new ImageIcon("pics/Safe.png");
        JOptionPane.showMessageDialog(null, image, "-Individual is Cleared-", 
                JOptionPane.PLAIN_MESSAGE);
        /*
        // Text Based only response.
        JOptionPane.showMessageDialog(null, "1) Provide colored armband to "
                    + "individual.\n2) Instruct individual to wear armband at "
                    + "all times on campus.");
        */
        quesOne(waitInLine, readyCheck, userArray);
        return 0;
    }
    // Create directories on device to store txt files. 
    public static void createDirectories(){
        try{
            // Designate the locations of the folders to be created
            Path heathyDir = Paths.get("DailyTempChecks/HeathyChecks/");
            Path sickDir = Paths.get("DailyTempChecks/SickChecks/");
            // Create the folders
            Files.createDirectories(heathyDir);
            Files.createDirectories(sickDir);
        }
        // Error message if the file can not be created on current device.
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Directories were not created. "
                    + " Please be aware of final counts, and contact admin.");
        }
    }
    public static void createFiles(){
        try{
            // Check the time and return the answer.
            String answer = timeCheck();
            // Create file named "Healthy Count.doc"
            File file = new File("Healthy Counts.doc");
            // Create file named "Healthy Count.doc"
            File file2 = new File("Covid Counts.doc");
            // Write into "Healthy Count.doc" file the word "Healthy" then 
            // start a new line for any additions required while program
            // is running.
            try (FileWriter goodCountWrite = new FileWriter(file, true)) {
                goodCountWrite.write("CREATED FILE - " + answer +"\n\n" 
                        + "Status\tTemp1\t\tTemp2\t\tDate\t\tTime\n");
            }
            try (FileWriter covidCountWrite = new FileWriter(file2, true)) {
                covidCountWrite.write("CREATED FILE - " + answer + "\n\n"
                        + "Status\tTitle\t\tTemp1\t\tTemp2\t\tDate\t\t"
                        + "Time\n");
            }
        }
        // Error message if the file can not be created on computer.
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e + "\nThere was an error.");
        }
    }
    // Move files into new directory and rename with time stamp.
    public static void renameMove(){
        //Try Statement for Renaming files
        try{
            timeStamp();
            // Get the current local time 
            LocalDateTime dateTime = LocalDateTime.now(); 
            // Format the local time to be placed into the txt files.
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                    "ddMMyy-HHmmss");
            // Create variable to use the current local time and date on 
            // each line of the txt file being written into.
            String answer = (dateTime.format(formatter));
            // Find the most recent created files
            Path source = Paths.get("Healthy Counts.doc");
            Path source2 = Paths.get("Covid Counts.doc");
            // Rename file with when they were closed.
            Files.move(source, source.resolveSibling(                    
                    "DailyTempChecks/HeathyChecks/Healthy Counts (CLOSED " 
                            + answer + ").doc"));
            Files.move(source2, source2.resolveSibling(
                    "DailyTempChecks/SickChecks/Covid Counts (CLOSED "
                            + answer +").doc"));
        }
        // Catch statement for any issues. 
        catch (IOException e) {
            System.out.println(e);
        }
    }
    // Time Check Section
    public static String timeCheck(){
        // Get the current local time 
            LocalDateTime dateTime = LocalDateTime.now(); 
            // Format the local time to be placed into the txt files.
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                    "dd-MM-yyyy\tHH:mm:ss");
            // Create variable to use the current local time and date on 
            // each line of the txt file being written into.
            String answer = (dateTime.format(formatter));
            return answer;
    }
    public static void timeStamp(){
        try{
            String answer = timeCheck();
            // Create file named "Healthy Count.doc"
            File file = new File("Healthy Counts.doc");
            // Create file named "Healthy Count.doc"
            File file2 = new File("Covid Counts.doc");
            // Write into "Healthy Count.doc" file the word "Healthy" then 
            // start a new line for any additions required while program
            // is running.
            try (FileWriter goodCountWrite = new FileWriter(file, true)) {
                goodCountWrite.write("\nFILE CLOSED - " + answer + "\n");
            }
            try (FileWriter covidCountWrite = new FileWriter(file2, true)) {
                covidCountWrite.write("\nFILE CLOSED - " + answer + "\n");
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    // Final count calculation before closing of the program.
    public static void finalCountDown(){
        // Initate variable used in the count.
        int goodAnswer = 0;
        int badAnswer = 0;
        // Attempt to open up the file "Healthy Counts.doc".
        try{
            // String variable used to open file "Healthy Counts.doc".
            String file = "Healthy Counts.doc";
            // Use BufferedReader with the variable countRead to read file.
            BufferedReader countRead = new BufferedReader(new FileReader(file));
            // While statement to count each line within the file 
            // "Heathy Counts.doc"
            while (countRead.readLine() != null) goodAnswer++;
            try{
            // Close "Healthy Counts.doc" file.
            countRead.close();
            }
            // Error message if the file can not be closed.
            catch(IOException e){
                System.out.println(e);
            }
        }
        // Error message if the file can not be created on computer.
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "There was no file"
                    + " available to show the count of healthy check-ins.");
        }
        try{
            // String variable used to open file "Covid Counts.doc".
            String file2 = "Covid Counts.doc";
            // Use BufferedReader with the variable readCount to read file.
            BufferedReader readCount = new BufferedReader
                (new FileReader(file2));
            // While statement to count each line within the file 
            // "Covid Counts.doc"
            while (readCount.readLine() != null) badAnswer++;
            // Close "Covid Counts.doc" file.
            try{
            readCount.close();
            }
            // Error message if the file can not be closed.
            catch(IOException e){
                System.out.println(e);
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "There was no file"
                    + " available to show the count of possible Covid-19 "
                    + "infections.");
        }
        if (goodAnswer - 3 == 1 && badAnswer - 3 == 1){
            // Display how many people were checked in as healthy & sick.
            JOptionPane.showMessageDialog(null, "There was " + (goodAnswer-3) 
                    + " healthy person today.\n" + "There was " + (badAnswer-3)
                    + " sick person today.");
        }
        else if (goodAnswer - 3 > 1 && badAnswer - 3 == 1){
            // Display how many people were checked in as healthy & sick.
            JOptionPane.showMessageDialog(null, "There were " + (goodAnswer-3) 
                    + " healthy people today.\n" + "There was " + (badAnswer-3)
                    + " sick person today.");
        }
        else if (goodAnswer - 3 == 1 && badAnswer - 3 > 1){
            // Display how many people were checked in as healthy & sick.
            JOptionPane.showMessageDialog(null, "There was " + (goodAnswer-3) 
                    + " healthy person today.\n" + "There was " + (badAnswer-3)
                    + " sick person today.");
        }
        else{
            // Display how many people were checked in as healthy & sick.
            JOptionPane.showMessageDialog(null, "There were " + (goodAnswer-3) 
                    + " healthy people today.\n" + "There were " + (badAnswer-3)
                    + " sick people today.");
        }
    }
    // Module used to end the program.
    public static void ending(){
        ImageIcon image = new ImageIcon("pics/Ending.png");
        // Create a place to save current count info.
        createDirectories();
        // Display final count of all individuals scanned.
        finalCountDown();
        // rename and move txt files into newly created directories
        renameMove();
        // Display final message and close program.
        JOptionPane.showMessageDialog(null, image);
    }
    // Program Start
    public static void main(String[] args) {
        double userArray[] = new double[500];
        // Create text files with title bars and time/date stamp.
        createFiles();
        // Variable initiated to ensure a place to store a high temperature 
        // while waiting the 3-5 minute and giving the program the ability to 
        // continue to run without interruption to more people arriving.
        double waitInLine = 0;
        // Variable to allow the variable to not be written over for high temp.
        // (If more that two people show up with symptoms within 5 minutes of 
        // each other, close program down and force stopping to close down the 
        // area for immediate quarantine.)
        int readyCheck = 0;
        // Call First Question Module with double variable and int variable.
        quesOne(waitInLine, readyCheck, userArray);
        // End program
        ending();
    }
}
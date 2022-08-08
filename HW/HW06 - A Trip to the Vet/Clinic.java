import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Clinic {
    // variables
    private File patientFile = null;
    private int day;

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    public Clinic(File file) {
        patientFile = file;
        this.day = 1;
    }

    // methods
    public String nextDay(String fileName) throws FileNotFoundException {
        return nextDay(new File(fileName));
    }

    public String nextDay(File f) throws FileNotFoundException {
        day++;
        Scanner fileScan = new Scanner(f);
        // Scanner infoScan = null;
        Scanner userInput = new Scanner(System.in);
        String[] tokens = null;
        // int index = 0;
        // String[] allNames = null;
        // String[] allTypeOfPets = null;
        // double[] allSpecAttr = null;
        // int[] allTimes = null;

        String line = null;
        String curName;
        String curType;
        // String curAttr;
        String curTime;
        String curTimeEnd;
        double curDroolRate;
        int curMiceCaught;
        String return_text = "";
        String total = "";

        while (fileScan.hasNextLine()) {
            // initiate scanners
            line = fileScan.nextLine();
            tokens = line.split(",");

            curName = tokens[0];
            curType = tokens[1];
            // curAttr = tokens[2];
            curTime = tokens[3];

            /*
             * infoScan = new Scanner(line);
             * infoScan.useDelimiter(",");
             * //parse values
             * allNames[index] = infoScan.next();
             * allTypeOfPets[index] = infoScan.next();
             * allSpecAttr[index] = infoScan.nextDouble();
             * allTimes[index] = infoScan.nextInt();
             */

            // validation pet type in file
            if (!curType.equals("Dog") && !curType.equals("Cat")) {
                throw new InvalidPetException();
            }

            /*
             * //validation pet type in file
             * if (!allTypeOfPets[index].equals("Dog") &&
             * !allTypeOfPets[index].equals("Cat")) {
             * throw new InvalidPetException();
             * }
             */

            double curHealth = 0.0;
            int curPainLevel = 0;
            boolean success1 = false;
            boolean success2 = false;
            System.out.print("Consultation for " + curName + " the " + curType + " at " + curTime
                    + ".\nWhat is the health of " + curName + "?\n");
            while (!success1) {
                if (userInput.hasNextDouble()) {
                    // System.out.print("What is the health of " + curName + "?\n");
                    curHealth = userInput.nextDouble();
                    success1 = true;
                } else {
                    userInput.nextLine();
                    System.out.println("Sorry, please input a number: ");
                }
            }

            System.out.print("On a scale of 1 to 10, how much pain is " + curName + " in right now?\n");
            while (!success2) {
                if (userInput.hasNextInt()) {
                    curPainLevel = userInput.nextInt();
                    success2 = true;
                } else {
                    userInput.nextLine();
                    System.out.println("Sorry, please input a number: ");
                }
            }

            // Treat pet based on pet type
            Pet patient;
            if (curType.equals("Dog")) {
                curDroolRate = Double.parseDouble(tokens[2]);
                patient = new Dog(curName, curHealth, curPainLevel, curDroolRate);
                // dog.speak();
                // int time_took = dog.treat();
                // curTimeEnd = addTime(curTime, time_took);
                // return_text = String.format("%s,%s,%.1f,Day %d,%s,%s,%.1f,%d\n", curName,
                // curType, curDroolRate, day,
                // curTime, curTimeEnd, curHealth, curPainLevel);
                // total += return_text;
            } else {
                curMiceCaught = Integer.parseInt(tokens[2]);
                patient = new Cat(curName, curHealth, curPainLevel, curMiceCaught);
                // cat.speak();
                // // calculate time took to treat()
                // int time_took = cat.treat();
                // curTimeEnd = addTime(curTime, time_took);
                // return_text = String.format("%s,%s,%d,Day %d,%s,%s,%.1f,%d\n", curName,
                // curType, curMiceCaught, day,
                // curTime, curTimeEnd, curHealth, curPainLevel);
                // total += return_text;
            }
            patient.speak();
            int time_took = patient.treat();
            curTimeEnd = addTime(curTime, time_took);
            return_text = String.format("%s,%s,%s,Day %d,%s,%s,%.1f,%d\n", curName, curType, tokens[2], day,
                    curTime, curTimeEnd, curHealth, curPainLevel);
            total += return_text;
            // each iteration ++
        }

        // end of while loop

        // close file.
        if (fileScan != null) {
            fileScan.close();
        }
        if (userInput != null) {
            userInput.close();
        }
        // System.out.print(total);
        return total;
    }

    public boolean addToFile(String patientInfo) {
        Scanner fileScan = null;
        PrintWriter fileWrite = null;
        String output = "";
        String[] tokens = patientInfo.split(",");
        try {
            fileScan = new Scanner(patientFile);

            // find if patient is first-time
            boolean isNewCustomer = true;
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                if (line.startsWith(tokens[0])) {
                    isNewCustomer = false;
                    line += (String.format(",%s,%s,%s,%s,%s", tokens[3], tokens[4], tokens[5], tokens[6],
                            tokens[7]));
                }
                output += (line + "\n");
                // System.out.print("addToFIle path1: " + output);
            }
            if (isNewCustomer) {
                output += patientInfo;
                // System.out.print("addToFIle path2: " + output);
            }
            // can't read & write at same time.
            fileScan.close();
            fileWrite = new PrintWriter(patientFile);
            fileWrite.print(output);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (fileScan != null) {
                fileScan.close();
            }
            if (fileWrite != null) {
                fileWrite.close();
            }
        }
    }

    protected String addTime(String timeIn, int treatmentTime) {
        int hour = Integer.parseInt(timeIn.substring(0, 2));
        int minute = Integer.parseInt(timeIn.substring(2));
        // for (int i = 0; i < treatmentTime; i++) {
        //     if (minute < 60) {
        //         minute++;
        //     } else {
        //         hour++;
        //         minute = 0;
        //     }
        // }
        hour = hour + (int)((minute + treatmentTime)/60);
        minute = (minute + treatmentTime) % 60;

        if (hour < 10 && minute < 10) {
            return String.format("0%d0%d", hour, minute);
        } else if (hour < 10) {
            return String.format("0%d%d", hour, minute);
        } else if (minute < 10) {
            return String.format("%d0%d", hour, minute);
        } else {
            return String.format("%d%d", hour, minute);
        }
    }
}
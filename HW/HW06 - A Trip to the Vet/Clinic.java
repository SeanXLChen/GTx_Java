import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Clinic {
    //variables
    private File patientFile = null;
    private int day;

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    public Clinic(File file) {
        patientFile = file;
        this.day = 1;
    }

    //methods
    public String nextDay(File f) throws FileNotFoundException {
        Scanner fileScan = null;
        int index = 0;
        String[] allNames = null;
        String[] allTypeOfPets = null;
        double[] allSpecAttr = null;
        int[] allTimes = null;

        fileScan = new Scanner(f);
        String line = null;
        while (fileScan.hasNextLine()) {
            line = fileScan.nextLine();
            tokens = line.split(",");
            
        }
        System.out.print("Consultation for [name] the [typeOfPet] at [time].\nWhat is the health of [name]?\n")

    }

    public String nextDay(String fileName) throws FileNotFoundException {

    }

Pillow,Cat,5,1839
Atlas,Cat,2,1742
Cocoa,Dog,1.4,1630
Starbs,Cat,10,1240
Tucker,Dog,7.9,0918
}

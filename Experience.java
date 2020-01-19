
import java.util.*;

public class Experience extends Person {// Class that inherits from the person class
    short numMacros;// Declaring all the variables that are exclusive to the experience class and
    // not the person class
    short numMicro;
    short numProtein;
    byte workoutLength;
    short howLongWrk;

    public Experience() {// Default constructor
        super();// calling the default constructor with all the variables from the person class
        this.numMacros = 0;
        this.numMicro = 0;
        this.numProtein = 0;
        this.workoutLength = 0;
        this.howLongWrk = 0;

    }

    public Experience(String n, String m, int d, short y, int yrs, short w, short h, String[] hp, boolean e, short wrk,
                      int gain, int lost, int cal, short ma, short mi, short pro, byte wrkl, short howlng) {
        // Constructor that takes variables from the person class and some new variables
        // to set equal to the unique variables in this class
        super(n, m, d, y, yrs, w, h, hp, e, wrk, gain, lost, cal);// calling the constructor with all the variables from
        // the person class
        this.numMacros = ma;
        this.numMicro = mi;
        this.numProtein = pro;
        this.workoutLength = wrkl;
        this.howLongWrk = howlng;

    }

    public String toString() {// Tostring method
        return super.toString() + "\nAmount of Macronutrients consumed per day: " + this.numMacros + "g"
                + " \nAmount of Micronutrients consumed per day: " + this.numMicro + "g"
                + "\nAmount of protein consumed per day: " + this.numProtein + "g"
                + "\nYour average daily workout is around " + this.workoutLength + "hours"
                + "\nYou have been working out for around " + this.howLongWrk + " months.";
        // Tostring that adds on to the Tostring from the person class
    }
}

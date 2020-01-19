
import javax.swing.*;
import java.util.ArrayList;

public class Person {

    static int monthLen[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    String name;
    String birthMonth;
    int birthDate;
    short birthYear;
    int yearsOld;
    short weight;
    short height;
    String[] healthProblem;
    boolean experience;
    ArrayList<String> sleepTimeHistory; // sleeping affects sleepTime
    short workOutTime; // working out affects workOutTime
    int caloriesGained;
    int caloriesLost;
    int totalCalories; // working out and eating both affect calories

    public Person() {
        this.name = "TBD";
        this.birthMonth = "";
        this.birthDate = 1;
        this.birthYear = 0000;
        this.weight = 0;
        this.height = 0;
        this.healthProblem = null;
        this.experience = false;
        this.sleepTimeHistory = new ArrayList<String>();
        this.workOutTime = 0;
        this.caloriesGained = 0;
        this.caloriesLost = 0;
        this.totalCalories = 0;
    }
    
    public Person(String n, String m, int d, short y, int yrs, short w, short h, String[] hp, boolean e, short wrk,
                  int gain, int lost, int cal) {
        this.name = n;
        this.birthMonth = m;
        this.birthDate = d;
        this.birthYear = y;
        this.yearsOld = yrs;
        this.weight = w;
        this.height = h;
        this.healthProblem = hp;
        this.experience = e;
        sleepTimeHistory = new ArrayList<String>();
        this.workOutTime = wrk;
        this.caloriesGained = gain;
        this.caloriesLost = lost;
        this.totalCalories = cal;
    }

    public static int numInMonths(String numiMonths) {// Method signature that takes a month and converts it to a
        // number from 1-12
        // String[] months={"January",
        // "February","March","April","May","June","July","August","September","October","November","December"};
        int numMonths = 0; // If statement that ties the given month with its respective number
        if (numiMonths.equals("January")) {
            numMonths = 1;
        } else if (numiMonths.equals("February")) {
            numMonths = 2;
        } else if (numiMonths.equals("March")) {
            numMonths = 3;
        } else if (numiMonths.equals("April")) {
            numMonths = 4;
        } else if (numiMonths.equals("May")) {
            numMonths = 5;
        } else if (numiMonths.equals("June")) {
            numMonths = 6;
        } else if (numiMonths.equals("July")) {
            numMonths = 7;
        } else if (numiMonths.equals("August")) {
            numMonths = 8;
        } else if (numiMonths.equals("September")) {
            numMonths = 9;
        } else if (numiMonths.equals("October")) {
            numMonths = 10;
        } else if (numiMonths.equals("November")) {
            numMonths = 11;
        } else if (numiMonths.equals("December")) {
            numMonths = 12;
        }

        return numMonths;// After finding the number it will return an integer value
    }

    public static int ageCalculator(int year, int month, int day)
    {

        int daysFrom = 0;

        for (int i = 0; i < month - 1; i++) {
            daysFrom += monthLen[i];
        }

        daysFrom += day;

        long todayYear = (System.currentTimeMillis() / 60000 / 1440 / 365);
        int yearsOld = (int) todayYear - (year - 1970);
        long daysAfter = ((System.currentTimeMillis() / 60000L / 1440L) - todayYear * 365 - todayYear / 4);

        if (daysAfter < daysFrom) {
            yearsOld -= 1;
        }

        return (yearsOld);
    }

    public static Person start() {
        String name = JOptionPane.showInputDialog("What's your name?");// Asking for general info like
        // name,birthate,etc...
        String aMonth = JOptionPane.showInputDialog("What month were you born in?");
        int month = numInMonths(aMonth);
        String aDays = JOptionPane.showInputDialog("What day were you born on?");
        int day = Integer.parseInt(aDays);

        String aYear;

        do {
            aYear = JOptionPane.showInputDialog("What year were you born in (full year, i.e 2005)?");
        } while(isNumeric(aYear) == false);
        short year = Short.parseShort(aYear);

        String aWeight;
        do {
            aWeight = JOptionPane.showInputDialog("What is your weight (in lbs)?");
        } while(isNumeric(aWeight) == false);
        short weight = Short.parseShort(aWeight);

        String aHeight;
        do {
            aHeight = JOptionPane.showInputDialog("How tall are you (in cm)?");
        } while(isNumeric(aHeight) == false);
        short height = Short.parseShort(aHeight);

        String aWorkoutTime;
        do {
            aWorkoutTime = JOptionPane.showInputDialog("How many hours do you spend working out a week?");
        } while(isNumeric(aWorkoutTime) == false);
        short workoutTime = Short.parseShort(aWorkoutTime);

        String aCalories;
        do {
            aCalories = JOptionPane.showInputDialog("How many calories do you usually consume ?");
        } while(isNumeric(aCalories) == false);
        int calories = Integer.parseInt(aCalories);

        if (JOptionPane.showConfirmDialog(null, "Do you have any experience with fitness apps?") == 0) {
            /*Asking whether or not they have experience with fitness apps. If they say yes,
            The code will ask the user more detailed questions like how many macronutrients
            they consume a day, How long their average workout lasts because this is info that
            that is generally asked in most fitness apps*/
            String aNumMacros;
            do {
                aNumMacros = JOptionPane
                        .showInputDialog("How many Macronutrients do you consume per day?(in grams)");
            } while (isNumeric(aNumMacros) == false);
            short numMacros = Short.parseShort(aNumMacros);

            String aNumMicros;

            do {
                aNumMicros = JOptionPane
                        .showInputDialog("How many Micronutrients do you consume per day?(in grams)");
            } while (isNumeric(aNumMicros) == false);
            short micros = Short.parseShort(aNumMicros);

            String aProtein;

            do {
                aProtein = JOptionPane.showInputDialog("How many grams of protein do you consume per day?");
            } while (isNumeric(aProtein) == false);
            short protein = Short.parseShort(aProtein);

            String aWorkoutLength;
            do {
                aWorkoutLength = JOptionPane.showInputDialog("How long are your workouts (round to nearest hour)?");
            } while (isNumeric(aWorkoutLength));
            short workoutLength = Short.parseShort(aWorkoutLength);

            String aHowLongWork;
            do {
                aHowLongWork = JOptionPane
                        .showInputDialog("How many months have you been working out for(round to nearest whole number)?");
            } while (isNumeric(aHowLongWork) == false);
            short howLngWork = Short.parseShort(aHowLongWork);

            boolean aExperience = true;
            // Making a new "experience" that takes all the data I recieved from the
            // user and outputting it into a specific tostring
            Experience test = new Experience(name, aMonth, day, year, Person.ageCalculator(year, month, day), weight,
                    height, null, aExperience, workoutTime, 0, 0, calories, numMacros, micros, protein,
                    (byte) workoutLength, howLngWork);
            System.out.println(test);
            return test;
        } else {
            // If they dont have experience it will cut right to the output without
            // asking any more questions
            boolean aExperience = false;
            Person test = new Person(name, aMonth, day, year, Person.ageCalculator(year, month, day), weight, height,
                    null, aExperience, workoutTime, 0, 0, calories);
            System.out.println(test);
            return test;
        }
    }

    public String toString() {

        return "Hello " + this.name + "\nYour birthday is " + this.birthMonth + " " + this.birthDate + " "
                + this.birthYear + "\nYou are " + this.yearsOld + " years old " + "\nYour height is " + this.height
                + "cm " + "\nYour weight " + this.weight + "lbs" + "\nYour mentioned health problem(s): "
                + this.healthProblem + "\nExperience? " + this.experience + "\nYour sleep time is: "
                + this.sleepTimeHistory + "\nYour workout time is " + this.workOutTime + " hours a week"
                + "\nYour calorie intake is " + this.totalCalories + " calories per day.";
    }

    public static boolean isNumeric(String str) {
        try {
            short s = Short.parseShort(str);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter a numeric value");
            return false;
        }
    }

}
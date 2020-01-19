
import javax.swing.*; //allows use of JOptionPanes

public class ExerciseStacks {

    LinkList list;// takes a link list
    long totalTime = 0;// initialize workout time
    public int caloriesLost = 0; // initialize calories lost in a workout session

    public ExerciseStacks(LinkList l) {
        this.list = l;
    }// constructor for the object

    public void push(LinkList l, Object c) {
        l.add(c);
    }//stack push method

    public Object pop(LinkList l) {//stack pop method
        Object o = l.findNode(0);
        l.remove();
        return o;//returns removed node
    }

    public Object peek(LinkList l) {// stack peek method
        Object c = l.findNode(0);
        return c;//returns next to be removed node
    }

    public void start() {//workout start
        Node head = new Node(null, null);//empty link list
        LinkList link = new LinkList(head, 1);//empty link list setup
        ExerciseStacks list = new ExerciseStacks(link); //pass empty link list into stack constructor

        String eList = "";//list of exercises
        Object[] sOptions = { "Cancel", "Start" };//buttons for GUI
        Object[] eOptions = { "Back" };//buttons for GUI
        Object[] done = { "Done" };//buttons for GUI

        String[] exercises= {"Walkdown push ups (3 sets of 10 reps)","Push-ups (3 sets of 10 reps)","Sit-ups (3 sets of 10 reps)","Plank (3 sets of 30 seconds)",
                "Pull-ups (3 sets of 10 or until failure)","Weighted squats (3 sets of 10 reps)",
                "Flutter kicks (3 sets of 20, 10 on each leg)","Leg raises (3 sets of 15)","Treadmill jog (5 min before every workout)",
                "Mountain climbers (3 sets of 25)","Calf raises(5 sets of 15 reps)","Squats (3 sets of 10 reps)"};
                //array of exercises, can be expanded or added too in future


        int start = JOptionPane.showOptionDialog(null,"Start custom workout?:\n" + eList,"Exercise Menu",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, sOptions, sOptions[1]); //prompts user to begin custom workout

        if (start==1) { //if user clicks start
            int numExercise = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter amount of workouts:\n(Estimated 5 minute completion for each)" ));
            //asks user for number of workouts they would like to complete

            long startTime = System.currentTimeMillis();//start timer

            for (int i = 0;i<numExercise;i++){//loop generates user wanted amount of exercises
                list.push(link,exercises[(int)(Math.random()*11)]);//adds random workouts to the stack
                eList+="  " +list.peek(link)+"\n";//adds workout for user display
            }

            for (int i = 0; i < numExercise; ) {//loops through each exercise
                int workout = JOptionPane.showOptionDialog(null, list.peek(link), "Exercise Menu",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, done, done[0]); //clicked when user completes an exercise
                if (workout == 0) {
                    list.pop(link);//removes that workout from the stack
                    i++; //increments the workout counter
                }
            }

            totalTime = System.currentTimeMillis() - startTime;//calculate time difference
            caloriesLost = (int)totalTime/10000; //calculates calories lost based of time
        }

        Activity a = new Activity();// used to format time

        int end = JOptionPane.showOptionDialog(null,
                "Good work!\nYou completed your exercise in: " + a.formatTime(totalTime) + "\nYou have burnt "
                        + this.caloriesLost + " calories.", "Exercise Menu",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, eOptions, sOptions[1]); //final summary msg of the workout

    }
}


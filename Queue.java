
import javax.swing.*;

public class Queue {
    LinkListQueue list;

    //default constructor
    public Queue() {
        list = null;
    }

    //initializing linklist
    public Queue(LinkListQueue l) {
        this.list = l;
    }

    //adding node to head of queue
    public void enQueue(Node n) {
        this.list.add(n);

    }

    //removing node from end of queue
    public Object deQueue() {
        Object c = list.findNode(this.list.length).cargo;
        list.remove();
        return c;
    }

    public static void makeRecipe() {
        //initializing nodes with Avocado Toast ingredients
        Node aIn1 = new Node("Bread", null);
        Node aIn2 = new Node("1 Ripe Avacado ", null);
        Node aIn3 = new Node("Salt and/or chilli flakes", null);

        // initializing nodes with Avacado Toast instructions
        Node avacado1 = new Node("Avacado Toast Breakfast", null);
        Node avacado2 = new Node("Toast bread", null);
        Node avacado3 = new Node("Spread avacado on toast", null);
        Node avacado4 = new Node("Add pepper and salt", null);
        Node avacado5 = new Node(" BON APPETIT!", null);

        //initializing nodes with Pasta Lunch ingredients
        Node pIn1 = new Node("Whole Wheat Pasta", null);
        Node pIn2 = new Node("Water ", null);
        Node pIn3 = new Node("Preferred Pasta Sauce", null);
        Node pIn4 = new Node("Preferred Vegetables", null);

        // initializing nodes with Pasta Lunch instructions
        Node pasta1 = new Node("Pasta Lunch", null);
        Node pasta2 = new Node("Boil water on stove", null);
        Node pasta3 = new Node("Put pasta in boiling water carefully", null);
        Node pasta4 = new Node("Wait until softened", null);
        Node pasta5 = new Node("Strain pasta", null);
        Node pasta6 = new Node("Add preferred vegetables and sauce", null);
        Node pasta7 = new Node(" BON APPETIT!", null);

        //initializing nodes with Salmon Dinner ingredients
        Node sIn1 = new Node("Salmon", null);
        Node sIn2 = new Node("Olive Oil", null);
        Node sIn3 = new Node("Preferred Salmon Seasoning", null);
        Node sIn4 = new Node("Preferred Sauce", null);

        // initializing nodes with Salmon Dinner instructions
        Node salmon1 = new Node("Salmon Dinner", null);
        Node salmon2 = new Node("Season fish", null);
        Node salmon3 = new Node("Add olive oil to pan and cook salmon", null);
        Node salmon4 = new Node("Add sauce", null);
        Node salmon5 = new Node(" BON APPETIT!", null);

        //creating linklist with ingredients for every meal
        LinkListQueue bIn = new LinkListQueue(aIn1);
        LinkListQueue lIn = new LinkListQueue(pIn1);
        LinkListQueue dIn = new LinkListQueue(sIn1);

        //creating linklist with first step
        LinkListQueue breakfast = new LinkListQueue(avacado1);
        LinkListQueue lunch = new LinkListQueue(pasta1);
        LinkListQueue dinner = new LinkListQueue(salmon1);

        //creating queue with created linklist
        Queue test1 = new Queue(breakfast);
        Queue test2 = new Queue(lunch);
        Queue test3 = new Queue(dinner);
        Queue test4 = new Queue(bIn);
        Queue test5 = new Queue(lIn);
        Queue test6 = new Queue(dIn);

        //enqueuing (adding) each ingredient for avacado toast recipe
        test4.enQueue(aIn1);
        test4.enQueue(aIn2);
        test4.enQueue(aIn3);

        //enqueuing (adding) each step for avacado toast recipe
        test1.enQueue(avacado1);
        test1.enQueue(avacado2);
        test1.enQueue(avacado3);
        test1.enQueue(avacado4);
        test1.enQueue(avacado5);

        //enqueuing (adding) each ingredient for pasta recipe
        test5.enQueue(pIn1);
        test5.enQueue(pIn2);
        test5.enQueue(pIn3);
        test5.enQueue(pIn4);

        //enqueuing (adding) each step for pasta recipe
        test2.enQueue(pasta1);
        test2.enQueue(pasta2);
        test2.enQueue(pasta3);
        test2.enQueue(pasta4);
        test2.enQueue(pasta5);
        test2.enQueue(pasta6);
        test2.enQueue(pasta7);

        //enqueuing (adding) each ingredient for salmon recipe
        test6.enQueue(sIn1);
        test6.enQueue(sIn2);
        test6.enQueue(sIn3);
        test6.enQueue(sIn4);

        //enqueuing (adding) each step for salmon recipe
        test3.enQueue(salmon1);
        test3.enQueue(salmon2);
        test3.enQueue(salmon3);
        test3.enQueue(salmon4);
        test3.enQueue(salmon5);

        //JOptionPane info
        String instructions = "";

        String[] options = {"Next"};

        String[] mOption = {"Back", "Breakfast", "Lunch", "Dinner"};


        int meal = JOptionPane.showOptionDialog(null, "What meal would you like to make?", "Cooking Menu",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, mOption, mOption[0]);
        if (meal == 1) {

            //looping through queue backwards to show each INGREDIENT for BREAKFAST
            for (int i = bIn.length; i > 0; i--) {
                instructions = (String) test4.list.findNode(i).cargo;
                JOptionPane.showOptionDialog(null, instructions, "Avacado Toast Ingredients", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            }

            //looping through queue backwards to show each step for BREAKFAST
            for (int i = breakfast.length; i > 0; i--) {
                instructions = (String) test1.list.findNode(i).cargo;
                JOptionPane.showOptionDialog(null, instructions, "Avacado Toast Recipe", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            }

        } else if (meal == 2) {

            //looping through queue backwards to show each INGREDIENT for LUNCH
            for (int i = lIn.length; i > 0; i--) {
                instructions = (String) test5.list.findNode(i).cargo;
                JOptionPane.showOptionDialog(null, instructions, "Pasta Lunch Ingredients", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            }

            //looping through queue backwards to show each step for LUNCH
            for (int i = lunch.length; i > 0; i--) {
                instructions = (String) test2.list.findNode(i).cargo;
                JOptionPane.showOptionDialog(null, instructions, "Pasta Recipe", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            }
        } else if (meal == 3) {
            //looping through queue backwards to show each INGREDIENT for DINNER
            for (int i = dIn.length; i > 0; i--) {
                instructions = (String) test6.list.findNode(i).cargo;
                JOptionPane.showOptionDialog(null, instructions, "Salmon Dinner Ingredients", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            }

            //looping through queue backwards to show each step for DINNER
            for (int i = dinner.length; i > 0; i--) {
                instructions = (String) test3.list.findNode(i).cargo;
                JOptionPane.showOptionDialog(null, instructions, "Salmon Dinner Recipe", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            }
        }
    }

}

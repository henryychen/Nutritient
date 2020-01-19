
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Activity {
	// Creating a new person
	static Person user = new Person();

	public static void introduction() {
		JPanel panel = new JPanel();

		String[] getStarted = new String[] { "Get Started" };
		int result = JOptionPane.showOptionDialog(panel, "Welcome to Nutritient!", "Setup complete",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, getStarted, getStarted[0]);

		String[] firstTime = new String[] { "Yes- Setup", "No- Continue as Guest" };

		int choice = JOptionPane.showOptionDialog(panel, "Would you like to setup now?", "Welcome",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, firstTime, firstTime[0]);

		if (choice == JOptionPane.YES_OPTION) {
			user = Person.start();
		}
		if (result == JOptionPane.YES_OPTION) {
			chooseActivity();
		}
	}

	// Home screen with all the activity options
	public static void chooseActivity() {
		// Array containing the possible actions the user can do
		String[] options = { "Start Sleep", "Start Meal", "Start Workout", "Exit" };

		// The user chooses what action they would like to do
		JPanel panel = new JPanel();
		int result = JOptionPane.showOptionDialog(panel, "Choose an activity:", "Main Menu",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		// Based on what action the user chose, the corresponding method is called
		// User starts their sleep
		if (result == JOptionPane.YES_OPTION) {
			startSleep();
		}

		// User starts their meal
		else if (result == JOptionPane.NO_OPTION) {
			startMeal();
		}

		// User starts their work out
		else if (result == JOptionPane.CANCEL_OPTION) {
			startWorkout();
		}

		// If the user clicks 'x' instead of choosing an activity, the program prints
		// out a summary of the user's activity and exits
		else {
			printSummary();
			System.exit(0);
		}

		// Once an activity is completely, the user is taken back to the main menu
		chooseActivity();
	}

	public static void startSleep() {
		// Immediately starts a timer
		long startTime = System.currentTimeMillis();

		// Once the user wakes up, they can click the finish sleep button to stop the
		// timer and see their total sleep time
		String[] option = { "Finish Sleep" };
		JPanel panel = new JPanel();
		int result = JOptionPane.showOptionDialog(panel, "Sleep in progress (ZZZZZ)", "Sleep",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, null);

		// Subtracts the current time from the time when they started sleeping and
		// outputs it
		if (result == 0) {
			long totalTime = System.currentTimeMillis() - startTime;
			String formattedTime = formatTime(totalTime);
			System.out.println("Your total sleep time is: " + formattedTime);

			// Adds their sleep time to their sleep history so they can track their progress
			user.sleepTimeHistory.add(formattedTime);
		}

		// If the user does not click "finish sleep" and exits, nothing happens and they
		// are taken back to the main menu
	}

	// Helper method to convert time into the format hh:mm:ss
	public static String formatTime(long t) {
		long seconds = t / 1000;
		long minutes = 0;
		long hours = 0;
		String formattedTime;

		// If there are more than 60 seconds, then add a minute
		if (seconds >= 60) {
			minutes = seconds / 60;
			seconds = seconds % 60;
		}
		// If there are more than 60 minutes, then add an hour
		if (minutes >= 60) {
			hours = minutes / 60;
			minutes = minutes % 60;
		}
		// Changing the seconds, minutes and hours into strings
		String formatSeconds = seconds + "";
		String formatMinutes = minutes + "";
		String formatHours = hours + "";

		// If the seconds, minutes and hours only have 1 digit, manually add a 0 (proper
		// format requires 2 digits)
		if (seconds < 10) {
			formatSeconds = "0" + seconds;
		}

		if (minutes < 10) {
			formatMinutes = "0" + minutes;
		}

		if (hours < 10) {
			formatHours = "0" + hours;
		}

		// Combine the seconds, minutes and hours together
		formattedTime = (formatHours + ":" + formatMinutes + ":" + formatSeconds);
		return formattedTime;
	}

	public static void startMeal() {
		// An array that contains the 3 meal options
		String[] chooseMeal = new String[] { "Breakfast", "Lunch", "Dinner", "Make Your Own" };
		JPanel panel = new JPanel();

		// Asks the user what meal they are eating
		int result = JOptionPane.showOptionDialog(panel, "What meal are you eating?", "Choose meal",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, chooseMeal, null);

		// Three arrays containing different dishes for each meal
		String[] chooseDishForBreakfast = new String[] { "Eggs, toast and milk (400 calories)",
				"Fruit slices, bagel and orange juice (400 calories)", "Ham, cereal and milk (400 calories)",
				"Cheese, muffin and yogourt (400 calories)" };
		String[] chooseDishForLunch = new String[] { "Tuna sandwhich (800 calories)",
				"Chicken ceasar salad (800 calories)", "Pasta salad (800 calories)", "Egg sandwhich (800 calories)" };
		String[] chooseDishForDinner = new String[] { "Pasta (1000 calories)", "Steak (1000 calories)",
				"Salmon (1000 calories)", "Sushi (1000 calories)", "Spaghetti and meatballs (1000 calories)" };

		// If the user clicked the meal 'breakfast', show them all the breakfast dishes
		if (result == JOptionPane.YES_OPTION) {

			String meal = mealPlan(chooseDishForBreakfast);

			if (meal != null) {
				// Output the meal that the user chose and add the corresponding amount of
				// calories for breakfast
				System.out.println(meal);
				user.caloriesGained += 400;
				user.totalCalories += 400;
			}
		}
		// If the user clicked the meal 'lunch', show them all the lunch dishes
		else if (result == JOptionPane.NO_OPTION) {
			String meal = mealPlan(chooseDishForLunch);
			if (meal != null) {
				// Output the meal that the user chose and add the corresponding amount of
				// calories for lunch
				System.out.println(meal);
				user.caloriesGained += 800;
				user.totalCalories += 800;
			}
		}
		// If the user clicked the meal 'dinner', show them all the dinner dishes
		else if (result == JOptionPane.CANCEL_OPTION) {
			String meal = mealPlan(chooseDishForDinner);

			if (meal != null) {
				// Output the meal that the user chose and add the corresponding amount of
				// calories for dinner
				System.out.println(meal);
				user.caloriesGained += 1000;
				user.totalCalories += 1000;
			}
		}

		else {
			Queue r = new Queue();
			r.makeRecipe();
		}

		// If the user did not choose a meal and clicked 'x', nothing happens and they
		// are taken back to the main menu
	}

	// Helper method for startMeal that shows the user their meal options and
	// outputs their choice
	public static String mealPlan(String[] dishChoices) {
		JFrame frame = new JFrame("Input Dialog Example 3");
		String meal = (String) JOptionPane.showInputDialog(frame, null, "Options for the day",
				+JOptionPane.QUESTION_MESSAGE, null, dishChoices, dishChoices[0]);

		return meal;

		// If the user did not choose a meal, nothing happens and they go back to the
		// home screen
	}

	public static void startWorkout() {
		// Asks the user to choose an intensity level for their work out
		String[] level = new String[] { "Mild (Walking, Yoga)", "Medium (Jogging, Swimming)",
				"Intense (Weight training, cardio)", "Custom Workout" };
		JFrame frame = new JFrame("Input Dialog Example 3");
		String intensity = (String) JOptionPane.showInputDialog(frame, null, "Choose your workout intensity",
				+JOptionPane.QUESTION_MESSAGE, null, level, level[0]);

		if (intensity != null) {
			// Starts a timer immediately when the user chooses to start their work out

			if (intensity.equals(level[3])) {
				ExerciseStacks e = new ExerciseStacks(null);
				e.start();
				user.workOutTime += e.totalTime;
				user.caloriesLost += e.caloriesLost;
			}

			else {
				long startTime = System.currentTimeMillis();
				boolean running = true;

				String[] workOut = new String[] { "Start/Stop", "Finish Workout" };
				int resultOne = 0;
				String s = "Workout in progress. Timer is on";

				// As long as the user does not click "Finish Workout", the timer will either be
				// running or paused
				while (resultOne == JOptionPane.YES_OPTION) {

					JPanel panel = new JPanel();
					resultOne = JOptionPane.showOptionDialog(panel, s, "Workout", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, workOut, null);

					// If the timer is currently running, it will be paused
					if (running) {
						user.workOutTime += System.currentTimeMillis() - startTime;
						running = false;
						s = "Workout paused";
						System.out.println("Your total workout time is: " + formatTime(user.workOutTime));
					}

					// If the timer is currently paused, it will be resumed
					else if (!running) {
						startTime = System.currentTimeMillis();
						running = true;
						s = "Workout resumed. Timer is on";
					}
				}
				// Depending on the amount of time and intensity of the workout, the number of
				// calories burned will be calculated
				int i = 0;
				int a = 2;
				while (intensity.equals(level[i]) == false) {
					i++;
					a++;
				}
				user.caloriesLost = (user.workOutTime / 10000) * a;

				user.totalCalories -= (user.caloriesLost);

			}
		}

	} // If the user did not choose an intensity level or clicked 'x' at any time,
		// their activity is canceled and they are taken back to the
		// main menu

	public static void printSummary() {
		// A summary of the user's sleep history, calories, and work out time from doing
		// these activities will be printed
		System.out.println("Here is a summary of your results:\n" + "Sleep history: " + user.sleepTimeHistory
				+ "\nTotal fitness time: " + formatTime(user.workOutTime) + "\nCalories gained from eating: "
				+ user.caloriesGained + "\nCalories lost from working out: " + user.caloriesLost + "\nTotal calories: "
				+ user.totalCalories);
	}
}

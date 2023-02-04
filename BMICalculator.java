import java.time.temporal.ValueRange;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BMICalculator {
    public static void main(String[] args) {
        int height = heightInInches();
        int weight = weightInPounds();
        outputBMI(height, weight);
    }

    /**
     * Returns the users height in inches based on feet & inches entered by the user.
     *
     * @return the height of the user in inches
     */
    public static int heightInInches() {
        System.out.println("Enter height in feet and inches");
        int height = 12 * getInt("Enter feet: ",2, 7);
        height += getInt("Enter inches: ",0, 11);
        return height;
    }

    /**
     * Returns the users weight in inches based on feet & inches entered by the user.
     *
     * @return the weight of the user in pounds
     */
    public static int weightInPounds() {
        System.out.println("\nEnter weight in stone and pounds");
        int weight = 14 * getInt("Enter stone: ",3, 30);
        weight += getInt("Enter pounds: ",0, 13);
        return weight;
    }

    /**
     * Prompts the user for input and returns integer value in range between min and max.
     *
     * @param   prompt  string printed to console to prompt user response
     * @param   min     the minimum integer value allowed to be returned
     * @param   max     the maximum integer value allowed to be returned
     * @return          integer value between min and max
     */
    public static int getInt(String prompt, int min, int max) {
        Scanner input = new Scanner(System.in);
        ValueRange rangeAllowed = ValueRange.of(min, max);
        while(true) {
            System.out.print(prompt);
            String userInput = input.next();
            if (Pattern.matches("(\\d+)", userInput) && rangeAllowed.isValidValue(Integer.parseInt(userInput))) {
                return Integer.parseInt(userInput);
            }
        }
    }

    /**
     * Prints the Body Mass Index value (BMI) based on height in inches and weight in pounds to
     * the console.
     *
     * @param   heightInInches  users height in inches
     * @param   weightInPounds  users weight in punds
     */
    public static void outputBMI(int heightInInches, int weightInPounds) {
        double bmi =  (weightInPounds * 703.0)/(heightInInches * heightInInches);
        System.out.printf("\nYour BMI is: %.2f ", bmi);
    }
}

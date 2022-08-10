import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String wantContinue = "";
        byte userChoice;

        do{
            userChoice = getUserChoice();
            switch (userChoice) {
                case 1 -> ResultHandler.resultProcessConsoleToConsole();
                case 2 -> ResultHandler.resultProcessFileToFile();
                case 3 -> ResultHandler.resultProcessFileToConsole();
                default -> wantContinue = "No";
            }

            if(!wantContinue.equals("No")){
                System.out.println("\nDo you want continue? Type Y and press enter. N to end.");
                wantContinue = sc.next().toUpperCase();
            }
        } while (wantContinue.equals("Y"));
        System.out.println("\nEND");
    }

    /**
     * Open "menu" to ask user what he wants to use and return his choice.
     * @return int - User choice
     */
    private static byte getUserChoice () {
        byte choice = 0;
        boolean isNumValid = false;

        System.out.printf("\nWELCOME TO APP - Choose how to work with numbers."
                + "\nType 1 - Print numbers from console to console."
                + "\nType 2 - Print numbers from file to file. "
                + "\nType 3 - Print numbers from file to console."
                + "\nType 4 - End program");

        while(!isNumValid){
            try {
                System.out.print("\nChose number: ");
                Scanner sc = new Scanner(System.in);
                choice = sc.nextByte();

                if(choice < 1 || choice > 4)
                    throw new InputMismatchException("Allowed range is 1-4.");

                isNumValid = true;
            } catch (InputMismatchException e) {
                String msg = e.getMessage() == null ? "This is not a number! " : e.getMessage();
                System.out.println(msg);
            }
        }
        System.out.println();
        return choice;
    }
}

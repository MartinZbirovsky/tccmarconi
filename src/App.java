import java.util.*;

public class App {
    public static void main(String[] args) {
        ResultHandler resultHandler = ResultHandler.getInstance();

        Scanner sc = new Scanner(System.in);
        String wantContinue = "";
        UserChoice userChoice;

        do{
            userChoice = getUserChoice();
            switch (userChoice.getChoiceNumber()) {
                case 1 -> resultHandler.resultProcess(userChoice.getFistFilePath());
                case 2 -> resultHandler.resultProcess(userChoice.getFistFilePath(), userChoice.getSecondFilePath());
                case 3 -> resultHandler.resultProcess();
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
    private static UserChoice getUserChoice () {
        UserChoice userChoice = null;
        String[] userInput;

        while(userChoice == null){
            try {
                System.out.print("\nEnter your choice: ");

                Scanner sc = new Scanner(System.in);
                userInput = sc.nextLine().replace("\"", "").split(" ");

                if (userInput.length == 1 && userInput[0].contains(".txt")) {
                    userChoice = new UserChoice(1, userInput[0]);
                }
                else if (userInput.length == 2 && userInput[0].contains(".txt") && userInput[1].contains(".txt")) {
                    userChoice = new UserChoice(2, userInput[0], userInput[1]);
                }
                else if (userInput.length == 1 && !userInput[0].contains(".txt")) {
                    try {
                        if(Integer.parseInt(userInput[0]) <= 0) throw new InputMismatchException("Only number bigger than zero.");
                    } catch (NumberFormatException e) {
                        throw new InputMismatchException("Error... enter valid path or number bigger than zero at first place");
                    }
                    userChoice = new UserChoice(3);
                }
                else {
                    throw new InputMismatchException("Invalid arguments");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return userChoice;
    }
}

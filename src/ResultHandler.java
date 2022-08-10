import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResultHandler implements ResultHandlerF {

    private static final ResultHandler handlerInstance = new ResultHandler();
    public static ResultHandler getInstance(){
        return handlerInstance;
    }

    /**
     * Result console to console
     * Filter console input and print result to console
     */
    @Override
    public void resultProcess () {
        List<Integer> nums = new ArrayList<>();
        Scanner cs = new Scanner(System.in);

        System.out.println("Enter all numbers on one line separated by a space. Example: \"  1 2 3 4  \"");
        while(nums.isEmpty()){
            try {
                nums = FileHandler.parseStringToInt(cs.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Use only numbers separated by a space... like 1 2 3");
            }
        }
        nums = filterNumber(nums);
        System.out.printf(nums.isEmpty() ? "No number to display" : "Your numbers are: " + nums);
    }

    /**
     * Result file to console
     * Read input file and print filtered numbers into console
     */
    @Override
    public void resultProcess (String aFilePath) {
        List<Integer> nums;

        if(FileHandler.fileExist(aFilePath)){
            nums = filterNumber(FileHandler.readNumFromFile(aFilePath));
            System.out.println("Your numbers: " + nums.toString());
        } else {
            System.out.println("File not found!");
        }
    }

    /**
     * Result file to file
     * Filter all number inside input file and save them into output file.
     */
    @Override
    public void resultProcess (String aFirstFilePath, String aSecondFilePath) {
        List<Integer> nums;

        if(FileHandler.fileExist(aFirstFilePath)){
            nums = filterNumber(FileHandler.readNumFromFile(aFirstFilePath));
            FileHandler.createFileWithText(aSecondFilePath, nums.toString());
            System.out.println("The numbers from input file were filtered and saved in the output file");
        } else {
            System.out.println("File not found!");
        }
   }
}

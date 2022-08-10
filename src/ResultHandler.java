import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResultHandler {

    /**
     * Result console to console
     * Filter console input and print result to console
     */
    protected static void resultProcessConsoleToConsole () {
        boolean isNumValid = false;
        List<Integer> nums = new ArrayList<>();
        Scanner cs = new Scanner(System.in);

        System.out.println("Enter all numbers on one line separated by a space. Example: \"1 2 3 4\"");
        while(!isNumValid){
            try {
                nums = FileHandler.parseStringToInt(cs.nextLine());
                isNumValid = true;
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
    protected static void resultProcessFileToConsole () {
        String filePath = FileHandler.getFilePathIfExist();

        List<Integer> nums = filterNumber(FileHandler.readNumFromFile(filePath));
        System.out.println("Your numbers: " + nums.toString());
    }

    /**
     * Result file to file
     * Filter all number inside input file and save them into output file.
     */
    protected static void resultProcessFileToFile () {
        String filePath = FileHandler.getFilePathIfExist();

        FileHandler.createFileWithText(filterNumber(FileHandler.readNumFromFile(filePath)).toString());
        System.out.println("The numbers from input file were filtered and saved in the output file");
    }

    /**
     * Check if size number is odd or even and return only odd or even numbers
     * odd = odd, even = even.
     * @param aNums - List of numbers
     * @return filtered list
     */
    private static List<Integer> filterNumber(List<Integer> aNums) {
        return (aNums.size() % 2 == 0)
                ? aNums.stream().filter(n -> n%2 == 0).collect(Collectors.toList())
                : aNums.stream().filter(n -> n%2 != 0).collect(Collectors.toList());
    }
}

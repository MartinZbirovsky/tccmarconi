import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileHandler {

    /**
     * Read numbers from file and parse them to int
     * @param aFilePath - File to read
     * @return parsed numbers
     */
    public static List<Integer> readNumFromFile(String aFilePath) {
        List<Integer> nums = new ArrayList<>();

        try {
            File file = new File(aFilePath);
            Scanner cs = new Scanner(file);
            while (cs.hasNextLine()) {
                String data = cs.nextLine();
                data = data.replace(",", "").replace("[", "").replace("]", "");
                nums = parseStringToInt(data);
            }
            cs.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return nums;
    }

    /**
     * Add text to file
     * @param aTextToAdd - Text to add
     */
    public static void createFileWithText(String aFilePath, String aTextToAdd) {
        try {
            File file = new File(aFilePath);
            FileWriter fw = new FileWriter(file);
            fw.write(aTextToAdd);
            fw.close();
            System.out.println("File created path is " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Something happened " + e.getMessage());
        }
    }

    /**
     * Check if file exists.
     * @param aFilePath - File path
     * @return - true if file is present else false
     */
    public static boolean fileExist(String aFilePath) {
            File file = new File(aFilePath);
            return file.exists();
    }

    /**
     * Split all numbers by " " and parse them to new int list.
     * @param aStringWithNums - String with numbers
     * @return - List of integers
     * @throws InputMismatchException - Invalid number
     */
    public static List<Integer> parseStringToInt (String aStringWithNums) throws InputMismatchException {
        List<Integer> nums = new ArrayList<>();
        Arrays.stream(aStringWithNums.split(" ")).forEach(num ->
            nums.add(Integer.parseInt(num))
        );
        return nums;
    }
}

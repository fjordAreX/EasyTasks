package Task2_A_Plus_B;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTask2 {
    private static final String ABSOLUTE_WAY = "src/main/java/Task2_A_Plus_B/files/";
    private static final File FILE_INPUT = new File(ABSOLUTE_WAY + "input.txt");
    private static final File FILE_OUTPUT = new File(ABSOLUTE_WAY + "output.txt");

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(FILE_INPUT);
            String text = scanner.nextLine();

            Pattern pattern = Pattern.compile("(\\d) (\\d)");
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()){
                if (!FILE_OUTPUT.exists()) {
                    FILE_OUTPUT.createNewFile();
                }
                    addSum(matcher.group(1),matcher.group(2));
                }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addSum(String first, String second) throws IOException {
        int sum = Integer.parseInt(first)+Integer.parseInt(second);
        try(FileWriter fileWriter = new FileWriter(FILE_OUTPUT)) {
            fileWriter.write(String.valueOf(sum));
        }


    }
}

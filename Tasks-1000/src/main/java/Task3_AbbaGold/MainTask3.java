package Task3_AbbaGold;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTask3 {
    private static final String ABSOLUTE_WAY = "src/main/java/Task3_AbbaGold/files/";
    private static final File FILE_INPUT = new File(ABSOLUTE_WAY + "input.txt");
    private static final File FILE_OUTPUT = new File(ABSOLUTE_WAY + "output.txt");

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(FILE_INPUT);
            String text = scanner.nextLine();
            Pattern pattern = Pattern.compile("(\\d+) (\\d+) (\\d+)");
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()){
                if (!FILE_OUTPUT.exists()) {
                    FILE_OUTPUT.createNewFile();
                }
                long first = Integer.parseInt(matcher.group(1));
                long second = Integer.parseInt(matcher.group(2));
                long third = Integer.parseInt(matcher.group(3));
                maxValue(first,second,third);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void maxValue(long first,long second,long third) throws IOException {
        long answer = Long.max(Long.max(first,second),third);

       try (FileWriter fileWriter = new FileWriter(FILE_OUTPUT)){
           fileWriter.write(String.valueOf(answer));
       }

    }

}

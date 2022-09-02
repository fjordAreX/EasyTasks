package Task4_acm_world_finals;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MainTask4 {
    private static final String ABSOLUTE_WAY = "src/main/java/Task4_acm_world_finals/files/";
    private static final File FILE_INPUT = new File(ABSOLUTE_WAY + "input.txt");
    private static final File FILE_OUTPUT = new File(ABSOLUTE_WAY + "output.txt");

    public static void main(String[] args) {

        try(FileInputStream fileInputStream = new FileInputStream(FILE_INPUT)) {
            StringBuilder stringBuilder = new StringBuilder();

            while (fileInputStream.available()>0){
                int reader = fileInputStream.read();
                stringBuilder.append((char)reader);
                }

            String[] arr = stringBuilder.toString().split("\r\n");
            if (!FILE_OUTPUT.exists()) {
                FILE_OUTPUT.createNewFile();
            }
            outputCorrectly(arr);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void outputCorrectly(String[] arr) throws FileNotFoundException {
        String answer = arr[0]+
                Arrays.stream(arr).skip(1).collect(Collectors.joining(", ",": ",""));

        try (OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream(FILE_OUTPUT))){
            streamWriter.write(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

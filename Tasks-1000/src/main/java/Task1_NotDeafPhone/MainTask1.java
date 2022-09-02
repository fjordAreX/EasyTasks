package Task1_NotDeafPhone;

import java.io.*;


public class MainTask1 {

    private static final String ABSOLUTE_WAY = "src/main/java/Task1_NotDeafPhone/files/";
    private static final File FILE_INPUT = new File(ABSOLUTE_WAY + "input.txt");
    private static final File FILE_OUTPUT = new File(ABSOLUTE_WAY + "output.txt");
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    public static void main(String[] args) {

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(FILE_INPUT))) {
            byte[] arr = new byte[8];
            int reader = bufferedInputStream.read(arr);

            while (reader !=-1){
                STRING_BUILDER.append(new String(arr,0,reader));
                reader = bufferedInputStream.read(arr);
            }

            if (!FILE_OUTPUT.exists()) {
                FILE_OUTPUT.createNewFile();
            }
            addToFile();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addToFile() throws IOException {
        OutputStream bufferedOutputStream = new FileOutputStream(FILE_OUTPUT);
        bufferedOutputStream.write(STRING_BUILDER.toString().getBytes());
        bufferedOutputStream.close();
    }
}



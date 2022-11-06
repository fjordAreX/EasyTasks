package Task7_Bowling;

import java.io.*;
import java.util.Scanner;

public class MainTask7 {

    private static final String ADDRESS = "src/main/java/Task7_Bowling/files";
    private static final File INPUT_FILE = new File(ADDRESS + "/input.txt");
    private static final File OUTPUT_FILE = new File(ADDRESS + "/output.txt");
    private static short TOTAL_SCORE = 0;


    public static void main(String[] args) throws IOException {

        try (Scanner scanner = new Scanner(INPUT_FILE)) {

            byte numOfThrows = scanner.nextByte();
            byte[] scores = new byte[numOfThrows];
            for (byte i = 0; i < scores.length; i++) {
                scores[i] = scanner.nextByte();
            }

            boolean firstThrow = true;
            byte currentScore = 0;

//            int i = 0;
//            byte attempt = 1;
//            do {
//                if (i != 0) {
//                   // if (currentScore != 0 && scores[i - 1] < 10) {
//                    if ((currentScore != 0 || scores[i-1]==10) && scores[i] == 10){
//                        firstThrow = true;
//                        attempt += 1;
//                        currentScore = 0;
//                    } else {
//                        firstThrow = false;
//                    }
//
//                    if (firstThrow && scores[i]==10){
//
//                        continue;
//                    }
//
//                    if (!firstThrow && currentScore == 10){
//
//                        continue;
//                    }
//
//                    currentScore += scores[i];
//                    TOTAL_SCORE += scores[i];
//                }
//


//                i++;
//            } while (i<numOfThrows);


            for (byte i = 0; i < scores.length; i++) {
                if (i != 0) {
                    if ( (scores[i-1]==10 || scores[i-1]==0) || currentScore != 0) {
                        firstThrow = true;
                        currentScore = 0;
                    } else {
                        firstThrow = false;
                    }
                }
                if (firstThrow && scores[i] == 10) {
                    byte strikeScore = scores[i];
                    if (i+2 < numOfThrows) {
                        for (byte j = (byte) (i + 1); j <= i + 2; j++) {
                            strikeScore += scores[j];
                        }
                        TOTAL_SCORE += strikeScore;
                    }
                    continue;
                }
                currentScore += scores[i];

                if (!firstThrow && currentScore == 10) {
                    if (i+1 < numOfThrows) {
                        TOTAL_SCORE += scores[i + 1];
                    }
                    continue;
                }


                TOTAL_SCORE += scores[i];

            }


            System.out.println(TOTAL_SCORE);

            if (!OUTPUT_FILE.exists()) {
                OUTPUT_FILE.createNewFile();
            }

            try (OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE))) {
                streamWriter.write(String.valueOf(TOTAL_SCORE));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
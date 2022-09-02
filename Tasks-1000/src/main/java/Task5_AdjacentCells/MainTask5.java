package Task5_AdjacentCells;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainTask5 {
    private static final String ABSOLUTE_WAY = "src/main/java/Task5_AdjacentCells/files/";
    private static final File FILE_INPUT = new File(ABSOLUTE_WAY + "input.txt");
    private static final File FILE_OUTPUT = new File(ABSOLUTE_WAY + "output.txt");
    private static final int BOARD_SIDE = 8;
    private static final int[][] CHESSBOARD = new int[BOARD_SIDE][BOARD_SIDE];

    public static void main(String[] args) {
        fillBoard();

        try(Scanner scanner = new Scanner(FILE_INPUT)){
            int input = scanner.nextInt();

            String answer = findTouching(input);

            addToOutput(answer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fillBoard(){
     int count = 1;
        for (int i = 0; i < CHESSBOARD.length; i++) {
            for (int j = 0; j < CHESSBOARD[i].length; j++,count++) {
                CHESSBOARD[i][j] = count;
            }
        }
    }

    private static String findTouching(int source){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < CHESSBOARD.length; i++) {
            for (int j = 0; j < CHESSBOARD[i].length; j++) {
                if (CHESSBOARD[i][j]==source){
                    if(i-1 >= 0 ){
                        list.add(CHESSBOARD[i-1][j]);
                    }if(i+1 < BOARD_SIDE ){
                        list.add(CHESSBOARD[i+1][j]);
                    }if(j-1 >= 0 ){
                        list.add(CHESSBOARD[i][j-1]);
                    }if(j+1 < BOARD_SIDE ){
                        list.add(CHESSBOARD[i][j+1]);
                    }
                    break;
                }
            }
        }

        return list.stream().sorted().map(Object::toString).collect(Collectors.joining(" "));
    }

    private static void addToOutput(String answer) throws IOException {
        try(FileWriter fileWriter = new FileWriter(FILE_OUTPUT)){
            fileWriter.write(answer);
        }
    }
}

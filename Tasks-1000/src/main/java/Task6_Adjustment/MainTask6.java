package Task6_Adjustment;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTask6 {
    public static void main(String[] args) {
        File file = new File("src/main/java/Task6_Adjustment/files/input.txt");
        try {
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            int answer = 0;
            if (!line.isBlank()){

                Pattern pattern = Pattern.compile("([x0-9])([+-])([x0-9])(=)([x0-9])");
                Matcher matcher = pattern.matcher(line);

                int unknown = 0;
                if (matcher.find()){
                    for (int i = 1; i < 6; i+=2) {
                        if (matcher.group(i).equals("x")){
                            unknown = i;
                            break;
                        }
                    }

                        if (unknown == 5) {
                            switch (matcher.group(2)) {
                                case ("+") -> answer = Integer.parseInt(matcher.group(1))+Integer.parseInt(matcher.group(3));
                                case ("-") -> answer = Integer.parseInt(matcher.group(1))-Integer.parseInt(matcher.group(3));
                            }
                        }else if(unknown == 1){
                            switch (matcher.group(2)) {
                                case ("+") -> answer = Integer.parseInt(matcher.group(5))-Integer.parseInt(matcher.group(3));
                                case ("-") -> answer = Integer.parseInt(matcher.group(5))+Integer.parseInt(matcher.group(3));
                            }
                        }else {
                            switch (matcher.group(2)) {
                                case ("+") -> answer = Integer.parseInt(matcher.group(5)) - Integer.parseInt(matcher.group(1));
                                case ("-") ->
                                        answer = (Integer.parseInt(matcher.group(5)) - Integer.parseInt(matcher.group(1))) * -1;
                            }
                        }

                }
                File fileOUT = new File("src/main/java/Task6_Adjustment/files/output.txt");
                fileOUT.createNewFile();
                try(FileOutputStream outputStreamWriter = new FileOutputStream(fileOUT)){
                    outputStreamWriter.write(String.valueOf(answer).getBytes());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

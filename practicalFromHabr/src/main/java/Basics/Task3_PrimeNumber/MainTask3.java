package Basics.Task3_PrimeNumber;

import java.util.LinkedList;
import java.util.List;

public class MainTask3 {
    public static void main(String[] args) {

        List<Integer> answer = new LinkedList<>();

        for (int i = 2; i < 101; i++) {
            int count = 0;

            for (int j = 2; j <= i; j++) {

                if (i % j == 0) {
                    count++;
                }
            }

            if (count == 1) {
                answer.add(i);
            }
        }
        System.out.println(answer);
    }
}

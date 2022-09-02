package Basics.Task2_SortingArray;

import java.util.Arrays;
import java.util.Random;

public class MainTask2 {
    // сортировка пузырьком

    private static final int ARRAY_LENGTH = 10;
    private static final int[] ARRAY = new int[ARRAY_LENGTH];

    public static void main(String[] args) {
        fillArr();
        System.out.println(Arrays.toString(ARRAY));
        sort();
        System.out.println(Arrays.toString(ARRAY));
    }

    private static void fillArr() {
        Random random = new Random(1);
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            ARRAY[i] = random.nextInt(100);
        }
    }

    private static void sort() {
        for (int i = 0; i < ARRAY.length; i++) {
            for (int j = 0; j < ARRAY.length - i - 1; j++) {
                if (ARRAY[j] > ARRAY[j + 1]) {
                    int temp = ARRAY[j];
                    ARRAY[j] = ARRAY[j + 1];
                    ARRAY[j + 1] = temp;
                }
            }
        }
    }

}

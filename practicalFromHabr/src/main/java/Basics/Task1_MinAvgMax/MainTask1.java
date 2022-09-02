package Basics.Task1_MinAvgMax;

import java.util.Arrays;

public class MainTask1 {

    private static final int ARRAY_LENGTH = 100;
    private static final double[] ARRAY = new double[ARRAY_LENGTH];

    public static void main(String[] args) {

        fillArr();

        System.out.println(min());
        System.out.println(avg());
        System.out.println(max());

    }

    private static void fillArr() {
        for (int i = 0; i < ARRAY.length; i++) {
            ARRAY[i] = Math.random();
        }
    }

    private static double min() {
        double min = Double.MAX_VALUE;

        for (double num : ARRAY) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }

    private static double avg() {
        double avg = 0;

        for (double num : ARRAY) {
            avg += num;
        }

        return avg / ARRAY_LENGTH;
    }

    private static double max() {
        double max = Double.MIN_VALUE;

        for (double num : ARRAY) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }
}

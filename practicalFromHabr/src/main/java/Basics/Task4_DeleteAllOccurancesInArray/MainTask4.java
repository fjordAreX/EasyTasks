package Basics.Task4_DeleteAllOccurancesInArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainTask4 {
    public static void main(String[] args) {
        //Дан массив целых чисел и ещё одно целое число.
        // Удалите все вхождения этого числа из массива (пропусков быть не должно).

        int [] array = {1,2,0,3,4,5,0,6,7,0,8};
        System.out.println(Arrays.toString(array));
        int[] newArray = deleteOccurrences(array,0);
        System.out.println(Arrays.toString(newArray));
    }

    private static int[] deleteOccurrences(int[]arr,int target){

        return Arrays.stream(arr).filter(e -> e != target).toArray();

    }

}

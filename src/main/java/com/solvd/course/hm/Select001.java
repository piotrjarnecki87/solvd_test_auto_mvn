package com.solvd.course.hm;

public class Select001 {


    public static void main(String[] args) {
        int array[] = {8, 2, 5, 3, 9, 1, 4, 7, 6};
        selectionSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }
}

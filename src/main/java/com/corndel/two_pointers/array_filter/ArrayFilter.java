package com.corndel.two_pointers.array_filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayFilter {

    public static int[] getDistinctNumbersBruteForce(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }

        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp.add(arr[i]);
            }
        }

        temp.add(arr[arr.length - 1]);

        return temp.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] getDistinctNumbersTwoPointers(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }

        int[] temp = Arrays.copyOf(arr, arr.length);
        int write = 1;

        for (int read = 1; read < arr.length; read++) {
            if (temp[read] != temp[read - 1]) {
                temp[write] = arr[read];
                write++;
            }
        }

        return Arrays.copyOf(temp, write);

    }
}

package com.rkv.notification;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DemoDS {
    public static void main(String[] args) {

        int arr[] = {-5, 2, -6, 0, 0, 8, -7, -10, -4, 4};

        int temp = 0;
        int frontZero = 0;
        int frontNeg = 0;

        for (int i = (arr.length - 1); i >= 0; i--) {
            if (arr[i] == 0) {
                temp = arr[frontZero];
                arr[frontZero] = arr[i];
                arr[i] = temp;
                frontZero++;
            }


        }
        for (int i = (arr.length - 1); i >= 0; i--)
        {
            if (arr[i]< 0) {
                temp = arr[frontNeg];
                arr[frontNeg] = arr[i];
                arr[i] = temp;
                frontNeg++;
            }
        }

        for (int i : arr) {
            System.out.print(" " + i);

        }

    }
}

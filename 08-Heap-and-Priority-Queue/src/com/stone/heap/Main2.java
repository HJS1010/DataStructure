package com.stone.heap;

import java.util.Arrays;
import java.util.Random;

public class Main2 {
    private static double testHeap(Integer[] testData, boolean isHeapify) {

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        int length = testData.length;

        if (isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else {
            maxHeap = new MaxHeap<>(length);
            for (Integer num : testData)
                maxHeap.add(num);
        }

        int[] arr = new int[length];
        for (int i = 0; i < length; i++)
            arr[i] = maxHeap.extractMax();

        for (int i = 1; i < length; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int n = 1_000_000;

        Random random = new Random();
        Integer[] testData1 = new Integer[n];
        for (int i = 0; i < n; i++){
            testData1[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData1, false);
        System.out.println("Without heapify: " + time1 + " s");

        Integer[] testData2 = Arrays.copyOf(testData1, n);
        double time2 = testHeap(testData2, true);
        System.out.println("With heapify: " + time2 + " s");
    }
}

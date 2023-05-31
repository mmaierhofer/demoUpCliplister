package com.demoup.sort;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DescendingMergeSort<T extends Comparable<T>> implements SortAlgorithm<T>{

    private ExecutorService executorService;
    public DescendingMergeSort() {
        executorService = Executors.newCachedThreadPool();
    }

    public T[] sort(T[] array) {
        if (array == null) {
            return null;
        }
        if (array.length <= 1) {
            return array;
        }

        var mid = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);

        Future<T[]> leftResult = submitSortTask(left);
        Future<T[]> rightResult = submitSortTask(right);

        try {
            left = leftResult.get();
            right = rightResult.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        merge(array, left, right);

        return array;
    }

    private Future<T[]> submitSortTask(T[] array) {
        return executorService.submit(() -> sort(array));
    }


    private void merge(T[] array, T[] left, T[] right) {
        var i = 0;
        var j = 0;
        var k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) > 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

}


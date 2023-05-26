package com.demoup.sort;

import java.util.Arrays;

public class DescendingMergeSort<T extends Comparable<T>> implements SortAlgorithm<T>{

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

        sort(left);
        sort(right);

        merge(array, left, right);

        return array;
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


package com.demoup.sort;

import java.util.Arrays;
import java.util.Comparator;

public class DescendingDefaultSort<T extends Comparable<? super T>> implements SortAlgorithm<T>{
    @Override
    public T[] sort(T[] array) {
        if (array != null) {
            Arrays.sort(array, Comparator.reverseOrder());
        }
        return array;
    }
}

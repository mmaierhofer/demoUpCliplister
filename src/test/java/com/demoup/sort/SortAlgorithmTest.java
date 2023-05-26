package com.demoup.sort;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortAlgorithmTest {
    private static Integer[] array;

    private static Integer[] expected;

    @BeforeAll
    public static void init() {
        array = new Integer[]{9,4,6,1,3,6,7,2};
        expected = new Integer[]{9,7,6,6,4,3,2,1};
    }

    @Test
    @DisplayName("LegacySort")
    public void testLegacySort() {

        SortAlgorithm<Comparable<?>> legacySort = new LegacySort();
        Comparable[] actual = legacySort.sort(array);
        assert Arrays.equals(actual, expected);
    }

    @Test
    @DisplayName("MergeSort")
    public void testMergeSort() {

        SortAlgorithm<Integer> mergeSort = new DescendingMergeSort<>();
        Integer[] actual = mergeSort.sort(array);
        assert Arrays.equals(actual, expected);
    }

    @Test
    @DisplayName("DefaultSort")
    public void testDefaultSort() {
        SortAlgorithm<Integer> defaultSort = new DescendingDefaultSort<>();
        Integer[] actual = defaultSort.sort(array);
        assert Arrays.equals(actual, expected);
    }

}

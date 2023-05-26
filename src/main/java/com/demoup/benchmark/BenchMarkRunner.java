package com.demoup.benchmark;

import com.demoup.sort.DescendingDefaultSort;
import com.demoup.sort.LegacySort;
import com.demoup.sort.DescendingMergeSort;
import com.demoup.sort.SortAlgorithm;

import java.util.List;
import java.util.Random;

public class BenchMarkRunner {

    private static final List<Integer> numOfElements = List.of(100, 1000, 10000);
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        numOfElements.forEach(BenchMarkRunner::runSortAlgorithmBenchMarkTest);
    }

    /**
     *
     * @param numOfElements - Number of random numbers array will contain
     * @return - array of size numElements
     */
    private static Integer[] getRandomNumbers(int numOfElements) {
        Integer[] array = new Integer[numOfElements];
        Random rand = new Random();
        for (int i = 0; i < numOfElements; i++) {
            int x = rand.nextInt(numOfElements);
            array[i] = x;
        }
        return array;
    }

    /**
     * Runs Benchmark performance test for
     * different versions of ascending sort
     *
     * @param numOfElements - Number of random numbers array for benchmark will contain
     */
    private static void runSortAlgorithmBenchMarkTest(int numOfElements){
        SortAlgorithm<Comparable<?>> legacySort = new LegacySort();
        SortAlgorithm<Integer> newSort = new DescendingMergeSort<>();
        SortAlgorithm<Integer> defaultSort = new DescendingDefaultSort<>();

        MicroBenchMark microBenchMark = new MicroBenchMark<Comparable<?>>(getRandomNumbers(numOfElements));
        microBenchMark.getPerformance(legacySort);
        microBenchMark.getPerformance(newSort);
        microBenchMark.getPerformance(defaultSort);
    }
}

package com.demoup.benchmark;


import com.demoup.sort.SortAlgorithm;

public class MicroBenchMark<T> {

    public T[] array;

    public MicroBenchMark(T[] array) {
        System.out.printf("Benchmark test with %d elements %n", array.length );
        this.array = array;
    }

    /**
     * Prints out time used by each algorithm
     * with respect to the size of the array
     *
     * @param algorithm - Sort algorithm to be benchmarked
     */
    public void getPerformance(SortAlgorithm<T> algorithm) {
        long startTime = System.nanoTime();
        algorithm.sort(array);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.printf("Time elapsed for algorithm %s: %d %n", algorithm.getClass() , estimatedTime);
    }
}

# DemoUp Cliplister Challenge

This file will answer the questions asked in the challenge pdf.


## Task 1

#### a) The algorithm used is the merge sort algorithm, with sorts in descending order

#### b)  Steps:
####    - First I have taken advantage of Generics, as the raw use of parameterized classes is not advisable
####     - Then I have used the copyOfRange method to improve readability
####      - To further improve readability i have introduced the var keyword for local variables
####     - I have also decided to split the function in two separate methods sort and merge again for readability
####    - The last step was to deprecated the LegacySort class

#### c) The output of the standard sort and the LegacySort is that the LegacySort works in descending order


## Task 2

#### a) The SortAlgorithm Interface I went for contains one function which uses generics again:

```
T[] sort(T[] array);
```

### this function can be implemented by all three SortingAlgorithm implementations, which makes the benchmarking easy.

#### b) and c) are found in the code

#### d) The microbenchmark test shows, that the refactored version of the descending merge sort was slower than the old as well
#### as the standard sorting of Java. This probably has its reason in the casting of the Generics.
#### The advantages of reusability and readability outway in my opinion the loss of performance.
#### The issues with microbenchmarking takes only the performance in one case into account but lack of real in depth insights and context


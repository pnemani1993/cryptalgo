# cryptalgo
Algorithms, Cyrptography related algorithms and DSA problem solving

## Introduction to Algorithms - Notes ##

### Backtracking Algorithms ###
Backtracking is an algorithmic technique for solving problems recursively by trying to build a solution incrementally, one piece at a time, removing those solutions that fail to satisfy the constraints of the problem at any point in time.

Backtracking basically uses recursion to reach till the end of the problem, it eliminates those possibilities that do not give the solution, and it does all of this while using recursion to subdivide the larger problem into smaller independently solvable problems. 

There are three types of problems in backtracking: 
- Decision making
- Optimization
- Enumeration

Example of a Backtracking problem: 
    Enumerate all the possible subsets of an array: A[1...n]
```java

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void calcSubset(List<Integer> A, // The actual array to be acted upon
                                  List<List<Integer> > res,  // initially empty
                                  List<Integer> subset, // initially empty
                                  int index) // initially 0
    {
        // Add the current subset to the result list
        res.add(new ArrayList<>(subset)); // 1 -> empty; 2 -> 1; 3 -> 1,2

        // Generate subsets by recursively including and
        // excluding elements
        for (int i = index; i < A.size(); i++) { // 1 -> 0; 2 -> 1
            // Include the current element in the subset
            subset.add(A.get(i)); // subset -> 1; subset -> 1,2;

            // Recursively generate subsets with the current
            // element included
            calcSubset(A, res, subset, i + 1); // recursive call 1 -> res -> {}; subset -> 1; i = 0;; recursive call 2 -> res -> {}, {1}; subset -> 1,2;;

            // Exclude the current element from the subset
            // (backtracking)
            subset.remove(subset.size() - 1);
        }
    }

    public static List<List<Integer> >
    subsets(List<Integer> A)
    {
        List<Integer> subset = new ArrayList<>(); // Empty when initialized
        List<List<Integer> > res = new ArrayList<>(); // empty when initialized

        int index = 0;
        calcSubset(A, res, subset, index);

        return res;
    }

    // Driver code

    public static void main(String[] args)
    {
        List<Integer> array = List.of(1, 2, 3);
        List<List<Integer> > res = subsets(array);

        // Print the generated subsets
        for (List<Integer> subset : res) {
            for (Integer num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

```

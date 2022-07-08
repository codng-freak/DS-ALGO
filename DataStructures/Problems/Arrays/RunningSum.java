package DataStructures.Problems.Arrays;

import java.util.Arrays;

public class RunningSum {
    public int[] runningSum(int[] nums) {

        // O(n*2) complexity solution - not efficient.

        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int total = 0;
            for (int j = 0; j <= i; j++) {
                total += nums[j];
            }
            newArr[i] = total;
        }
        return newArr;
    }

    public int[] runningSumMethodTwo(int[] nums) {
        // O(n) complexity solution
        // Algorithm -

        // Define an array result.
        // Initialize the first element of result with the first element of the input
        // array.
        // At index i append the sum of the element nums[i] and previous running sum
        // result[i - 1] to the result array.
        // We repeat step 3 for all indices from 1 to n-1.

        int[] newArr = new int[nums.length];
        newArr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            newArr[i] = newArr[i - 1] + nums[i];
        }
        return newArr;
    }

    public int[] runningSumMethodThree(int[] nums) {
        // Result at index `i` is sum of result at `i-1` and element at `i`
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        RunningSum object = new RunningSum();
        int[] result = object.runningSum(new int[] { 1, 2, 3, 4 });
        System.out.println(Arrays.toString(result));
    }
}

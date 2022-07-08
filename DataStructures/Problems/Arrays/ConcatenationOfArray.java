package DataStructures.Problems.Arrays;

import java.util.Arrays;

public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[2 * (nums.length)];
        int len = nums.length;
        int i = 0;
        while (i < len) {
            arr[i] = nums[i];
            arr[i + len] = nums[i];
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        ConcatenationOfArray object = new ConcatenationOfArray();
        int[] result = object.getConcatenation(new int[] { 1, 2, 1 });
        System.out.println(Arrays.toString(result));
    }
}

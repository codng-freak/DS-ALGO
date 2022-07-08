package DataStructures.Problems.Arrays;

import java.util.Arrays;

public class BuildArrayFromPermutation {
    public int[] buildArray(int[] arr) {
        int[] finalArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            finalArr[i] = arr[arr[i]];
        }
        return finalArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 2, 1, 5, 3, 4 };
        BuildArrayFromPermutation obj = new BuildArrayFromPermutation();
        int[] result = obj.buildArray(arr);
        System.out.println(Arrays.toString(result));
    }
}

import java.util.Arrays;

class Solution {
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                runningSum(new int[]{1, 2, 3, 4})));

        System.out.println(Arrays.toString(
                runningSum(new int[]{1, 1, 1, 1, 1})));

        System.out.println(Arrays.toString(
                runningSum(new int[]{3, 1, 2, 10, 1})));
    }
}

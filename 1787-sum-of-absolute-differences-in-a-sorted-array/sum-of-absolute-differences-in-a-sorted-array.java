import java.util.Arrays;

class Solution {
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            result[i] = (nums[i] * i - leftSum) 
                        + (rightSum - nums[i] * (n - i - 1));

            leftSum += nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                getSumAbsoluteDifferences(new int[]{2, 3, 5})));

        System.out.println(Arrays.toString(
                getSumAbsoluteDifferences(new int[]{1, 4, 6, 8, 10})));
    }
}

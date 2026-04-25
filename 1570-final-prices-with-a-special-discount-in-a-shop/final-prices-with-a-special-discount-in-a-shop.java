class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();

            stack.push(prices[i]);
        }

        return result;
    }
}
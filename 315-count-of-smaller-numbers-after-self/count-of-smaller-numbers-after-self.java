class Solution {
    private int[] indexes;
    private int[] counts;
    private int[] temp;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        indexes = new int[n];
        counts = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, 0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int count : counts) {
            result.add(count);
        }

        return result;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = indexes[i];
        }

        int i = left, j = mid + 1, k = left;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[temp[j]] < nums[temp[i]]) {
                indexes[k++] = temp[j++];
                rightCount++;
            } else {
                counts[temp[i]] += rightCount;
                indexes[k++] = temp[i++];
            }
        }

        while (i <= mid) {
            counts[temp[i]] += rightCount;
            indexes[k++] = temp[i++];
        }

        while (j <= right) {
            indexes[k++] = temp[j++];
        }
    }
}
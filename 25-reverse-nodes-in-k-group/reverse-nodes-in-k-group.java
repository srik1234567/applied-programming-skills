class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        // Step 1: Check if there are at least k nodes
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // Step 2: If we have k nodes, reverse them
        if (count == k) {
            curr = reverseKGroup(curr, k); // recursive call

            // Reverse current k nodes
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }
            head = curr;
        }

        return head;
    }
}

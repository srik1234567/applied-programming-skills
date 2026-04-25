/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class NodeInfo {
        TreeNode node;
        int row, col;

        NodeInfo(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<NodeInfo> queue = new LinkedList<>();

        queue.offer(new NodeInfo(root, 0, 0));

        while (!queue.isEmpty()) {
            NodeInfo curr = queue.poll();

            map.putIfAbsent(curr.col, new ArrayList<>());
            map.get(curr.col).add(new int[]{curr.row, curr.node.val});

            if (curr.node.left != null) {
                queue.offer(new NodeInfo(curr.node.left, curr.row + 1, curr.col - 1));
            }

            if (curr.node.right != null) {
                queue.offer(new NodeInfo(curr.node.right, curr.row + 1, curr.col + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (List<int[]> list : map.values()) {
            list.sort((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });

            List<Integer> column = new ArrayList<>();
            for (int[] pair : list) {
                column.add(pair[1]);
            }

            result.add(column);
        }

        return result;
    }
}
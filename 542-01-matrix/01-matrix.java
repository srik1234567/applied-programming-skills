class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];

                if (r >= 0 && r < rows && c >= 0 && c < cols && !visited[r][c]) {
                    dist[r][c] = dist[cell[0]][cell[1]] + 1;
                    visited[r][c] = true;
                    queue.offer(new int[]{r, c});
                }
            }
        }

        return dist;
    }
}
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] redGraph = new ArrayList[n];
        List<Integer>[] blueGraph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            redGraph[i] = new ArrayList<>();
            blueGraph[i] = new ArrayList<>();
        }

        for (int[] edge : redEdges) {
            redGraph[edge[0]].add(edge[1]);
        }

        for (int[] edge : blueEdges) {
            blueGraph[edge[0]].add(edge[1]);
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        boolean[][] visited = new boolean[n][2];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0}); // last edge red
        queue.offer(new int[]{0, 1}); // last edge blue
        visited[0][0] = true;
        visited[0][1] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int color = curr[1];

                if (answer[node] == -1) {
                    answer[node] = steps;
                }

                List<Integer>[] nextGraph = (color == 0) ? blueGraph : redGraph;
                int nextColor = 1 - color;

                for (int next : nextGraph[node]) {
                    if (!visited[next][nextColor]) {
                        visited[next][nextColor] = true;
                        queue.offer(new int[]{next, nextColor});
                    }
                }
            }

            steps++;
        }

        return answer;
    }
}
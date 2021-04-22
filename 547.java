/**
 * id: 547 - number of provinces
 * tag: graph
 * date: 2021-04-21
 * note: find the numebr of connected components on a graph
 */
class Solution {
    private boolean [] visited;
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visit(isConnected, i);
                count += 1;
            }
        }
        return count;
    }
    
    private void visit(int[][] graph, int start) {
        visited[start] = true;
        for(int i=0; i<graph.length; i++) {
            if(!visited[i] && graph[start][i] == 1) {
                visit(graph, i);
            }
        }
    }
}
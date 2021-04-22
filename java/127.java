/**
 * id: 127 word ladder
 * tags: bfs
 * date: 2020-04-22
 */
class Solution {
    private int wordDistance(String a, String b) {
        int count = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                count += 1;
            }
        }
        return count;
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        } else if(wordDistance(beginWord, endWord) == 1) {
            return 2;
        }
        
        wordList.add(0, beginWord);
        wordList.add(endWord);
        
        int n = wordList.size();
        int [][] graph = new int[n][n];
        // build graph
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(wordDistance(wordList.get(i), wordList.get(j)) == 1) {
                    graph[i][j] = graph[j][i] = 1;
                }
            }
        }
        // bfs
        Queue<Integer> q = new ArrayDeque<Integer>();
        int [] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        q.add(0);
        while(q.size() > 0) {
            int index = q.poll();
            for(int i=0; i<n; i++) {
                if(graph[index][i] == 1 && dist[i] < 0) {
                    dist[i] = dist[index] + 1;
                    q.add(i);
                }
            }
        }
        return dist[n-1] > 0 ? dist[n-1] + 1: 0;
        
    }
}

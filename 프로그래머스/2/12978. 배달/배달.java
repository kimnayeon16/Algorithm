import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<ArrayList<int[]>> list = new ArrayList<ArrayList<int[]>>();
        
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<int[]>());
        }
        
        for(int i=0; i<road.length; i++){
            list.get(road[i][0]).add(new int[]{road[i][1], road[i][2]});
            list.get(road[i][1]).add(new int[]{road[i][0], road[i][2]});
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,1});
        
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int time = tmp[0];
            int area = tmp[1];
            
            if(time > dist[area]) continue;
            
            for(int[] next: list.get(area)){
                int nextArea = next[0];
                int nextTime = next[1];
                
                if(dist[nextArea] > dist[area] + nextTime){
                    dist[nextArea] = dist[area] + nextTime;
                    pq.add(new int[]{dist[nextArea], nextArea});
                }
            }
        }
        
        for(int i=1; i<=N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        
        return answer;
    }
}

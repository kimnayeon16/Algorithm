import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2*w+1;
        
        for(int i=1; i<stations.length; i++){
            int end = stations[i] - w;
            int start = stations[i-1] + w;
            if(end <= start) continue;
            answer += (end - start -1) / range;
            
            if((end - start - 1) % range != 0) answer++;
        }
        // System.out.println("반복 = " + answer);
        
//         처음
        if(stations[0] - w > 0){
            answer += (stations[0] - w - 1) / range;
            if((stations[0] - w - 1) % range != 0) answer++;
            // System.out.println("처음 = " + answer);
        }
        
        
//         마지막
        if(stations[stations.length-1] + w < n){
            answer += (n - stations[stations.length-1] - w) / range;
            if((n - stations[stations.length-1] - w) % range != 0) answer++;
            // System.out.println("마지막 = " + answer);
        }
        return answer;
    }
}
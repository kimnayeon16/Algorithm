import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        
        int before = -1;
        for(int i=0; i<arr.length; i++){
            if(before != arr[i]){
                queue.add(arr[i]);
                before = arr[i];
            }
        }
        
        int[] answer = new int[queue.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = queue.remove();
        }

        return answer;
    }
}
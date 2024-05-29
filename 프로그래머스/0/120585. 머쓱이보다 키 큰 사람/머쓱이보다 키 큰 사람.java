import java.util.*;

class Solution {
    public int solution(int[] array, int height) {
        int cnt = array.length;
        Arrays.sort(array);
        
        int start = 0;
        int end = array.length - 1;
        
        while(start <= end){
            int mid = (start + end) / 2;
            
            if(array[mid] > height){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return array.length - start;
    }
}
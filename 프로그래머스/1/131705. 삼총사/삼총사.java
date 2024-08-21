import java.util.*;

class Solution {
    static int[] numbers;
    static int[] pickNums = new int[3];
    static int answer = 0;
    public int solution(int[] number) {
        numbers = number;
        Arrays.sort(number);
        
        if(number[0] > 0) return 0;
        
        combination(0,0);
        
        return answer;
    }
    
    public static void combination(int idx, int sidx){
        if(sidx == 3){
            if(pickNums[0] > 0) return;
            
            int sum = 0;
            for(int i=0; i<pickNums.length; i++){
                sum += pickNums[i];
            }
            if(sum == 0) answer++;
            return;
        }
        if(idx == numbers.length) return;
        
        pickNums[sidx] = numbers[idx];
        combination(idx+1, sidx+1);
        combination(idx+1, sidx);
    }
}
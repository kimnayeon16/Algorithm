class Solution {
    public int[] solution(int n, int s) {
        int num = s/n;
        int r = s%n;
        if(num == 0){
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        for(int i = answer.length-1; i >= 0;i--){            
            answer[i] = num;
            if(r > 0){
                answer[i]++;
                r--;
            }
        }

        return answer;
    }
    
}
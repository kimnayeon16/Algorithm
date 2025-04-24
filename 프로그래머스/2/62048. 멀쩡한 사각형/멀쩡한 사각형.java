class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        long a = 0; long b = 0;
        
        if(w > h){
            a = w; b = h;
        }else{
            b = w; a = h;
        }
        
        if(a % b == 0){
            answer = a * b - a;
            return answer;
        }
        
        int gcd = 1;
        for(int i=2; i<=b; i++){
            if(a%i==0 && b%i==0){
                gcd = i;
            }
        }
        answer = a * b - (w + h - gcd);
        
        return answer;
    }
}
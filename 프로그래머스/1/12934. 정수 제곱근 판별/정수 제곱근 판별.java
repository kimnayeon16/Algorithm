class Solution {
    public long solution(long n) {
        long answer = 0;
        
        double num = Math.sqrt(n);
        System.out.println(num);
        
        if(num % 1 == 0){
            return (long) Math.pow(num+1, 2);
        }
        return -1;
    }
}
class Solution {
    public String solution(int[] food) {
        String answer = "";
        String s = "";
        for(int i=1; i<food.length; i++){
            int num = food[i]/2;
            
            for(int j=0; j<num; j++){
                s += i;
            }
        }
        
        StringBuffer sb = new StringBuffer(s);
        String sr = sb.reverse().toString();
        return s + 0 + sr;
    }
}
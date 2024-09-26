class Solution {
    static int cnt = 0;
    static String words = "";
    static String[] alpha = {"A", "E", "I", "O", "U"};
    static Boolean isStop = false;
    public int solution(String word) {
        words = word;
        
        for(int i=0; i<5; i++){
            findAlpha(alpha[i]);
        }
        return cnt;
    }
    
    public static void findAlpha(String tmp){
        // System.out.println(tmp);
        if(!isStop) cnt++;
        
        
        //단어를 찾았다면 //여기서 끝내야되는데 ..
        if(tmp.equals(words)){
            // System.out.println(cnt);
            isStop = true;
            return;
        }
        //단어 길이가 5가 됐다면
        if(tmp.length() == 5){
            // return;
        }
        //단어 길이가 5보다 작다면
        if(tmp.length() != 5){
            for(int i=0; i<5; i++){
                findAlpha(tmp + alpha[i]);
            }
        }
    }
}
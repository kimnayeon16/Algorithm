class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] baby = {"aya", "ye", "woo", "ma"};
        
        for(int i=0; i<baby.length; i++){
            for(int j=0; j<babbling.length; j++){
                if(babbling[j].contains(baby[i])){
                    // System.out.println(babbling[j]);
                    babbling[j] = babbling[j].replace(baby[i], i+"");
                    // System.out.println(babbling[j]);
                }
            }
        }
        
        for(int i=0; i<babbling.length; i++){
            
            if(isNum(babbling[i])){
                char c = babbling[i].charAt(0);
                boolean check = true;
                for(int j=1; j<babbling[i].length(); j++){
                    if(c == babbling[i].charAt(j)){
                        check = false;
                        break;
                    }else{
                        c = babbling[i].charAt(j);
                    }
                }
                if(check){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public boolean isNum(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
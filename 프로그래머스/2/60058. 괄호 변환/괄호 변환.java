import java.util.*;

class Solution {
    static String answer = "";
    public String solution(String p) {
        String a = findWord(p);
        // System.out.println("정답은 = " + a);
        return a;
    }
    public String findWord(String p){
        //빈 문자열이면 빈 문자열 반환
        if(p.length() == 0) return "";
        String u = ""; String v = "";
        int left = 0; int right = 0;
        
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            u += p.charAt(i);
            if(left == right){
                v = p.substring(i+1, p.length());
                break;
            }
        }
        // System.out.println(u + ", " + v);
        
        if(isRight(u)){
            //u가 올바른 괄호라면 v에 대해 재귀
            // System.out.println("u는 올바른 괄호");
            u += findWord(v); //))((() //()
            return u;
            
        }else{
            //u가 올바르지 않은 괄호라면
            // System.out.println("u는 올바르지 않은 괄호");
            String result = "";
            result += "(" + findWord(v) + ")";
            // System.out.println("result == " + result); //()
            
            u = u.substring(1, u.length()-1);
            String news = "";
            for(int i=0; i<u.length(); i++){
                if(u.charAt(i) == '('){
                    result += ')';
                }else{
                    result += '(';
                }
            }
            return result;
        }
        // String bb = result + news;
        
    }
    
    private boolean isRight(String u){
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<u.length(); i++){
            if(u.charAt(i) == '('){
                stack.push('(');
            }else{
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(')');
                }
            }
        }
        
        if(stack.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}
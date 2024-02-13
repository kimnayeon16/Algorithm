class Solution {
    fun solution(id_pw: Array<String>, db: Array<Array<String>>): String {
        var answer: String = "fail"
        
        for(element in db){
            if(element[0] == id_pw[0]){
                if(element[1] == id_pw[1]){
                    answer = "login"
                    break
                }else{
                    answer = "wrong pw"
                }
            }
        }
        return answer
    }
}
class Solution {
    fun solution(my_string: String, overwrite_string: String, s: Int): String {
        var answer: String = ""
        
        for(m in 0 until s){
            answer += my_string[m]
        }
        answer += overwrite_string
        
        if(my_string.length > overwrite_string.length + s){
            for(m in overwrite_string.length + s until my_string.length){
                answer += my_string[m]
            }
        }
        
        return answer
    }
}
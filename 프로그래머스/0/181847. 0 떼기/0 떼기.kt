class Solution {
    fun solution(n_str: String): String {
        var answer: String = ""
        answer = n_str
        
        for(i in 0 until n_str.length){
            if(n_str[i] == '0'){
                answer = answer.substring(1)
                println(answer)
            }else{
                break
            }
        }
        return answer
    }
}
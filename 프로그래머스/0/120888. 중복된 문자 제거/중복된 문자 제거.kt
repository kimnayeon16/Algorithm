class Solution {
    fun solution(my_string: String): String {
        var answer: String = ""
        
        for(i in 0 until my_string.length){
            var str = my_string[i].toString()
            if(!answer.contains(str)){
                answer += str
            }
        }
        return answer
    }
}
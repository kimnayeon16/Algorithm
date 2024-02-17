class Solution {
    fun solution(my_string: String): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        var myString = my_string
        answer += my_string
        
        for(i in 0 until my_string.length-1){
            answer += myString.substring(1)
            myString = myString.substring(1)
        }
        
        answer.sort()
        return answer
    }
}
class Solution {
    fun solution(my_string: String): String {
        var answer: String = ""
        answer = my_string.replace("a","")
        answer = answer.replace("e","")
        answer = answer.replace("i","")
        answer = answer.replace("o","")
        answer = answer.replace("u","")
        println(answer)
        return answer
    }
}
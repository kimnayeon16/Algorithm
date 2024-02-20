class Solution {
    fun solution(my_string: String): Array<String> {
        var answer = my_string.split(" ").filter{ it. isNotEmpty() }
        return answer.toTypedArray()
    }
}
class Solution {
    fun solution(s: String): StringBuilder {
        var answer = StringBuilder()
        var arr = s.split(" ").map { it.toInt() }

        val array = arr.sorted()

        answer.append(array[0]).append(" ").append(array[arr.size-1])
        return answer
    }
}
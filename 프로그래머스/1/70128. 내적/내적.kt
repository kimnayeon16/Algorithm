class Solution {
    fun solution(a: IntArray, b: IntArray): Int {
        var answer: Int = 0
        for((index, element) in a.withIndex()){
            answer += element * b[index]
        }
        return answer
    }
}
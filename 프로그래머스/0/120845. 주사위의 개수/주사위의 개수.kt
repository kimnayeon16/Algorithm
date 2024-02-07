class Solution {
    fun solution(box: IntArray, n: Int): Int {
        var answer: Int = 0
        answer = (box[0] / n) * (box[1] / n) * (box[2] / n)
        return answer
    }
}
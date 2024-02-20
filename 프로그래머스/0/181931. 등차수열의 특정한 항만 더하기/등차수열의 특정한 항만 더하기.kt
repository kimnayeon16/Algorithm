class Solution {
    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        var answer: Int = 0
        
        for((index, element) in included.withIndex()){
            if(element) {
                answer += a + index * d
            }
            println(index)
        }
        return answer
    }
}
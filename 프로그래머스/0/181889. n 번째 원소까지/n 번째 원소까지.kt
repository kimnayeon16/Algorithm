class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        
        for(i in 0 until n){
            answer += num_list[i]
        }
        return answer
    }
}
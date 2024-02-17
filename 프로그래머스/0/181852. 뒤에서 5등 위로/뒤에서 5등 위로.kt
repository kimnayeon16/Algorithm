class Solution {
    fun solution(num_list: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        
        num_list.sort()
        
        for(i in 5 until num_list.size){
            answer += num_list[i]
        }
        return answer
    }
}
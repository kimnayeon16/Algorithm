class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        
        answer = arr
        for(element in queries){
            for(i in element[0] .. element[1]){
                answer[i]++
            }
        }
        return answer
    }
}
class Solution {
    fun solution(arr: IntArray, intervals: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        for(element in intervals){
            for(i in element[0] .. element[1]){
                answer += arr[i]
            }
        }
        return answer
    }
}
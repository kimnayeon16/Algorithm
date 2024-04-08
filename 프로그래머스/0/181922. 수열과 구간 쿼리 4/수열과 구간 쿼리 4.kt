class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        answer = arr.copyOf()
        
        for(query in queries){
            for(element in query[0]..query[1]){
                if(element % query[2] == 0){
                    answer[element]++
                }
            }
        }
        return answer
    }
}
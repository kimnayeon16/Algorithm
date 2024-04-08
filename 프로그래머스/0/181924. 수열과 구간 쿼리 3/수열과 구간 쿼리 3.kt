class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer = arr
        
        for(element in queries){
            var first = arr[element[0]]
            
            answer[element[0]] = arr[element[1]]
            answer[element[1]] = first
        }
        return answer
    }
}
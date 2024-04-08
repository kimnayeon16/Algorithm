import kotlin.math.min

class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer = IntArray(queries.size,{1000000})
        
        for((idx,query) in queries.withIndex()){
            for(element in query[0]..query[1]){
                if(arr[element] > query[2]){
                    answer[idx] = min(answer[idx], arr[element])
                }
            }
        }
        
        // answer.forEach{print("$it ")}
        
        val answerArray = answer.map{if(it == 1000000) -1 else it}.toIntArray()
        return answerArray
    }
}
class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 0
        var arrays = Array(10){ false}
        for(n in numbers){
            arrays[n] = true
        }
        
        for((index, array) in arrays.withIndex()){
            if(!array){
                answer += index
            }
        }
        return answer
    }
}
class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        
        var start = 0
        var end = 0
        
        for((index, i) in arr.withIndex()){
            if(i == 2){
                start = index
                break
            }
        }
        
        for(i in arr.size-1 downTo 0){
            if(arr[i] == 2){
                end = i
                break
            }
        }
        
        if(start == 0 && end == 0){
            answer += -1
        }else{
            for(element in start .. end){
                answer += arr[element]
            }
        }
        return answer
    }
}
class Solution {
    fun solution(array: IntArray): IntArray {
        var answer: IntArray = IntArray(2)
        
        for(i in 0 until array.size){
            if(array[i] > answer[0]){
                answer[0] = array[i]
                answer[1] = i
            }    
        }
        return answer
    }
}
class Solution {
    fun solution(arr: IntArray, idx: Int): Int {
        var answer: Int = 0
        
        for(i in idx until arr.size){
            if(arr[i] == 1){
                return i
            }
        }
        return -1
    }
}
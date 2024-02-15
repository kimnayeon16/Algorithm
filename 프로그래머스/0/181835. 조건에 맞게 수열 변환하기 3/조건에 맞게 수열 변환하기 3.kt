class Solution {
    fun solution(arr: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        
        if(k % 2 == 0){
            answer = arr.map { it + k }.toIntArray()
        }else{
            answer = arr.map { it * k }.toIntArray()
        }
        return answer
    }
}
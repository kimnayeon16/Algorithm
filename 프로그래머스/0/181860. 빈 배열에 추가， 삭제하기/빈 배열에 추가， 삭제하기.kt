import java.util.*

class Solution {
    fun solution(arr: IntArray, flag: BooleanArray): IntArray {
        val answer = Stack<Int>()
        
        for((index,element) in flag.withIndex()){
            if(element){
                for(i in 0 until arr[index] * 2){
                    answer.add(arr[index])
                }
            }else{
                for(i in 0 until arr[index]){
                    answer.pop()
                }
            }
        }
        return answer.toIntArray()
    }
}
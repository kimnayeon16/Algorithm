import kotlin.math.*

class Solution {
    fun solution(array: IntArray, n: Int): Int {
        var answer: Int = 0
        
        array.sort()
        
        var minn: Int = 999999
        for(i in array){
            if(minn > abs(i-n)){
                minn = abs(i-n)
                answer = i
            }
        }
        println(minn)        
        
        return answer
    }
}
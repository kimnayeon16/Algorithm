import kotlin.math.pow

class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        answer = arr
        var sqr = 0
        while(2.0.pow(sqr).toInt() < arr.size){
            sqr++
        }
        
        for(i in 0 until 2.0.pow(sqr).toInt() - arr.size){
            answer += 0
        }
        return answer
    }
}
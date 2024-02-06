import kotlin.math.*;

class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var newN = n.toDouble()
        var sqr = sqrt(newN).toInt()
        
        for(i in 1..sqr){
            if(i*i == n){
                return 1
            }
        }
        return 2
    }
}
import kotlin.math.*

class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0
        
        for(i in 1..n){
            if(i*i == n) return (i+1)*(i+1)
        }
        return -1
    }
}
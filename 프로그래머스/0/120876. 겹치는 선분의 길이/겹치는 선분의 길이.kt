import java.util.*

class Solution {
    fun solution(lines: Array<IntArray>): Int {
        var answer: Int = 0
    
        val count = Array(201){ 0 }
        
        lines.forEach{
            for(i in it[0] until it[1]) count[i+100]++
        }
        
        return count.count{it >= 2}
    }
}
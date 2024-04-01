class Solution {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0
            
        answer = (0 .. t.length - p.length)
        .map { t.substring(it, it+p.length)}
        .count { it <= p }
        
        return answer
    }
}
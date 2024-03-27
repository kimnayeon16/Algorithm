class Solution {
    fun solution(intStrs: Array<String>, k: Int, s: Int, l: Int): IntArray {
        var answer = intArrayOf()
        
        intStrs.forEach{
            val sub = it.substring(s, s+l).toInt()
            if(sub > k){
                answer += sub
            }
        }
        return answer
    }
}
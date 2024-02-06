class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var str = n.toString()
        
        for(i in 0 until str.length){
            answer += str.substring(i,i+1).toInt()
        }
        return answer
    }
}
class Solution {
    fun solution(i: Int, j: Int, k: Int): Int {
        var answer: Int = 0
        var sb = StringBuilder()
        
        for(element in i..j){
            sb.append(element.toString())
        }
        
        for(s in 0 until sb.length){
            if(sb[s].toString().toInt() == k){
                answer++
            }
        }
        return answer
    }
}
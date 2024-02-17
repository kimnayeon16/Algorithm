class Solution {
    fun solution(number: String): Int {
        var answer: Int = 0
        
        for(i in 0 until number.length){
            answer += number[i].toString().toInt()
        }
        return answer % 9
    }
}
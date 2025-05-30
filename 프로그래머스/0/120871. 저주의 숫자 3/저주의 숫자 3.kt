class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        
        for(i in 1..n){
            answer++
            while(answer % 3 == 0 || answer.toString().contains("3")){
                answer += 1
            }
        }
        return answer
    }
}
class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        
        for(i in 4..n){
            if(i != 5 && i!= 7){
                if(i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0){
                    answer++
                }
            }
        }
        return answer
    }
}
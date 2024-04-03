class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        
        var sortedSec = section.sorted()
        var start = section[0]
        var idx = 1
        answer++
        
        while(idx != section.size){
            if(sortedSec[idx] - start >= m){
                start = sortedSec[idx]
                answer++
            }
            // if(sortedSec[idx] - start < m){
            //     // continue
            // }else{
            //     start = sortedSec[idx]
            //     answer++
            // }
            idx++
        }
        return answer
    }
}
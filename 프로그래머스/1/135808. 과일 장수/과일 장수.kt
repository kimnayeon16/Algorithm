class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        var scoreSorted = score.sortedDescending()
        
        for(i in 0 until scoreSorted.size/m){
            for(j in 0 until m){
                answer += scoreSorted[i*m + (m-1)]
            }
        }
        return answer
    }
}
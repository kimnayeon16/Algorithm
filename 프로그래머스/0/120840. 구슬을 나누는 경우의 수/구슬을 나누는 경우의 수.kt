class Solution {
    fun solution(balls: Int, share: Int): Int {
        var answer: Int = 1
        
        var array = Array(balls+1) { IntArray(share+1) }
        
        for(i in 1..balls){
            array[i][1] = i
        }
        for(i in 1..share){
            array[i][i] = 1
        }
        
        for(i in 2..balls){
            for(j in 2..share){
                array[i][j] = array[i-1][j-1] + array[i-1][j]
            }
        }
        
        println(array.contentDeepToString())
        
        answer = array[balls][share]
        
        
        
        return answer
    }
}
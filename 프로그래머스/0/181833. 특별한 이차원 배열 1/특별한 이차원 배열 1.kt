class Solution {
    fun solution(n: Int): Array<Array<Int>> {
        var answer = Array(n) {Array(n){ 0 }}
        for(i in 0 until n){
            answer[i][i] = 1
        }
        return answer
    }
}
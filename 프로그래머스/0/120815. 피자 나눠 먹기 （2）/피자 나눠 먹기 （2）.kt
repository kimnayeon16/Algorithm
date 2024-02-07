class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var cnt = 1
        while(true){
            if((6 * cnt) % n == 0){
                break
            }else{
                cnt++
            }
        }
        return cnt
    }
}
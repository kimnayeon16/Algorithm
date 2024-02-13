class Solution {
    fun solution(common: IntArray): Int {
        var answer: Int = 0
        
        if(common[1] == (common[0] + common[2]) / 2 && (common[0] + common[2]) % 2 == 0){
            val d = common[1] - common[0]
            answer = common[common.size - 1] + d
        }else{
            val d = common[1] / common[0]
            answer = common[common.size - 1] * d
        }
        return answer
    }
}
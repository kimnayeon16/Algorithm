class Solution {
    fun solution(sides: IntArray): Int {
        var answer: Int = 0
        sides.sort()
        
        if(sides[0] + sides[1] > sides[2]){
            return 1
        }else{
            return 2
        }
        return answer
    }
}
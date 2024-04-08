import kotlin.math.pow

class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var num = n
        var threeChange = ""
        while(num > 2){
            threeChange += num % 3
            num /= 3
        }
        threeChange += num
        
        var threeBinArr = threeChange.reversed().toCharArray()
        println(threeBinArr)
        
        var sqrt = 0
        for(i in threeBinArr){
            answer += (i-'0') * 3.0.pow(sqrt++).toInt()
        }
        
        
        return answer
    }
}
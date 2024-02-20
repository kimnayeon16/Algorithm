import kotlin.math.max

class Solution {
    fun solution(strArr: Array<String>): Int {
        var answer: Int = 0
        
        var group = strArr.groupingBy{ it.length }
        var count = group.eachCount()
        // group.forEach{ println(it) }
        answer = count.maxByOrNull {it.value}?.value ?: 0
        return answer
    }
}
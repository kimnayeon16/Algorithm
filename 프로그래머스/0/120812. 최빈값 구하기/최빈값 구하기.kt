import kotlin.math.*

class Solution {
    fun solution(array: IntArray): Int {
        var answer: Int = 0
        var map = HashMap<Int, Int>()
        var maxCount = 0
        
        for(i in array){
            map[i] = map.getOrPut(i) {0} + 1
            maxCount = max(maxCount, map[i]!!)
        }
        println(map)
        var list = map.filter { it.value == maxCount }.keys.toList()
        
        if(list.size != 1){
            answer = -1
        }else{
            answer = list[0]
        }
        
        
        return answer
    }
}
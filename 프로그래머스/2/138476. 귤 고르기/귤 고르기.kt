class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        
        var map = HashMap<Int, Int>()
        tangerine.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        
        var valueSorted = map.toList().sortedByDescending {it.second}.toMap()
        
        var sum = 0
        valueSorted.forEach {
            sum += it.value
            answer++
            if(sum >= k){
                return answer
            }
        }
        return answer
    }
}
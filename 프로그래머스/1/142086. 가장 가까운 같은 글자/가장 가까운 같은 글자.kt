class Solution {
    fun solution(s: String): IntArray {
        var answer = IntArray(s.length, {0})
        var map = HashMap<Char, Int>()
        
        for(i in 0 until s.length){
            var c = s[i]
            if(map.getOrDefault(c, -1) == -1){
                map[c] = i
                answer[i] = -1
            }else{
                answer[i] = i - map[c]!!
                map[c] = i
            }
        }
        println(map)
        return answer
    }
}
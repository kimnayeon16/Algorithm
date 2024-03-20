class Solution {
    fun solution(a: Int, b: Int): String {
        var answer = ""
        var days = arrayOf("THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED")
        var day = 0
        var map = HashMap<Int, Int>()
        map[1] = 31
        map[2] = 29
        map[3] = 31
        map[4] = 30
        map[5] = 31
        map[6] = 30
        map[7] = 31
        map[8] = 31
        map[9] = 30
        map[10] = 31
        map[11] = 30
        map[12] = 31
        
        
        for(i in 1 until a){
            day += map[i] ?: 0
        }
        day += b
        
        val div = day % 7
        answer = days[div]
        return answer
    }
}
class Solution {
    fun solution(food: IntArray): String {
        var s = ""
        for(i in 1 until food.size){
            var num = food[i]/2
            for(j in 0 until num){
                s += i
            }
        }
        return s + 0 + s.reversed()
    }
}
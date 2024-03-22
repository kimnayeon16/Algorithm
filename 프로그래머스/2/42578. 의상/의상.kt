class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        var map = HashMap<String, Int>()
        
        for(cloth in clothes){
            map[cloth[1]] = map.getOrDefault(cloth[1], 0) + 1
        }
        
        for(element in map){
            answer *= (element.value + 1) 
        }
        
        answer -= 1
        return answer
    }
}
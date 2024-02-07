class Solution {
    fun solution(s: String): StringBuilder {
        var answer = StringBuilder()
        var map = HashMap<Char, Int>()
        var array = ArrayList<Char>()
        
        for(element in s){
            map[element] = map.getOrDefault(element, 0) + 1
        }
        
        for((key, value) in map){
            if(value == 1){
                array.add(key)
            }
        }
        
        array.sort()
        
        for(i in array){
            answer.append(i)
        }
        
        println(array)
        
        return answer
    }
}
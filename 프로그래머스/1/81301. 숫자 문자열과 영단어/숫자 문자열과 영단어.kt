class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var word = s
        var map = HashMap<Int, String>()
        map[0] = "zero"
        map[1] = "one"
        map[2] = "two"
        map[3] = "three"
        map[4] = "four"
        map[5] = "five"
        map[6] = "six"
        map[7] = "seven"
        map[8] = "eight"
        map[9] = "nine"
        
        for(element in map){
            var (key, value) = element
            if(word.contains(value)){
                word = word.replace(value, key.toString())
            }
        }
        answer = word.toInt()
        return answer
    }
}
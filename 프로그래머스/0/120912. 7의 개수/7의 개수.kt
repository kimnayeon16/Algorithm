class Solution {
    fun solution(array: IntArray): Int {
        var answer: Int = 0
        
        for(element in array){
            var tmp = element.toString()
            for(e in 0 until tmp.length){
                if(tmp[e] == '7'){
                    answer++
                }
            }
        }
        return answer
    }
}
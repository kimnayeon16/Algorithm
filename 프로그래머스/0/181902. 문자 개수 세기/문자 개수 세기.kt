class Solution {
    fun solution(my_string: String): IntArray {
        var answer = IntArray(52, {0})
        
        for(i in 0 until my_string.length){
            var changeNum = my_string[i] - '0'
            //대문자
            if(changeNum < 43){
                answer[changeNum - 17] += 1
            }else{
                answer[changeNum - 23] += 1
            }
        }
        return answer
    }
}
class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        
        
        if(num_list.size >= 11){
            for(element in num_list){
                answer += element
            }
        }else{
            answer = 1
            for(element in num_list){
                answer *= element
            }
        }
        return answer
    }
}
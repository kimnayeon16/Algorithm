class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        var odd: String = ""
        var even: String = ""
        
        for(element in num_list){
            if(element % 2 == 0){
                even += element.toString()
            }else{
                odd += element.toString()
            }
        }
        
        answer += even.toInt() + odd.toInt()
        return answer
    }
}
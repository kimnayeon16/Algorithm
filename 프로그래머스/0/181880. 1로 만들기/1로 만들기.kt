class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        for(e in num_list){
            var element = e
            while(element != 1){
                if(element % 2 == 0){
                    element /= 2
                }else{
                    element = (element - 1) / 2
                }
                answer++
            }
        }
        return answer
    }
}
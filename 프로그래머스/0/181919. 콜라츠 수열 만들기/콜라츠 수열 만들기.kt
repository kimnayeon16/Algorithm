class Solution {
    fun solution(n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var num: Int = n
        answer += n
        
        while(true){
            if(num == 1){
                return answer
            }else if(num % 2 == 0){
                num /= 2
                answer += num
            }else{
                num = 3 * num + 1
                answer += num
            }
        }
        
    }
}
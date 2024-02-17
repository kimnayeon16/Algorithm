class Solution {
    fun solution(n: Int, control: String): Int {
        var answer: Int = n
        
        for(i in 0 until control.length){
            if(control[i] == 'w'){
                answer++
            }else if(control[i] == 's'){
                answer--
            }else if(control[i] == 'd'){
                answer += 10
            }else{
                answer -= 10
            }
        }
        return answer
    }
}
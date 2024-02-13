class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        
        var array = s.split(" ")
        var num = 0
        for(i in array){
            if(!i.equals("Z")){
                answer += i.toInt()
                num = i.toInt()
            }else{
                answer -= num
            }
        }
        return answer
    }
}
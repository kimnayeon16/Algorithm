class Solution {
    fun solution(n: Int): Set<Int> {
        var answer = mutableSetOf<Int>()
        var newN = n
        
        var cnt = 2
        while(newN != 1){
            if(newN % cnt == 0){
                answer.add(cnt)
                newN /= cnt
            }else{
              cnt++  
            }
        }
        println(answer)
        return answer
    }
}
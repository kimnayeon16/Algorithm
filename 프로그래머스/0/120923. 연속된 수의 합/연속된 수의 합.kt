class Solution {
    fun solution(num: Int, total: Int): IntArray {
        var answer: IntArray = IntArray(num)
        
        var n = 0
        while(true){
            var sum = 0
            
            for(i in n until num+n){
                sum += i
            }
            
            if(sum == total) break
            else if(sum > total) n--
            else n++
        }
        
        var idx = 0
        for(i in n until n+num){
            answer[idx++] = i
        }
        println(n)
        
        return answer
    }
}
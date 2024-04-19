class Solution {
    fun solution(arr: IntArray): Int {
        var answer: Int = 0
        var arrays = arr
        
        
        while(true){
            answer++
            var cnt = 0
            for((idx, array) in arrays.withIndex()){
                if(array >= 50 && array % 2 == 0){
                    arrays[idx] = array / 2
                    cnt++
                }else if(array < 50 && array % 2 == 1){
                    arrays[idx] = array * 2 + 1
                    cnt++
                }
            }
            
            if(cnt == 0){
                return answer-1
            }
        }
        
        return answer
    }
}
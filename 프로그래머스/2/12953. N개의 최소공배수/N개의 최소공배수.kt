class Solution {
    fun solution(arr: IntArray): Int {
        var answer = 0
        var arrSorted = arr.sorted()
        var max = arrSorted[arrSorted.size-1]
        println(max)
        
        var cnt = 0
        var num = 1
        while(cnt != arrSorted.size-1){
            // println("비교 값 ${max*num}")
            cnt = 0
            for(i in 0 until arrSorted.size-1){
                if((num * max) % arrSorted[i] == 0){
                    cnt++
                }else{
                    break
                }
            }
            // println(cnt)
            num++
        }
        answer = (num-1) * max
        return answer
    }
}
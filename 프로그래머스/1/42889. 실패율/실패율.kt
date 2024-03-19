class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = intArrayOf()
        
        var num = stages.size
        var outNum = 0
        
        var map = HashMap<Int, Double>()
        
        for(i in 1..N){
            var cnt = -outNum
            stages.forEach{ stage ->
                if(stage <= i){
                    cnt++
                }
            }
            
            if(num != 0){
                map[i] = cnt.toDouble()/num
                println("$cnt / $num")
                num -= cnt
                outNum += cnt
            }else{
                map[i] = 0.0
            }
            
            
            
        }
        println(map)
        var sortedByValue = map.toList().sortedWith(compareByDescending ({it.second})).toMap()
        
        for((key, value) in sortedByValue){
            answer += key
        }
        println(sortedByValue)
        return answer
    }
}
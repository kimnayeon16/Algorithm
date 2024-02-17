class Solution {
    fun solution(myString: String): IntArray {
        var answer: IntArray = intArrayOf()
        var cnt: Int = 0
        
        for(i in 0 until myString.length){
            if(myString[i].toString() == "x"){
                answer += cnt
                cnt = 0
            }else{
                cnt++
            }
        }
        answer += cnt
        return answer
    }
}
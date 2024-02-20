class Solution {
    fun solution(myString: String): String {
        var answer: String = ""
        for(i in 0 until myString.length){
            if(myString[i].toString() < "l"){
                answer += "l"
            }else{
                answer += myString[i].toString()
            }
        }
        return answer
    }
}
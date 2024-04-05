class Solution {
    fun solution(myString: String, pat: String): String {
        var answer: String = ""
        
        var reverse = myString.reversed()
        var rePat = pat.reversed()
        for(i in 0 .. reverse.length - pat.length){
            if(reverse.substring(i, i+rePat.length) == rePat){
                answer += reverse.substring(i, reverse.length)
                break
            }
        }
        return answer.reversed()
    }
}
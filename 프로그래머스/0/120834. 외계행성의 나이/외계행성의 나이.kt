class Solution {
    fun solution(age: Int): String {
        var alpha: Array<String> = arrayOf("a","b","c","d","e","f","g","h","i","j")
        var answer: String = ""
        var strAge = age.toString()
        for(i in 0 until strAge.length){
            println(strAge[i].toString().toInt())
            answer += alpha[strAge[i].toString().toInt()]
        }
        return answer
    }
}
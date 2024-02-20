class Solution {
    fun solution(myString: String): Array<String> {
        var answer = myString.split("x").filter{ it.isNotEmpty()}
        answer = answer.sorted()
       
        return answer.toTypedArray()
    }
}
class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        var answer = arrayOf<String>()
        
        var sortedStrings = strings.sorted()
        
        var a = sortedStrings.toList().sortedBy{ it[n] }
        a.forEach{
            answer += it
        }
        println(a)
        return answer
    }
}
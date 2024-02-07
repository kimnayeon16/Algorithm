class Solution {
    fun solution(my_string: String, num1: Int, num2: Int): String {
        var answer: String = ""
        var stringBuilder = StringBuilder(my_string)
        
        var swap = my_string[num1]
        stringBuilder.setCharAt(num1, stringBuilder[num2])
        stringBuilder.setCharAt(num2, swap)

        return stringBuilder.toString()
    }
}
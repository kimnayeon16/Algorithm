import kotlin.math.abs

class Solution {
    fun solution(numlist: IntArray, n: Int): IntArray {
        var answer: IntArray = IntArray(numlist.size)
        
        answer = numlist.sortedWith(compareBy<Int>{ abs(it - n)}.thenByDescending {it}).toIntArray()

      
        return answer
    }
}
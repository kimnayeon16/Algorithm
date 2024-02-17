class Solution {
    fun solution(arr: IntArray, delete_list: IntArray): IntArray {
        val answer = arr.filter { !delete_list.contains(it) }.toIntArray()
        return answer
    }
}
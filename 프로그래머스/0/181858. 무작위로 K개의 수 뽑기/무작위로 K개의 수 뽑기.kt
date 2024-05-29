class Solution {
    fun solution(arr: IntArray, k: Int): IntArray {
        var answer = IntArray(k, {-1})
        var sortedArr = arr.sorted()
        
        var idx = 0
        
        arr.forEach {
            if(idx < k && !answer.contains(it)){
                answer[idx++] = it
            }
        }
        return answer
    }
}
class Solution {
    fun solution(n: Int, numlist: IntArray): MutableList<Int> {
        var answer: MutableList<Int> = mutableListOf()
        
        for(i in numlist){
            if(i % n == 0){
                answer.add(i)
            }
        }
        return answer
    }
}
class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 0
        numbers.sort()
        if(numbers[0] * numbers[1] > numbers[numbers.size-1] * numbers[numbers.size-2]){
            answer = numbers[0] * numbers[1]
        }else{
            answer = numbers[numbers.size-1] * numbers[numbers.size-2]
        }
        return answer
    }
}
class Solution {
    fun solution(hp: Int): Int {
        var answer: Int = 0
        var newHp = hp
        answer += newHp / 5
        newHp %= 5
        answer += newHp / 3
        newHp %= 3
        answer += newHp
        return answer
    }
}
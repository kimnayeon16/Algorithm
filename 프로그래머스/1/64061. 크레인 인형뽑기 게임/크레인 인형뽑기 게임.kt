import java.util.*

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        var stack = Stack<Int>()
        
        for(move in moves){
            var moving = move - 1 //인덱스
            for(m in 0 until board.size){
                if(board[m][moving] != 0){
                    if(stack.isNotEmpty() && board[m][moving] == stack.peek()){
                        stack.pop()
                        answer += 2
                    }else{
                        stack.add(board[m][moving])
                    }
                    board[m][moving] = 0
                    break
                }
            }
        }
        return answer
    }
}
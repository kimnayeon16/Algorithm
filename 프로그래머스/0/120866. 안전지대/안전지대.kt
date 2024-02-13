import java.util.*

class Solution {
    var dx = arrayOf(-1, -1, -1, 0, 1, 1, 1, 0)
    var dy = arrayOf(-1, 0, 1, 1, 1, 0, -1, -1)
    
    fun solution(board: Array<IntArray>): Int {
        var answer: Int = 0
        var queue: Queue<IntArray> = LinkedList()
        
        println(board.size)
        println(board[0].size)
        
        for(i in 0 until board.size){
            for(j in 0 until board[0].size){
                if(board[i][j] == 1){
                    val array1 = intArrayOf(i,j)
                    queue.add(array1)
                }
            }
        }
        
        val size = queue.size
        for(i in 0 until size){
            val removedArray = queue.poll()
            
            for(d in 0 until 8){
                val nx = dx[d] + removedArray[0]
                val ny = dy[d] + removedArray[1]
                
                if(0<=nx && nx < board.size && 0<=ny && ny < board[0].size && board[nx][ny] == 0){
                    board[nx][ny] = 1
                }
            }
        }
        
        for(i in 0 until board.size){
            for(j in 0 until board[0].size){
                if(board[i][j] == 0){
                    answer++
                }
            }
        }
        return answer
    }
    
}
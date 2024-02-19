import java.util.*


class Solution {
    val size = 5
    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)
    
    
    fun solution(places: Array<Array<String>>): IntArray {
        var ans = mutableListOf<Int>()

        places.forEach { place ->
            val result = obeyDistance(place)
            ans.add(result)
        }
        var answer: IntArray = ans.toIntArray()

        return answer
    }
    fun obeyDistance(place: Array<String>): Int {
        for (i in place.indices) {
            for (j in 0 until place[i].length) {
                val cur = place[i][j]
                if (cur == 'P') {
                    if (!bfs(place, i, j)) {
                        return 0
                    }
                }
            }
        }
        return 1
    }

    fun bfs(place: Array<String>, startX: Int, startY: Int): Boolean {
        val q: Queue<Int> = LinkedList<Int>()
        q.add(startX)
        q.add(startY)
        val board: Array<Array<Int>> = Array(5) { Array(5) { 0 } }
        
        while(!q.isEmpty()) {
            val curX = q.poll()
            val curY = q.poll()
            var distance = board[curX][curY] + 1
           
          
            if (distance > 2) {
                return true
            }
            
            for (i in 0..3) {
                val nx = curX + dx[i]
                val ny = curY + dy[i]
                
                if (!isIn(nx, ny)) { continue }
                
                if (nx == startX && ny == startY) { continue } 
                
                if (place[nx][ny] != 'X' && board[nx][ny] == 0) {
                    q.add(nx) 
                    q.add(ny)
                    board[nx][ny] = distance
                }
                
                if (place[nx][ny] == 'P' && board[nx][ny] <= 2) {
                    return false
                }
            }
        }
        return true
    }
    private fun isIn(x: Int, y: Int): Boolean = (x >= 0 && x < size && y >= 0 && y < size) 
}
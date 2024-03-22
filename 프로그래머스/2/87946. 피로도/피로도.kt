import kotlin.math.max

class Solution {
    lateinit var visited : BooleanArray
    var answer: Int = -1
    lateinit var dungeon :Array<IntArray>
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        visited = BooleanArray(dungeons.size)
        dungeon = dungeons
        for(i in 0 until dungeons.size){
            if(!visited[i] && k >= dungeon[i][0]){
                dfs(k-dungeon[i][1], i, 1)
            }
            visited[i] = false
        }
        return answer
    }
    
    fun dfs(hp: Int, now: Int, cnt: Int){
        visited[now] = true
        answer = max(cnt, answer)
        
        for(i in 0 until visited.size){
            if(!visited[i] && hp - dungeon[i][0] >= 0){
                dfs(hp-dungeon[i][1], i, cnt+1)
            }
        }
        visited[now] = false
    }
}
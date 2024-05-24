import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

val n = readln().toInt()
var array = Array(n){ IntArray(n) }
var dp = Array(n){ IntArray(n) }

var dx = intArrayOf(0,1,0,-1)
var dy = intArrayOf(1,0,-1,0)

fun main() {
    var answer = 0
    for(i in 0 until n){
        array[i] = readln().split(" ").map{it.toInt()}.toIntArray()
    }

    //전체 구역 탐색
    for(i in 0 until n){
        for(j in 0 until n){
            answer = max(answer, dfs(i,j))
        }
    }
    println(answer)
}

fun dfs(i: Int, j: Int): Int{

    if(dp[i][j] != 0) return dp[i][j]

    dp[i][j] = 1

    var nx = 0
    var ny = 0
    for(d in 0 until 4){
        nx = dx[d] + i
        ny = dy[d] + j

        if(nx in 0 until n && ny in 0 until n){
            if(array[i][j] < array[nx][ny]){
                dp[i][j] = Math.max(dp[i][j], dfs(nx,ny)+1)

            }
        }
    }
    return dp[i][j]
}
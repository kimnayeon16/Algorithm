import java.util.LinkedList
import java.util.Queue

private var n = 0
private var k = 0
private lateinit var map: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private var list =  ArrayList<Virus>()
private var s = 0

private var dx = arrayOf(1, 0, -1, 0)
private var dy = arrayOf(0, 1, 0, -1)

private class Virus(var virusNum: Int, var x: Int, var y: Int, var cnt: Int) : Comparable<Virus> {
    override fun compareTo(other: Virus): Int {
        return this.virusNum - other.virusNum
    }
}


fun main(){
    var(N, K) = readln().split(" ").map{ it.toInt() }
    n = N
    k = K

    map = Array(N) { IntArray(N) }
    visited = Array(N) { BooleanArray(N) }

    for(i in 0 until N){
        var input = readln().split(" ").toTypedArray().map{ it.toInt() }
        map[i] = input.toIntArray()
    }

    var (S, x, y) = readln().split(" ").map{ it.toInt() }
    s = S

    for(i in 0 until N){
        for(j in 0 until N){
            if(map[i][j] != 0){
                list.add(Virus(map[i][j], i, j, 0))
            }

        }
    }
    list.sort()

    bfs()
    println(map[x-1][y-1])
}

fun bfs(){
    var queue:Queue<Virus> = LinkedList(list)

    while(queue.isNotEmpty()){
        var tmp = queue.poll()

        if(tmp.cnt == s){
            break
        }

        for(d in 0 until 4){
            var nx = dx[d] + tmp.x
            var ny = dy[d] + tmp.y

            if(nx<0 || nx>=n || ny<0 || ny>=n) continue

            if(map[nx][ny] == 0){
                map[nx][ny] = tmp.virusNum
                queue.add(Virus(map[nx][ny], nx, ny, tmp.cnt+1))
            }
        }
    }
}
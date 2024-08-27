import java.util.LinkedList
import java.util.Queue

var N = 0
var M = 0
lateinit var map: Array<IntArray>

class MyNode(val x: Int, val y: Int)

var nx = arrayOf(0, 1, 0, -1);
var ny = arrayOf(1, 0, -1, 0);

var max = 0

fun main(){
    var (n, m) = readln().split(" ").map{ it.toInt() }
    N = n
    M = m
    map = Array(N) { IntArray(M) }

    for(i in 0 until N){
        val row = readln().split(" ").map{ it.toInt() }
        map[i] = row.toIntArray()
    }

    dfs(0)
    println(max)
}

fun dfs(cnt: Int){
    if(cnt == 3){
        bfs()
        return
    }

    for(i in 0 until N){
        for(j in 0 until M){
            if(map[i][j] == 0){
                map[i][j] = 1
                dfs(cnt+1)
                map[i][j] = 0 //원상 복구
            }
        }
    }
}

fun bfs(){
    val queue: Queue<MyNode> = LinkedList()

    for(i in 0 until N){
        for(j in 0 until M){
            if(map[i][j] == 2){
                queue.add(MyNode(i,j))
            }
        }
    }

    var copyMap = map.map{ it.copyOf()}.toTypedArray()

    while(queue.isNotEmpty()){
        var tmp = queue.poll()

        for(d in 0 until 4){
            var dx = nx[d] + tmp.x
            var dy = ny[d] + tmp.y

            if(dx in 0..<N && 0<=dy && dy<M){
                if(copyMap[dx][dy] == 0){
                    copyMap[dx][dy] = 2
                    queue.add(MyNode(dx,dy))
                }
            }
        }
    }
    safeZone(copyMap)
}

fun safeZone(copyMap: Array<IntArray>){
    var cnt = copyMap.sumOf { row -> row.count { it == 0 } }
    max = maxOf(max, cnt)
}
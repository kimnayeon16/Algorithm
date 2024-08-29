import java.util.LinkedList
import java.util.Queue

var L = 0
var R = 0
var C = 0

lateinit var building: Array<Array<CharArray>>
lateinit var visited: Array<Array<BooleanArray>>

var dz = arrayOf(0, 0, 0, 0, 1, -1)
var dx = arrayOf(1, 0, -1 ,0, 0, 0)
var dy = arrayOf(0, 1, 0, -1, 0, 0)

class Node(var floor: Int, var x: Int, var y: Int, var time: Int)

var result = Integer.MAX_VALUE


fun main(){
    while(true){
        var (l, r, c) = readln().split(" ").map{ it.toInt() }
        L = l
        R = r
        C = c

        if(L == 0 && R == 0 && C == 0) return

        result = Integer.MAX_VALUE

        building = Array(L) { Array(R) { CharArray(C) }}
        visited = Array(L) { Array(R) { BooleanArray(C) }}

        var start = IntArray(3){0}
        var end = IntArray(3){0}

        for(l in 0 until L){
            for(r in 0 until R){
                var input = readln()
                for(c in 0 until C){
                    building[l][r][c] = input[c]

                    if(building[l][r][c] == 'S'){
                        start[0] = l
                        start[1] = r
                        start[2] = c
                    }

                    if(building[l][r][c] == 'E'){
                        end[0] = l
                        end[1] = r
                        end[2] = c
                    }
                }
            }
            readln()
        }
        bfs(start[0], start[1], start[2])

        if(result != Integer.MAX_VALUE){
            println("Escaped in $result minute(s).")
        }else{
            println("Trapped!")
        }
    }
}

fun bfs(floor: Int, x: Int, y: Int){
    var queue:Queue<Node> = LinkedList()

    queue.add(Node(floor, x, y, 0))
    visited[floor][x][y] = true

    while(queue.isNotEmpty()){
        var tmp = queue.poll()

        if(building[tmp.floor][tmp.x][tmp.y] == 'E'){
            result = tmp.time
            break
        }

        for(d in 0 until 6){
            var nz = dz[d] + tmp.floor
            var nx = dx[d] + tmp.x
            var ny = dy[d] + tmp.y

            if(nz<0 || nz>=L || nx<0 || nx>=R || ny<0 || ny>=C) continue

            if(!visited[nz][nx][ny] && building[nz][nx][ny] != '#'){
                queue.add(Node(nz, nx, ny, tmp.time+1))
                visited[nz][nx][ny] = true
            }

        }
    }

}
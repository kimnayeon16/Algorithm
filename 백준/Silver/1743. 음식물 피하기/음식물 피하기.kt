import java.util.LinkedList
import java.util.Queue

var nn = 0
var m = 0
var k = 0
lateinit var map: Array<IntArray>
lateinit var visitedd: Array<BooleanArray>
var maxValue = Integer.MIN_VALUE

var dxx = arrayOf(1, 0, -1, 0)
var dyy = arrayOf(0, -1, 0, 1)


class Nodee(var x: Int, var y: Int)

fun main(){
    var (N, M, K) = readln().split(" ").map{ it.toInt() }

    nn = N
    m = M
    k = K

    map = Array (nn+1) { IntArray(m+1) }
    visitedd = Array(nn+1) { BooleanArray(m+1) }

    repeat(K){
        var (a, b) = readln().split(" ").map{ it.toInt() }
        map[a][b] = 1
    }

    for(i in 1 .. nn){
        for(j in 1 .. m){
            if(map[i][j] == 1 && !visitedd[i][j]){
                bfss(i,j)
            }
        }
    }
    println(maxValue)
}

fun bfss(i: Int, j: Int){
    var queue: Queue<Nodee> = LinkedList()
    var cnt = 1

    queue.add(Nodee(i,j))
    visitedd[i][j] = true

    while(queue.isNotEmpty()){
        var tmp = queue.poll()

        for(d in 0 until 4){
            var nx = dxx[d] + tmp.x
            var ny = dyy[d] + tmp.y

            if(0<nx && nx<=nn && 0<ny && ny<=m && !visitedd[nx][ny]){
                if(map[nx][ny] == 1){
                    queue.add(Nodee(nx, ny))
                    visitedd[nx][ny] = true
                    cnt++
                }
            }
        }
    }
    maxValue = maxOf(maxValue, cnt)
}
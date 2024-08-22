fun main(){
    var (N, M) = readln().split(" ").map { it.toInt() }

    var arr = MutableList(N){0}

    for(i in 0 until N){
        arr[i] = readln().toInt()
    }

    var sortArr = arr.sorted()

    var start = 0
    var end = 1

    var min = Integer.MAX_VALUE

    while(start <= end && end < N){
        var dis = sortArr[end] - sortArr[start]

        if(dis >= M){
            min = minOf(min, dis)
            start++
        }else{
            end++
        }
    }

    println(min)

}
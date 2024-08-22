fun main(){
    var (N, S) = readln().split(" ").map{ it.toInt() }
    var arr = readln().split(" ").toTypedArray().map{ it.toInt() }
    var pfNum = MutableList(N+2){ 0 }
    var min = Integer.MAX_VALUE
    
    for(n in 1 ..N){
        pfNum[n] = pfNum[n-1] + arr[n-1]
    }

    var start = 1
    var end = 1

    var sum = pfNum[start]

    while(start <= end && end <= N){

        if(sum >= S){
            min = minOf(min, end-start+1)
            start++
        }else{
            end++
        }
        sum = pfNum[end] - pfNum[start-1]
    }

    if(min == Integer.MAX_VALUE){
        println(0)
    }else{
        println(min)
    }
}
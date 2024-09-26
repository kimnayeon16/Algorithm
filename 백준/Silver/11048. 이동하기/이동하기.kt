fun main(){
    var (N, M) = readln().split(" ").map{ it.toInt()}
    var arr = Array(N+1){ IntArray(M+1) }
    var dp = Array(N+1){ IntArray(M+1) }

    for(i in 1 ..N){
        var input = "0 " + readln()
        arr[i] = input.split(" ").map{ it.toInt() }.toIntArray()
    }

    dp[0][0] = arr[0][0]

    for(i in 1 .. N){
        for(j in 1 .. M){
            dp[i][j] = maxOf(dp[i-1][j-1], maxOf(dp[i-1][j], dp[i][j-1])) + arr[i][j]
        }
    }
    println(dp[N][M])
}
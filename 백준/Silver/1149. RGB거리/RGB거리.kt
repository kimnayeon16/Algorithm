fun main(){
    var N = readln().toInt()

    var arr = Array(N){ IntArray(3) }
    var dp = Array(N){ IntArray(3) }

    var result = Integer.MAX_VALUE

    for(i in 0 until N){
        arr[i] = readln().split(" ").map{ it.toInt() }.toIntArray()
    }

    dp[0] = arr[0].clone()

    for(n in 1 until N){
        dp[n][0] = minOf(dp[n-1][1], dp[n-1][2]) + arr[n][0]
        dp[n][1] = minOf(dp[n-1][0], dp[n-1][2]) + arr[n][1]
        dp[n][2] = minOf(dp[n-1][0], dp[n-1][1]) + arr[n][2]
    }

    for(n in 0 until 3){
        result = minOf(result, dp[N-1][n])
    }
    println(result)

}
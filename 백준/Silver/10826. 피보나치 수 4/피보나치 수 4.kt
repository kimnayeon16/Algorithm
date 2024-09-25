import java.math.BigInteger

fun main(){
    var n = readln().toInt()

    var dp = Array(n+1){ BigInteger.ZERO }

    if(n == 0 || n == 1){
        println(n)
        return
    }

    dp[1] = BigInteger.ONE

    for(i in 2 .. n){
        dp[i] = dp[i-1].add(dp[i-2])
    }
    println(dp[n])
}
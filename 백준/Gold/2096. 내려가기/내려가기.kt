fun main(){
    var N = readln().toInt()

    var arr = Array(N){ IntArray(3) }
    var maxArr = Array(N){ IntArray(3) }
    var minArr = Array(N){ IntArray(3) }

    var max = Integer.MIN_VALUE
    var min = Integer.MAX_VALUE

    for(i in 0 until N){
        arr[i] = readln().split(" ").map{ it.toInt() }.toIntArray()
    }

    maxArr[0] = arr[0].clone()
    minArr[0] = arr[0].clone()

    for(n in 1 until N){
        //0열
        maxArr[n][0] = maxOf(maxArr[n-1][0], maxArr[n-1][1]) + arr[n][0]
        minArr[n][0] = minOf(minArr[n-1][0], minArr[n-1][1]) + arr[n][0]

        //1열
        maxArr[n][1] = maxOf(maxArr[n-1][0], maxOf(maxArr[n-1][1], maxArr[n-1][2])) + arr[n][1]
        minArr[n][1] = minOf(minArr[n-1][0], minOf(minArr[n-1][1], minArr[n-1][2])) + arr[n][1]

        //2열
        maxArr[n][2] = maxOf(maxArr[n-1][1], maxArr[n-1][2]) + arr[n][2]
        minArr[n][2] = minOf(minArr[n-1][1], minArr[n-1][2]) + arr[n][2]

    }

    for(i in 0 until 3){
        max = maxOf(max, maxArr[N-1][i])
        min = minOf(min, minArr[N-1][i])
    }
    println("$max $min")
}
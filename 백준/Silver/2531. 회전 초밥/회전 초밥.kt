fun main(){
    var(N, d, k, c) = readln().split(" ").map { it.toInt() }
    var list = mutableListOf<Int>()
    var result = 0

    repeat(N){
        list.add(readln().toInt())
    }

    for(i in 0 until N){
        var count = MutableList(d+1){0}
        var bobCount = 0

        for(j in 0 until k){
            count[list[(i+j) % N]]++
        }
        count[c]++

        for(a in 1..d){
            if(count[a] != 0){
                bobCount++
            }
        }
        result = maxOf(result, bobCount)

    }

    println(result)
}
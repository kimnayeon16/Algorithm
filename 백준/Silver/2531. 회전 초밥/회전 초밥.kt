fun main(){
    var(N, d, k, c) = readln().split(" ").map { it.toInt() }
    var sushiBelt = MutableList(N){0}
    var sushi = MutableList(d + 1){0}

    var cnt = 0

    for(i in 0 until N){
        sushiBelt[i] = readln().toInt()
    }

    //최초의 k개의 벨트에 대해서 접시 확인
    for(j in 0 until k){
        if(sushi[sushiBelt[j]] == 0) cnt++
        sushi[sushiBelt[j]]++
    }
    var max = cnt

    for(n in 0 until N){
        if(max <= cnt){
            if(sushi[c] == 0){
                max = cnt+1
            }else{
                max = cnt
            }
        }

        //첫번째 접시 빼기
        sushi[sushiBelt[n]]--
        if(sushi[sushiBelt[n]] == 0) cnt--

        //접시 추가하기
        if(sushi[sushiBelt[(n + k) % N]] == 0) cnt++
        sushi[sushiBelt[(n + k) % N]]++
    }
    println(max)
}
import java.util.Arrays

fun main(){
    var(N, M) = readln().split(" ").map{ it.toInt() }
    var result = StringBuilder()

    var A = readln().split(" ").toTypedArray().map{ it.toInt() }
    var B = readln().split(" ").toTypedArray().map{ it.toInt() }

    var sortedA = A.sorted()
    var sortedB = B.sorted()



    var a = 0
    var b = 0
    while(a<N && b<M){
        if(sortedA[a] > sortedB[b]){
            result.append(sortedB[b++]).append(" ")
        }else{
            result.append(sortedA[a++]).append(" ")
        }
    }

    if(a == N){
        for(i in b until M){
            result.append(sortedB[i]).append(" ")
        }
    }else{
        for(i in a until N){
            result.append(sortedA[i]).append(" ")
        }
    }

    println(result)
}
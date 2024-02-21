fun main(){
    val k = readln().toInt()
    var answer = 0
    var array = ArrayDeque<Int>()

    for(i in 1..k){
        var n = readln().toInt()
        if(n == 0){
           array.removeLast()
        }else{
            array.add(n)
        }
    }

    for(i in 0 until array.size){
        answer += array.removeFirst()
    }
    println(answer)
}
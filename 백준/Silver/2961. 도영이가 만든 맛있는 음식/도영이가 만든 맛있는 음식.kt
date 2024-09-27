import kotlin.math.abs

var nums = 0
lateinit var cooks: Array<IntArray>
lateinit var visiteds: BooleanArray
var min = Integer.MAX_VALUE

fun main(){
    nums = readln().toInt()

    cooks = Array(nums){ IntArray(2) }
    visiteds = BooleanArray(nums)

    for(i in 0 until nums){
        cooks[i] = readln().split(" ").map{ it.toInt() }.toIntArray()
    }

    getCook(0)
    println(min)
}

fun getCook(cnt: Int){
    if(nums == cnt){
        min = minOf(min, getTaste())
        return
    }
    visiteds[cnt] = true
    getCook(cnt+1)

    visiteds[cnt] = false
    getCook(cnt+1)
}

fun getTaste() :Int{
    var bitter = 0
    var sour = 1

    for(i in 0 until nums){
        if(visiteds[i]){
            sour *= cooks[i][0]
            bitter += cooks[i][1]
        }
    }

    if(bitter==0 && sour==1) {
        return Integer.MAX_VALUE
    }
    return abs(sour-bitter)
}
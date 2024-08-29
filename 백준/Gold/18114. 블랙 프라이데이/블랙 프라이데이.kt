fun main(){
    var (N, C) = readln().split(" ").map{ it.toInt() }
    var things = readln().split(" ").map{ it.toInt() }.toIntArray()

    things.sort()

    //물건 한 개
    if(things.contains(C)){
        println("1")
        return
    }

    var start = 0
    var end = N - 1

    while(start < end){
        var sum = things[start] + things[end]

        if(sum == C){
            println("1")
            return
        }else if(sum > C){
            end--
        }else{
            //물건 3가지로 되는지 확인
            var s = start+1
            var e = end-1
            var sumValue = C - sum

            while(s <= e){
                var mid = (s + e) / 2

                if(things[mid] == sumValue){
                    println("1")
                    return
                }else if(things[mid] > sumValue){
                    e = mid-1
                }else{
                    s = mid+1
                }
            }
            start++
        }
    }

    println("0")
}
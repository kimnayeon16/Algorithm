import java.util.Arrays

fun main(){
    var N = readln().toInt()
    var M = readln().toInt()
    var nums = readln().split(" ").map{ it.toInt() }.toTypedArray()

    var cnt = 0
    Arrays.sort(nums)

    var start = 0
    var end = nums.size - 1

    while(start < end){
        var sum = nums[start] + nums[end]
        if(sum == M){
            cnt++
            start++
            end--
        }else{
            if(sum > M){
                end--;
            }else{
                start++;
            }
        }
    }
    println(cnt)
}
class Solution {
    fun solution(arr: Array<IntArray>): Int {
        for(i in 0 until arr.size-1){
            if(arr[i][i+1] != arr[i+1][i]){
                return 0
            }
        }
        return 1
    }
}
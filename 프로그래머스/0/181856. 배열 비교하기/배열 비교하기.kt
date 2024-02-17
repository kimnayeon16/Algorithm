class Solution {
    fun solution(arr1: IntArray, arr2: IntArray): Int {
        var answer: Int = 0
        
        println(arr1.sum())
        
        if(arr1.size < arr2.size){
            return -1
        }else if(arr1.size > arr2.size){
            return 1
        }else{
            if(arr1.sum() > arr2.sum()) return 1
            else if(arr1.sum() < arr2.sum()) return -1
            else return 0
        }
    }
}
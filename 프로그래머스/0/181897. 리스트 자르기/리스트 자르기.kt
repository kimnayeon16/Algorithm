class Solution {
    fun solution(n: Int, slicer: IntArray, num_list: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        
        var list: List<Int> = num_list.asList()
        
        if(n == 1){
            list = list.slice(0 .. slicer[1])
        }else if(n == 2){
            list = list.slice(slicer[0] .. list.size-1)
        }else if(n == 3){
            list = list.slice(slicer[0] .. slicer[1])
        }else{
            list = list.slice(slicer[0] .. slicer[1] step slicer[2])
        }
        
        answer = list.toIntArray()
        return answer
    }
}
class Solution {
    fun solution(num_list: IntArray, n: Int): Array<IntArray> {
        var answer: Array<IntArray> = arrayOf<IntArray>()
        
        var rows = num_list.size / n
        var cols = n
        var array = Array(rows){ IntArray(cols) }
        var idx = 0
        for(r in 0 until rows){
            for(c in 0 until cols){
                array[r][c] = num_list[idx++]
            }
        }
        return array
    }
}
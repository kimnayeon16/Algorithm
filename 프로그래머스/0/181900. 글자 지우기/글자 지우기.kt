class Solution {
    fun solution(my_string: String, indices: IntArray): String {
        var answer: String = ""
        var indicesort = indices.sortedDescending().toIntArray()
        
        val array = ArrayList<Char>()
        for(i in 0 until my_string.length){
            array.add(my_string[i])
        }
        for(idx in indicesort){
            array.removeAt(idx)
        }
        
        for(element in array){
            answer += element
        }
        return answer
    }
}
class Solution {
    fun isNum(str: String): Boolean{
        return try{
            str.toInt()
            true
        }catch(e: NumberFormatException){
            false
        }
    }
    
    fun solution(my_string: String): ArrayList<Int> {
        var answer = ArrayList<Int>() 
        
        for(i in 0 until my_string.length){
            if(isNum(my_string[i].toString())){
                answer.add(my_string[i].toString().toInt())
            }
        }
        answer.sort()
        return answer
    }
}
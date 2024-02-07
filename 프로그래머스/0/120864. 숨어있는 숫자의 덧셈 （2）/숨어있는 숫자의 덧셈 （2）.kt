class Solution {
    fun isNum(str: String): Boolean {
        return try{
            str.toInt()
            true
        }catch(e: NumberFormatException){
            false
        }
    }
    fun solution(my_string: String): Int {
        var answer: Int = 0
        var num = StringBuilder()
        for(i in 0 until my_string.length){
            if(isNum(my_string[i].toString())){
                num.append(my_string[i])
            }else{
                if(num.length != 0){
                    answer += num.toString().toInt()
                    num.clear()
                }
                
            }
        }
        
        if(num.length != 0){
            answer += num.toString().toInt()
        }
        return answer
    }
}
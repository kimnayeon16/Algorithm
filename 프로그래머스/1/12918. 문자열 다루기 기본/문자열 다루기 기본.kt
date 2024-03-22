class Solution {
    fun solution(s: String): Boolean {
        if(isNum(s)){
            if(s.length == 4 || s.length == 6){
                return true
            }else{
                return false
            }
        }else{
            return false
        }
    }
    
    fun isNum(s: String): Boolean {
        return try{
            s.toInt()
            true
        }catch(e: NumberFormatException){
            false
        }
    }
}
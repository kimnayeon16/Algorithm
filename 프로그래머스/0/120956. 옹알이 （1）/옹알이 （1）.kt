class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        
        var baby = arrayOf("aya", "ye", "woo", "ma")
        
        for(i in 0 until babbling.size){
            for(j in 0 until baby.size){
                if(babbling[i].contains(baby[j])){
                    babbling[i] = babbling[i].replace(baby[j], "1")
                }
            }
            if(isNum(babbling[i])){
                answer++
            }
        }
        return answer
    }
    
    fun isNum(s: String): Boolean{
        return try{
            s.toInt()
            true
        }catch(e: NumberFormatException){
            false
        }
    }
}
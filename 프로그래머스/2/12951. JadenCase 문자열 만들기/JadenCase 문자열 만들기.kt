class Solution {
    fun solution(s: String): StringBuilder {
        var answer = StringBuilder()
        
        
        var words = s.split(" ")
        println(words)
        words.forEach{
            println(it)
            if(it.length == 0){
                answer.append(" ")
            }else{
                if(!isNum(it[0].toString())){
                    answer.append(it[0].toUpperCase())
                }else{
                    answer.append(it[0])
                }

                for(i in 1 until it.length){
                    answer.append(it[i].toLowerCase())
                }
                answer.append(" ")
                }
        }
        
        answer.delete(answer.length-1, answer.length)
        return answer
    }
    
    fun isNum(c: String): Boolean{
        return try{
            c.toInt()
            true
        }catch(e: NumberFormatException){
            false
        }
    }
}
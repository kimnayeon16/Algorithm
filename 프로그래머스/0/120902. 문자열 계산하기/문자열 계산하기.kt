class Solution {
    fun isNum(str: String): Boolean{
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
        var plus: Boolean = true
        
        for(i in my_string){
            if(i == ' '){
                continue
            }else{
                if(isNum(i.toString())){
                    num.append(i.toString())
                }else{
                    if(plus){
                        answer += num.toString().toInt()
                    }else{
                        answer -= num.toString().toInt()
                    }
                    
                    if(i == '+') plus = true
                    else plus = false
                    num.clear()
                }
            } 
        }
        
        if(plus){
            answer += num.toString().toInt()
        }else{
            answer -= num.toString().toInt()
        }
        
        
        return answer
    }
}
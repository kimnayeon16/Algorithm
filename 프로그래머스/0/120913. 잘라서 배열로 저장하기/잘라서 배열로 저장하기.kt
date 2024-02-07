class Solution {
    fun solution(my_str: String, n: Int): ArrayList<String> {
        var answer = ArrayList<String>()
        
        var len = 0
        if(my_str.length % n == 0){
            len = my_str.length / n
        }else{
            len = my_str.length / n + 1
        }
        
        for(i in 0 until len){
            var sb = StringBuilder()
            for(j in i*n until i*n+n){
                sb.append(my_str[j])
                
                if(j+1 == my_str.length){
                    break
                }
            }
            answer.add(sb.toString())
            sb.clear()
            
        }
        
        
        return answer
    }
}
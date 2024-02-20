class Solution {
    fun solution(myStr: String): Array<String> {
        var str = myStr
        
        str = str.replace("a", ",")
        str = str.replace("b", ",")
        str = str.replace("c", ",")
        
        var answer = str.split(",").filter{ it.isNotEmpty() }
        
        if(answer.size != 0){
            return answer.toTypedArray()
        }else{
            answer += "EMPTY"
            return answer.toTypedArray()
        }
    }
}
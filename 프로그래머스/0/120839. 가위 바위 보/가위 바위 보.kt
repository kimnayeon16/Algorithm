class Solution {
    fun solution(rsp: String): String {
        var answer: String = ""
        for(i in 0 until rsp.length){
            if(rsp.substring(i,i+1).equals("2")){
                answer += "0"
            }else if(rsp.substring(i,i+1).equals("0")){
                answer += "5"
            }else{
                answer += "2"
            }
        }
        return answer
    }
}
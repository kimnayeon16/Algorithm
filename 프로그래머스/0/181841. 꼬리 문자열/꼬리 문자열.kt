class Solution {
    fun solution(str_list: Array<String>, ex: String): String {
        var answer: String = ""
        
        for(element in str_list){
            if(!element.contains(ex)){
                answer += element
            }
        }
        return answer
    }
}
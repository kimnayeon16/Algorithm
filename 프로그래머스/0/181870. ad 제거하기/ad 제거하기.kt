class Solution {
    fun solution(strArr: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        for(element in strArr){
            if(!element.contains("ad")){
                answer+= element
            }
        }
        return answer
    }
}
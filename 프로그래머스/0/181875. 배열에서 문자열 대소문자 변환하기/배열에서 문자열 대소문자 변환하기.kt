class Solution {
    fun solution(strArr: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        var idx = 0
        for(element in strArr){
            if(idx % 2 == 0){
                answer += element.toLowerCase()
            }else{
                answer += element.toUpperCase()
            }
            idx++
        }
        return answer
    }
}
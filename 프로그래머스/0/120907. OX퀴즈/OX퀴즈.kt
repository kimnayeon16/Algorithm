class Solution {
    fun solution(quiz: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        
        for(element in quiz){
            var list: List<String> = element.split(" ")
            var isPlus: Boolean = true
            var sum: Int = 0
            
            if(list[1] == "+"){
                sum = list[0].toInt() + list[2].toInt()
            }else{
                sum = list[0].toInt() - list[2].toInt()
            }
            
            if(sum == list[4].toInt()){
                answer += "O"
            }else{
                answer += "X"
            }
        }
        return answer.toTypedArray()
    }
}
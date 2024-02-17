class Solution {
    fun solution(todo_list: Array<String>, finished: BooleanArray): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        
        for(element in 0 until finished.size){
            if(!finished[element]){
                answer += todo_list[element]
            }
        }
        return answer
    }
}
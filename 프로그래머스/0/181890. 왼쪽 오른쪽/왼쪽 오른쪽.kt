class Solution {
    fun solution(str_list: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        
        if(str_list.size == 1){
            return answer
        }else{
            for((index, element) in str_list.withIndex()){
                if(element == "l"){
                    for(i in 0 until index){
                        answer += str_list[i]
                    }
                    break
                }else if(element == "r"){
                    for(i in index+1 until str_list.size){
                        answer += str_list[i]
                    }
                    break
                }
            }
        }
        return answer
    }
}
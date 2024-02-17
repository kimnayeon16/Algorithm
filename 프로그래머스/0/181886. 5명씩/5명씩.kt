class Solution {
    fun solution(names: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        var rep: Int = 0
        
        if(names.size % 5 == 0){
            rep = names.size / 5
        }else{
            rep = names.size / 5 + 1
        }
        
        for(i in 0 until rep){
            answer += names[i*5]
        }
        return answer
    }
}
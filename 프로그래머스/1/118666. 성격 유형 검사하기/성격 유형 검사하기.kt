class Solution {
    fun solution(survey: Array<String>, choices: IntArray): StringBuilder {
        var answer = StringBuilder()
        
        var map = HashMap<String, Int>()
        var alpha = arrayOf("R", "T", "C", "F", "J", "M", "A", "N")
        var score = arrayOf(0, 3, 2, 1, 0, 1, 2, 3)
        map["R"] = 0
        map["T"] = 0
        map["C"] = 0
        map["F"] = 0
        map["J"] = 0
        map["M"] = 0
        map["A"] = 0
        map["N"] = 0
        
        for((index, element) in survey.withIndex()){
            if(choices[index] > 4){
                map[element[1].toString()] = map.getOrDefault(element[1].toString(), 0) + score[choices[index]]
            }else if(choices[index] < 4){
                map[element[0].toString()] = map.getOrDefault(element[0].toString(), 0) + score[choices[index]]
            }
            // if(choices[index] > 4){
            //     map[element[1].toString()] = map.getOrDefault(element[1].toString(), 0) + choices[index] / 5 + choices[index] % 5
            // }else if(choices[index] < 4){
            //     map[element[0].toString()] = map.getOrDefault(element[0].toString(), 0) + choices[index] / 3 + choices[index] % 3
            // }
        }
        
        for(i in 0 until 4){
            var val1 = map[alpha[i*2]] ?: 0
            var val2 = map[alpha[i*2+1]] ?: 0
            if(val1 > val2){
                answer.append(alpha[i*2])
            }else if(val1 < val2){
                answer.append(alpha[i*2+1])
            }else{
                if(alpha[i*2] < alpha[i*2+1]){
                    println(alpha[i*2])
                    answer.append(alpha[i*2])
                }else{
                    answer.append(alpha[i*2+1])
                }
            }
        }
        return answer
    }
}
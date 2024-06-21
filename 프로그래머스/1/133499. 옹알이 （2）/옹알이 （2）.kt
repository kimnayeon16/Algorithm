class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
       
        for(i in 0 until babbling.size){
            if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye") || babbling[i].contains("woowoo") || babbling[i].contains("mama")){
                continue
            }
            
            babbling[i] = babbling[i].replace("aya"," ")
            babbling[i] = babbling[i].replace("ye"," ")
            babbling[i] = babbling[i].replace("woo"," ")
            babbling[i] = babbling[i].replace("ma"," ")
            babbling[i] = babbling[i].replace(" ","")
            
            println(babbling[i])
            
            if(babbling[i].length == 0){
                answer++
            }
        }
        return answer
    }
}
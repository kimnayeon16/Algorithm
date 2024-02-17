class Solution {
    fun solution(myString: String, pat: String): Int {
        var answer: Int = 0
        var str = ""
        
        for(i in 0 until myString.length){
            if(myString[i].toString() == "A"){
                str += "B"
            }else{
                str += "A"
            }
        }
        
        if(str.contains(pat)){
            return 1
        }else{
            return 0
        }
    }
}
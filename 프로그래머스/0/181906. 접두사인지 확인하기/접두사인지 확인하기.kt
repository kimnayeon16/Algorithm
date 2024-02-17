class Solution {
    fun solution(my_string: String, is_prefix: String): Int {
        var answer: Int = 0
        
        if(my_string.length >= is_prefix.length){
            var newMyString = my_string.substring(0, is_prefix.length)
            if(newMyString == is_prefix) return 1
            else return 0
        }else{
            return 0
        }
    }
}
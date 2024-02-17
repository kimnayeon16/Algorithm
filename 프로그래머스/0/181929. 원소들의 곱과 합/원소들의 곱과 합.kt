class Solution {
    fun solution(num_list: IntArray): Int {
        var mult: Int = 1
        var add: Int = 0
        
        for(element in num_list){
            mult *= element
            add += element
        }
        
        if(mult < add*add){
            return 1
        }else{
            return 0
        }
    }
}
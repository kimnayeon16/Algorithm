class Solution {
    fun solution(before: String, after: String): Int {
        var afterArray = ArrayList<Char>()
        
        for(i in 0 until after.length){
            afterArray.add(after[i])
        }
        
        for(i in 0 until before.length){
            if(afterArray.contains(before[i])){
                afterArray.remove(before[i])
            }
        }
        if(afterArray.size == 0){
            return 1
        }else{
            return 0
        }
    }
}
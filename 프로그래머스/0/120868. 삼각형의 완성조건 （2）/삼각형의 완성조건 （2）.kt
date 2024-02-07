class Solution {
    fun solution(sides: IntArray): Int {
        var answer: Int = 0
        var array = ArrayList<Int>()
        array.add(sides[0])
        array.add(sides[1])
        
        var max = sides[0] + sides[1]
        
        for(i in 1..max){
            array.add(i)
            array.sort()
            
            if(array.get(0) + array.get(1) > array.get(2)){
                answer++
            }
            array.remove(i)
        }
        
        return answer
    }
}
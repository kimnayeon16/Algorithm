import java.util.*

class Solution {
    fun solution(numbers: IntArray, k: Int): Int {
        var answer: Int = 0
        
        var queue: Queue<Int> = LinkedList()
        for(i in numbers){
            queue.add(i)
        }
        
        for(i in 1 until k){
            queue.add(queue.remove())
            queue.add(queue.remove())
            
            answer = queue.peek()
        }
        return answer
    }
}
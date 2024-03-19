import kotlin.math.abs

class Solution {
    fun solution(numbers: IntArray, hand: String): StringBuilder {
        var answer = StringBuilder()
        
        var map = HashMap<Int, String>()
        map[0] = "3,1"
        map[1] = "0,0"
        map[2] = "0,1"
        map[3] = "0,2"
        map[4] = "1,0"
        map[5] = "1,1"
        map[6] = "1,2"
        map[7] = "2,0"
        map[8] = "2,1"
        map[9] = "2,2"
        map[10] = "3,0"
        map[11] = "3,2"
        
        var left = 10
        var right = 11
        
        for(number in numbers){
            if(number == 1 || number == 4 || number == 7){
                answer.append("L")
                left = number
            }else if(number == 3 || number == 6 || number == 9){
                answer.append("R")
                right = number
            }else{
                var (row, col) = map[number]!!.split(",")
                var (leftRow, leftCol) = map[left]!!.split(",")
                var (rightRow, rightCol) = map[right]!!.split(",")
                
                var leftDistance = distance(leftRow, leftCol, row, col)
                var rightDistance = distance(rightRow, rightCol, row, col)
                
                if(leftDistance > rightDistance){
                    answer.append("R")
                    right = number
                }else if(leftDistance < rightDistance){
                    answer.append("L")
                    left = number
                }else{
                    if(hand == "right"){
                        answer.append("R")
                        right = number
                    }else{
                        answer.append("L")
                        left = number
                    }
                }
            }
        }
        return answer
    }
    
    private fun distance(leftRow: String, leftCol: String, row: String, col: String): Int {
        return abs(leftRow.toInt() - row.toInt()) + abs(leftCol.toInt() - col.toInt())
    }
}
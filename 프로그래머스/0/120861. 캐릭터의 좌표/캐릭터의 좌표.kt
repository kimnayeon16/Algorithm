class Solution {
    var board: IntArray = intArrayOf()
    var answer: IntArray = intArrayOf()
    
    
    fun solution(keyinput: Array<String>, board: IntArray): IntArray {
        this.board = board
        answer = intArrayOf(0,0)
        
        for(element in keyinput){
            move(element)
        }
        return answer
    }
    
    fun move(moving: String){
        if(moving.equals("up")){
            if(answer[1] + 1 <= board[1]/2) answer[1] += 1
        }else if(moving.equals("down")){
            if(answer[1] - 1 >= -board[1]/2) answer[1] -= 1
        }else if(moving.equals("left")){
            if(answer[0] - 1 >= -board[0]/2) answer[0] -= 1
        }else{
            if(answer[0] + 1 <= board[0]/2) answer[0] += 1
        }
    }
}
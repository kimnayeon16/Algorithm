import kotlin.math.min

class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        
        var arr = Array(rows+1, {Array(columns+1, {0})})
        
        var num = 1
        for(i in 1 .. rows){
            for(j in 1 .. columns){
                arr[i][j] = num++
            }
        }
        
        for((index, element) in queries.withIndex()){
            var x1 = element[0]
            var y1 = element[1]
            var x2 = element[2]
            var y2 = element[3]
            
            var temp = arr[x1][y1]
            
            var min = temp
            
            //아래에서 위로 이동
            for(i in x1 until x2){
                arr[i][y1] = arr[i+1][y1]
                min = min(min, arr[i][y1])
            }
            //arr[2][2] = arr[3][2] = 14
            //arr[3][2] = arr[4][2] = 20
            //arr[4][2] = arr[5][2] = 26
            
            //오른쪽에서 왼쪽으로 이동
            for(i in y1 until y2) {
                arr[x2][i] = arr[x2][i+1]
                min = min(min, arr[x2][i])
            }
            //arr[4][2] = arr[4][3] = 27
            //arr[4][3] = arr[4][4] = 28
            
            //위에서 아래로 이동
            for(i in x2 downTo x1+1) {
                arr[i][y2] = arr[i-1][y2]
                min = min(min, arr[i][y2])
            }
            //arr[5][4] = arr[4][4] = 22
            //arr[4][4] = arr[3][4] = 16
            //arr[3][4] = arr[2][4] = 10

            
            //왼쪽에서 오른쪽으로 이동
            for(i in y2 downTo y1+1) {
                arr[x1][i] = arr[x1][i-1]
                min = min(min, arr[x1][i])
            }
            //arr[2][4] = arr[2][3] = 9
            //arr[2][3] = arr[2][2] = 14
            
            //맨 처음 start 끊은 값으로 바꿔주기
            arr[x1][y1+1] = temp

            //최솟값 저장
            answer += min
            
        }
        return answer
    }
}
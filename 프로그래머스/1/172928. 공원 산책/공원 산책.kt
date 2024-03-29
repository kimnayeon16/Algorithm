class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        
        var startRow = 0
        var startCol = 0
        
        var array = Array(park.size, {Array(park[0].length, {""})})
        for((index, p) in park.withIndex()){
            for(i in 0 until p.length){
                array[index][i] = p[i].toString()
                
                if(p[i].toString() == "S"){
                    startRow = index
                    startCol = i
                }
            }
        }
        
        for(route in routes){
            val (direction, number) = route.split(" ")
            var num = number.toInt()
            var check = true
            if(direction == "E"){
                for(i in 1..num){
                    if(startCol+i < array[0].size && array[startRow][startCol+i] != "X"){
                        continue
                    }else{
                        check = false
                        break
                    }
                }
                if(check) startCol += num
                
            }else if(direction == "W"){
                for(i in 1..num){
                    if(startCol-i >= 0 && array[startRow][startCol-i] != "X"){
                        continue
                    }else{
                        check = false
                        break
                    }
                }
                if(check) startCol -= num
                
            }else if(direction == "S"){
                for(i in 1..num){
                    if(startRow+i < array.size && array[startRow+i][startCol] != "X"){
                        continue
                    }else{
                        check = false
                        break
                    }
                }
                if(check) startRow += num
                
            }else{
                for(i in 1..num){
                    if(startRow-i >= 0 && array[startRow-i][startCol] != "X"){
                        continue
                    }else{
                        check = false
                        break
                    }
                }
                if(check) startRow -= num
            }
            println("$startRow , $startCol")
        }
        answer += startRow
        answer += startCol
        return answer
    }
}
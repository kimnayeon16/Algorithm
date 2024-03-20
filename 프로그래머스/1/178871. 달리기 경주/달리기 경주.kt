class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        
        var map = HashMap<String, Int>()
        for((index, player) in players.withIndex()){
            map[player] = index
        }
        
        for(calling in callings){
            //추월한 사람 등수 올리기
            var score = map[calling]!!
            
            var behindPlayer = players[score - 1]
            // println(behindPlayer)
            
            players[score - 1] = calling
            
            players[score] = behindPlayer
            
            
            // players.forEach{
            //     print("$it ")
            // }
            // println()
            
            map[calling] = score - 1
            map[behindPlayer] = score
            
            //추월 당한 사람 등수 내리기
            // val name = map.filterValues {it == score - 1}.keys
            
            // if(name.isNotEmpty()){
            //     map[name.first()] = score
            //     map[calling] = score - 1
            // }
        }
        
        // val sortedMap = map.toList().sortedBy { it.second }.toMap().toMutableMap()
        // for(element in sortedMap){
        //     val(key, value) = element
        //     answer += key
        // }
        return players
    }
}
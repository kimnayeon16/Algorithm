import kotlin.math.max

class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        var answer: Int = 0
        
        var map = HashMap<String, Int>()
        for((index, friend) in friends.withIndex()){
            map[friend] = index
        }
        
        var arr = Array(friends.size, {IntArray(friends.size,{0})})
        
        for(gift in gifts){
            val (givePerson, getPerson) = gift.split(" ")
            var row = map[givePerson] ?: 0
            var col = map[getPerson] ?: 0
            arr[row][col] += 1
        }
        
        //선물 지수 구하기
        val indexs: Array<Int> = Array(friends.size){ 0 }
        //내가 준 선물
        for(i in 0 until friends.size){
            for(j in 0 until friends.size){
                indexs[i] += arr[i][j]
            }
        }
        
        //내가 받은 선물
        for(i in 0 until friends.size){
            for(j in 0 until friends.size){
                indexs[i] -= arr[j][i]
            }
        }
        
        val futureGift: Array<Int> = Array(friends.size) { 0 }
        
        for((index, giveFriend) in friends.withIndex()){
            for((idx, getFriend) in friends.withIndex()){
                if(index <= idx && giveFriend != getFriend){
                    
                    val giveF = map[giveFriend] ?: 0
                    val getF = map[getFriend] ?: 0
                    
                    var person1 = arr[giveF][getF]
                    var person2 = arr[getF][giveF]
                    
                    if(person1 > person2){
                        futureGift[giveF] += 1
                    }else if(person1 < person2){
                        futureGift[getF] += 1
                    }else{
                        if(indexs[index] > indexs[idx]){
                            futureGift[giveF] += 1
                        }else if(indexs[index] < indexs[idx]){
                            futureGift[getF] += 1
                        }
                    }
                }
            }
        }
        
        futureGift.forEach{
            answer = max(it, answer)
        }
        
        return answer
    }
}
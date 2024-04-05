class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        
        var wallpaper2 = Array(wallpaper[0].length, {""})
        
        
        for(i in 0 until wallpaper[0].length){
            for(j in 0 until wallpaper.size){
                wallpaper2[i] += wallpaper[j][i].toString()
            }
        }
        
        
        //위
        for(i in 0 until wallpaper.size){
            if(wallpaper[i].contains("#")){
                answer += i
                break
            }
        }
        
        //왼쪽
        for(i in 0 until wallpaper2.size){
            if(wallpaper2[i].contains("#")){
                answer += i
                break
            }
        }
        
        //아래
        for(i in wallpaper.size-1 downTo 0){
            if(wallpaper[i].contains("#")){
                answer += i+1
                break
            }
        }
        
        //오른쪽
        for(i in wallpaper2.size-1 downTo 0){
            if(wallpaper2[i].contains("#")){
                answer += i+1
                break
            }
        }
        
        
        return answer
    }
}
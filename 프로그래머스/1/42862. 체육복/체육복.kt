class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n - lost.size
        
        var sortedLost = lost.sorted()
        // lost.forEach{
        //     sortedLost.add(it)
        // }
        // sortedLost.sorted()
        // println(sortedLost)
        
        
        var map = HashMap<Int, Int>()
        for(r in reserve){
            map[r] = map.getOrDefault(r, 0) + 1
        }
        for(e in 0..n+1){
            map[e] = map.getOrDefault(e, 0)
        }
        
        //여벌 체육복을 가져온 학생이 체육복 도난당했을 경우 처리
        // for(lost in sortedLost){
        //     if(reserve.contains(lost)){
        //         answer++
        //         map[lost] = map.getOrDefault(lost, 0) - 1
        //         // sortedLost.removeIf{ it == lost }
        //     }
        // }
        val filteredList = sortedLost.filter { !reserve.contains(it) }
        val MeList = sortedLost.filter { reserve.contains(it) }
        // println(filteredList)
        // println(MeList)
        for(m in MeList){
            map[m] = map.getOrDefault(m, 0) - 1
        }
        answer += sortedLost.size - filteredList.size
        sortedLost = filteredList
        
        // println(answer)
        // println(map)
        
        sortedLost.forEach {
            if(map[it-1]!! > 0){
                map[it-1] = map.getOrDefault(it-1, 0) - 1
                answer++
            }else if(map[it+1]!! > 0){
                map[it+1] = map.getOrDefault(it+1, 0) - 1
                answer++
            }
        }
        return answer
    }
}
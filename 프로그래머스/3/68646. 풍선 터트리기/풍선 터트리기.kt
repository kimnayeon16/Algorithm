class Solution {
    fun solution(a: IntArray): Int {
        //양쪽 끝 값은 항상 최후까지 남을 수 있음.
        var answer: Int = 2
        
        var leftMin = IntArray(a.size)
        var rightMin = IntArray(a.size)
        
        var left = a[0]
        var right = a[a.size-1]
        for(i in 1 until a.size-1){
            left = minOf(left, a[i])
            leftMin[i] = left
        }
        
        for(i in a.size-1 downTo 0){
            right = minOf(right, a[i])
            rightMin[i] = right
        }
        
        for(i in 1 until a.size-1){
            //i 기준 양 쪽 값이 둘 다 크면 ans 증가
            if(a[i] < leftMin[i] && a[i] < rightMin[i]) {
                answer++
            //i 기준 양 쪽 값이 둘 다 작으면
            }else if(a[i] > leftMin[i] && a[i] > rightMin[i]){
                continue
            //i 기준 양 쪽 값들 중 하나만 작으면
            }else{
                answer++
            }
        }
        
        return answer
    }
}
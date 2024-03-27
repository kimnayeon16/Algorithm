class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        var outZero = s
        var zeroCnt = 0
        var cnt = 0
        
        while(outZero != "1"){
            //0이 몇 개인지 체크
            zeroCnt += outZero.count{ it == '0'}
            
            //0 모두 제거
            outZero = outZero.replace("0", "")
            
            var len = outZero.length
            
            //2진수로 바꾸기
            outZero = Integer.toBinaryString(len).toString()
          
            //몇 번 반복하는지 체크
            cnt++
        }
        
        answer += cnt
        answer += zeroCnt
        return answer
    }
}
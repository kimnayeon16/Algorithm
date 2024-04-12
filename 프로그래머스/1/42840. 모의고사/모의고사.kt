class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = intArrayOf()
        
        var one = arrayOf(1,2,3,4,5)
        var two = arrayOf(2,1,2,3,2,4,2,5)
        var three = arrayOf(3,3,1,1,2,2,4,4,5,5)
        
        var ans = IntArray(3, {0})
        
        for((idx, answer) in answers.withIndex()){
            //1번 수포자
            if(answer == (one[idx % 5])){
                ans[0]++
            }
            
            //2번 수포자
            if(answer == (two[idx % 8])){
                ans[1]++
            }
            
            //3번 수포자
            if(answer == (three[idx % 10])){
                ans[2]++
            }
        }
        // ans.forEach{print("$it ")}
        
        var max = ans.maxOrNull()
        
        for((idx, a) in ans.withIndex()){
            if(max == a){
                answer += idx+1
            }
        }
        
        return answer
    }
}
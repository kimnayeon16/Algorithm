class Solution {
    fun solution(n: Int, m: Int): IntArray {
        var answer = intArrayOf()
        
        var g = gcd(n, m)
        answer+= g
        
        answer += n * m / g
        
        return answer
    }
    
    fun gcd(n: Int, m: Int): Int{
        return if(n < m){
            if(n == 0) m else gcd(n, m%n)
        }else{
            if(m == 0) n else gcd(m, n%m)
        }
        
    }
}
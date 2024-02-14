class Solution {
    fun solution(chicken: Int): Int {
        var answer: Int = 0
        var newChicken = chicken
        var coupon = chicken
        while(coupon > 9){
            answer += coupon / 10
            coupon = coupon % 10 + coupon / 10
        }
        
        return answer
    }
}
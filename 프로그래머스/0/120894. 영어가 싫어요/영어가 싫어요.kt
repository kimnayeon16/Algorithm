class Solution {
    fun solution(numbers: String): Long {
        val array = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var newNum = numbers
        for(i in 0..9){
            if(newNum.contains(array[i])){
                newNum = newNum.replace(array[i], i.toString())
            }
        }
        return newNum.toLong()
    }
}
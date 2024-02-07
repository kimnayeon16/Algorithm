class Solution {
    fun solution(my_string: String): String {
        var answer: String = ""
        var newString = ""
        var arrayList = ArrayList<Char>()
        for(i in 0 until my_string.length){
            newString += my_string[i].toLowerCase()
        }
        println(newString)
        
        for(i in 0 until newString.length){
            arrayList.add(newString[i])
        }
        arrayList.sort()
        for(i in 0 until arrayList.size){
            answer += arrayList.get(i)
        }
        return answer
    }
}
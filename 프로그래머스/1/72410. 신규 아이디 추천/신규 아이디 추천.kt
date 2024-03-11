class Solution {
    fun solution(new_id: String): String {
        var answer = new_id
        
        val reg1 = Regex("[a-z0-9-_.]")
        val reg2 = Regex("[.]{2,}")
        
        //1단계 : 모두 소문자 치환
        answer = answer.toLowerCase()
        var temp = StringBuilder()

        //2단계 : 소문자, 숫자, 빼기, 밑줄, 마침표 모두 제거
        for (e in answer) {
            if (reg1.containsMatchIn(e.toString())) {
                temp.append(e)
            }
        }
        
        //3단계 : 마침표 2번 이상이면 하나의 마침표로
        answer = temp.toString().replace(reg2, ".")
        
        //4단계 : 처음이나 마지막이 마침표이면 제거
        if (answer.isNotEmpty() && answer.first() == '.') {
            answer = answer.removeRange(0, 1)
        }
        if (answer.isNotEmpty() && answer.last() == '.') {
            answer = answer.removeRange(answer.length-1, answer.length)
        }
        
        //5단계 : 빈 문자열이면 a 대입
        if(answer.isEmpty()){
            answer = "a"
        }
        
        //6단계 : 길이 16 이상이면 15까지만 두고 제거, 마지막이 . 이면 제거
        if(answer.length >= 16){
            answer = answer.slice(0..14)
        }
        if (answer.isNotEmpty() && answer.last() == '.') {
            answer = answer.removeRange(answer.length-1, answer.length)
        }
        
        //7단계 : 길이 2 이하이면 길이 3 될 때까지 마지막 문자 반복
        while (answer.length <= 2) {
            answer += answer[answer.length - 1]
        }
        
        return answer
    }
}
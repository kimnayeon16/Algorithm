class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        
        val (nYear, nMonth, nDay) = today.split(".")
        val nowYear = nYear.toInt()
        val nowMonth = nMonth.toInt()
        val nowDay = nDay.toInt()
        
        var map = HashMap<String, Int>()
        for(element in terms){
            var(type, month) = element.split(" ")
            map[type] = month.toInt()
        }
        
        for((index, privacy) in privacies.withIndex()){
            val (date, typ) = privacy.split(" ")
            val (y, m, d) = date.split(".")
            var year = y.toInt()
            var month = m.toInt()
            var day = d.toInt()
            
            var type = map[typ] ?: 0
            
            //년 더하기
            year += type / 12
            
            type % 12
            
            // 월 더하기
            month += type % 12
            
            if(month > 12){
                year++
                month = month % 12
            }
            
            
            //일 처리하기
            if(day == 1){
                month--
                day = 28
                
                if(month == 0){
                    month = 12
                    year--
                }
            }else{
                day--
            }
            
            
            println("$year $month $day")
            
            if(nowYear > year){
                answer += index+1
            }else if(nowYear == year){
                if(nowMonth > month){
                    answer += index+1
                }else if(nowMonth == month){
                    if(nowDay > day){
                        answer += index+1
                    }
                }
            }
        }
        return answer
    }
}
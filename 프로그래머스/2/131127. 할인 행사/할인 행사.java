import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int days = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        
        for(int i=0; i<discount.length; i++){
            if(!map2.containsKey(discount[i])){
                map2.put(discount[i],1);
            }else{
                map2.replace(discount[i], map2.get(discount[i])+1);
            }
        }
        // System.out.println(map2);
        
        for(int i=0; i<want.length; i++){
            if(map2.containsKey(want[i])){
                if(map2.get(want[i]) < number[i]){
                    return 0;
                }
            }else{
                return 0;
            }
            
        }
        
        for(int i=0; i<10 && i<discount.length; i++){
            if(!map.containsKey(discount[i])){
                map.put(discount[i],1);
            }else{
                map.replace(discount[i], map.get(discount[i])+1);
            }
        }
        // System.out.println(map);
        
        int idx = 10;
        
        for(int n=0; n<discount.length - 10 + 1; n++){
            boolean isContain = true;
            for(int i=0; i<want.length; i++){
                if(map.containsKey(want[i])){
                    if(number[i] <= map.get(want[i])){
                        isContain = true;
                    }else{
                        isContain = false;
                        break;
                    }
                }else{
                    isContain = false;
                    break;
                }
            }
            
            if(isContain){
                days++;
            }
            
            if(idx == discount.length){
                break;
            }
            
            //map에서 하나 빼고
            map.replace(discount[idx-10], map.get(discount[idx-10])-1);
//             하나 넣기
            if(!map.containsKey(discount[idx])){
                map.put(discount[idx],1);
            }else{
                map.replace(discount[idx], map.get(discount[idx])+1);
            }
            idx++;
        }
        
        return days;
    }
}
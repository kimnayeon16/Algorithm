import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.replace(nums[i], map.get(nums[i])+1);
            }
        }
        if(map.size() > nums.length/2){
            return nums.length/2;
        }else{
            return map.size();
        }
    }
}
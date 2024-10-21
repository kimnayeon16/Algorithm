class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int heal = health;
        int time = bandage[0];
        int plus = bandage[1];
        int bonus = bandage[2];
        
        heal -= attacks[0][1];
        // System.out.println(heal);
        if(heal <= 0) return -1;
        
        for(int i=1; i<attacks.length; i++){
            int tmp = attacks[i][0];
            int before = attacks[i-1][0];
            if(tmp - before > time){
                heal += (tmp - before - 1) / time * bonus +
                    (tmp - before - 1) * plus;
                
            }else{
                heal += plus*(attacks[i][0] - attacks[i-1][0]-1);
            }
            if(heal > health){
                heal = health;
            }
            heal -= attacks[i][1];
            
            // System.out.println(heal);
            if(heal <= 0) return -1;
        }
        return heal;
    }
}
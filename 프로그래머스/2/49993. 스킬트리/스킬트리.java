class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++){
            String newSkill = skill_trees[i].replaceAll("[^" + skill + "]", "");
            for(int j=0; j<=skill.length(); j++){
                String s = skill.substring(0, j);
                if(newSkill.equals(s)){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
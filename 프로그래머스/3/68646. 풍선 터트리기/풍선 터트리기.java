class Solution {
    public int solution(int[] a) {
        int[] leftMin = new int[a.length]; //현재 위치에서 왼쪽 값들 중 가장 작은 값
        int[] rightMin = new int[a.length]; //현재 위치에서 오른쪽 값들 중 가장 작은 값
        int L = a[0];
        int R = a[a.length-1];
        
        //최솟값 저장
        for(int i=1; i<a.length-1; i++){
            if(L > a[i]) L = a[i];
            leftMin[i] = L;
        }
        
        //최댓값 저장
        for(int i=a.length-2; i>0; i--){
            if(R > a[i]) R = a[i];
            rightMin[i] = R;
        }
        
        if(a.length == 1) return 1;
        int answer = 2; //배열 a의 양 끝 값은 항상 true임.
        for(int i=1; i<a.length-1; i++){
            if(a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
            answer ++;
        }
        return answer;
    }
}
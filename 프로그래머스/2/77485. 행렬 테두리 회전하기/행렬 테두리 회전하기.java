class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] arr = new int[rows+1][columns+1];

        int num = 1;
        for(int i = 1 ; i <= rows; i++) {
            for(int j = 1;  j <= columns; j++) {
                arr[i][j] = num++;
            }
        }

        for(int i = 0 ; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            int temp = arr[x1][y1];

            int min = temp;

            //좌측으로 이동
            for(int j = x1; j < x2; j++) {
                arr[j][y1] = arr[j+1][y1];
                min = Math.min(min, arr[j][y1]);
            }

            //하단으로 이동
            for(int j = y1; j < y2; j++) {
                arr[x2][j] = arr[x2][j+1];
                min = Math.min(min, arr[x2][j]);
            }

            //우측으로 이동
            for(int j = x2; j > x1; j--) {
                arr[j][y2] = arr[j-1][y2];
                min = Math.min(min, arr[j][y2]);
            }


            //상단으로 이동
            for(int j = y2; j > y1; j--) {
                arr[x1][j] = arr[x1][j-1];
                min = Math.min(min, arr[x1][j]);
            }

            arr[x1][y1+1] = temp;

            answer[i] = min;
        }

        return answer;
    }
}
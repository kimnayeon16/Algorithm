import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static HashMap<Character, int[]> keymap;
    private static StringBuilder sb = new StringBuilder();

    //각 문자의 키보드 위치를 map에 저장 / key는 문자, value는 행,열 값
    private static HashMap<Character, int[]> alphabetMap() {
        HashMap<Character, int[]> map = new HashMap<>();
        String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < keyboard[i].length(); j++) {
                map.put(keyboard[i].charAt(j), new int[]{i,j});
            }
        }
        return map;
    }

    //거리 비교
    private static int charDistance(char a, char b) {
        return Math.abs(keymap.get(a)[0] - keymap.get(b)[0]) +
                Math.abs(keymap.get(a)[1] - keymap.get(b)[1]);
    }

    //문자열 사이 거리와 해당 단어 저장 클래스
    static class wordNode {
        int distance;
        String word;

        public wordNode(int distance, String word) {
            this.distance = distance;
            this.word = word;
        }

        @Override
        public String toString() {
            return this.word + " " + this.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        keymap = alphabetMap();
        //오름차순 정렬 -> 거리가 같다면 사전순 정렬
        PriorityQueue<wordNode> wordQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.distance == o2.distance) return o1.word.compareTo(o2.word);
            return o1.distance - o2.distance;
        });

        String userWord;
        String newWord;
        int wordNum;
        int sum;
        
        //테케만큼 반복
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            userWord = st.nextToken();
            wordNum = Integer.parseInt(st.nextToken());
            for (int i = 0; i < wordNum; i++) {
                sum = 0;
                st = new StringTokenizer(br.readLine());
                newWord = st.nextToken();
                for (int j = 0; j < userWord.length(); j++) {
                    sum += charDistance(userWord.charAt(j), newWord.charAt(j));
                }
                wordQueue.offer(new wordNode(sum, newWord));
            }

            while (!wordQueue.isEmpty()) {
                sb.append(wordQueue.poll().toString());
                sb.append("\n");
            }
        }
        //출력
        System.out.println(sb.toString());
    }
}
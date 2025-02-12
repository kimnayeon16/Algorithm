import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int t, n, d, c;
    static ArrayList<ArrayList<Node>> map;

    static class Node implements Comparable<Node> {
        int idx;
        int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                map.add(new ArrayList<>());
            }
            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                map.get(b).add(new Node(a, s));
            }
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int[] time = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                time[j] = Integer.MAX_VALUE;
            }
            pq.add(new Node(c, 0));
            time[c] = 0;
            while (!pq.isEmpty()) {
                Node curr = pq.poll();
                if (time[curr.idx] < curr.time) {
                    continue;
                }
                for (Node next : map.get(curr.idx)) {
                    if (time[next.idx] > curr.time + next.time) {
                        pq.add(new Node(next.idx, curr.time + next.time));
                        time[next.idx] = curr.time + next.time;
                    }
                }
            }
            int count = 0;
            int maxTime = 0;
            for (int j = 1; j <= n; j++) {
                if (time[j] < Integer.MAX_VALUE) {
                    count++;
                    maxTime = Math.max(maxTime, time[j]);
                }
            }
            sb.append(count).append(" ").append(maxTime).append("\n");
        }
        System.out.println(sb);
    }
}
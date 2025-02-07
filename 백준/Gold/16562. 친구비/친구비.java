import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] cost;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계 수
        int k = Integer.parseInt(st.nextToken()); // 가진 돈

        parent = new int[N + 1];
        cost = new int[N + 1];

        // 자기 자신을 부모
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 친구비 [10, 10, 20, 20, 30]
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        // 친구 관계 유니온
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        int totalCost = 0;
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            int root = find(i);
            if (!visited[root]) { // 이미 방문한 그룹인지 체크
                totalCost += cost[root];
                visited[root] = true;
            }
        }

        // 예산 초과 여부 확인 후 출력
        if (totalCost <= k) {
            System.out.println(totalCost);
        } else {
            System.out.println("Oh no");
        }
    }

    // Find 연산)
    static int find(int x) {
        if (parent[x] != x) { //parent노드
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    // Union 연산 비용이 적은 학생을 부모로 설정
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (cost[rootX] < cost[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }
    }
}

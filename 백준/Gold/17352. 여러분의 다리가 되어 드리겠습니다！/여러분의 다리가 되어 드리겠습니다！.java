import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for(int i = 1; i <= N - 2; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a) != find(b)) {
                union(a, b);
            }
        }
        int root1 = -1, root2 = -1;
        for (int i = 1; i <= N; i++) {
            int root = find(i);
            if (root1 == -1) {
                root1 = root;
            } else if (root1 != root) {
                root2 = root;
                break;
            }
        }
        System.out.println(root1 + " " + root2);

    }

    public static int find(int a){
        if(parent[a] != a){
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    public static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            parent[rootY] = rootX;
        }
    }

}

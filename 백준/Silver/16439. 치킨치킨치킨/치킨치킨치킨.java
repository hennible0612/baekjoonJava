import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] preferences;
    static int maxSatisfaction = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 
        preferences = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                preferences[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0, new int[3]);

        System.out.println(maxSatisfaction);
    }

    static void combination(int depth, int start, int[] selected) {
        if (depth == 3) { 
            calculateSatisfaction(selected);
            return;
        }

        for (int i = start; i < M; i++) {
            selected[depth] = i;
            combination(depth + 1, i + 1, selected); 
        }
    }

    static void calculateSatisfaction(int[] selected) {
        int totalSatisfaction = 0;

        for (int i = 0; i < N; i++) {
            int maxPreference = 0;
            for (int j : selected) {
                maxPreference = Math.max(maxPreference, preferences[i][j]);
            }
            totalSatisfaction += maxPreference;
        }

        maxSatisfaction = Math.max(maxSatisfaction, totalSatisfaction);
    }
}

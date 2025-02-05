import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static int answer = 0;
    static int[] dy = {-1, -1, 0};
    static int[] dx = {0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        backtrack(0, 0);
        System.out.println(answer);
    }

    static void backtrack(int r, int c) {

        if (r == N) {
            answer++;
            return;
        }

        int nextR, nextC;
        if (c == M - 1) { // 현재 열이 마지막 열이면
            nextR = r + 1;
            nextC = 0;
        } else { // 마지막 열이 아니라면
            nextR = r;
            nextC = c + 1;
        }

        // 안놓는경우
        backtrack(nextR, nextC);

        if (canPlaceNemo(r, c)) {
            board[r][c] = 1;
            //놓는경우
            backtrack(nextR, nextC);
            //보구
            board[r][c] = 0;
        }
    }

    static boolean canPlaceNemo(int r, int c) {
        if (r >= 1 && c >= 1) {
            boolean isSquare = true;
            for (int i = 0; i < 3; i++) {
                int ny = r + dy[i];
                int nx = c + dx[i];
                if (board[ny][nx] == 0) {
                    isSquare = false;
                    break;
                }
            }
            if (isSquare){
                return false;
            }
        }
        return true;
    }
}


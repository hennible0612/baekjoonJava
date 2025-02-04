import java.util.*;
import java.io.*;

public class Main {
    static char[] selected;
    static char[] chars;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            String temp = bf.readLine();
            chars = temp.toCharArray();
            Arrays.sort(chars);
            selected = new char[chars.length];
            visited = new boolean[chars.length];

            sb = new StringBuilder();

            recursion(0);

            System.out.print(sb.toString());
        }
    }

    private static void recursion(int depth) {
        if (depth == selected.length) {
            sb.append(new String(selected)).append("\n");
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]){
                if(i > 0 && chars[i -1] == chars[i] && !visited[i-1]){
                    continue;
                }
                visited[i] = true;
                selected[depth] = chars[i];

                recursion(depth + 1);

                visited[i] = false;
            }
        }
    }
}

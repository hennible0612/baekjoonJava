import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] select = {1, 2, 3};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        back(0);

    }

    public static void back(int depth) {
        if(depth == N) {
            System.out.println(sb.toString());
            System.exit(0);
        }

        for(int num = 0; num < 3; num++) {
            sb.append(select[num]);
            if (isOk()) {
                back(depth + 1);
            }
            sb.deleteCharAt(sb.length() - 1);

        }

    }

    public static boolean isOk() {
        int len = sb.length();
        for(int subLen = 1; subLen <= len / 2; subLen++) { // 비교 최대 길이는 반이다
            String left = sb.substring(len - 2 * subLen, len - subLen);
            String right = sb.substring(len - subLen, len);
            if(left.equals(right)) {
                return false;
            }
        }
        return true;
    }

}
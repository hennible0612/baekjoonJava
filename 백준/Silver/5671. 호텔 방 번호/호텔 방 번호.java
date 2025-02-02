import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) { 
            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int i = N; i <= M; i++) {
                if (isUnique(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isUnique(int num) {
        Set<Character> digits = new HashSet<>();
        String strNum = String.valueOf(num);

        for (char c : strNum.toCharArray()) {
            if (!digits.add(c)) {
                return false; 
            }
        }
        return true; 
    }
}

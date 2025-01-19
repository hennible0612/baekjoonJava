import java.io.*;
import java.util.*;

public class Main {

    static int N; 
    static List<Integer> K; 
    static int max = 0; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int kSize = Integer.parseInt(st.nextToken());
        K = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < kSize; i++) {
            K.add(Integer.parseInt(st.nextToken()));
        }

        K.sort(Collections.reverseOrder());

        findMax(0);

        System.out.println(max);
    }

    static void findMax(int current) {
        if (current > N) {
            return;
        }

        max = Math.max(max, current);

        for (int digit : K) {
            findMax(current * 10 + digit);
        }
    }
}

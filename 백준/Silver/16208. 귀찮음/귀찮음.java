import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long totalSum = 0;
        long squareSum = 0;
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            totalSum += num;
            squareSum += (long) num * num;
        }
        
        long result = (totalSum * totalSum - squareSum) / 2;
        System.out.println(result);
    }
}
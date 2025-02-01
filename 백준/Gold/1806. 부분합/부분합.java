import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine()); 
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken()); 
        }

        int left = 0, right = 0;
        long sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < N) {
            sum += arr[right];
            
            while(sum >= S){
                
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left];
                left++;
            }
            right++;
        }
        
        if(minLength == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(minLength);
        }
        

    }
}
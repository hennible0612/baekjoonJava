/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); 
        
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int S = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[S];
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < S; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            find(arr, K);
        }
        
        System.out.println(sb);
    }
    
    public static void find(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int count = 0;
        int minDiff = Integer.MAX_VALUE;

        Arrays.sort(arr);
        while(left < right){
            int sum = arr[left] + arr[right];
            int diff = Math.abs(target - sum);
            if(diff < minDiff){
                minDiff = diff;
                count = 1;
            }else if(diff == minDiff){
                count++;
            }
            
            if(sum < target){
                left++;
            }else{
                right--;
            }
            
        }
        
        sb.append(count).append("\n");

    }
}

/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] dna = new String[N];
		for(int i = 0; i < N; i++){
		    dna[i] = bf.readLine();
		}
		
		StringBuilder sb = new StringBuilder();
		int tDis = 0;
		
		for(int i = 0; i < M; i++){
            int[] counts = new int[4];
            for(int j =0; j<N; j++){
                char c = dna[j].charAt(i);
                if (c == 'A') counts[0]++;
                else if (c == 'C') counts[1]++;
                else if (c == 'G') counts[2]++;
                else if (c == 'T') counts[3]++;
            }
            
            int maxIndex = 0;
            for (int k = 1; k < 4; k++) {
                if (counts[k] > counts[maxIndex]) {
                    maxIndex = k;
                }
            }
            char chosen;
            if (maxIndex == 0) chosen = 'A';
            else if (maxIndex == 1) chosen = 'C';
            else if (maxIndex == 2) chosen = 'G';
            else chosen = 'T';
            sb.append(chosen);
            
            tDis += N - counts[maxIndex];

		    
		}
        System.out.println(sb.toString());
        System.out.println(tDis);
	}
}

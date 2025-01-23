/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int K;
    static HashSet<String>  hashSet = new HashSet<>();
    static int[] selected;
    static int[] numbers;
    static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(bf.readLine());
		K = Integer.parseInt(bf.readLine());
		selected = new int[K];
		numbers = new int[N];
		visited = new boolean[N];

		for(int i = 0; i < N; i++){
		    numbers[i] = Integer.parseInt(bf.readLine());
		}
		perm(0);
		System.out.println(hashSet.size());

	}
	
	public static void perm(int depth){
	    
	    if(depth == K){
	        
	        StringBuilder sb = new StringBuilder();
            for (int i = 0; i < K; i++) {
                sb.append(selected[i]);
            }
	        hashSet.add(sb.toString());
		    return;
	    }
	    
	    for(int i = 0; i < numbers.length; i++){
	        
	        if(!visited[i]){
	            visited[i] = true;
	            selected[depth]= numbers[i];
	            perm(depth + 1);
	            visited[i] = false; 
	        }

	    }
	    
	}
}

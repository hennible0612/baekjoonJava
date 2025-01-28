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
		String S = bf.readLine();
		String T = bf.readLine();
		
		Queue<String> queue = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		
		queue.add(T);
		visited.add(T);
		
		boolean found = false;
		while(!queue.isEmpty()){
		    
		    String cur = queue.poll();
		    if(cur.equals(S)){
		        found = true;
		        break;
		    }
		    
		    if(cur.length() <= S.length()){
		        continue;
		    }
		    
		    if(cur.charAt(cur.length() - 1) == 'A'){
		        String next = cur.substring(0, cur.length() - 1);
		        if(!visited.contains(next)){
		            visited.add(next);
		            queue.add(next);
		        }
		    }
		    
		    if(cur.charAt(0)=='B'){
		        StringBuilder sb = new StringBuilder(cur).reverse();
		        String next = sb.substring(0, sb.length() - 1);
	       	    if(!visited.contains(next)){
		            visited.add(next);
		            queue.add(next);
		        }
		    }
		}
		
		if(found){
		    System.out.println(1);
		}else{
		    System.out.println(0);
		}
		
		
	}
}


/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        char d = st.nextToken().charAt(0); 

        int count = 0; 

        for (int i = 1; i <= n; i++) {
            String numStr = Integer.toString(i);
            for (int j = 0; j < numStr.length(); j++) {
                if (numStr.charAt(j) == d) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

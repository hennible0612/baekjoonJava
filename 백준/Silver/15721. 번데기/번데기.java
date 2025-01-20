import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine()); 
        int T = Integer.parseInt(br.readLine()); 
        int N = Integer.parseInt(br.readLine()); 

        int repeat = 2; 
        int zeroCount = 0; 
        int oneCount = 0; 

        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
                if (N == 0 && zeroCount == T) {
                    System.out.println((zeroCount + oneCount - 1) % A);
                    return;
                }
                if (N == 1 && oneCount == T) {
                    System.out.println((zeroCount + oneCount - 1) % A);
                    return;
                }
            }

            for (int i = 0; i < repeat; i++) {
                zeroCount++;
                if (zeroCount == T && N == 0) {
                    System.out.println((zeroCount + oneCount - 1) % A);
                    return;
                }
            }

            for (int i = 0; i < repeat; i++) {
                oneCount++;
                if (oneCount == T && N == 1) {
                    System.out.println((zeroCount + oneCount - 1) % A);
                    return;
                }
            }

            repeat++; 
        }
    }
}

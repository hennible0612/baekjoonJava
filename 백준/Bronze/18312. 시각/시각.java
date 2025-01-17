import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int count = 0;

        for (int hour = 0; hour <= N; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                for (int second = 0; second < 60; second++) {
    
                    String time = String.format("%02d%02d%02d", hour, minute, second);
                    if (time.contains(String.valueOf(K))) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}

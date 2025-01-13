import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        Integer[] cranes = new Integer[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(bf.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(cranes, Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if (boxes.get(0) > cranes[0]) {
            System.out.println(-1);
            return;
        }

        int answer = 0;

        while (!boxes.isEmpty()) {
            int boxIndex = 0;
            int craneIndex = 0;
            while (craneIndex < N) {
                if (boxIndex >= boxes.size()) {
                    break;
                }
                if (cranes[craneIndex] >= boxes.get(boxIndex)) {
                    boxes.remove(boxIndex);
                    craneIndex++;
                } else {
                    boxIndex++;
                }
            }

            answer++;
        }

        System.out.println(answer);
    }
}

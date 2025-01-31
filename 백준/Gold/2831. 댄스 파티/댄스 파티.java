import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> mPlus = new ArrayList<>();
        List<Integer> mMinus = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (val > 0) {
                mPlus.add(val);
            } else {
                mMinus.add(-val);
            }
        }
        
        List<Integer> wPlus = new ArrayList<>();
        List<Integer> wMinus = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (val > 0) {
                wPlus.add(val);
            } else {
                wMinus.add(-val);
            }
        }
        
        // M+  W-
        Collections.sort(mPlus);
        Collections.sort(wMinus);
        int count1 = 0;
        int i = 0, j = 0;
        while (i < mPlus.size() && j < wMinus.size()) {
            if (wMinus.get(j) > mPlus.get(i)) {
                count1++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        
        // M- W+
        Collections.sort(mMinus);
        Collections.sort(wPlus);
        int count2 = 0;
        i = 0; j = 0;
        while (i < mMinus.size() && j < wPlus.size()) {
            if (mMinus.get(i) > wPlus.get(j)) {
                count2++;
                i++;
                j++;
            } else {
                i++;
            }
        }
        
        System.out.println(count1 + count2);
    }
}
import java.util.*;
import java.io.*;
public class Main {

    static class Node {
        int left;
        int right;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static boolean[] booleans;
    static StringBuilder sb = new StringBuilder();
    static String input;
    static ArrayList<Node> nodes;
    static TreeSet<String> results = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input = bf.readLine();
        Stack<Integer> locStack = new Stack<>();
        nodes = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if (c == '(') {
                locStack.push(i);
            }else if (c == ')') {
                nodes.add(new Node(locStack.pop(), i));
            }
        }
        booleans = new boolean[nodes.size()];
        recursion(0);
        results.remove(input);
        for (String s : results) {
            System.out.println(s);
        }
    }

    public static void recursion(int depth){
        if(depth == booleans.length){
            boolean[] removeIndex = new boolean[input.length()];
            for (int i = 0; i < booleans.length; i++) {
                if (booleans[i]) {
                    removeIndex[nodes.get(i).left] = true;
                    removeIndex[nodes.get(i).right] = true;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < input.length(); i++){
                if (!removeIndex[i]) {
                    sb.append(input.charAt(i));
                }
            }
            results.add(sb.toString());
            return;
        }

        booleans[depth] = true;
        recursion(depth+1);
        booleans[depth] = false;
        recursion(depth + 1);


    }
}
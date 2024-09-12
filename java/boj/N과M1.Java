//https://www.acmicpc.net/problem/15649

import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[] isUsed;
    static Deque<Integer> seq = new ArrayDeque<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        isUsed = new boolean[n + 1];
        
        pick();
    }
    public static void pick() {
        if (seq.size() == m) {
            printSeq();
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (isUsed[i])
                continue;
            seq.add(i);
            isUsed[i] = true;
            pick();
            isUsed[i] = false;
            seq.removeLast();
        }
    }
    
    public static void printSeq() {
        for (int num : seq) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }
}
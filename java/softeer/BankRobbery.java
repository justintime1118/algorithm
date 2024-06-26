package softeer;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BankRobbery {

    private static class Elem {
        int weight;
        int price;

        public Elem(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int n = sc.nextInt();

        Queue<Elem> pq = new PriorityQueue<>((e1, e2) -> e2.price - e1.price);
        for (int i = 0; i < n; i++)
            pq.add(new Elem(sc.nextInt(), sc.nextInt()));

        int maxPrice = 0;
        while (!pq.isEmpty() && w > 0) {
            Elem e = pq.poll();
            if (e.weight < w) {
                maxPrice += e.weight * e.price;
                w -= e.weight;
            } else {
                maxPrice += w * e.price;
                w = 0;
            }
        }

        System.out.println(maxPrice);
    }
}
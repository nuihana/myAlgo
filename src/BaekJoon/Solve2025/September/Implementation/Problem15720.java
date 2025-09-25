package BaekJoon.Solve2025.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem15720 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int burgerCnt = Integer.parseInt(st.nextToken());
        int sideCnt = Integer.parseInt(st.nextToken());
        int drinkCnt = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> burger = new PriorityQueue<>((i1, i2) -> i2 - i1);
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            burger.add(Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Integer> side = new PriorityQueue<>((i1, i2) -> i2 - i1);
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            side.add(Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Integer> drink = new PriorityQueue<>((i1, i2) -> i2 - i1);
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            drink.add(Integer.parseInt(st.nextToken()));
        }

        int total = 0, discount = 0;
        while (!burger.isEmpty() && !side.isEmpty() && !drink.isEmpty()) {
            int sum = burger.poll() + side.poll() + drink.poll();
            total += sum;
            discount += sum * 0.9;
        }

        while (!burger.isEmpty()) {
            int price = burger.poll();
            total += price;
            discount += price;
        }
        while (!side.isEmpty()) {
            int price = side.poll();
            total += price;
            discount += price;
        }
        while (!drink.isEmpty()) {
            int price = drink.poll();
            total += price;
            discount += price;
        }

        System.out.println(total);
        System.out.print(discount);

        br.close();
    }
}

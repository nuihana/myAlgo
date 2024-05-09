package BaekJoon.Solve2024.May.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem15961 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int laneLength = Integer.parseInt(st.nextToken());
        int typeCnt = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] lane = new int[laneLength];
        for (int i = 0; i < laneLength; i++) {
            lane[i] = Integer.parseInt(br.readLine());
        }

        int l = 0;
        int r = size;
        Eat eat = new Eat(coupon);
        for (int i = l; i < r; i++) eat.eat(lane[i]);

        int res = eat.getTypeCnt();
        while (l < laneLength) {
            eat.remove(lane[l++]);
            eat.eat(lane[r++ % laneLength]);

            res = Math.max(res, eat.getTypeCnt());
        }

        System.out.print(res);

        br.close();
    }

    class Eat {
        Map<Integer, Sushi> map;

        public Eat(int base) {
            map = new HashMap<>();

            map.put(base, new Sushi(base));
        }

        public void eat(int type) {
            if (map.containsKey(type)) {
                map.get(type).amount++;
            } else {
                map.put(type, new Sushi(type));
            }
        }

        public void remove(int type) {
            Sushi item = map.get(type);

            item.amount--;
            if (item.amount == 0) {
                map.remove(type);
            }
        }

        public int getTypeCnt() {
            return map.size();
        }
    }

    class Sushi {
        int species, amount;

        public Sushi(int id) {
            species = id;
            amount = 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Sushi sushi = (Sushi) o;
            return species == sushi.species;
        }

        @Override
        public int hashCode() {
            return Objects.hash(species);
        }
    }
}
